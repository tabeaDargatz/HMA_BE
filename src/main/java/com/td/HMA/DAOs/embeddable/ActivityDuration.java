package com.td.HMA.DAOs.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ActivityDuration {

    private String name;
    private Long duration;
    private String comment;

}
