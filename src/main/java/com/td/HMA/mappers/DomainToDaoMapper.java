package com.td.HMA.mappers;

import com.td.HMA.DAOs.TrackerEntry;
import com.td.HMA.DLOs.Tracker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DomainToDaoMapper {

    //TODO: check unmapped target properties (in all mappers!)
    TrackerEntry mapToDao(com.td.HMA.DLOs.TrackerEntry trackerEntry);

    com.td.HMA.DAOs.Tracker mapToDao(Tracker tracker);
}
