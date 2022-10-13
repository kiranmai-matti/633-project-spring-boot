### Change the Database connection details

```
spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
spring.datasource.username= username
spring.datasource.password= password
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto= none
```

### Start the Application

```
Build the project using gradle
./gradlew clean build
Run the application using
./gradlew bootRun
```

### Register Customer

```
curl --location --request POST 'http://localhost:8080/api/customers/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"UserFirstName",
    "lastName":"UserLastName",
    "email":"test@gmail.com",
    "mobileNo":1234567890,
    "password":"password"
}'
```

### Login Customer

```
curl --location --request GET 'http://localhost:8080/api/customers/test@gmail.com/info'
```

### Customer Details

```
curl --location --request GET 'http://localhost:8080/api/customers/test@gmail.com/info'
```

### Products by category

```
curl --location --request GET 'http://localhost:8080/api/categories/206/products'
```