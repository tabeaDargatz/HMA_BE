package com.td.HMA.DTOs.trackerEntry;

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
  private String customName;
    private ActivityDuration activityDuration;
    private Mood mood;
    private Integer version;
}
