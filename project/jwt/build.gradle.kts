import org.jetbrains.kotlin.ir.backend.js.compile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id ("org.jetbrains.kotlin.jvm") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.22"
    id ("org.jetbrains.kotlin.plugin.spring") version "1.9.22"
}

group = "com.study"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")

    implementation ("io.jsonwebtoken:jjwt-api", version: "")
    runtimeOnly ("io.jsonwebtoken:jjwt-impl")
    runtimeOnly ("io.jsonwebtoken:jjwt-jackson")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
