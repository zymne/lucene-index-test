import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    idea
}

idea {
    module {
        isDownloadJavadoc = true
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.apache.lucene:lucene-core:9.4.0")
    implementation("org.apache.lucene:lucene-queryparser:9.4.0")
    implementation("org.apache.lucene:lucene-analyzers-common:8.11.2")



    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}