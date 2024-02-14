# ecom

## Run ZipKin 
```
docker run -p 9411:9411 openzipkin/zipkin
```
## Run RabbitMQ
```
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.12-management
```

## Ports
| Service          | Port |
|------------------|------|
| API Gateway      | 8765 |
| Service Registry | 8761 |
| Config Server    | 8888 |
| ZipKin Server    | 9411 |
| Identity Service | 8000 |
| Item Service     | 8100 |
| Order Service    | 8200 |
| Email Service    | 8300 |
| Payment Service  | 8400 |