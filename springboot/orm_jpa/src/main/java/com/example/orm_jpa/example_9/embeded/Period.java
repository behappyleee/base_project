package com.example.orm_jpa.example_9.embeded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

// 임베디드 타입은 기본 생성자가 필수임
// Embeded 기능을 사용하여 새로운 값 타입을 지정이 가능
@Embeddable
public class Period {
    
    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    // TODO
    // 필요한 메서드를 만들어서 사용도 가능하다
    public boolean isWork(Date date) {

        return false;
    }

}
