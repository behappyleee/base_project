package com.sample.data.basic.domain;

// Java Record Keyword 사용
// Class 대신 record keyword 사용
// record 사용 시 변수들은 private final 취급
// record 를 사용 하면 각 필드에 대한 각 필드에 대한 인수가 생성된 public 생성자가 생성이 됨

public record PersonRecord(String name, String address) {



}
