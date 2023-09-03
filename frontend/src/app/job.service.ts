import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private baseUrl: string = `${environment.backendUrl}/api/`;

  constructor(private http: HttpClient) { }

  getJobs(filters = {}): Observable<any> {
    return this.http.get(`${this.baseUrl}jobs`, { params: filters });
  }

  getLanguages(): Observable<Array<{id: number, languageName: string}>> {
    return this.http.get<Array<{id: number, languageName: string}>>(`${this.baseUrl}languages`);
  }

  getRoles(): Observable<Array<{id: number, roleName: string}>> {
    return this.http.get<Array<{id: number, roleName: string}>>(`${this.baseUrl}roles`);
  }
}
