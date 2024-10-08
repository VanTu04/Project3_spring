package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "ward", nullable = false)
  private String ward;

  @Column(name = "district", nullable = false)
  private String district;

  @Column(name = "structure")
  private String structure;

  @Column(name = "numberofbasement")
  private Long numberofbasement;

  @Column(name = "direction")
  private String direction;

  @Column(name = "floorarea")
  private Long floorarea;

  @Column(name = "level")
  private Long level;

  @OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
  private List<RentareaEntity> rentareaList = new ArrayList<>();

  @Column(name = "rentprice")
  private Long rentprice;

  @Column(name = "rentpricedescription")
  private  String rentpricedescription;

  @Column(name = "servicefee")
  private String servicefee;

  @Column(name = "carfee")
  private String carfee;

  @Column(name = "overtimefee")
  private String overtimefee;

  @Column(name = "brokeragefee")
  private Double brokeragefee;

  @Column(name = "managername")
  private String managername;

  @Column(name = "managerphone")
  private String managerphone;

  @Column(name = "note")
  private String note;

  @Column(name = "type")
  private String type;

  @OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
  private List<AssignmentBuildingEntity> assignmentBuildingList = new ArrayList<>();

//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(name = "assignmentbuilding", joinColumns = @JoinColumn(name = "buildingid", nullable = false),
//                                          inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
//  private List<UserEntity> userEntities = new ArrayList<>();

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<AssignmentBuildingEntity> getAssignmentBuildingList() {
    return assignmentBuildingList;
  }

  public void setAssignmentBuildingList(List<AssignmentBuildingEntity> assignmentBuildingList) {
    this.assignmentBuildingList = assignmentBuildingList;
  }

  //  public List<UserEntity> getUserEntities() {
//    return userEntities;
//  }
//
//  public void setUserEntities(List<UserEntity> userEntities) {
//    this.userEntities = userEntities;
//  }

  public Long getFloorarea() {
    return floorarea;
  }

  public void setFloorarea(Long floorarea) {
    this.floorarea = floorarea;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getWard() {
    return ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getStructure() {
    return structure;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public Long getNumberofbasement() {
    return numberofbasement;
  }

  public void setNumberofbasement(Long numberofbasement) {
    this.numberofbasement = numberofbasement;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public Long getLevel() {
    return level;
  }

  public void setLevel(Long level) {
    this.level = level;
  }

  public List<RentareaEntity> getRentareaList() {
    return rentareaList;
  }

  public void setRentareaList(List<RentareaEntity> rentareaList) {
    this.rentareaList = rentareaList;
  }

  public Long getRentprice() {
    return rentprice;
  }

  public void setRentprice(Long rentprice) {
    this.rentprice = rentprice;
  }

  public String getRentpricedescription() {
    return rentpricedescription;
  }

  public void setRentpricedescription(String rentpricedescription) {
    this.rentpricedescription = rentpricedescription;
  }

  public String getServicefee() {
    return servicefee;
  }

  public void setServicefee(String servicefee) {
    this.servicefee = servicefee;
  }

  public String getCarfee() {
    return carfee;
  }

  public void setCarfee(String carfee) {
    this.carfee = carfee;
  }

  public String getOvertimefee() {
    return overtimefee;
  }

  public void setOvertimefee(String overtimefee) {
    this.overtimefee = overtimefee;
  }

  public Double getBrokeragefee() {
    return brokeragefee;
  }

  public void setBrokeragefee(Double brokeragefee) {
    this.brokeragefee = brokeragefee;
  }

  public String getManagername() {
    return managername;
  }

  public void setManagername(String managername) {
    this.managername = managername;
  }

  public String getManagerphone() {
    return managerphone;
  }

  public void setManagerphone(String managerphone) {
    this.managerphone = managerphone;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

//  public List<AssignmentBuildingEntity> getAssignmentBuildingList() {
//    return assignmentBuildingList;
//  }
//
//  public void setAssignmentBuildingList(List<AssignmentBuildingEntity> assignmentBuildingList) {
//    this.assignmentBuildingList = assignmentBuildingList;
//  }
}
