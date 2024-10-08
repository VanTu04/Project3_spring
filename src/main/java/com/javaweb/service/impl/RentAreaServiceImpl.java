package com.javaweb.service.impl;

import com.javaweb.converter.RentAreaConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.RentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentAreaServiceImpl implements RentAreaService {

  @Autowired
  private BuildingRepository buildingRepository;

  @Autowired
  private RentAreaRepository rentAreaRepository;

  @Override
  public void addRentArea(BuildingDTO buildingDTO) {
    BuildingEntity buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
    rentAreaRepository.deleteBybuildingEntity(buildingEntity);

    String[] rentArea = buildingDTO.getRentarea().toString().split(",");
    for(String item : rentArea){
      RentareaEntity rentareaEntity = RentAreaConverter.toRentAreaEntity(buildingDTO, Long.valueOf(item));
      rentAreaRepository.save(rentareaEntity);
    }
  }

  @Override
  public void deleteRentAreaByBuildingId(List<Long> ids) {
    for(Long item : ids){
      BuildingEntity buildingEntity = buildingRepository.findById(item).get();
      rentAreaRepository.deleteBybuildingEntity(buildingEntity);
    }
  }

  @Override
  public String getRentAreaByBuildingId(Long id) {
    List<RentareaEntity> rentareaEntities = buildingRepository.findById(id).get().getRentareaList();
    String resultRentArea = rentareaEntities.stream().map(item -> item.getValue().toString()).collect(Collectors.joining(","));
    return resultRentArea;
  }
}
