import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private htppClient: HttpClient) { }

  public login(email: String, password: String): Observable<any> {
    return this.htppClient.post<any>('/api/auth/login', {email, password});
  }
}
