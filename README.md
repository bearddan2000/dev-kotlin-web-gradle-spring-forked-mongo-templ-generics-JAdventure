# dev-kotlin-web-gradle-spring-forked-mongo-templ-generics-JAdventure

## dev-Description
A POC for REST web service using mongodb.
Creates a user with credentials.

So modification were made to the JSON
files so as to make them mongo compliant.
`db/init/*.json`. There is a feature in mongodb
to auto load JSON files, but to create the
entities we elected to use a built-in import
function. As a result of the import option, we
put each entity in its own collection.

The web service is RESTful so we follow the
basic Controller->Service->Repository->Model
pattern. Using generics we can reduce the code
needed by Service and Repository layers.

## dev-Tech stack
- kotlin
- gradle
  - mongo connector
  - springboot
- mongo

## dev-Docker stack
- mongodb:latest
- gradle:jdk11

## dev-To run
`sudo ./install.sh -u`
- Endpoints
  - localhost/weapons/
  - localhost/weapons/name/shiv
  - localhost/armors/
  - localhost/armors/name/wooden%20shield
  - localhost/foods/
  - localhost/foods/name/bread
  - localhost/tools/
  - localhost/tools/name/lock%20and%20pick
  - localhost/potions/
  - localhost/potions/name/milk
  - localhost/locations/
  - localhost/locations/coor/5,2,-1

## dev-To stop
`sudo ./install.sh -d`

## dev-For help
`sudo ./install.sh -h`

## dev-Credit
- [Data from JAdventure text game](https://github.com/Progether/JAdventure.git)
- [Code concept](https://github.com/ragcrix/StudentInformationSystem.git)
