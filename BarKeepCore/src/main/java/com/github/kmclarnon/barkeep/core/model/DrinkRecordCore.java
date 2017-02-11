package com.github.kmclarnon.barkeep.core.model;

public interface DrinkRecordCore {
  String getName();
  String getStyle();
  String getSource();
  String getGarnish();
  String getGlass();
  String getDirections();
  long getDateAdded();
  long getDateTried();
}
