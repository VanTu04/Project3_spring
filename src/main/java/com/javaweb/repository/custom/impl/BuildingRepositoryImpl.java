package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

  @Autowired
  private EntityManager em;

  public static void jointable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
    Long staffid = buildingSearchBuilder.getStaffId();
    if(staffid != null) {
      where.append(" INNER JOIN assignmentbuilding asb ON b.id = asb.buildingid ");
    }
    Long rentAreaTo = buildingSearchBuilder.getAreaTo();
    Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
    if(rentAreaTo != null || rentAreaFrom != null) {
      where.append(" INNER JOIN rentarea r ON b.id = r.buildingid ");
    }
  }

  public static void normalWhere(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
    try {
      Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
      for(Field item : fields) {
        item.setAccessible(true);
        String fieldName = item.getName();
        if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area") && !fieldName.startsWith("rentPrice")) {
          Object value = item.get(buildingSearchBuilder);
          if(value != null && value != "") {
            if(item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {
              where.append(" AND b." + fieldName + " = " + value + " ");
            }
            else if(item.getType().getName().equals("java.lang.String")){
              where.append(" AND b." + fieldName + " LIKE '%" + value + "%' ");
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void specialWhere(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
    Long staffid = buildingSearchBuilder.getStaffId();
    if(staffid != null) {
      where.append(" AND asb.staffid = " + staffid );
    }
    Long rentAreaTo = buildingSearchBuilder.getAreaTo();
    Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
    if(rentAreaTo != null || rentAreaFrom != null) {
      if(rentAreaFrom != null) {
        where.append(" AND r.value >= " + rentAreaFrom);
      }
      if(rentAreaTo != null) {
        where.append(" AND r.value <= " + rentAreaTo);
      }
    }
    Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
    Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
    if(rentPriceTo != null || rentPriceFrom != null) {
      if(rentPriceFrom != null) {
        where.append(" AND b.rentprice >= " + rentPriceFrom);
      }
      if(rentPriceTo != null) {
        where.append(" AND b.rentprice <= " + rentPriceTo);
      }
    }
    List<String> typeCode = buildingSearchBuilder.getTypeCode();
    if(typeCode != null){
      for(String item : typeCode){
        where.append(" AND b.type like '%" + item + "%' ");
      }
    }
  }

  @Override
  public List<BuildingEntity> getAllBuildings(BuildingSearchBuilder buildingSearchBuilder) {
    StringBuilder sql = new StringBuilder();
    sql.append(" SELECT b.* FROM building b ");
    jointable(buildingSearchBuilder, sql);
    sql.append(" WHERE 1=1 ");
    normalWhere(buildingSearchBuilder, sql);
    specialWhere(buildingSearchBuilder, sql);
    sql.append(" GROUP BY b.id ");
    Query query = em.createNativeQuery(sql.toString(), BuildingEntity.class);
    return query.getResultList();
  }
}
