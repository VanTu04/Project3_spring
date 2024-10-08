package com.javaweb.service;

import com.javaweb.entity.RentareaEntity;
import com.javaweb.model.dto.BuildingDTO;

import java.util.List;

public interface RentAreaService{
  void addRentArea(BuildingDTO buildingDTO);
  void deleteRentAreaByBuildingId(List<Long> ids);
  String getRentAreaByBuildingId(Long id);
}
