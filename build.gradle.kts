plugins {
    // Soporte para desarrollo en Java
    java
    // Permite ejecutar la aplicación desde la terminal
    application
}

group = "com.pablo.githubcli"
version = "1.0-SNAPSHOT"

repositories {
    // Almacén de librerías de Java
    mavenCentral()
}

dependencies {
    // Librería principal para el procesamiento de JSON (Jackson)
    // Nota: En Kotlin usamos paréntesis y comillas dobles
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}

application {
    // Definimos la clase principal que Gradle debe ejecutar
    mainClass.set("com.pablo.githubcli.GitHubActivityApp")
}