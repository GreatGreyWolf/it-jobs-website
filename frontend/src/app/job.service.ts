import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private API_URL = 'http://localhost:8080/api/jobs';

  constructor(private http: HttpClient) { }

  getJobs(): Observable<any> {
    return this.http.get(this.API_URL);
  }
}
