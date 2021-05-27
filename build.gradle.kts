plugins {
    java
    kotlin("jvm") version "1.5.10"
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.flywaydb.flyway") version "7.9.1"
}


group = "org.example"
version = "1.0-SNAPSHOT"

val javaVer = JavaVersion.VERSION_1_8

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.data:spring-data-jpa:2.4.2")

}

java {
    sourceCompatibility = javaVer
    targetCompatibility = javaVer
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
