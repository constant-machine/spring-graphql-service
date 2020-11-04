val liquibaseVersion = "3.8.0"
val postgresVersion = "42.2.18"

plugins {
    java
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:29.0-jre")

    implementation("com.graphql-java-kickstart:graphql-java-tools:6.2.0")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:8.0.0")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:8.0.0")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql:$postgresVersion")
    //implementation("org.liquibase:liquibase-core:$liquibaseVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
//    testImplementation("com.h2database:h2")
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
