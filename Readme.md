# Asteroid-api

Une brique qui va lire les données de la NASA sur les astéroides géocroiseurs et les convertit en un format exploitable

## utilisation

Importez le projet dans gradle
Pour utiliser des fausses données, lancez le projet avec le profil spring "mock"
./gradlew bootRun --args='--spring.profiles.active=mock'
Pour le lancer avec des données du monde réel :
./gradlew bootRun

## IHM
Y'en pas! Tout ce que vous verrez, c'est une page générée qui permet d'interagir avec le back.
Elle devrait se trouver ici : 
http://127.0.0.1:8080/


## TODO
- faire un joli front
