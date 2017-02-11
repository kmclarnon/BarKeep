package com.github.kmclarnon.barkeep.service.config;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

import com.github.kmclarnon.barkeep.service.config.utils.DaoBinder;
import com.github.kmclarnon.barkeep.service.config.utils.LowerCaseWithUnderscoresModule;
import com.github.kmclarnon.barkeep.service.data.DrinksDao;
import com.github.kmclarnon.barkeep.service.resources.DrinksResource;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.hubspot.dropwizard.guicier.DropwizardAwareModule;
import com.hubspot.rosetta.Rosetta;

public class BarKeepServiceModule extends DropwizardAwareModule<BarKeepConfiguration> {

  @Override
  public void configure(Binder binder) {
    // resources
    binder.bind(DrinksResource.class);

    // migrations
    binder.bind(DbMigrations.class).asEagerSingleton();

    // Rosetta configuration
    Rosetta.addModule(new LowerCaseWithUnderscoresModule());

    // Database access objects
    DaoBinder.newDaoBinder(binder)
        .addDaos(DrinksDao.class);
  }

  @Provides
  public DBI providesDbi(BarKeepConfiguration configuration) {
  }
}
