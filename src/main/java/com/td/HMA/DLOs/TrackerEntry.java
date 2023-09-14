package com.td.HMA.DLOs;

import com.td.HMA.DAOs.Tracker;
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
public class TrackerEntry {

    private Integer id;
    private String comment;
    private Tracker tracker;
    private MealTime mealTime;
    private Double weight;
    private ActivityDuration activityDuration;
    private Mood mood;
    private LocalDate date;
    private Integer version;
}
