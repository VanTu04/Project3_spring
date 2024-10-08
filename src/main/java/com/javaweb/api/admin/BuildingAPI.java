package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.AssignmentBuildingService;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional
@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

  @Autowired
  private IBuildingService buildingService;

  @Autowired
  private AssignmentBuildingService assignmentBuildingService;

  @PutMapping
  public void addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO){
    buildingService.addorUpdateBuiling(buildingDTO);
  }

  @DeleteMapping("/{ids}")
  public void deleteBuilding(@PathVariable("ids") List<Long> ids){
    buildingService.deleteBuildingList(ids);
  }

  @GetMapping("/{id}/staff")
  public ResponseDTO loadStaff(@PathVariable("id") Long id){
    ResponseDTO responseDTO = buildingService.listStaff(id);
    return responseDTO;
  }

  @PostMapping
  public void addAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
    assignmentBuildingService.addAssignmentBuilding(assignmentBuildingDTO);
  }
}