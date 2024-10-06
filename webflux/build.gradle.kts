plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.study"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Webflux 의존성을 추가 !
    implementation("org.springframework.boot:spring-boot-starter-webflux") {
        // 내장형 웹 서버를 네티에서 톰갯으로 변경
        // Netty 사용 시 서버 시작 시 Netty started on port 8080 (http) 해당 로그 출력 됨
        exclude("org.springframework.boot", "spring-boot-starter-reactor-netty")
    }

    // 내장형 웹 서버를 Netty -> Tomcat 으로 변경
    // 톰캣으로 변경 후 서버 시작 시 해당 로그 출력이 됨 ! Tomcat started on port 8080 (http)
    implementation("org.springframework.boot:spring-boot-starter-tomcat:3.3.4")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
