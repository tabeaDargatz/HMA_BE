package com.td.HMA.DAOs.embeddable;

import com.td.HMA.enums.TimeOfDay;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class MealTime {

    private TimeOfDay timeOfDay;
    private String name;
    private Integer calories;

}
