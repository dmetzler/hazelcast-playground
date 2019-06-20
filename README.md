# Hazelcast demo


# How to run

```
mvn clean package
docker compose up --build -d
curl http://localhost:8080/status/
curl http://localhost:8081/status/
docker compose node2
curl http://localhost:8080/status/
```