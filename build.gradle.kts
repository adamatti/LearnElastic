import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    id("application")
}

repositories {
    jcenter()
}

application {
    mainClassName = "adamatti.Main"
}

val kluentVersion = "1.40"
val mockkVersion = "1.9.3"

dependencies {
    //  Basic dependencies:
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("ch.qos.logback", "logback-classic", "1.2.3")
    implementation("org.springframework.boot","spring-boot-starter-data-elasticsearch","2.2.5.RELEASE")

    //  Test and lint dependencies
    testImplementation("org.amshove.kluent", "kluent", kluentVersion)
    testImplementation("io.mockk", "mockk", mockkVersion)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
