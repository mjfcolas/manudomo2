package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "intensity_seq")
public class Intensity extends ValuableEntity<Double>{
}
