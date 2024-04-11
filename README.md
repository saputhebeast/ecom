# ecom

## Run RabbitMQ
```
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.12-management
```

## Ports
| Service          | Port |
|------------------|------|
| API Gateway      | 8765 |
| Identity Service | 8000 |
| Item Service     | 8100 |
| Order Service    | 8200 |
| Email Service    | 8300 |
| Payment Service  | 8400 |
