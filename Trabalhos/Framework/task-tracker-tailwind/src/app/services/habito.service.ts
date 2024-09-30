import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HabitoService {
  private apiUrl = 'http://localhost:8080/habitos';

  constructor(private http: HttpClient) { }

  getHabitos(): Observable<any> {
    return this.http.get(`${this.apiUrl}`);
  }
}
