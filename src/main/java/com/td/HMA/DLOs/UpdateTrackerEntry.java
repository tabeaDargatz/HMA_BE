package com.td.HMA.DLOs;

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
  private String customName;
    private Integer version;
}
