window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {
	document.fuelTrackerForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var fuelTrackerId = document.fuelTrackerForm.fuelTrackerId.value;
		if (!isNaN(fuelTrackerId) && fuelTrackerId > 0) {
			getFuelTrackerList(fuelTrackerId);
		}
	})
	document.getElementById('addFuelTracker').addEventListener('click',
			function(evt) {
				event.preventDefault();
				addFuelTracker();
			});
	document.deleteFuelTrackerForm.deleteFuelTracker
			.addEventListener(
					'click',
					function(evt) {
						event.preventDefault();
						var fuelTrackerId = document.deleteFuelTrackerForm.fuelTrackerId.value;
						if (!isNaN(fuelTrackerId) && fuelTrackerId > 0) {
							deleteFuelTracker(fuelTrackerId);
						}

					});
}

function getFuelTrackerList() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/fuelTrackers/', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log('Found fuel tracker entries ');
				let fuelTracker = JSON.parse(xhr.responseText);
				console.log(fuelTracker);
				displayFuelTrackerList(fuelTracker);
			} else {
				document.getElementById('FuelTrackerData').textContent = 'Fuel Tracker entry not Found';
			}
		}
	}
	xhr.send(null);
}

function displayFuelTrackerList(fuelTracker) {
	let fuelTrackerDiv = document.getElementById('fuelTrackerData');
	fuelTrackerDiv.textContent = '';

//	let div = document.createElement('div');
//	fuelTrackerDiv.append(div);

	let h2 = document.createElement('h2');
	h2.textContent = "Fuel Tracker Entry: " + fuelTracker.date;
	fuelTrackerDiv.appendChild(h2);


	let table = document.createElement("table");
	fuelTrackerDiv.appendChild(table);
	
	let th = document.createElement("th");
	
	th.textContent = "Id";
	table.appendChild(th);	
	
	
	th.textContent = "Gallons";
	table.appendChild(th);	

//	for (let i = 0; i < fueltracker.length; i++) {
//		let tr = document.createElement("tr");
//		th.appendChild(tr);
//		
//		for (let j = 0; j < fueltracker.length; j++) {
//			let td = document.createElement("td");
//			
//			td.textContent = fuelTracker.id;
//			tr.appendChild(td);
//		}
//	}
	

//			cellText.textContent = "Gallons: " + fuelTracker.gallons;
//			td.appendChild(cellText);
//
//			cellText.textContent = "Price/Gallon: "
//					+ fuelTracker.pricePerGallon;
//			td.appendChild(cellText);
			//					
			// li = document.createElement("li");
			// li.textContent = "Total Purchase Price: " +
			// fuelTracker.totalPurchasePrice;
			// td.appendChild(cellText);
			//					
			// li = document.createElement("li");
			// li.textContent = "Estimated Miles: " +
			// fuelTracker.estimatedMiles;
			// td.appendChild(cellText);
			//					
			// li = document.createElement("li");
			// li.textContent = "Odometer Reading: " +
			// fuelTracker.odometerReading;
			// td.appendChild(cellText);

	// let ul = document.createElement("ul");
	//	
	// for (let i = 0; i < fuelTracker.length; i++) {
	// let li = document.createElement("li");
	//		
	// li.textContent = "Id: " + fuelTracker.id ;
	// ul.appendChild(li);
	//		
	// li.textContent = "Gallons: " + fuelTracker.gallons;
	// ul.appendChild(li);
	//		
	// li = document.createElement("li");
	// li.textContent = "Price/Gallon: " + fuelTracker.pricePerGallon;
	// ul.appendChild(li);
	//		
	// li = document.createElement("li");
	// li.textContent = "Total Purchase Price: " +
	// fuelTracker.totalPurchasePrice;
	// ul.appendChild(li);
	//		
	// li = document.createElement("li");
	// li.textContent = "Estimated Miles: " + fuelTracker.estimatedMiles;
	// ul.appendChild(li);
	//		
	// li = document.createElement("li");
	// li.textContent = "Odometer Reading: " + fuelTracker.odometerReading;
	// ul.appendChild(li);
	// }
	//
	// div.appendChild(ul);

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
	fuelTracker.vehicle = {
		id : f.vehicle.value
	};

	console.log(fuelTracker);
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/fuelTrackers');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 201) {
				let addedFuelTracker = JSON.parse(xhr.responseText);
				console.log(addedFuelTracker);
				displayFuelTracker(addedFuelTracker);
			}
		}
	}
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON
	xhr.send(JSON.stringify(fuelTracker));
}
function deleteFuelTracker(fuelTrackerId) {
	console.log('deleteFuelTracker() called.');
	let f = document.deleteFuelTrackerForm;
	let fuelTracker = {};
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/fuelTrackers/' + fuelTrackerId, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log('Found fuel tracker entry ' + fuelTrackerId);
				let deleteFuelTracker = JSON.parse(xhr.responseText);
				console.log(deleteFuelTracker);

			}
		}
	}
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(fuelTracker));

}
function updateFuelTracker(fuelTrackerId) {
	console.log('updateFuelTracker() called.');
	let f = document.updateFuelTrackerForm;
	let fuelTracker = {};
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/fuelTrackers/' + fuelTrackerId, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				console.log('Found fuel tracker entry ' + fuelTrackerId);
				let updateFuelTracker = JSON.parse(xhr.responseText);
				console.log(updateFuelTracker);

			}
		}
	}
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(fuelTracker));

}