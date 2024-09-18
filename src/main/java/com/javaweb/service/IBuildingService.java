package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;

import java.util.List;

public interface IBuildingService {
  List<BuildingDTO> getAllBuildings(BuildingSearchRequest buildingSearchRequest);
  ResponseDTO listStaff(Long buildingid);

}
