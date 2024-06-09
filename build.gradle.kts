// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
        uri("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(ClassPaths.gradle)
        classpath(ClassPaths.kotlinGradlePlugin)
        classpath(ClassPaths.daggerHiltGradlePlugin)
        classpath(ClassPaths.detekt)
        classpath(ClassPaths.ktlint)
        classpath(ClassPaths.gradle_versions)
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint").version("10.2.0")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
