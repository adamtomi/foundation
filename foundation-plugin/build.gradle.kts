import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
    id("io.papermc.paperweight.userdev") version "1.7.2"
}

repositories {
    mavenCentral()
}

dependencies {
    // Platform
    paperweight.paperDevBundle("1.21.1-R0.1-SNAPSHOT")

    // DI Framework
    implementation("com.google.dagger:dagger:2.52") {
        // javax.inject will be present at runtime, we don't need to include it in our jar
        exclude("javax.inject")
    }
    annotationProcessor("com.google.dagger:dagger-compiler:2.52")

    // Libs
    implementation(files("../libs/grapefruit-core.jar"))
    annotationProcessor(files("../libs/grapefruit-gen-2.0.0-ALPHA-all.jar"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.processResources {
    filesMatching("paper-plugin.yml") {
        expand("version" to (project.parent?.version!!))
    }
}

tasks.named<ShadowJar>("shadowJar") {
    minimize()
    val relocations = mapOf(
        "grapefruit.command" to "foundation.reloc.command",
        "dagger" to "foundation.reloc.dagger",
        "jakarta" to "foundation.reloc.jakarta",
    )

    relocations.forEach {
        relocate(it.key, it.value)
    }

    archiveFileName.set("${project.parent?.name}-${project.parent?.version}.jar")
}
