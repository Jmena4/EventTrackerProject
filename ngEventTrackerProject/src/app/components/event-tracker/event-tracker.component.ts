import { EventTrackerService } from './../../services/event-tracker.service';
import { FuelTracker } from './../../models/fuel-tracker';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-event-tracker',
  templateUrl: './event-tracker.component.html',
  styleUrls: ['./event-tracker.component.css']
})
export class EventTrackerComponent implements OnInit {

  fueltrackers: FuelTracker[] = [];
  selected: FuelTracker = null;
  edit: FuelTracker = null;
  add: FuelTracker = null;
  delete: FuelTracker = null;
  // add: FuelTracker = new FuelTracker();
  mode = 'list';
  selectedType = 'all';
  selectedFuelTracker = null;
  editFuelTracker: FuelTracker = null;
  showAllFuelTrackers = false;
  // newFuelTracker: FuelTracker = new FuelTracker();

  constructor(private eventTrackerService: EventTrackerService) { }

  ngOnInit() {
    this.reload();
  }

  goBack() {
    this.selectedFuelTracker = null;
  }

  reload() {
    // const myObservable = this.eventTrackerService.index();
    // myObservable.subscribe(
    this.eventTrackerService.index().subscribe(
      data => {
        this.fueltrackers = data;
      },
      err => {
        console.log('A bad thing happened in reload()');
        console.log(err);
      }
    );
  }
  displayTable(): void {
    this.selected = null;
  }

  setEditFuelTracker() {
    this.edit = Object.assign({}, this.selected);
  }

  setAddFuelTracker() {
    this.add = Object.assign({}, this.selected);
  }


  setSelected(fuelTrackers) {
    this.selected = fuelTrackers;
  }
  addFuelTracker(form: NgForm) {
    // todo.id = this.generateId();
    // this.todoService.create(todo);
    // this.todos = this.todoService.index();
    console.log('addFuelTRacker()');
    console.log(form.value);
    const tracker = form.value;
    tracker.vehicle = { id: tracker.vehicleId };

    this.eventTrackerService.create(tracker).subscribe(
      data => {
        console.log('addFuelTracker(): tracker created');
        console.log(data);

        this.reload();
      },
      err => {
        console.error('EventTrackerComponent.addFuelTracker(): Error');
        console.error(err);
      }
    );
    this.selected = null;
    // this.newFuelTracker = new FuelTracker();
  }

  saveEdit() {
    this.selected.gallons = this.edit.gallons;
    this.selected.pricePerGallon = this.edit.pricePerGallon;
    this.selected.totalPrice = this.edit.totalPrice;
    this.selected.estimatedMiles = this.edit.estimatedMiles;
    this.selected.odometerReading = this.edit.odometerReading;
    this.selected.vehicle = this.edit.vehicle;

    this.edit = null;
    this.selected = null;
  }

  deleteFuelTracker(fuelTrackers: FuelTracker) {
    // this.todoService.delete(todo);
    // this.todos = this.todoService.index();
    this.eventTrackerService.destroy(fuelTrackers.id).subscribe(
      data => {
        this.reload();
      },
      err => {
        console.error('EventTrackerComponent.deleteTodo(): Error');
        console.error(err);
      }
    );
  }
  // updateFuelTracker(form: NgForm): void {
  //   // this.todoService.update(this.editTodo);
  //   // this.todos = this.todoService.index();
  //   console.log('updateFuelTracker()');
  //   console.log(form.value);
  //   const tracker = form.value;
  //   tracker.vehicle = { id: tracker.vehicleId };

  //   this.eventTrackerService.update(tracker).subscribe(
  //     data => {
  //       this.reload();
  //       this.editFuelTracker = null;
  //       this.selected = data;
  //     },
  //     err => {
  //       console.error('EventTrackerComponent.updateTodo(): Error');
  //       console.error(err);
  //     }
  //   );
  // }
}
