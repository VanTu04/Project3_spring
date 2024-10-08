package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
  @Autowired
  private ModelMapper modelMapper;

  public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity buildingEntity) {
    BuildingSearchResponse buildingSearchResponse = modelMapper.map(buildingEntity,BuildingSearchResponse.class);
    Map<String,String> dictricts = DistrictCode.type();
    String districtName = "";
    if(buildingEntity.getDistrict() != null && buildingEntity.getDistrict() != ""){
      districtName = dictricts.get(buildingEntity.getDistrict());
      buildingSearchResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", " + districtName);
    }

    List<RentareaEntity> rentareaEntities = buildingEntity.getRentareaList();
    String resultRentArea = rentareaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
    buildingSearchResponse.setRentArea(resultRentArea);
    return buildingSearchResponse;
  }
}
