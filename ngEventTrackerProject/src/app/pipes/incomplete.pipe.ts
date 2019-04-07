import { Pipe, PipeTransform } from '@angular/core';
import { FuelTracker } from '../models/fuel-tracker';

@Pipe({
  name: 'incomplete'
})
export class IncompletePipe implements PipeTransform {

  transform(fuelTrackers: FuelTracker[], showAllFuelTrackers?: boolean): FuelTracker[] {
    if (showAllFuelTrackers) {
      return fuelTrackers;
    }
    const result: FuelTracker[] = [];

    for (const fuelTracker of fuelTrackers) {
      result.push(fuelTracker);
    }
    return result;
  }

}
