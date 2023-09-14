package com.td.HMA.DTOs.trackerEntry;

import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateTrackerEntry {

    private String comment;
    private MealTime mealTime;
    private ActivityDuration activityDuration;
    private Mood mood;
    private LocalDate date;
}
