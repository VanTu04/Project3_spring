package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface IBuildingService {
  List<BuildingSearchResponse> getAllBuildings(BuildingSearchRequest buildingSearchRequest);
  ResponseDTO listStaff(Long buildingid);
  void deleteBuildingList(List<Long> buildingids);
  void addorUpdateBuiling(BuildingDTO buildingDTO);
  BuildingDTO getBuildingById(Long buildingid);
}
