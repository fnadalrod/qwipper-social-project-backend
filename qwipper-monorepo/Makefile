PROJECT_NAME=qwipper

SERVICES=services/users-service

run-%:
	mvn -pl services/$* spring-boot:run

run-all:
	for service in $(SERVICES); do \
		mvn -pl $$service spring-boot:run & \
	done

build:
	mvn clean install -DskipTests

clean:
	mvn clean

test:
	mvn test

stop-all:
	for service in $(SERVICES); do \
		mvn -pl $$service spring-boot:stop & \
	done

list-services:
	@echo "Available services:"
	@for service in $(SERVICES); do \
		echo "- $$service"; \
	done

help:
	@grep -E '^[a-zA-Z_-]+:' Makefile | awk -F':' '{print $$1}'
