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
    List<BuildingSearchResponse> result = buildingService.getAllBuildings(buildingSearchRequest);
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
    BuildingDTO b = buildingService.getBuildingById(id);
    modelAndView.addObject("buildingEdit", b);
    modelAndView.addObject("districtCode", DistrictCode.type());
    modelAndView.addObject("typeCode", BuildingType.type());
    return modelAndView;
  }

}
