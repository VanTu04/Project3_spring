package com.javaweb.enums;


import java.util.*;

public enum BuildingType {
    TANG_TRET("Tầng trệt"),
    NGUYEN_CAN("Nguyên căn"),
    NOI_THAT("Nội thất");

    private final String buildingName;

    BuildingType(String buildingName) {
        this.buildingName = buildingName;
    }

    public static Map<String,String> type(){
        Map<String,String> map = new HashMap<>();
        for (BuildingType buildingType : BuildingType.values()) {
            map.put(buildingType.toString(),buildingType.buildingName);
        }
        return map;
    }
}
