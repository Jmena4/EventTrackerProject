
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { FuelTracker } from '../models/fuel-tracker';
import { DatePipe } from '@angular/common';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EventTrackerService {

  // private baseUrl = 'http://localhost:8085/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/fuelTrackers/';
  //  C o n s t r u c t o r
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  // M e t h o d s
  index() {
    return this.http.get<FuelTracker[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }


  public create(tracker: FuelTracker) {
    console.log(tracker);
    const httpOptions = { headers: { 'Content-type': 'application/json' } };
    return this.http.post<FuelTracker>(this.url, tracker, httpOptions).pipe(
      catchError((err: any) => {
        console.error('FuelTrackerService.create(): Error');
        console.error(err);
        return throwError('Error in FuelTrackerService.create()');
      })
    );
  }

  public destroy(id: number) {
    return this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.error('FuelTrackerService.destroy(): Error');
        console.error(err);
        return throwError('Error in FuelTrackerService.destroy()');
      })
    );
  }


  public update(tracker: FuelTracker) {
    console.log('tracker: ' + tracker);
    console.log('tracker.id: ' + tracker.id);
    const httpOptions = { headers: { 'Content-type': 'application/json' } };
    return this.http.put<FuelTracker>(`${this.url}/${tracker.id}`, tracker, httpOptions).pipe(
      catchError((err: any) => {
        console.error('FuelTrackerService.update(): Error');
        console.error(err);
        return throwError('Error in FuelTrackerService.update()');
      })
    );
  }
}
