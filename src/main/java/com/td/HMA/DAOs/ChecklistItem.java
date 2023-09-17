package com.td.HMA.DAOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CHECKLIST_ITEMS")
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
    @JoinColumn(name = "TRACKER_ENTRY_ID",nullable = false)
    private TrackerEntry trackerEntry;
    @Column(name = "VERSION", nullable = false)
    private Integer version;

}
