
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

    implementation("com.graphql-java:graphql-java:15.0")
    implementation("com.graphql-java:graphql-java-spring-boot-starter-webmvc:2.0")
    implementation("com.graphql-java:graphql-java-tools:5.2.4")
    implementation("com.graphql-java:graphiql-spring-boot-starter:5.0.2")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")

    runtimeOnly("com.h2database:h2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
