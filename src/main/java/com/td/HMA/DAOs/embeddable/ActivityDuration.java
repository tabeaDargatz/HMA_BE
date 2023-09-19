package com.td.HMA.DAOs.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class ActivityDuration {

    private String name;
    private Long duration;
    private String comment;

}
