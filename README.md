# Help.md

## Guide d'utilisation et d'installation

### Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :

1. **Java Development Kit (JDK) 17**  
   Assurez-vous que JDK 17 est installé et défini comme JDK par défaut. Vous pouvez vérifier votre version de Java en exécutant :
   ```bash
   java -version
2. **maven 3.0.x**
    ```bash
   mvn -v
### Installation
**1. clone project**
   ```bash
   git clone https://github.com/yelmariky/scoring-players
   cd scoring-players
   mvn clean package
   mvn spring-boot:run
   ```
   **cette commade démarre l'application Spring Boot.**
   **Par défaut, elle s'exécutera sur http://localhost:8080**

### Tester l'Application avec curl ou postmen
Pour tester l'application de score de tennis, vous pouvez utiliser curl pour envoyer des requêtes HTTP à l'application en cours d'exécution. 
Voici quelques exemples de comment le faire.

## Exemple 1 : Le joueur A gagne avec un jeux blanc
```bash
curl -X POST http://localhost:8080/api/tennis/play -H "Content-Type: text/plain" -d "AAAA"
  ```
# Réponse attendue :

```bash
Player A: 15 / Player B: 0
Player A: 30 / Player B: 0
Player A: 40 / Player B: 0
Player A wins the game
```
## Exemple 2 : Egalité et Avantage, le joueur B gagne
```bash
curl -X POST http://localhost:8080/api/tennis/play -H "Content-Type: text/plain" -d "ABABABBB"
```
# Réponse attendue :
```
Player A: 15 / Player B: 0
Player A: 15 / Player B: 15
Player A: 30 / Player B: 15
Player A: 30 / Player B: 30
Player A: 40 / Player B: 30
Player A: 40 / Player B: 40
Player A: 40 / Player B: Advantage
Player B wins the game
```
# Exemple 3 : Le joueur A gagne après un match serré
```bash
curl -X POST http://localhost:8080/api/tennis/play -H "Content-Type: text/plain" -d "ABABABABBB"
```
# Réponse attendue :
```
Player A: 15 / Player B: 0
Player A: 15 / Player B: 15
Player A: 30 / Player B: 15
Player A: 30 / Player B: 30
Player A: 40 / Player B: 30
Player A: 40 / Player B: 40
Player A: Advantage / Player B: 40
Player A: 40 / Player B: 40
Player A: 40 / Player B: Advantage
Player B wins the game
```
### Exécution des Tests
Pour exécuter les tests unitaires inclus dans le projet, utilisez la commande suivante :

```
mvn test
```

