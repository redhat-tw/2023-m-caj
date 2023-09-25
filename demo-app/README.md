## Demo App
A Spring Boot application for practicing containerization.

* Build Artifact
```bash=
mvn clean package
ls target
```

* Start the Application (Default service port is 8080)
```bash=
java -jar target/demo-app-0.0.1-SNAPSHOT.jar
```

* Environment Variables
The application can connect to various databases by modifying environment variables.
| No | Variables | Desc | Example |
| -------- | -------- | -------- | -------- |
| 1     | DB_DIALECT     | DB Dialect     |org.hibernate.dialect.PostgreSQLDialect|
| 2     | DB_DRIVER     | DB Driver     |org.postgresql.Driver|
| 3     | DB_URL     | DB URL     |jdbc:postgresql://postgresql:5432/postgres|
| 4     | DB_USER     | DB User     |postgres|
| 5     | DB_PXD     | DB Password     |password|


* Swagger UI
```
http://localhost:8080/swagger-ui.html
```

* Health Check Endpoint 
```
http://localhost:8080/actuator/health
```

* Build Image - Senario1 (Maven build in image)
The generated image is quite large.
```bash=
docker build -f Containerfile-fat -t demp-app:latest .
```

* Build Image - Senario2 (COPY Artifact into image)
The generated image is relatively lightweight.
```bash=
docker build -f Containerfile -t demp-app:latest .
```

* Run the container
```bash=
podman run -p 8080:8080 demp-app:latest
```
