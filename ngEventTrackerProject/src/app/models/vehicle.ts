export class Vehicle {
  id: number;
  vin: string;
  year: number;
  make: number;
  model: number;




  // tslint:disable-next-line: max-line-length
  constructor(id: number = 0, vin: string = '', year: number = 0, make: number = 0, model: number = 0) {
    this.id = id;
    this.vin = vin;
    this.year = year;
    this.make = make;
    this.model = model;
  }
}
