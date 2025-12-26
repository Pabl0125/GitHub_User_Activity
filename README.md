# GitHub User Activity CLI

Este proyecto es una herramienta de línea de comandos (CLI) desarrollada en **Java** que consume la **API de GitHub** para mostrar de forma resumida la actividad reciente de un usuario específico.

---

## 1. Características Principales

* ### 1.1 **Resumen de Actividad**


Agrupa los eventos por tipo y repositorio para ofrecer una lectura limpia (ej. "Pushed 3 commits to repo-name").
* ### 1.2 **Gestión Automática con Gradle**


Utiliza el **Gradle Wrapper** para que no necesites instalar herramientas adicionales de construcción.
* ### 1.3 **Integración con Jackson**


Maneja la respuesta JSON de la API de GitHub de forma eficiente mediante el mapeo de objetos (POJO).

---

## 2. Requisitos Previos

Antes de comenzar, asegúrate de cumplir con lo siguiente:

* Tener instalado **Java JDK 17** o superior.
* Conexión a internet para realizar las peticiones a la API de GitHub.

---

## 3. Instalación y Configuración

* ### 3.1 **Clonar el Repositorio**


Primero, descarga el código a tu máquina local:
```bash
git clone https://github.com/Pabl0125/GitHub_User_Activity.git
cd GitHub_User_Activity

```


* ### 3.2 **Estructura del Proyecto Recomendada**


El repositorio está organizado de la siguiente manera para evitar archivos innecesarios:
```text
.
├── src/                # Código fuente Java
├── gradle/             # Archivos de configuración del Wrapper
├── build.gradle.kts    # Dependencias (Jackson, etc.)
├── gradlew             # Ejecutable para Linux/macOS
└── gradlew.bat         # Ejecutable para Windows

```



---

## 4. Cómo Ejecutar la Aplicación

No necesitas compilar manualmente. El comando `run` se encarga de todo.

* ### 4.1 **En Linux o macOS**


Asigna permisos de ejecución al script y lánzalo con el nombre de usuario deseado:
```bash
chmod +x gradlew
./gradlew run --args='Pabl0125'

```


* ### 4.2 **En Windows**


Usa el archivo bat desde el CMD o PowerShell:
```powershell
.\gradlew.bat run --args="Pabl0125"

```



---

## 5. Ejemplo de Salida

Al ejecutar el programa, verás un resumen similar a este:

```text
Respuesta del servidor: 200
- Pushed 5 commits to Pabl0125/Java-Monopoly
- Created 1 resources on Pabl0125/GitHub_User_Activity
- Deleted 2 resources on Pabl0125/GitHub_User_Activity

```

---

## 6. Notas para Desarrolladores

* ### 6.1 **Limpieza de archivos**


Si deseas limpiar los archivos compilados localmente, ejecuta:
```bash
./gradlew clean

```


* ### 6.2 **Variables de entorno**


Actualmente el programa usa la API pública. Si realizas muchas peticiones seguidas, podrías alcanzar el límite de la API de GitHub.

---

### Autor

Desarrollado por [Pabl0125](https://www.google.com/search?q=https://github.com/Pabl0125) - 2025.

---
