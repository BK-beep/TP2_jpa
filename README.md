# Application de Gestion Médicale

Cette application est développée en utilisant Spring Boot et Spring Data JPA pour la gestion des patients, médecins, rendez-vous, consultations, utilisateurs et rôles.

## Prérequis

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [IntelliJ IDEA Ultimate](https://www.jetbrains.com/idea/download/)
- [MySQL](https://dev.mysql.com/downloads/installer/)

## Installation

1. **Clonez le dépôt :**
    ```bash
    git clone <URL_DU_REPO>
    cd <nom_du_dossier_du_projet>
    ```

2. **Ouvrez le projet dans IntelliJ IDEA :**
    - Allez à `File -> Open` et sélectionnez le répertoire du projet.

3. **Assurez-vous que Maven télécharge toutes les dépendances nécessaires :**
    - Ouvrez le panneau Maven (`View -> Tool Windows -> Maven`) et cliquez sur le bouton `Refresh` pour télécharger les dépendances.

## Configuration de la Base de Données

Par défaut, l'application utilise H2 Database. Pour configurer MySQL :

1. **Ajoutez la dépendance MySQL dans le fichier `pom.xml` :**
    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```

2. **Modifiez le fichier `src/main/resources/application.properties` :**
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/votre_base_de_donnees
    spring.datasource.username=votre_utilisateur
    spring.datasource.password=votre_mot_de_passe
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```

## Fonctionnalités Principales

### Entité JPA Patient

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
