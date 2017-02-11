package com.github.kmclarnon.barkeep.core.model;

import org.immutables.value.Value;

import com.github.kmclarnon.barkeep.core.BarKeepStyle;

@BarKeepStyle
@Value.Immutable
public abstract class AbstractDrinkRecordEgg implements DrinkRecordCore {
  public DrinkRecord toRecord(int id) {
    return DrinkRecord.builder()
        .from(this)
        .setId(id)
        .build();
  }
}
