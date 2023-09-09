package com.td.HMA.persist.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "TRACKER_ENTRIES")
public class TimeSpanItem {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    private OffsetTime beginning;
    private OffsetTime end;
    @Column(name = "NAME", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "TRACKER_ENTRY_ID")
    private TrackerEntry trackerEntry;

}
