package com.td.HMA.DLOs;

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
