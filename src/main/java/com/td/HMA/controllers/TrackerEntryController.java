package com.td.HMA.controllers;

import com.td.HMA.DTOs.trackerEntry.CreateTrackerEntry;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryDetails;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryListItem;
import com.td.HMA.DTOs.trackerEntry.UpdateTrackerEntry;
import com.td.HMA.mappers.DTOToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.TrackerEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class TrackerEntryController {

    @Autowired
    private final TrackerEntryService trackerEntryService;
    @Autowired
    private DomainToDTOMapper domainToDTOMapper;
    @Autowired
    private DTOToDomainMapper dtoToDomainMapper;

    //replace with actual list that has filtering / pagination
    @GetMapping("/trackers/{id}/trackerEntries")
    public List<TrackerEntryListItem> getTrackerEntries(@PathVariable Integer id) {
        return domainToDTOMapper.mapToDTO(trackerEntryService.getTrackerEntriesByTrackerId(id));
    }

    @GetMapping("/trackers/{id}/trackerEntry/{entryId}")
    public TrackerEntryDetails getTrackerEntry(@PathVariable Integer id, @PathVariable Integer entryId) {
        return domainToDTOMapper.mapToDTO(trackerEntryService.getTrackerEntry(id, entryId));
    }

    @PostMapping("/trackers/{id}/trackerEntry")
    public TrackerEntryDetails createTrackerEntry(@PathVariable Integer id, @RequestBody CreateTrackerEntry createTrackerEntry) {
        return domainToDTOMapper.mapToDTO(trackerEntryService.createTrackerEntry(id, dtoToDomainMapper.mapToDomain(createTrackerEntry)));
    }

    @PutMapping("/trackers/{id}/trackerEntry/{entryId}")
    public TrackerEntryDetails updateTrackerEntry(@PathVariable Integer id, @PathVariable Integer entryId, @RequestBody UpdateTrackerEntry updateTrackerEntry){
        return domainToDTOMapper.mapToDTO(trackerEntryService.updateTrackerEntry(id,entryId,dtoToDomainMapper.mapToDomain(updateTrackerEntry)));
    }
}
