package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentAreaRepository extends JpaRepository<RentareaEntity, Long> {
  void deleteBybuildingEntity(BuildingEntity buildingEntity);
  RentareaEntity findBybuildingEntity(BuildingEntity buildingEntity);
}
