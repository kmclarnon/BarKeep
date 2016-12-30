package com.github.kmclarnon.barkeep.core.model;

import org.immutables.value.Value;

import com.github.kmclarnon.barkeep.core.BarKeepStyle;

@BarKeepStyle
@Value.Immutable
public abstract class AbstractDrinkRecord {
  public abstract int getId();
  public abstract String getName();
  public abstract String getStyle();
  public abstract String getSource();
  public abstract String getGarnish();
  public abstract String getGlass();
  public abstract String getDirections();
  public abstract long getDateAdded();
  public abstract long getDateTried();
}
