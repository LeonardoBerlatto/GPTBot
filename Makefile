up:
	docker-compose -f ./docker/docker-compose.yaml up

build-docker:
	./gradlew clean build
	docker-compose -f ./docker/docker-compose.yaml build