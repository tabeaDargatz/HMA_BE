package com.td.HMA.DTOs.trackerEntry;

import com.td.HMA.DAOs.Tracker;
import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TrackerEntryDetails {

    private Integer id;
    private String comment;
    private Tracker tracker;
    private String name;
    private MealTime mealTime;
    private ActivityDuration activityDuration;
    private Mood mood;
    private Double weight;
    private OffsetDateTime createdOn;
    private Integer version;

}
