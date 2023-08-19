import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-filters',
  templateUrl: './search-filters.component.html',
  styleUrls: ['./search-filters.component.scss']
})
export class SearchFiltersComponent {

  title!: string;
  company_name!: string;
  // Add more filter variables as needed

  @Output() filtersChanged = new EventEmitter<any>();

  applyFilters() {
    this.filtersChanged.emit({
      title: this.title,
      company_name: this.company_name
      // Add other filters here
    });
  }
}
