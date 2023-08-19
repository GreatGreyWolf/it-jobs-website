import { Component, OnInit } from '@angular/core';
import { JobService } from '../job.service';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss']
})
export class JobListComponent implements OnInit {
  jobs: any[] = [];

  constructor(private jobService: JobService) { }

  ngOnInit(): void {
    this.jobService.getJobs().subscribe(data => {
      this.jobs = data;
    });
  }

  filters = {};

  onFiltersChanged(event: any) {
    this.filters = event;
    // Now, you can call the service again with filters or filter the jobs array directly.
    // Ideally, you'd modify the service to accept these filters and return filtered data.
  }

}
