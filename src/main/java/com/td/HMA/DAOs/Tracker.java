package com.td.HMA.DAOs;

import com.td.HMA.enums.TrackerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRACKERS")
public class Tracker {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "VERSION", nullable = false)
    private Integer version;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private TrackerType type;
    @Column(name = "CUSTOM_NAME", length = 60)
    private String customName;
    @Column(name = "COMMENT", length = 150)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY_USER_ID")
    private User createdBy;
    @Column(name = "STREAK")
    private int streak;
    @Column(name = "CREATED_ON")
    private OffsetDateTime createdOn;
    @Column(name = "UPDATED_ON")
    private OffsetDateTime updatedOn;
}
