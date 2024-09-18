package com.javaweb.controller.admin;



import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller(value="buildingControllerOfAdmin")
public class BuildingController {

  @Autowired
  private UserService userService;

  @Autowired
  private IBuildingService buildingService;

  @GetMapping(value = "/admin/building-list")
  public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView("admin/building/list");
    //hiển thị các field người dùng tìm kiếm
    modelAndView.addObject("modelSearch", buildingSearchRequest);
    modelAndView.addObject("listStaffs", userService.getStaffs());
    modelAndView.addObject("districtCode", DistrictCode.type());
    modelAndView.addObject("typeCode", BuildingType.type());

    // truy vấn
    List<BuildingDTO> result = buildingService.getAllBuildings(buildingSearchRequest);

//    List<BuildingSearchResponse> result = new ArrayList<>();
//    BuildingSearchResponse b = new BuildingSearchResponse();
//    b.setId(1L);
//    b.setAddress("2,hoang ha,HN");
//    b.setFloorArea(20L);
//    b.setManagerName("Anh Long,chi Huong");
//    b.setManagerPhoneNumber("5091218251");
//    b.setNumberOfBasement(5L);
//    b.setRentArea("300,400,500");
//    result.add(b);
//
//    BuildingSearchResponse c = new BuildingSearchResponse();
//    c.setId(2L);
//    c.setAddress("2,Cau giay,HN");
//    c.setFloorArea(25L);
//    c.setManagerName("Anh Long");
//    c.setManagerPhoneNumber("5091218224251");
//    c.setNumberOfBasement(5L);
//    c.setRentArea("400,500");
//    result.add(c);

    // hiện thị kết quả
    modelAndView.addObject("result", result);
    return modelAndView;
  }

  @GetMapping(value = "/admin/building-edit")
  public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO ,HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView("admin/building/edit");
    modelAndView.addObject("districtCode", DistrictCode.type());
    modelAndView.addObject("typeCode", BuildingType.type());
    return modelAndView;
  }

  @GetMapping(value = "/admin/building-edit-{id}")
  public ModelAndView buildingEdit(@PathVariable("id") Long id, HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView("admin/building/edit");
    //xuong db tìm building in ra
    BuildingDTO b = new BuildingDTO();
    b.setId(id);
    b.setName("ACE building");
    modelAndView.addObject("buildingEdit", b);
    modelAndView.addObject("districtCode", DistrictCode.type());
    modelAndView.addObject("typeCode", BuildingType.type());
    return modelAndView;
  }

}
