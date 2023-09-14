package com.td.HMA.mappers;

import com.td.HMA.DAOs.TrackerEntry;
import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.User;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryListItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DaoToDomainMapper {

    User mapToDomain(com.td.HMA.DAOs.User user);
    Tracker mapToDomain(com.td.HMA.DAOs.Tracker tracker);

    List<com.td.HMA.DLOs.TrackerEntry> mapToDomain(List<TrackerEntry> trackerEntry);

    com.td.HMA.DLOs.TrackerEntry mapToDomain(TrackerEntry trackerEntry);
}
