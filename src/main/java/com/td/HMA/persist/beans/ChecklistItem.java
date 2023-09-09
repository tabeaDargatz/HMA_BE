package com.td.HMA.persist.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "TRACKER_ENTRIES")
public class ChecklistItem {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CHECKED")
    private boolean checked;
    @ManyToOne
    @JoinColumn(name = "TRACKER_ENTRY_ID")
    private TrackerEntry trackerEntry;

}
