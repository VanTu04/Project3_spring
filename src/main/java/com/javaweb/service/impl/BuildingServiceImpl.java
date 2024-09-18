package com.javaweb.service.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements IBuildingService {

  @Autowired
  private BuildingRepository buildingRepository;

  @Autowired
  private UserRepository userRepository;


  @Autowired
  private RentAreaRepository rentAreaRepository;

  @Override
  public List<BuildingDTO> getAllBuildings(BuildingSearchRequest buildingSearchRequest) {

    List<BuildingDTO> buildingDTOList = new ArrayList<>();
    List<BuildingEntity> buildingEntities = buildingRepository.findAll();

    for (BuildingEntity buildingEntity : buildingEntities) {
      BuildingDTO buildingDTO = new BuildingDTO();
//      buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
      buildingDTO.setId(buildingEntity.getId());
      buildingDTO.setName(buildingEntity.getName());
      buildingDTO.setWard(buildingEntity.getWard());
      buildingDTO.setStreet(buildingEntity.getStreet());
      buildingDTO.setDistrict(buildingEntity.getDistrict());
      buildingDTO.setFloorarea(buildingEntity.getFloorarea());
      buildingDTO.setManagername(buildingEntity.getManagername());
      buildingDTO.setManagerphone(buildingEntity.getManagerphone());

      List<RentareaEntity> rentareaEntities = buildingEntity.getRentareaList();
      String rentArea = rentareaEntities.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
      buildingDTO.setRentarea(rentArea);
      buildingDTO.setDirection(buildingEntity.getDirection());
      buildingDTO.setRentpricedescription(buildingEntity.getRentpricedescription());
      buildingDTO.setNumberofbasement(buildingEntity.getNumberofbasement());
      buildingDTOList.add(buildingDTO);
    }
    return buildingDTOList;
  }

  @Override
  public ResponseDTO listStaff(Long buildingid) {
    BuildingEntity building = buildingRepository.findById(buildingid).get();
    List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
    List<UserEntity> staffAssignment = building.getUserEntities();

    List<StaffResponseDTO> staffResponseDTOList = new ArrayList<>();
    for(UserEntity it : staffs){
      StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
      staffResponseDTO.setStaffId(it.getId());
      staffResponseDTO.setFullName(it.getFullName());
      if(staffAssignment.contains(it)){
        staffResponseDTO.setChecked("checked");
      }
      else {
        staffResponseDTO.setChecked("");
      }
      staffResponseDTOList.add(staffResponseDTO);
    }

    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setData(staffResponseDTOList);
    responseDTO.setMessage("success");
    return responseDTO;
  }

}
