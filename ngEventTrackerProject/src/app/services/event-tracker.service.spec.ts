import { TestBed } from '@angular/core/testing';

import { EventTrackerService } from './event-tracker.service';

describe('EventTrackerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventTrackerService = TestBed.get(EventTrackerService);
    expect(service).toBeTruthy();
  });
});
