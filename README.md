## Exemple Spring Boot Test avec JUnit et Mockito
Ce projet montrera comment implémenter un exemple des tests unitaires Spring Boot, JUnit et Mockito.
Spring Boot fournit une annotation `@SpringBootTest` qui permet de charger le contexte Spring lors de l’exécution des tests.
Ce projet se concentre sur le test de la couche `service`  qui se compose la logique métier du traitement.
Nous écrirons des cas de test pour les opérations de base de données telles que CRUD (Create, Read, Update et Delete) d'une entité - `User`.

### Introduction
---
Un test informatique est une activité permettant de vérifier l’adéquation d’un système informatique à un fonctionnement attendu.<br/>
Parmi les types de test, on distingue généralement :
* Les **tests unitaires** : testent une partie (une unité) d’un système afin de s’assurer qu’il s’exécute sans erreur (build the system right)
* Les **tests d’acceptation** : testent le système afin de s’assurer qu’il est conforme aux attentes de l’utilisateur (build the right system)
* Les **tests d’intégration** : testent le système sur une plate-forme proche de la plate-forme cible afin de s’assurer que les différents composants s’intègrent correctement les uns avec les autres.
* Les **tests de performance** : testent les performances du système afin de s’assurer qu’il répond à certains critères de réactivité. Par exemple, pour un service en ligne, il peut s’agir du temps de réponse moyen en seconde.
* Les **tests de sécurité** : testent que l’application ne contient pas de failles de sécurité connues (injection de code, attaque XSS, …)
* Les **tests de robustesse** (ou stress tests) : testent le comportement de l’application aux limites des ressources disponibles (mémoire, CPU, …).

### Qu'est-ce que JUnit ?
---
JUnit est un framework de test populaire pour Java. L'utilisation simple est très simple 
et JUnit 5 a apporté quelques différences et commodités par rapport à JUnit 4.<br/>

Le code de test est séparé du code du programme réel, et dans la plupart des IDE, 
les résultats/sorties de test sont également séparés de la sortie du programme, fournissant une structure lisible et pratique.<br/>

Vous pouvez choisir de créer simplement les classes de test dans le même dossier 
que le reste de votre code, mais il est recommandé d'avoir un répertoire séparé pour les tests. 
Une autre chose à noter est les conventions de nommage. Si nous souhaitons tester complètement 
notre code, chaque classe doit avoir une classe de test correspondante nommée - `classnameTest`.

### Prérequis
---
Pour ce projet, vous auriez besoin des spécifications suivantes :<br/>
- Spring Boot v2.0+
- JDK v1.8+
- JUnit 5 - Le framework de test le plus populaire et le plus utilisé pour Java.
- Mockito - Cadre à usage général pour les services et objets de moquerie et de stub.
- MockMVC - Module de Spring pour effectuer des tests d'intégration lors des tests unitaires.
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- SGBD NoSQL MongoDB

### Architecture de test
---
Cette image présente l'architecture simple de cet exemple.<br/><br/>
![Archi_JUnitTest](https://user-images.githubusercontent.com/75081354/134864726-327320ec-7168-4fe5-9753-0420112cd1c0.jpg)

### Dependances Maven de tests unitaires
---
Spring Boot fournit un certain nombre d'utilitaires et d'annotations pour vous aider lors du test de votre application. 
La prise en charge des tests est fournie par deux modules : `spring-boot-test` contient des éléments de base et 
`spring-boot-test-autoconfigure` prend en charge la configuration automatique pour les tests. <br/>

La plupart des développeurs utiliseront simplement le "Starter" `spring-boot-starter-test` qui importe 
les deux modules de test Spring Boot ainsi que **JUnit, AssertJ, Hamcrest** et un certain nombre d'autres bibliothèques utiles.

### Dépendances de la portée du test
---
Si vous utilisez le **'Starter'** `spring-boot-starter-test` (dans le `test` `scope`), vous trouverez les bibliothèques fournies suivantes :
* **JUnit** — La norme de facto pour les tests unitaires des applications Java.
* **Spring Test & Spring Boot Test** - Prise en charge des utilitaires et des tests d'intégration pour les applications Spring Boot.
* **AssertJ** — Une bibliothèque d'assertions fluide.
* **Hamcrest** — Une bibliothèque d'objets matcher (également appelés contraintes ou prédicats).
* **Mockito** — Un framework de moqueur Java.
* **JSONassert** — Une bibliothèque d'assertions pour JSON.
* **JsonPath** — XPath pour JSON.

### Annotations de Test utiliséss
---
* `@SpringBootTest` est une annotation fournie par Spring Boot. Elle permet lors de l’exécution des tests d’initialiser le contexte Spring. Les beans de notre application peuvent alors être utilisés.
* `@MockBean` annotation qui peut être utilisée pour ajouter des maquettes à un Spring *ApplicationContext*. Peut être utilisé comme annotation au niveau de la classe ou sur des champs dans l'une *@Configuration* ou l' autre des classes, ou des classes de test qui sont *@RunWith* de *SpringRunner*.
* `@Test` afin que JUnit puisse les récupérer et les mettre dans une liste de tous les tests à exécuter.

### Exécuter les tests
---
Pour exécuter le test, il ne vous reste plus qu’à faire un clic droit sur la classe, `Run As`, `JUnit Test`.<br/>

- **Test unitaire getUsersTest** - test la capacité à récupérer une liste de tous les enregistrements.
- **Test unitaire getUserbyAddressTest** - test la capacité à récupérer des enregistrements par addresse.
- **Test unitaire saveUserTest** - test sa capacité à conserver les enregistrements.
- **Test unitaire deleteUserTest** - supprimer un enregistrement dans la base de données.

La vue JUnit au sein de STS devrait ressembler à ça :<br/><br/>
![Resultat_test](https://user-images.githubusercontent.com/75081354/134864804-06e13876-c218-40b9-8983-924f74a1687a.PNG)
