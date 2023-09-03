import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
    selector: 'custom-autocomplete',
    templateUrl: './custom-autocomplete.component.html',
    styleUrls: ['./custom-autocomplete.component.scss']
})
export class CustomAutocompleteComponent implements OnInit {
    @Input() options: string[] = [];
    @Input() placeholder: string = '';
    @Input() label: string = '';
    @Input() identifier: string = '';
    @Output() optionSelected = new EventEmitter<{ identifier: string, value: string }>();


    control = new FormControl('');
    filteredOptions!: Observable<string[]>;

    ngOnInit() {
        this.filteredOptions = this.control.valueChanges.pipe(
            startWith(''),
            map(value => this._filter(value || '')),
        );

        this.control.valueChanges.subscribe(value => {
            this.optionSelected.emit({ identifier: this.identifier, value: value! });
        });
    }

    private _filter(value: string): string[] {
        const filterValue = value.toLowerCase();
        return this.options.filter(option => option.toLowerCase().includes(filterValue));
    }
}
