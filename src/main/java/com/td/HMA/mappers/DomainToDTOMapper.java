package com.td.HMA.mappers;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.TrackerEntry;
import com.td.HMA.DLOs.User;
import com.td.HMA.DTOs.tracker.TrackerDetails;
import com.td.HMA.DTOs.trackerEntry.*;
import com.td.HMA.DTOs.user.CreateUser;
import com.td.HMA.DTOs.user.UserDetails;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DomainToDTOMapper {

    UserDetails mapToDTO(User user);

  @Mapping(target = "createdById", source = "createdBy.id")
  TrackerDetails mapToDTO(Tracker tracker);

    List<TrackerEntryListItem> mapToDTO(List<TrackerEntry> trackerEntryListItems);

  @Mapping(target = "trackerId", source = "tracker.id")
  TrackerEntryListItem mapToDTOListItem(TrackerEntry trackerEntry);

  @Mapping(target = "trackerId", source = "tracker.id")
  TrackerEntryDetails mapToDTO(TrackerEntry trackerEntry);

    com.td.HMA.DLOs.CreateUser mapToDTO(CreateUser createUser);

  MealTime mapToDTO(com.td.HMA.DLOs.MealTime mealTime);

  Mood mapToDTO(com.td.HMA.DLOs.Mood mealTime);

  ActivityDuration mapToDTO(com.td.HMA.DLOs.ActivityDuration mealTime);

  public default Instant mapToDTO(OffsetDateTime offsetDateTime) {
    return offsetDateTime == null ? null : offsetDateTime.toInstant();
  }
}
