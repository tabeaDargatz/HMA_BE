package com.td.HMA.controller;

import com.td.HMA.bl.TrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

}
