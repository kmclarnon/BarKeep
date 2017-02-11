package com.github.kmclarnon.barkeep.service;

import com.github.kmclarnon.barkeep.service.config.BarKeepConfiguration;
import com.github.kmclarnon.barkeep.service.config.BarKeepServiceModule;
import com.hubspot.dropwizard.guicier.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BarKeepService extends Application<BarKeepConfiguration> {

  public static final String SERVICE_NAME = "BarKeep Service";

  public static void main(String[] args) throws Exception {
    new BarKeepService().run(args);
  }

  @Override
  public void initialize(Bootstrap<BarKeepConfiguration> bootstrap) {
    GuiceBundle<BarKeepConfiguration> guiceBundle = GuiceBundle.defaultBuilder(BarKeepConfiguration.class)
        .modules(new BarKeepServiceModule())
        .build();

    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public String getName() {
    return SERVICE_NAME;
  }

  @Override
  public void run(BarKeepConfiguration configuration, Environment environment) throws Exception { }
}
