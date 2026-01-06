import com.vanniktech.maven.publish.DeploymentValidation

plugins {
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish") version "0.36.0"
}

group = "io.github.payrexx"
version = "1.0.0"


android {
    namespace = "io.github.payrexx.taptopay.sdk"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.gson)
    implementation(libs.activity)
    implementation(libs.fragment)
}

mavenPublishing {
    publishToMavenCentral(validateDeployment = DeploymentValidation.NONE)
    signAllPublications()

    configure(com.vanniktech.maven.publish.AndroidSingleVariantLibrary(
        variant = "release",
        sourcesJar = true,
        publishJavadocJar = false
    ))

    coordinates(group.toString(), name.toString(), version.toString())

    pom {
        name.set("Payrexx Tap To Pay SDK")
        description.set("SDK for controlling the Payrexx Tap to Pay App for an ECR Integration")
        inceptionYear.set("2025")
        url.set("https://github.com/payrexx/TapToPaySDK")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("payrexx")
                name.set("Payrexx AG")
                url.set("https://github.com/payrexx/")
            }
        }
        scm {
            url.set("https://github.com/payrexx/TapToPaySDK")
            connection.set("scm:git:git://github.com/payrexx/TapToPaySDK.git")
            developerConnection.set("scm:git:ssh://git@github.com/payrexx/TapToPaySDK.git")
        }
    }
}