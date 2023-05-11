# API Cuenta Bancaria

Este proyecto es una aplicación Spring Boot que utiliza Java 11, Spring Boot 2.6.2, Lombok y JPA. La aplicación se conecta a una base de datos PostgreSQL utilizando Docker para la ejecución local.

## Requisitos previos

Asegúrese de tener instalado lo siguiente en su máquina:

- JDK 11
- Gradle
- Docker

## Configuración del proyecto

1. Clonar el repositorio:

   ```
   git clone https://github.com/julianr0223/sundevs-challenge.git
   ```

2. Cambiar al directorio del proyecto:

   ```
   cd sundevs-challenge
   ```

3. Compilar el proyecto utilizando Gradle:

   ```
   gradle clean build
   ```

## Configuración de la base de datos

Este proyecto utiliza una base de datos PostgreSQL que se ejecuta en un contenedor Docker. A continuación, se describen los pasos para ejecutar la base de datos en su máquina local.

1. Ejecute el siguiente comando para descargar la imagen de PostgreSQL:

   ```
   docker pull postgres
   ```

2. Cree un directorio en su máquina local para almacenar los datos de PostgreSQL:

   ```
   mkdir -p ~/postgres-data
   ```

3. Inicie el contenedor de Docker para PostgreSQL:

   ```
   docker run --name cuenta-bancaria -e POSTGRES_PASSWORD=miContraseña -d -p 5432:5432 -v ~/postgres-data:/var/lib/postgresql/data postgres
   ```

   Asegúrese de reemplazar `miContraseña` con una contraseña segura para su base de datos.

4. Después de iniciar el contenedor de Docker, cree la base de datos y las tablas necesarias para la aplicación. Puede hacer esto usando herramientas como pgAdmin o ejecutando scripts SQL directamente en el contenedor.

## Ejecución del proyecto

Una vez que haya completado los pasos de configuración anteriores, puede ejecutar la aplicación utilizando el siguiente comando:

```
gradle bootRun
```

La aplicación ahora debería estar ejecutándose en `http://localhost:8080`.

## Nota

Si necesita cambiar la configuración de la base de datos, como el nombre de usuario, la contraseña, el nombre de la base de datos o el host, asegúrese de actualizar el archivo `properties.yml` en la carpeta `src/main/resources` del proyecto.

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nombre_de_base_de_datos
    username: usuario_de_base_de_datos
    password: contraseña_de_base_de_datos
```

No olvide volver a compilar el proyecto con `gradle clean build` después de realizar cambios en la configuración.