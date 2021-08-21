# Exposed REST End Point
- 
- GET POST UPDATE DELETE http://localhost:8080/api/stations
- POST http://localhost:8080/api/link-query/query

![](/API.png)

for overriding the application property

java -jar target/powerstation-0.0.1-SNAPSHOT.jar --server.port=9000 --spring.datasource.password="powerstation" --spring.datasource.username="powerstation" --spring.datasource.url="jdbc:mysql://localhost:3306/powerstation?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC