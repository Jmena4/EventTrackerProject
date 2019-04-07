export class FuelTracker {
  id: number;
  date: Date;
  gallons: number;
  pricePerGallon: number;
  totalPrice: number;
  estimatedMiles: number;
  odometerReading: number;
  vehicle: {};



  // tslint:disable-next-line: max-line-length
  constructor(id: number = 0, date: Date = null, gallons: number = 0, pricePerGallon: number = 0, totalPrice: number = 0, estimatedMiles: number = 0, odometerReading: number = 0,
              vehicle: {}) {
    this.id = id;
    this.date = date;
    this.gallons = gallons;
    this.pricePerGallon = pricePerGallon;
    this.totalPrice = totalPrice;
    this.estimatedMiles = estimatedMiles;
    this.odometerReading = odometerReading;
    this.vehicle = vehicle;
  }
}
