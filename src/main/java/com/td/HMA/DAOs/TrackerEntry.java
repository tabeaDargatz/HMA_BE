package com.td.HMA.DAOs;

import com.td.HMA.DAOs.embeddable.ActivityDuration;
import com.td.HMA.DAOs.embeddable.MealTime;
import com.td.HMA.DAOs.embeddable.Mood;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRACKER_ENTRIES")
public class TrackerEntry {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "COMMENT", length = 150)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "TRACKER_ID")
    private Tracker tracker;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "timeOfDay", column = @Column(name = "MEALTIME_TIME_OF_DAY")),
            @AttributeOverride(name = "name", column = @Column(name = "MEALTIME_NAME")),
            @AttributeOverride(name = "calories", column = @Column(name = "MEALTIME_CALORIES"))
    })
    private MealTime mealTime;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "ACTIVITY_DURATION_NAME")),
            @AttributeOverride(name = "duration", column = @Column(name = "ACTIVITY_DURATION")),
            @AttributeOverride(name = "comment", column = @Column(name = "ACTIVITY_DURATION_COMMENT"))
    })
    private ActivityDuration activityDuration;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "MOOD_TYPE")),
            @AttributeOverride(name = "prefix", column = @Column(name = "MOOD_PREFIX")),
            @AttributeOverride(name = "recordedAt", column = @Column(name = "MOOD_RECORDED_AT"))
    })
    private Mood mood;
    @Column(name = "WEIGHT", nullable = false)
    private Double weight;
    @Column(name = "CREATED_ON", nullable = false)
    private OffsetDateTime createdOn;
    @Column(name = "VERSION", nullable = false)
    private Integer version;
    @Column(name = "DATE", nullable = false)
    private LocalDate date;
    @Column(name = "UPDATED_ON", nullable = false)
    private OffsetDateTime updatedOn;
}
