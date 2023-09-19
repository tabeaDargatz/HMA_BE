package com.td.HMA.DTOs.trackerEntry;

import com.td.HMA.enums.TimeOfDay;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MealTime {
  private TimeOfDay timeOfDay;
  private String name;
  private Integer calories;
}
