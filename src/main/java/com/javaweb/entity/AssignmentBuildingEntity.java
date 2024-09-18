//package com.javaweb.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "assignmentbuilding")
//public class AssignmentBuildingEntity {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//  @ManyToOne
//  @JoinColumn(name = "staffid")
//  private UserEntity staffs;
//
//  @ManyToOne
//  @JoinColumn(name = "buildingid")
//  private BuildingEntity buildingEntity;
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public UserEntity getStaffs() {
//    return staffs;
//  }
//
//  public void setStaffs(UserEntity staffs) {
//    this.staffs = staffs;
//  }
//
//  public BuildingEntity getBuilding() {
//    return buildingEntity;
//  }
//
//  public void setBuilding(BuildingEntity buildingEntity) {
//    this.buildingEntity = buildingEntity;
//  }
//}
