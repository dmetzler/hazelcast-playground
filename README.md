# Hazelcast demo


# How to run

```
mvn clean package
docker compose up --build -d
curl http://localhost:8080/status/
curl http://localhost:8081/status/
````

Browse to http://localhost:8082/hazelcast-mancenter

Kill a node
```
docker compose stop node2
curl http://localhost:8080/status/
```