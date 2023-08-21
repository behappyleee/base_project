package com.sample.data.basic;

import com.sample.data.basic.domain.Car;
import com.sample.data.basic.domain.CarType;
import com.sample.data.basic.domain.PersonRecord;
import org.junit.jupiter.api.Test;

public class RecordTest {

    // Record Keyword 사용
    // Record Class -> Record Class in Java is supported by the context sensitive keyword record. This keyword has no special
    // meaning unless used with the record

    @Test
    public void recordTest() {
        PersonRecord pr = new PersonRecord("TEST_NAME", "TEST_ADDRESS");
        // Recrod 는 Value Setting 이 불가
        pr.name();  // 해당 그냥 get / set 분리 불가 후 그냥 데이터 조회가 가능
        //pr.name("NAME_TEST");
        // Record 는 초기 생성자 생성은 생성불가
        // PersonRecord pr1 = new PersonRecord();
        
        Car ca = new Car("MyCar", CarType.SPORTS_CAR);
        // Enum 값 가져오기

        ca.carType();

        CarType.getCarName("truck");

        Car ca2 = new Car("NORMAL", CarType.getCarName("normal"));

    }


}
