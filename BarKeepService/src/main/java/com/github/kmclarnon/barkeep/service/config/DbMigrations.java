package com.github.kmclarnon.barkeep.service.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import io.dropwizard.lifecycle.Managed;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

@Singleton
public class DbMigrations implements Managed {
  private static final Logger LOG = LoggerFactory.getLogger(DbMigrations.class);

  private final DataSource dataSource;

  @Inject
  public DbMigrations(DataSource dataSource) {
      this.dataSource = dataSource;
  }

  @Override
  public void start() throws Exception {
    LOG.info("Starting database migrations");
    try {
      JdbcConnection connection = new JdbcConnection(dataSource.getConnection());
      new Liquibase("migrations.xml", new ClassLoaderResourceAccessor(DbMigrations.class.getClassLoader()), connection)
          .update(new Contexts(""));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void stop() throws Exception {
    // nothing to do here
  }
}
