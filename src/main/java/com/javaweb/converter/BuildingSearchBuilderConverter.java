package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingSearchBuilderConverter {
  public static BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest b, List<String> typeCode) {
    BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                                                                          .setName(b.getName())
                                                                          .setFloorArea(b.getFloorArea())
                                                                          .setWard(b.getWard())
                                                                          .setStreet(b.getStreet())
                                                                          .setDistrictid(b.getDistrict())
                                                                          .setNumberOfBasement(b.getNumberOfBasement())
                                                                          .setTypeCode(typeCode)
                                                                          .setManagerName(b.getManagerName())
                                                                          .setmanagerPhone(b.getManagerPhone())
                                                                          .setRentPriceFrom(b.getRentPriceFrom())
                                                                          .setRentPriceTo(b.getRentPriceTo())
                                                                          .setAreaFrom(b.getAreaFrom())
                                                                          .setAreaTo(b.getAreaTo())
                                                                          .setStaffId(b.getStaffId())
                                                                          .build();
    return buildingSearchBuilder;
  }
}
