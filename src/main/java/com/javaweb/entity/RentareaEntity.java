package com.javaweb.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rentarea")
public class RentareaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "value")
  private Long value;

  @ManyToOne
  @JoinColumn(name = "buildingid")
  private BuildingEntity buildingEntity;

  @Column(name = "createddate")
  private String createddate;

  @Column(name = "modifieddate")
  private String modifieddate;

  @Column(name = "createdby")
  private String createdby;

  @Column(name = "modifiedby")
  private String modifiedby;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public BuildingEntity getBuilding() {
    return buildingEntity;
  }

  public void setBuilding(BuildingEntity buildingEntity) {
    this.buildingEntity = buildingEntity;
  }

  public String getCreateddate() {
    return createddate;
  }

  public void setCreateddate(String createddate) {
    this.createddate = createddate;
  }

  public String getModifieddate() {
    return modifieddate;
  }

  public void setModifieddate(String modifieddate) {
    this.modifieddate = modifieddate;
  }

  public String getCreatedby() {
    return createdby;
  }

  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }

  public String getModifiedby() {
    return modifiedby;
  }

  public void setModifiedby(String modifiedby) {
    this.modifiedby = modifiedby;
  }
}
