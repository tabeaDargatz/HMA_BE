package com.td.HMA.DAOs;

import jakarta.persistence.*;
import java.time.OffsetTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIMESPAN_ITEMS")
public class TimeSpanItem {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "BEGIN_TIME")
    private OffsetTime beginning;
    @Column(name = "END_TIME")
    private OffsetTime end;
    @Column(name = "NAME", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "TRACKER_ENTRY_ID")
    private TrackerEntry trackerEntry;

  @Column(name = "VERSION", nullable = false)
  @Version
  private Integer version;
}
