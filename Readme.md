# Asteroid-api

Une brique qui va lire les données de la NASA sur les astéroides géocroiseurs et les convertit en un format exploitable

## utilisation

Importez le projet dans gradle
Le programme à lancer est gradlew, le wrapper gradle. En principe il s'occupe d'installer la bonne version de gradle et de préparer le projet.
Sous windows, c'est gradle.bat

Pour compiler
./gradlew build

Pour lancer le projet avec données fictives, lancez le projet avec le profil spring "mock"
./gradlew bootRun --args='--spring.profiles.active=mock'

Pour le lancer avec des données du monde réel (n'abusez pas trop sinon mon token sera bloqué)
./gradlew bootRun

(remplacer le gradlew par gradlew.bat pour windows)

## IHM
Y'en pas! Tout ce que vous verrez, c'est une page générée qui permet d'interagir avec le back.
Elle devrait se trouver ici : 
http://127.0.0.1:8080/


## TODO
- faire un joli front
