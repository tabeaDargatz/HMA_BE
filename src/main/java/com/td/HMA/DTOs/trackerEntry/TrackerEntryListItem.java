package com.td.HMA.DTOs.trackerEntry;

import com.td.HMA.DAOs.Tracker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TrackerEntryListItem {

    private Integer id;
    private Tracker tracker;
    private String name;
    private OffsetDateTime createdOn;
    private Integer version;
}
