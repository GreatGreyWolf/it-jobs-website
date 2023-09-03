import { Input, OnInit, Output, EventEmitter } from '@angular/core';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatAutocompleteSelectedEvent, MatAutocomplete } from '@angular/material/autocomplete';
import { MatChipInputEvent } from '@angular/material/chips';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'autocomplete-chips-component',
  templateUrl: 'autocomplete-chips-component.html',
  styleUrls: ['autocomplete-chips-component.scss'],
})
export class AutocompleteChipsComponent implements OnInit {
  @Input() dataSource: any[] = [];
  @Input() placeholder: string = '';
  @Input() displayProperty: string = '';
  @Input() identifier: string = '';

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  ItemCtrl = new FormControl();
  filteredItems!: Observable<string[]>;
  availableItems: string[] = [];
  @Output() itemsChanged = new EventEmitter<{ identifier: string, items: string[] }>();
  selectedItems: string[] = [];

  @ViewChild('itemInput', { static: false }) itemInput!: ElementRef<HTMLInputElement>;
  @ViewChild('auto', { static: false }) matAutocomplete!: MatAutocomplete;

  ngOnInit() {
    this.availableItems = this.dataSource.map(item => this.getDisplayValue(item));
    this.filteredItems = this.ItemCtrl.valueChanges.pipe(
      startWith(''),
      map((item: string | null) => {
        if (!item || item.length === 0) {
          return this.availableItems; // if the input is empty, show all items
        } else {
          return this._filter(item); // else filter them
        }
      })
    );
  }

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    if ((value || '').trim() && !this.selectedItems.includes(value.trim()) && this.isInDataSource(value.trim())) {
      this.selectedItems.push(value.trim());
      this.itemsChanged.emit({ identifier: this.identifier, items: this.selectedItems });
    }

    if (input) {
      input.value = '';
    }

    this.ItemCtrl.setValue(null);
  }

  remove(item: string): void {
    const index = this.selectedItems.indexOf(item);

    if (index >= 0) {
      this.selectedItems.splice(index, 1);
      this.itemsChanged.emit({ identifier: this.identifier, items: this.selectedItems });
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    const item = event.option.viewValue;

    if (!this.selectedItems.includes(item)) {
      this.selectedItems.push(item);
      this.itemsChanged.emit({ identifier: this.identifier, items: this.selectedItems });
      this.itemInput.nativeElement.value = '';
      this.ItemCtrl.setValue(null);
    } else {
      // If the item is already selected, the input is cleared without adding it
      this.itemInput.nativeElement.value = '';
    }
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    const filtered = this.availableItems.filter(item =>
      item.toLowerCase().includes(filterValue) && !this.selectedItems.includes(item)
    );
    return filtered;
  }

  private isInDataSource(value: string): boolean {
    if (this.displayProperty) {
      return !!this.dataSource.find(item =>
        item && item.hasOwnProperty(this.displayProperty) &&
        item[this.displayProperty].toLowerCase() === value.toLowerCase()
      );
    } else {
      return this.dataSource.includes(value);
    }
  }

  getDisplayValue(item: any): string {
    if (this.displayProperty && item && item.hasOwnProperty(this.displayProperty)) {
      return item[this.displayProperty];
    } else if (item) {
      return item;
    } else {
      return '';
    }
  }
}
