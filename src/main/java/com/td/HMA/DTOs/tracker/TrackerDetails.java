package com.td.HMA.DTOs.tracker;

import com.td.HMA.enums.TrackerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackerDetails {
    private Integer id;
    private Integer version;
    private TrackerType type;
    private String customName;
    private String comment;
    private Integer createdById;
    private int streak;
}
