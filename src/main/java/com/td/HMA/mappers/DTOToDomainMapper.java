package com.td.HMA.mappers;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.UpdateTrackerEntry;
import com.td.HMA.DTOs.tracker.CreateTracker;
import com.td.HMA.DTOs.tracker.UpdateTracker;
import com.td.HMA.DTOs.trackerEntry.CreateTrackerEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOToDomainMapper {
    com.td.HMA.DLOs.TrackerEntry mapToDomain(CreateTrackerEntry createTrackerEntry);

    UpdateTrackerEntry mapToDomain(com.td.HMA.DTOs.trackerEntry.UpdateTrackerEntry updateTrackerEntry);

    com.td.HMA.DLOs.UpdateTracker mapToDomain(UpdateTracker updateTracker);

    Tracker mapToDomain(CreateTracker createTracker);
}
