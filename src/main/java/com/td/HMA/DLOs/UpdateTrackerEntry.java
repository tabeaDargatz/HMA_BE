package com.td.HMA.DLOs;

import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTrackerEntry {

    private String comment;
    private MealTime mealTime;
    private Double weight;
    private ActivityDuration activityDuration;
    private Mood mood;
    private Integer version;
}
