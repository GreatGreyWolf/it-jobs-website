import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';

import { JobService } from '../job.service';
import { AutocompleteChipsComponent } from './chips/autocomplete-chips-component';

@Component({
  selector: 'app-search-filters',
  templateUrl: './search-filters.component.html',
  styleUrls: ['./search-filters.component.scss']
})

export class SearchFiltersComponent implements OnInit {
  // JSON Choosable Vars
  languages: string[] = [];
  roles: string[] = [];

  // User Option Vars
  keyword!: string;
  title!: string;
  companyName!: string;
  roleName!: string;
  goodieName!: string[];
  companyType!: string;
  employmentTypeName!: string;
  languageName!: string[];
  professionName!: string;
  certificateName!: string[];
  categoryName!: string;
  technologyName!: string[];
  methodName!: string[];
  salaryMin = 40000;
  salaryMax = 100000;
  workPercentageMin = 10;
  workPercentageMax = 100;
  location!: string;

  titleControl = new FormControl();
  titles: string[] = ['Java Developer', 'Angular Developer'];
  filteredTitles: Observable<string[]>;

  languageInputControl = new FormControl();

  @ViewChild('rolesChips', { static: false }) rolesChips!: AutocompleteChipsComponent;
  @ViewChild('languagesChips', { static: false }) languagesChips!: AutocompleteChipsComponent;

  constructor(private jobService: JobService) { // inject the service here
    this.filteredTitles = this.titleControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value))
    );
  }

  ngOnInit() {
    this.fetchLanguages();
    this.fetchRoles();
  }

  fetchLanguages() {
    this.jobService.getLanguages().subscribe({
      next: data => {
        this.languages = data.map(languageObj => languageObj.languageName);
      },
      error: error => console.error('Error fetching languages:', error)
    });
  }

  onLanguagesChanged(items: string[]): void {
    this.languageName = items;
  }

  fetchRoles() {
    this.jobService.getRoles().subscribe({
      next: data => {
        this.roles = data.map(roleObj => roleObj.roleName); // assuming roles have a similar structure
      },
      error: error => console.error('Error fetching roles:', error)
    });
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    return this.titles.filter(title => title.toLowerCase().includes(filterValue));
  }

  @Output() filtersChanged = new EventEmitter<any>();

  applyFilters() {
    this.filtersChanged.emit({
      title: this.titleControl.value,
      keyword: this.keyword,
      location: this.location,
      languageName: this.languageName,
      roleName: this.rolesChips,
      employmentTypeName: this.employmentTypeName,
      technologyName: this.technologyName,
      methodName: this.methodName,
      professionName: this.professionName,
      certificateName: this.certificateName,
      categoryName: this.categoryName,
      companyName: this.companyName,
      companyType: this.companyType,
      goodieName: this.goodieName,
      salaryMin: this.salaryMin,
      salaryMax: this.salaryMax,
      workPercentageMin: this.workPercentageMin,
      workPercentageMax: this.workPercentageMax
    });
  }

}
