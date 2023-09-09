package com.td.HMA.persist.beans.embeddable;

import com.td.HMA.enums.MoodPrefix;
import com.td.HMA.enums.MoodType;
import jakarta.persistence.Embeddable;

import java.time.OffsetDateTime;

@Embeddable
public class Mood {

    private MoodType type;
    private MoodPrefix prefix;
    private OffsetDateTime recordedAt;

}
