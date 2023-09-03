# capitole

## Acceso sin docker por el puerto 8080

### URL SWAGGER 
```
 http://localhost:8080/swagger-ui/index.html
 ```

### Acceso DB H2

```
http://localhost:8080/h2-console/
```

### Credenciales

JDBC URL: ``` jdbc:h2:mem:commercedb ```

User: ``` sa ```

Password: ``` password ```

## Docker

### Crear imagen 
```
docker build -t "capitole_technical_test_pricing_api" .
```

### ejecutar docker-compose 
```
docker-compose up -d
```

#### Se ejecuta en el puerto ``` 9090 ```

### URL SWAGGER 
```
 http://localhost:9090/swagger-ui/index.html
 ```

### Acceso DB H2

```
http://localhost:9090/h2-console/
```