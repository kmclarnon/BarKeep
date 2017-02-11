package com.github.kmclarnon.barkeep.service.data;

import java.util.Optional;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.sqlobject.customizers.SingleValueResult;

import com.github.kmclarnon.barkeep.core.model.DrinkRecord;
import com.github.kmclarnon.barkeep.core.model.DrinkRecordEgg;
import com.hubspot.rosetta.jdbi.BindWithRosetta;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;

@RegisterMapperFactory(RosettaMapperFactory.class)
public interface DrinksDao {
  String SET_FIELDS = "name = :name, style = :style, source = :source, garnish = :garnish, glass = :glass,"
      + " directions = :directions, date_added = :date_added, date_tried = :date_tried";

  @SingleValueResult
  @SqlQuery("SELECT * FROM drinks WHERE id = :id")
  Optional<DrinkRecord> getById(@Bind("id") int id);

  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO drinks SET " + SET_FIELDS)
  int insert(@BindWithRosetta DrinkRecordEgg drinkRecord);
}
