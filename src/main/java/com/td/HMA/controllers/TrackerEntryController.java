package com.td.HMA.controllers;

import com.td.HMA.DTOs.trackerEntry.CreateTrackerEntry;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryDetails;
import com.td.HMA.DTOs.trackerEntry.TrackerEntryListItem;
import com.td.HMA.DTOs.trackerEntry.UpdateTrackerEntry;
import com.td.HMA.mappers.DTOToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.TrackerEntryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class TrackerEntryController {

  @Autowired private final TrackerEntryService trackerEntryService;
  @Autowired private DomainToDTOMapper domainToDTOMapper;
  @Autowired private DTOToDomainMapper dtoToDomainMapper;

  // TODO: replace with actual list that has filtering / pagination
  @GetMapping("/trackers/{id}/trackerEntries")
  public ResponseEntity<List<TrackerEntryListItem>> getTrackerEntries(@PathVariable Integer id) {
    return ResponseEntity.ok(
        domainToDTOMapper.mapToDTO(trackerEntryService.getTrackerEntriesByTrackerId(id)));
  }

  @GetMapping("/trackers/{id}/trackerEntry/{entryId}")
  public ResponseEntity<TrackerEntryDetails> getTrackerEntry(
      @PathVariable Integer id, @PathVariable Integer entryId) {
    return ResponseEntity.ok(
        domainToDTOMapper.mapToDTO(trackerEntryService.getTrackerEntry(id, entryId)));
  }

  @PostMapping("/trackers/{id}/trackerEntry")
  public ResponseEntity<TrackerEntryDetails> createTrackerEntry(
      @PathVariable Integer id, @RequestBody CreateTrackerEntry createTrackerEntry) {
    TrackerEntryDetails trackerEntryDetails =
        domainToDTOMapper.mapToDTO(
            trackerEntryService.createTrackerEntry(
                id, dtoToDomainMapper.mapToDomain(createTrackerEntry)));

    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(trackerEntryDetails.getId())
                .toUri())
        .body(trackerEntryDetails);
  }

  @PutMapping("/trackers/{id}/trackerEntry/{entryId}")
  public ResponseEntity<TrackerEntryDetails> updateTrackerEntry(
      @PathVariable Integer id,
      @PathVariable Integer entryId,
      @RequestBody UpdateTrackerEntry updateTrackerEntry) {
    return ResponseEntity.ok(
        domainToDTOMapper.mapToDTO(
            trackerEntryService.updateTrackerEntry(
                id, entryId, dtoToDomainMapper.mapToDomain(updateTrackerEntry))));
  }
}
