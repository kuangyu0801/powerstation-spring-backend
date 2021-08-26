# Exposed REST End Point
- 
- GET POST UPDATE DELETE http://localhost:8080/api/stations
- POST http://localhost:8080/api/link-query/query

![](/API.png)

for overriding the application property

java -jar target/powerstation-0.0.1-SNAPSHOT.jar --server.port=9000 --spring.datasource.password="powerstation" --spring.datasource.username="powerstation" --spring.datasource.url="jdbc:mysql://localhost:3306/powerstation?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC

# Unit Testing
What are the difference among @Mock, @MockBean, @MockInject?
@Mock creates a mock. 
@InjectMocks creates an instance of the class and injects the mocks that are created with the @mock (or @SPY) annotations into this instance.
With JUnit 5, you must use @ExtendWith(MockitoExtension.class).
@MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.

- Readable
- Simple
- Isolated
- Frequent-ran