package com.td.HMA.mappers;

import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.TrackerEntry;
import com.td.HMA.DLOs.UpdateTrackerEntry;
import com.td.HMA.DLOs.User;
import com.td.HMA.DTOs.tracker.TrackerDetails;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryDetails;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryListItem;
import com.td.HMA.DTOs.user.UserDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainToDTOMapper {

    UserDetails mapToDTO(User user);
    TrackerDetails mapToDTO(Tracker tracker);

    List<TrackerEntryListItem> mapToDTO(List<TrackerEntry> trackerEntryListItems);

    TrackerEntryListItem mapToDTOListItem(TrackerEntry trackerEntry);
    TrackerEntryDetails mapToDTO(TrackerEntry trackerEntry);
}
