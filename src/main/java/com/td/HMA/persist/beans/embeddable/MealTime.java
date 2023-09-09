package com.td.HMA.persist.beans.embeddable;

import com.td.HMA.enums.TimeOfDay;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MealTime {

    private TimeOfDay timeOfDay;
    @Column(name = "NAME", nullable = false)
    private String name;
    private Integer calories;

}
