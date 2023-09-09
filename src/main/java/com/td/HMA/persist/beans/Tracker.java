package com.td.HMA.persist.beans;

import com.td.HMA.enums.TrackerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "TRACKERS")
public class Tracker {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private TrackerType type;
    @Column(name = "COMMENT", length = 150)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY_USER_ID")
    private User createdBy;

    @Column(name = "STREAK")
    private int streak;
}
