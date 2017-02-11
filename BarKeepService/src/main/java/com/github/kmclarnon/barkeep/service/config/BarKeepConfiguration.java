package com.github.kmclarnon.barkeep.service.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.postgresql.osgi.PGDataSourceFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class BarKeepConfiguration extends Configuration {
  private DataSource dataSource = null;
  private String dbEnvironmentVariable;

  @JsonProperty("dbEnvironmentVariable")
  public String getDbEnvironmentVariable() {
    return dbEnvironmentVariable;
  }

  public void setDbEnvironmentVariable(String dbEnvironmentVariable) {
    this.dbEnvironmentVariable = dbEnvironmentVariable;
  }

  public DataSource getDataSource() {
    if (dataSource == null) {
      initDataSource();
    }

    return dataSource;
  }

  private void initDataSource() {
    PGDataSourceFactory dataSourceFactory = new PGDataSourceFactory();
    Properties properties = new Properties();
    // install db properties here

    try {
      dataSource = dataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

