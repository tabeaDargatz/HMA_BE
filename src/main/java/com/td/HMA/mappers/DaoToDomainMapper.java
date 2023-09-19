package com.td.HMA.mappers;

import com.td.HMA.DAOs.TrackerEntry;
import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import com.td.HMA.DLOs.Tracker;
import com.td.HMA.DLOs.User;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DaoToDomainMapper {

    User mapToDomain(com.td.HMA.DAOs.User user);

    Tracker mapToDomain(com.td.HMA.DAOs.Tracker tracker);

    List<com.td.HMA.DLOs.TrackerEntry> mapToDomain(List<TrackerEntry> trackerEntry);

    com.td.HMA.DLOs.TrackerEntry mapToDomain(TrackerEntry trackerEntry);

  com.td.HMA.DLOs.MealTime mapToDomain(MealTime mealTime);

  com.td.HMA.DLOs.Mood mapToDomain(Mood mealTime);

  com.td.HMA.DLOs.ActivityDuration mapToDomain(ActivityDuration mealTime);
}
