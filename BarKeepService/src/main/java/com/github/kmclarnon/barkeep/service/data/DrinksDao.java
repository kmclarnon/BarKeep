package com.github.kmclarnon.barkeep.service.data;

import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;

import com.hubspot.rosetta.jdbi.RosettaMapperFactory;

@RegisterMapperFactory(RosettaMapperFactory.class)
public interface DrinksDao {

}
