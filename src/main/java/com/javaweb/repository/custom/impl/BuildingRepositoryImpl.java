package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

  @Autowired
  private EntityManager em;

  @Override
  public List<BuildingEntity> getAllBuildings(BuildingSearchRequest buildingSearchRequest) {
    String q = "use estateadvance; SELECT id, name, street, ward, district, structure, numberofbasement, floorarea, direction, level, rentprice, rentpricedescription, servicefee, carfee, overtimefee, brokeragefee, note, managername, managerphone FROM building ";
    StringBuilder sql = new StringBuilder(q);
    Query query = em.createQuery(sql.toString(), BuildingEntity.class);
    return query.getResultList();
  }
}
