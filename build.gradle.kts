import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.61"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.spring.io/milestone")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencyManagement {
    imports {
        mavenBom("io.projectreactor:reactor-bom:Dysprosium-SR2")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("io.projectreactor:reactor-core")
    implementation("io.projectreactor.addons:reactor-adapter")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("io.reactivex.rxjava2:rxjava:2.2.17")
    testImplementation("junit:junit:4.12")
    testImplementation("io.projectreactor:reactor-test")
}
