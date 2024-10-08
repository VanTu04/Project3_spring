package com.javaweb.service.impl;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentBuildingServiceImpl implements AssignmentBuildingService {

  @Autowired
  private AssignmentBuildingRepository assignmentBuildingRepository;

  @Autowired
  private BuildingRepository buildingRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void deleteAssignmentBuildingByBuildingId(List<Long> Ids) {
    for(Long item : Ids){
      BuildingEntity buildingEntity = buildingRepository.findById(item).get();
      assignmentBuildingRepository.deleteBybuildingEntity(buildingEntity);
    }
  }

  @Override
  public void addAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
    BuildingEntity building = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
    assignmentBuildingRepository.deleteBybuildingEntity(building);

    List<Long> staffs = assignmentBuildingDTO.getStaffs();
    for(Long staff : staffs){
      AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
      assignmentBuildingEntity.setBuilding(building);
      UserEntity userEntity = userRepository.findById(staff).get();
      assignmentBuildingEntity.setStaffs(userEntity);
      assignmentBuildingRepository.save(assignmentBuildingEntity);
    }
  }
}
