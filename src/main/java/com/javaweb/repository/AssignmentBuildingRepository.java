package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity, Long> {
  List<AssignmentBuildingEntity> findBybuildingEntity(BuildingEntity buildingEntity);
  void deleteBybuildingEntity(BuildingEntity buildingEntity);
}
