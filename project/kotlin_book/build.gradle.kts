import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// Task 를 customizing 이 가능 !
// ./gradlew customBuild 입력 시 해당 Task 실행이 가능 !
// named 된 Task 까지 같이 실행이 됨 ... !
tasks.register("customBuild") {
    println("[THISISISISISISIS CUSTOMER GRADLE BUILD !!!]")
}

tasks.named("customBuild") {
    println("SDSDSDSD NAMED TEST GET CLASS DSDS NAMED TASK !!")

    doFirst {
        println("[CUSTOM BUILD DO FIRST !!!]")
    }

}

// Main Class 가 여러개 일 시 MainClass 를 지정
tasks.withType<BootJar> {
    mainClass = "com.example.kotlin_book.KotlinBookApplication"
}

tasks.register("task1") {
    println("[TASK 1 START !!!]")
}

tasks.register("task2") {
    println("[TASK 2 START !!!]")
}

tasks.withType<KotlinCompile> {
    println("[START KOTLIN COMPILE !!!]")

    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    println("[START JUNIN TEST !!! RUN TEST CODE !!!!]")

    useJUnitPlatform()
}
