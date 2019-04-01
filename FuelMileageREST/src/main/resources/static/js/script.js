window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {
	document.fuelTrackerForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var fuelTrackerId = document.fuelTrackerForm.fuelTrackerId.value;
		if (!isNaN(fuelTrackerId) && fuelTrackerId > 0) {
			getFuelTracker(fuelTrackerId);
		}
	})
	document.getElementById('addFuelTracker').addEventListener('click',
			function(evt) {
				event.preventDefault();
				addFuelTracker();
			});
	document.getElementById('deleteFuelTracker').addEventListener('click',
			function(evt) {
				event.preventDefault();
				deleteFuelTracker();
			});
}

function getFuelTracker(fuelTrackerId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/fuelTrackers/' + fuelTrackerId, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log('Found fuel tracker entry ' + fuelTrackerId);
				let fuelTracker = JSON.parse(xhr.responseText);
				console.log(fuelTracker);

				displayFuelTracker(fuelTracker);
			} else {
				document.getElementById('FuelTrackerData').textContent = 'Fuel Tracker entry not Found';
			}
		}
	}
	xhr.send(null);
}

function displayFuelTracker(fuelTracker) {
	let fuelTrackerDiv = document.getElementById('fuelTrackerData');
	fuelTrackerDiv.textContent = '';

	let div = document.createElement('div');
	fuelTrackerDiv.append(div);

	let h2 = document.createElement('h2');
	h2.textContent = "Fuel Tracker Entry: " + fuelTracker.date;
	div.appendChild(h2);

	let ul = document.createElement("ul");
	//	
	let li = document.createElement("li");
	li.textContent = "Gallons: " + fuelTracker.gallons;
	ul.appendChild(li);

	li = document.createElement("li");
	li.textContent = "Price/Gallon: " + fuelTracker.pricePerGallon;
	ul.appendChild(li);

	li = document.createElement("li");
	li.textContent = "Total Purchase Price: " + fuelTracker.totalPurchasePrice;
	ul.appendChild(li);

	li = document.createElement("li");
	li.textContent = "Estimated Miles: " + fuelTracker.estimatedMiles;
	ul.appendChild(li);

	li = document.createElement("li");
	li.textContent = "Odometer Reading: " + fuelTracker.odometerReading;
	ul.appendChild(li);

	div.appendChild(ul);

	getAndDisplayFuelTrackerVehicle(fuelTracker);
}
function getAndDisplayFuelTrackerVehicle(fuelTracker) {
	console.log('getting vehicle for fuel tracker entry ' + fuelTracker.id);
	let xhr = new XMLHttpRequest();
	console.log(fuelTracker.vehicle);
	displayFuelTrackerVehicles(fuelTracker);
	// xhr.open('GET', `api/fuelTrackers/${fuelTracker.id}/vehicle`);
	// xhr.onreadystatechange = function() {
	// if (xhr.readyState === 4) {
	// if (xhr.status == 200 || xhr.status == 201) {
	// console.log('Found vehicles for fuel tracker entry '
	// + fuelTrackerId);
	// let vehcile = JSON.parse(xhr.responseText);
	// console.log(vehicle);
	// displayFuelTrackerVehicles(vehicle);
	// } else {
	// document.getElementById('fuelTrackerData').textContent = 'Fuel Tracker
	// Entry not Found';
	// }
	// }
	// }
	// xhr.send(null);
};

function displayFuelTrackerVehicles(fuelTracker) {
	let vehicleDiv = document.getElementById('vehicleData');
	vehicleDiv.textContent = '';

	let ul = document.createElement('ul');

	let li = document.createElement('li');
	li.textContent = fuelTracker.vehicle.year + ", " + fuelTracker.vehicle.make
			+ ", " + fuelTracker.vehicle.model;
	ul.append(li);

	vehicleDiv.append(ul);
}
function addFuelTracker() {
	console.log('addFuelTracker() called.');
	let f = document.addFuelTrackerForm;
	let fuelTracker = {};
	fuelTracker.gallons = f.gallons.value;
	fuelTracker.pricePerGallon = f.pricePerGallon.value;
	fuelTracker.totalPrice = f.totalPrice.value;
	fuelTracker.estimatedMiles = f.estimatedMiles.value;
	fuelTracker.odometerReading = f.odometerReading.value;
	fuelTracker.vehicle = f.vehicle.value;
	console.log(fuelTracker);
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/fuelTrackers');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				let addedFuelTracker = JSON.parse(xhr.responseText);
				console.log(addedFuelTracker);
				displayFilm(addedFuelTracker);
			}
		}
	}
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON
	xhr.send(JSON.stringify(fuelTracker));
}
function deleteFuelTracker(fuelTrackerId) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELTE', 'api/fuelTrackers/' + fuelTrackerId, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log('Found fuel tracker entry ' + fuelTrackerId);
				let fuelTracker = JSON.parse(xhr.responseText);
				console.log(fuelTracker);

				displayFuelTracker(fuelTracker);
			} else {
				document.getElementById('FuelTrackerData').textContent = 'Fuel Tracker entry not Found';
			}
		}
	}
	xhr.send(null);
}