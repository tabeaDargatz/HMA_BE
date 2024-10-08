package com.td.HMA.DAOs.embeddable;

import com.td.HMA.enums.MoodPrefix;
import com.td.HMA.enums.MoodType;
import jakarta.persistence.Embeddable;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Mood {

    private MoodType type;
    private MoodPrefix prefix;
    private OffsetDateTime recordedAt;

}
