package com.td.HMA.controllers;

import com.td.HMA.DTOs.tracker.CreateTracker;
import com.td.HMA.DTOs.tracker.TrackerDetails;
import com.td.HMA.DTOs.tracker.UpdateTracker;
import com.td.HMA.mappers.DTOToDomainMapper;
import com.td.HMA.mappers.DomainToDTOMapper;
import com.td.HMA.services.TrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;
    @Autowired
    private DomainToDTOMapper domainToDTOMapper;
    @Autowired
    private DTOToDomainMapper dtoToDomainMapper;

    //TODO: figure out security shtuff
    @GetMapping("/trackers/{id}")
    public TrackerDetails getTracker(@PathVariable Integer id) {
        return domainToDTOMapper.mapToDTO(trackerService.getTracker(id));
    }

    @PostMapping("/trackers")
    public TrackerDetails createTracker(@RequestBody CreateTracker createTracker) {
        return domainToDTOMapper.mapToDTO(trackerService.createTracker(dtoToDomainMapper.mapToDomain(createTracker)));
    }

    @PutMapping("/trackers/{id}")
    public TrackerDetails updateTracker(@PathVariable Integer id, @RequestBody UpdateTracker updateTracker){
        return domainToDTOMapper.mapToDTO(trackerService.updateTracker(id,dtoToDomainMapper.mapToDomain(updateTracker)));
    }

}
