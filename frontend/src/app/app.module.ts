import { NgModule } from '@angular/core';

import {NgFor} from '@angular/common';

import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule } from '@angular/forms';
import { MatSliderModule } from '@angular/material/slider';
import { MatFormFieldModule } from '@angular/material/form-field';

import { ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';


import { AppComponent } from './app.component';
import { JobListComponent } from './job-list/job-list.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { SearchFiltersComponent } from './search-filters/search-filters.component';

import { CustomChipsComponent } from './search-filters/chips/custom-chips.component';
import { CustomAutocompleteComponent  } from './search-filters/autocomplete/custom-autocomplete.component';

@NgModule({
  declarations: [
    AppComponent,
    JobListComponent,
    JobDetailsComponent,
    SearchFiltersComponent,
    CustomChipsComponent,
    CustomAutocompleteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatSliderModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatInputModule,
    MatChipsModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
