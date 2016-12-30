package com.github.kmclarnon.barkeep.service;

import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BarKeepService extends Application<BarKeepConfiguration> {

  public static final String SERVICE_NAME = "BarKeep Service";

  public static void main(String[] args) throws Exception {
    new BarKeepService().run(args);
  }

  @Override
  public void initialize(Bootstrap<BarKeepConfiguration> bootstrap) {
    GuiceBundle<BarKeepConfiguration> guiceBundle = GuiceBundle.<BarKeepConfiguration>newBuilder()
        .addModule(new BarKeepServiceModule())
        .enableAutoConfig(getClass().getPackage().getName())
        .setConfigClass(BarKeepConfiguration.class)
        .build();

    MigrationsBundle<BarKeepConfiguration> migrationsBundle = new MigrationsBundle<BarKeepConfiguration>() {
      @Override
      public DataSourceFactory getDataSourceFactory(BarKeepConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    };

    bootstrap.addBundle(guiceBundle);
    bootstrap.addBundle(migrationsBundle);
  }

  @Override
  public String getName() {
    return SERVICE_NAME;
  }

  @Override
  public void run(BarKeepConfiguration configuration, Environment environment) throws Exception {
  }
}
