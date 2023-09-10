package com.td.HMA.persist.beans.embeddable;

import com.td.HMA.enums.TimeOfDay;
import jakarta.persistence.Embeddable;

@Embeddable
public class MealTime {

    private TimeOfDay timeOfDay;
    private String name;
    private Integer calories;

}
