package com.td.HMA.DTOs.trackerEntry;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTrackerEntry {

    private String comment;
    private MealTime mealTime;
  private String customName;
    private ActivityDuration activityDuration;
    private Mood mood;
  private Double weight;
    private LocalDate date;
}
