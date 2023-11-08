import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  

  constructor(private _http : HttpClient) { }

  public loginUserFromREmote(user :User):Observable<any>{
    return this._http.post<any>("http://localhost:8080/login", user);
  }

  registerUserFromRemote(user: User) :Observable<any>{
    return this._http.post<any>("http://localhost:8080/register", user);
  }
}
