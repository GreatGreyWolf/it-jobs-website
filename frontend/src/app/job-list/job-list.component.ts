import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { JobService } from '../job.service';
import { cleanFilters } from '../utils/clean-filters'

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss']
})
export class JobListComponent implements OnInit {
  jobs: any[] = [];

  @Input() filters: any = {};

  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.jobService.getJobs().subscribe(data => {
      this.jobs = data;
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['filters'] && !changes['filters'].firstChange) {
      this.onFiltersChanged(this.filters);
    }
  }


  onFiltersChanged(filters: any) {
    const cleanedFilters = cleanFilters(filters);
    // Fetch the filtered jobs using the service
    this.jobService.getJobs(cleanedFilters).subscribe(data => {
      this.jobs = data;
    });
  }

}
