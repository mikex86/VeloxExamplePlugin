plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation(files("libs/VeloxServer-1.0.3-alpha.jar"))
    implementation("org.jetbrains:annotations:20.1.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}