package com.td.HMA.DTOs.trackerEntry;

import com.td.HMA.enums.MoodPrefix;
import com.td.HMA.enums.MoodType;
import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mood {
  private MoodType type;
  private MoodPrefix prefix;
  private Instant recordedAt;
}
