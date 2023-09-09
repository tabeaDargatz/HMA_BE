package com.td.HMA.persist.beans;

import com.td.HMA.persist.beans.embeddable.ActivityDuration;
import com.td.HMA.persist.beans.embeddable.MealTime;
import com.td.HMA.persist.beans.embeddable.Mood;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
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
    @Column(name = "NAME", nullable = false)
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "timeOfDay", column = @Column(name = "TIME_OF_DAY")),
            @AttributeOverride(name = "name", column = @Column(name = "NAME")),
            @AttributeOverride(name = "calories", column = @Column(name = "CALORIES"))
    })
    private MealTime mealTime;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "NAME")),
            @AttributeOverride(name = "duration", column = @Column(name = "DURATION")),
            @AttributeOverride(name = "comment", column = @Column(name = "COMMENT"))
    })
    private ActivityDuration activityDuration;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "TYPE")),
            @AttributeOverride(name = "prefix", column = @Column(name = "PREFIX")),
            @AttributeOverride(name = "recordedAt", column = @Column(name = "RECORDED_AT"))
    })
    private Mood mood;
    @Column(name = "CREATED_ON")
    private OffsetDateTime createdOn;
}
