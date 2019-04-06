import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class EventTrackerService {

  private baseUrl = 'http://api.skilldistillery.com:8085/';
  // private url = this.baseUrl + 'poke/data/poke';
  //  C o n s t r u c t o r
  constructor(private http: HttpClient) {}

  // M e t h o d s
  index() {
    // return this.http.get<Pokemon[]>(this.url + '?sorted=true').pipe(
    //   catchError((err: any) => {
    //     console.log(err);
    //     return throwError('KABOOM');
    //   })
    // );
  }
}
