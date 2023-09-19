package com.td.HMA.mappers;

import com.td.HMA.DAOs.TrackerEntry;
import com.td.HMA.DAOs.User;
import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import com.td.HMA.DLOs.CreateUser;
import com.td.HMA.DLOs.Tracker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class DomainToDaoMapper {

  @PersistenceContext EntityManager entityManager;

  @Mapping(target = "updatedOn", expression = "java(java.time.OffsetDateTime.now())")
  @Mapping(target = "createdOn", expression = "java(java.time.OffsetDateTime.now())")
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "tracker", source = "tracker.id")
  public abstract TrackerEntry mapToCreateDao(com.td.HMA.DLOs.TrackerEntry trackerEntry);

  @Mapping(target = "updatedOn", ignore = true)
  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "tracker", source = "tracker.id")
  public abstract void mapToUpdateDao(
      @MappingTarget TrackerEntry trackerEntryEntity, com.td.HMA.DLOs.TrackerEntry trackerEntry);

  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "updatedOn", ignore = true)
  @Mapping(target = "createdBy", source = "userId")
  @Mapping(target = "version", ignore = true)
  public abstract com.td.HMA.DAOs.Tracker mapToCreateDao(Tracker tracker, Integer userId);

  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "updatedOn", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "version", ignore = true)
  public abstract com.td.HMA.DAOs.Tracker mapToUpdateDao(Tracker tracker);

  @Mapping(target = "version", ignore = true)
  @Mapping(target = "id", ignore = true)
  public abstract User mapToDao(CreateUser createUser);

  public abstract MealTime mapToDao(com.td.HMA.DLOs.MealTime mealTime);

  public abstract Mood mapToDao(com.td.HMA.DLOs.Mood mealTime);

  public abstract ActivityDuration mapToDao(com.td.HMA.DLOs.ActivityDuration mealTime);

  public com.td.HMA.DAOs.Tracker toTrackerEntity(Integer id) {
    return id == null ? null : entityManager.getReference(com.td.HMA.DAOs.Tracker.class, id);
  }

  public User toUserEntity(Integer id) {
    return id == null ? null : entityManager.getReference(com.td.HMA.DAOs.User.class, id);
  }
}
