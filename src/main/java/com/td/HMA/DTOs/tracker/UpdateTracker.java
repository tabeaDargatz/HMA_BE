package com.td.HMA.DTOs.tracker;

import com.td.HMA.enums.TrackerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTracker {
    private Integer version;
    private String customName;
    private String comment;
}
