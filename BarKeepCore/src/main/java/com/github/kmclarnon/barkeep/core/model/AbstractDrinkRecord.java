package com.github.kmclarnon.barkeep.core.model;

import org.immutables.value.Value;

import com.github.kmclarnon.barkeep.core.BarKeepStyle;

@BarKeepStyle
@Value.Immutable
public abstract class AbstractDrinkRecord implements DrinkRecordCore {
  public abstract int getId();
}
