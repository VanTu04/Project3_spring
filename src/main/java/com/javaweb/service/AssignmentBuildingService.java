package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;

import java.util.List;

public interface AssignmentBuildingService {
  void deleteAssignmentBuildingByBuildingId(List<Long> Ids);

  void addAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
