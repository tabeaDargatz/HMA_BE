package com.td.HMA.controllers;

import com.td.HMA.DTOs.tracker.CreateTracker;
import com.td.HMA.DTOs.tracker.TrackerDetails;
import com.td.HMA.DTOs.tracker.UpdateTracker;
import com.td.HMA.mappers.DTOToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.TrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class TrackerController {

  @Autowired private TrackerService trackerService;
  @Autowired private DomainToDTOMapper domainToDTOMapper;
  @Autowired private DTOToDomainMapper dtoToDomainMapper;

  @GetMapping("/trackers/{id}")
  public ResponseEntity<TrackerDetails> getTracker(@PathVariable Integer id) {
    return ResponseEntity.ok(domainToDTOMapper.mapToDTO(trackerService.getTracker(id)));
  }

  @PostMapping("/trackers")
  public ResponseEntity<TrackerDetails> createTracker(@RequestBody CreateTracker createTracker) {
    TrackerDetails trackerDetails =
        domainToDTOMapper.mapToDTO(
            trackerService.createTracker(dtoToDomainMapper.mapToDomain(createTracker)));

    return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(trackerDetails.getId())
                .toUri())
        .body(trackerDetails);
  }

  @PutMapping("/trackers/{id}")
  public ResponseEntity<TrackerDetails> updateTracker(
      @PathVariable Integer id, @RequestBody UpdateTracker updateTracker) {
    return ResponseEntity.ok(
        domainToDTOMapper.mapToDTO(
            trackerService.updateTracker(id, dtoToDomainMapper.mapToDomain(updateTracker))));
  }
}
