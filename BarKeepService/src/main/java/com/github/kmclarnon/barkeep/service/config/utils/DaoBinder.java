package com.github.kmclarnon.barkeep.service.config.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.skife.jdbi.v2.DBI;

import com.google.inject.Binder;
import com.google.inject.Provider;

public class DaoBinder {

  public static Builder newDaoBinder(Binder binder) {
    return new Builder(binder);
  }

  public static class Builder {
    private final Binder binder;
    private final Set<Class<?>> daoClasses = new HashSet<>();

    public Builder(Binder binder) {
      Objects.requireNonNull(binder);
      this.binder = binder;
    }

    public Builder addDaos(Class<?> daoClass) {
      Objects.requireNonNull(daoClass);
      daoClasses.add(daoClass);
      return this;
    }

    public Builder addDaos(Class<?>... daoClasses) {
      this.daoClasses.addAll(
          Arrays.stream(daoClasses)
              .map(Objects::requireNonNull)
              .collect(Collectors.toSet()));
      return this;
    }
  }

  private DaoBinder(Binder binder, Set<Class<?>> classes) {
    Objects.requireNonNull(binder);
    Provider<DBI> dbiProvider = binder.getProvider(DBI.class);
    classes.forEach(klass -> bindDao(binder, dbiProvider, klass));
  }

  private <T> void bindDao(Binder binder, Provider<DBI> dbiProvider, Class<T> daoClass) {
    binder.bind(daoClass).toProvider(getDaoProvider(dbiProvider, daoClass));
  }

  private <T> Provider<T> getDaoProvider(Provider<DBI> dbiProvider, Class<T> daoClass) {
    return () -> dbiProvider.get().onDemand(daoClass);
  }
}
