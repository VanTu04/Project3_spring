package com.javaweb.api.admin;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

  @Autowired
  private IBuildingService buildingService;

  @PostMapping
  public BuildingDTO addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO){

    return buildingDTO;
  }

  @DeleteMapping("/{ids}")
  public void deleteBuilding(@PathVariable("ids") String ids){
    //xuong db xoa building theo id

  }

  @GetMapping("/{id}/staff")
  public ResponseDTO loadStaff(@PathVariable("id") Long id){
    ResponseDTO responseDTO = buildingService.listStaff(id);
    return responseDTO;
  }
}
