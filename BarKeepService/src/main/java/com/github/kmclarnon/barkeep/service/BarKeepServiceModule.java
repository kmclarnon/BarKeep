package com.github.kmclarnon.barkeep.service;

import org.skife.jdbi.v2.DBI;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

public class BarKeepServiceModule extends AbstractModule {

  @Override
  protected void configure() {

  }

  @Provides
  public DBI providesDbi(Environment environment, BarKeepConfiguration configuration) {
    DBIFactory dbiFactory = new DBIFactory();
    return dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
  }
}
