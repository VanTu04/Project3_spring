package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentareaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignmentBuildingService;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.RentAreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements IBuildingService {

  @Autowired
  private BuildingRepository buildingRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

  @Autowired
  private BuildingConverter buildingConverter;

  @Autowired
  private AssignmentBuildingRepository assignmentBuildingRepository;

  @Autowired
  private RentAreaService rentAreaService;

  @Autowired
  private AssignmentBuildingService assignmentBuildingService;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<BuildingSearchResponse> getAllBuildings(BuildingSearchRequest buildingSearchRequest) {
    List<String> typeCode = buildingSearchRequest.getTypeCode();
    BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest,typeCode);

    List<BuildingSearchResponse> result = new ArrayList<>();
    List<BuildingEntity> buildingEntities = buildingRepository.getAllBuildings(buildingSearchBuilder);
    for(BuildingEntity buildingEntity : buildingEntities) {
      BuildingSearchResponse buildingSearchResponse = buildingConverter.toBuildingSearchResponse(buildingEntity);
      result.add(buildingSearchResponse);
    }
    return result;
  }

  @Override
  public ResponseDTO listStaff(Long buildingid) {
    BuildingEntity building = buildingRepository.findById(buildingid).get();
    List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
//    List<UserEntity> staffAssignment = building.getUserEntities();
    List<UserEntity> staffAssignment = new ArrayList<>();

    List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findBybuildingEntity(building);
    for(AssignmentBuildingEntity item : assignmentBuildingEntities) {
      staffAssignment.add(item.getStaffs());
    }

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

  @Override
  public void deleteBuildingList(List<Long> buildingids) {
    assignmentBuildingService.deleteAssignmentBuildingByBuildingId(buildingids);
    rentAreaService.deleteRentAreaByBuildingId(buildingids);
    buildingRepository.deleteByIdIn(buildingids);
  }

  @Override
  public void addorUpdateBuiling(BuildingDTO buildingDTO) {
    BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
    buildingEntity.setType(toType(buildingDTO.getTypeCode()));
    buildingRepository.save(buildingEntity);
    buildingDTO.setId(buildingEntity.getId());
    if(buildingDTO.getRentarea() != "" && buildingDTO.getRentarea() != null) {
      rentAreaService.addRentArea(buildingDTO);
    }
  }

  @Override
  public BuildingDTO getBuildingById(Long buildingid) {
     BuildingEntity buildingEntity = buildingRepository.findById(buildingid).get();
     BuildingDTO buildingDTO = modelMapper.map(buildingEntity, BuildingDTO.class);
     buildingDTO.setRentarea(rentAreaService.getRentAreaByBuildingId(buildingid));
     String[] t = buildingEntity.getType().split(",");
     List<String> typeCode =Arrays.asList(t);
     buildingDTO.setTypeCode(typeCode);
     return buildingDTO;
  }

  public static String toType(List<String> typeCode){
    return typeCode.stream().collect(Collectors.joining(","));
  }
}
