package com.td.HMA.DLOs;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackerEntry {

  private Integer id;
  private String comment;
  private Tracker tracker;
  private MealTime mealTime;
  private Double weight;
  private ActivityDuration activityDuration;
  private Mood mood;
  private String customName;
  private OffsetDateTime createdOn;
  private LocalDate date;
  private Integer version;
}
