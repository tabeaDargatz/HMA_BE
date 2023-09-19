package com.td.HMA.DTOs.trackerEntry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDuration {
  private String name;
  private Long duration;
  private String comment;
}
