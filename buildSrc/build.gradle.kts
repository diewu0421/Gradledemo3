
apply {
    plugin("java-gradle-plugin")
    plugin("kotlin")
}

buildscript {
//    extensions.add("kotlin_version", "1.3.72")



    repositories {

        google()
        jcenter()
        mavenCentral()
    }

    dependencies {

        extra.apply {
            set("kotlin_version", "1.3.72")
        }

//        ext {
//            set("kotlin_version", "1.3.72")
//        }
////        println("kotlin-version  ${extensions.getByName("kotlin_version")}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra.get("kotlin_version")}")
    }
}

dependencies {
    println("gradle Api =================${gradleApi()}")
    implementation( "com.android.tools.build:gradle:4.1.1")

}

repositories {
    mavenCentral()
    google()
    jcenter()
}