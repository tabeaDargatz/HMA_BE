package com.td.HMA.mappers;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.UpdateTrackerEntry;
import com.td.HMA.DTOs.tracker.CreateTracker;
import com.td.HMA.DTOs.tracker.UpdateTracker;
import com.td.HMA.DTOs.trackerEntry.ActivityDuration;
import com.td.HMA.DTOs.trackerEntry.CreateTrackerEntry;
import com.td.HMA.DTOs.trackerEntry.MealTime;
import com.td.HMA.DTOs.trackerEntry.Mood;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DTOToDomainMapper {

  @Mapping(target = "version", ignore = true)
  @Mapping(target = "tracker", ignore = true) // added manually in the service
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdOn", ignore = true)
  com.td.HMA.DLOs.TrackerEntry mapToDomain(CreateTrackerEntry createTrackerEntry);

    UpdateTrackerEntry mapToDomain(com.td.HMA.DTOs.trackerEntry.UpdateTrackerEntry updateTrackerEntry);

    com.td.HMA.DLOs.UpdateTracker mapToDomain(UpdateTracker updateTracker);

  @Mapping(target = "version", ignore = true)
  @Mapping(target = "streak", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  Tracker mapToDomain(CreateTracker createTracker);

  public default OffsetDateTime mapToDomain(Instant instant) {
    return instant == null ? null : instant.atOffset(ZoneOffset.UTC);
  }

  com.td.HMA.DLOs.MealTime mapToDomain(MealTime mealTime);

  com.td.HMA.DLOs.Mood mapToDomain(Mood mealTime);

  com.td.HMA.DLOs.ActivityDuration mapToDomain(ActivityDuration mealTime);
}
