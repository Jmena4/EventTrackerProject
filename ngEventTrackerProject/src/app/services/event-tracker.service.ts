
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { FuelTracker } from '../models/fuel-tracker';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class EventTrackerService {

  private baseUrl = 'http://localhost:8085';
  private url = this.baseUrl + '/api/fuelTrackers';
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


  public create(fuelTrackers: FuelTracker) {
    console.log(fuelTrackers);
    const httpOptions = { headers: { 'Content-type': 'application/json' } };
    return this.http.post<FuelTracker>(this.url, fuelTrackers, httpOptions).pipe(
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


  // public update(fuelTrackers: FuelTracker) {
  //   if (fuelTrackers != null) {
  //     fuelTrackers.date = this.datePipe.transform(Date.now(), 'shortDate');
  //   } else {
  //     fuelTrackers.date = '';
  //   }
  //   console.log('completeDate: ' + fuelTrackers.date);
  //   const httpOptions = { headers: { 'Content-type': 'application/json' } };
  //   return this.http.put<FuelTracker>(`${this.url}/${fuelTrackers.id}`, fuelTrackers, httpOptions).pipe(
  //     catchError((err: any) => {
  //       console.error('TodoService.update(): Error');
  //       console.error(err);
  //       return throwError('Error in TodoService.update()');
  //     })
  //   );
  // }
}
