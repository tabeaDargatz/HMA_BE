package com.td.HMA.DTOs.trackerEntry;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackerEntryDetails {

  private Integer id;
  private String comment;
  private Integer trackerId;
  private String customName;
  private MealTime mealTime;
  private ActivityDuration activityDuration;
  private Mood mood;
  private Double weight;
  private LocalDate date;
  private Integer version;
}
