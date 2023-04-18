val liquibaseVersion = "4.18.0"
val postgresVersion = "42.5.1"

plugins {
    java
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.liquibase.gradle") version "2.0.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    implementation("com.graphql-java-kickstart:graphql-java-tools:13.0.2")
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:14.1.0")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("dev.akkinoc.spring.boot:orika-spring-boot-starter:2.4.5")

    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("org.liquibase:liquibase-core:$liquibaseVersion")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-core:1.2.9")
    testImplementation("ch.qos.logback:logback-classic:1.2.9")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("com.h2database:h2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
