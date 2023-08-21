package com.sample.data.basic.domain;

import java.util.Arrays;

public enum CarType {
    TRUCK("truck"),
    NORMAL_CAR("normal"),
    SPORTS_CAR("sports");

    private String carName;

    CarType(String carName) {
        this.carName = carName;
    }

    private String getCarName() {
        return this.carName;
    }

    public static CarType getCarName(String carName) {
        // 문자열로 해당 EnumData 찾기  !!
        return Arrays.stream(values())
                .filter(car -> car.getCarName().equals(carName))
                .findAny()
                .orElse(null);
    }

}
