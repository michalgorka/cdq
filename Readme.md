# CDQ demo app

## Requirements
- Java 17
- Maven
- Docker and Docker-compose
- 
## Setup
1. Run `mvn package`
2. Run `docker build -t cdq/demo:1.0.0 .`
3. Go to docker directory and run `docker-compose up -d`

## Test
- Run `mvn gatling:test`

## Dashboard grafana
- Login: admin
- Password: admin
- http://locahost:3000
