package com.td.HMA.DLOs;

import com.td.HMA.DAOs.User;
import com.td.HMA.enums.TrackerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tracker {

    private Integer id;
    private Integer version;
    private TrackerType type;
    private String customName;
    private String comment;
    private User createdBy;
    private int streak;
}
