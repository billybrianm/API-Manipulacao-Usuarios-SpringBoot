setup:
   mvn install

build:
   echo "nada a buildar"

run:
   ./mvnw spring-boot:run

dockertest:
   make setup
   make build
   make run