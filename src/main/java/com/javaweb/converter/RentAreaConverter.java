package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import com.javaweb.model.dto.BuildingDTO;

public class RentAreaConverter {
  public static RentareaEntity toRentAreaEntity(BuildingDTO buildingDTO, Long val) {
    RentareaEntity rentarea = new RentareaEntity();
    BuildingEntity buildingEntity = new BuildingEntity();
    buildingEntity.setId(buildingDTO.getId());
    rentarea.setValue(val);
    rentarea.setBuilding(buildingEntity);
    return rentarea;
  }
}
