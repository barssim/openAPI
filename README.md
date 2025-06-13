
# Projekt-Dokumentation

## Projektname

OpenAPI

##  Übersicht

Dieses Projekt wurde mit dem OpenAPI Generator erstellt und verwendet das Spring Boot Framework zur Implementierung eines RESTful API-Servers.

Durch die Nutzung einer OpenAPI-Spezifikation wird automatisch ein Server-Stubskelett generiert, das die Entwicklung beschleunigt und die Dokumentation automatisiert.

Die OpenAPI-Spezifikation wird automatisch mit springdoc-openapi generiert.

---

##  Startanleitung

### Voraussetzungen

* Java 17 oder höher
* Maven 3.x
* 
### Anwendung starten

```bash
mvn spring-boot:run
oder
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.config.location=file:src/main/resources/application.yml

```

Oder als JAR:

```bash
java -jar target/openAPI*.jar
```

### Port konfigurieren

Standardport: `8080` 
Du kannst den Port in der Datei `src/main/resources/application.yml` ändern:

```yml
server.port=8091
```

---

##  Projektstruktur

```plaintext
src/
 └── main/
     ├── java/
     │    └── ma/solide/openapi/
     │         ├── controller/
     │         ├── model/
     │         └── service/
               └── repository
     └── resources/
          ├── application.yml
          └── articlestore.yml
```

---

## ⚙ Konfiguration

* `application.yml`: zentrale Konfiguration wie Port, Datenbankzugang.
* Logging ist standardmäßig über Spring Boot aktiviert (`logback`).

---

## Tests

```bash
mvn test
```

---

##  Abhängigkeiten (Auszug)

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version> 
</dependency>
```

---


##  Entwicklungshinweise

* Controllers werden automatisch anhand der API-Spezifikation erstellt.
* Du kannst Business-Logik in den Services implementieren.
* Models werden aus den OpenAPI `schemas` generiert.

---

