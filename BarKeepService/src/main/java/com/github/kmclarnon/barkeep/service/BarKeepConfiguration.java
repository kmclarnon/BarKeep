package com.github.kmclarnon.barkeep.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class BarKeepConfiguration extends Configuration {

  @JsonProperty
  private DataSourceFactory database = new DataSourceFactory();

  public DataSourceFactory getDataSourceFactory() {
    return database;
  }
}
