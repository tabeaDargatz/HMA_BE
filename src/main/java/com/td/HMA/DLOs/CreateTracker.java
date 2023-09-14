package com.td.HMA.DLOs;

import com.td.HMA.enums.TrackerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTracker {
    private Integer version;
    private TrackerType type;
    private String customName;
    private String comment;
}
