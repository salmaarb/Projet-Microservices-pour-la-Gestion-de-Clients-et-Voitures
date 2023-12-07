# Projet-Microservices-pour-la-Gestion-de-Clients-et-Voitures
Ce projet vise à développer une compréhension approfondie de l'architecture micro-service. Les axes centraux de cet apprentissage englobent la création et l'enregistrement de micro-services, la connexion à une base de données MySQL, l'établissement d'un micro-service Gateway, et l'implémentation d'une communication synchrone entre les micro-services en utilisant l'outil OPENFEIGN.
Dans ce projet, nous adopterons une architecture basée sur les microservices, caractérisée par la décomposition d'une application en de petits services indépendants. Au cœur de cette structure se situent les microservices clients, des entités autonomes qui interagissent pour fournir une fonctionnalité complète. L'API Gateway agit en tant que point d'entrée centralisé, simplifiant la gestion des requêtes en dirigeant le trafic vers les microservices appropriés. Le serveur de découverte Eureka revêt un rôle crucial en permettant à chaque microservice de s'enregistrer de manière dynamique, formant ainsi un annuaire décentralisé des services disponibles
<img  alt="image" src="https://github.com/salmaarb/Projet-Microservices-pour-la-Gestion-de-Clients-et-Voitures/assets/119877992/06d2e97a-b5cb-4d6f-ae43-f1ba6f7381c8">
# Technologies utilisées
Spring Boot : Utilisé pour le développement du microservice.
MySQL: Base de données relationnelle pour stocker les informations sur les voitures et clients.
Hibernate: Utilisé pour la couche de persistance des données.
# Création du service discovery Eureka
Eureka est un service de découverte de microservices développé par Netflix et fait partie du framework Spring Cloud. Le principal objectif de la création d'un serveur Eureka est de faciliter la gestion et la découverte des microservices dans une architecture distribuée.
![image](https://github.com/salmaarb/Projet-Microservices-pour-la-Gestion-de-Clients-et-Voitures/assets/119877992/d298b035-6d3a-4211-aa7b-86a6f28dd6e0)
# Création d’un service Gateway
La création d'un service de passerelle (Gateway) dans une architecture basée sur des microservices a plusieurs objectifs et avantages.La passerelle sert de point d'entrée central pour l'ensemble du système. Au lieu d'avoir plusieurs points d'entrée pour chaque microservice, la passerelle offre un point d'accès unique pour les clients et les utilisateurs finaux.La passerelle peut effectuer un routage dynamique des requêtes vers les différents microservices en fonction de critères tels que le chemin de l'URL, les en-têtes HTTP, ou d'autres paramètres. Cela permet une gestion flexible du trafic.
voici les dependances:
•	Spring Cloud Routing Gatway
•	Spring Boot Actuator
•	Eureka Discovry Client
# Création du service Client
voici les dependances 
Spring Boot Actuator Prend en charge les points de terminaison intégrés (ou personnalisés) qui vous permettent de surveiller et de gérer votre application - comme la santé de l'application, les mesures, les sessions, etc.
Eureka Discovry Client il se base sur REST pour localiser des services dans le but d'équilibrer la charge et le basculement des serveurs intermédiaires.
Spring Data JPA Persistance des données SQL avec l'API qui permet aux développeurs d'organiser des données relationnelles dans des applications utilisant la plateforme Java en se basant sur Spring Data et Hibernate.
Spring Web pour créer des applications web en utilisant Spring MVC. Il utilise Apache Tomcat comme conteneur intégré par défaut.
Spring Boot Devtools Offre des redémarrages rapides des applications, LiveReload, et des configurations pour une expérience de développement améliorée.
Rest Repositories Expose les JPA repositorie sur REST via Spring Data REST.
Lombok Bibliothèque d'annotation Java qui permet de réduire le code passe-partout.
# Creation du service voiture
voici les dependances 
Spring Boot Actuator Prend en charge les points de terminaison intégrés (ou personnalisés) qui vous permettent de surveiller et de gérer votre application - comme la santé de l'application, les mesures, les sessions, etc.
Eureka Discovry Client il se base sur REST pour localiser des services dans le but d'équilibrer la charge et le basculement des serveurs intermédiaires.
Spring Data JPA Persistance des données SQL avec l'API qui permet aux développeurs d'organiser des données relationnelles dans des applications utilisant la plateforme Java en se basant sur Spring Data et Hibernate.
Spring Web pour créer des applications web en utilisant Spring MVC. Il utilise Apache Tomcat comme conteneur intégré par défaut.
Spring Boot Devtools Offre des redémarrages rapides des applications, LiveReload, et des configurations pour une expérience de développement améliorée.
Rest Repositories Expose les JPA repositorie sur REST via Spring Data REST.
Lombok Bibliothèque d'annotation Java qui permet de réduire le code passe-partout.
# Communication entre les Microservices
C'est une approche courante dans les architectures microservices d'utiliser Feign pour la communication entre microservices. Feign facilite la création de clients HTTP déclaratifs en utilisant des annotations, ce qui simplifie le code et améliore la lisibilité.
Pour la classe clientbeans dans le service voiture est utilisé pour transporter des données entre les microservices. Lorsqu’on invoque des méthodes dans MicroserviceClientProxy (l'interface Feign), les données sont généralement sérialisées et désérialisées à l'aide de cette classe. Elle encapsule les informations relatives aux clients dans un objet Java. clientbeans agit comme un moyen de transporter, organiser et définir la structure des données client dans le contexte de la communication entre microservices via Feign. Elle contribue à la cohérence des données et simplifie le processus de communication entre les différentes parties de votre application.

Dans le code,on a créé une interface MicroserviceClientProxy qui agit comme un client Feign pour le microservice client. Cette interface déclare les méthodes correspondant aux points de terminaison du microservice client et utilise des annotations Feign pour définir le chemin, la méthode HTTP.
import java.util.List;
@FeignClient(name="SERVICE-CLIENT", url="http://localhost:8080")

public interface MicroserviceClientProxy {
    @GetMapping("/clients")
    List<clientbeans> find();
    @GetMapping("/clients/{id}")
    clientbeans chercherUnClient(@PathVariable Long id);
    @GetMapping("clientInfo/{id}")
    clientbeans getInfoClient(@PathVariable Long id) ;

}
Dans VoitureController, on a MicroserviceClientProxy pour interagir avec le microservice client. on appele les méthodes de cette interface pour récupérer la liste des clients, obtenir des informations sur un client en fonction de l'ID de la voiture.

Cela favorise la séparation des préoccupations entre les microservices, car le microservice voiture n'a pas besoin de connaître les détails d'implémentation du microservice client. La communication entre eux est définie de manière déclarative à l'aide de l'interface Feign.

microservice-client:
  url: http://localhost:8080 
microservice-voiture:
  url: http://localhost:8090  
# Comment exécuter le projet
   1. Cloner le référentiel depuis GitHub.
   2.  Configurer les bases de données dans les fichiers applications.properties de chaque microservice.
   3.  Exécutez tous les micro-service : Eureka , Client et voiture 
   4. Lancez votre navigateur et tapez : http://localhost:8090/carr/{id_voiture}. Sur la console vos aurez : exemple id=2
![image](https://github.com/salmaarb/Projet-Microservices-pour-la-Gestion-de-Clients-et-Voitures/assets/119877992/1a9b7c27-778c-4954-9af8-59345a6c7ad2)

Microservice voiture peut interroger le microservice client de manière transparente pour obtenir tous les informations.

![image](https://github.com/salmaarb/Projet-Microservices-pour-la-Gestion-de-Clients-et-Voitures/assets/119877992/51e20ae2-2648-4951-a0e2-c08c8ceed99f)

Microservice voiture peut interroger le microservice client de manière transparente pour obtenir les informations nécessaires sur le client associé à une voiture.
 

