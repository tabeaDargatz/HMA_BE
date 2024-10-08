package com.td.HMA.DTOs.trackerEntry;

import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackerEntryListItem {

    private Integer id;
  private Integer trackerId;
  private String customName;
  private Instant createdOn;
    private Integer version;
}
