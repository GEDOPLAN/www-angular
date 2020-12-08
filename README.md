# Angular und JEE

# _Wieso, weshalb, warum (und wie)?_

Webanwendungen in Java EE werden mit JSF implementiert,
ist es doch das Framework welches im Standard vorhanden ist und seid Jahren erfolgreich in Projekten eingesetzt wird. Wirft man einen Blick über den Tellerrand kommt man dieser Tage jedoch an einem ganz anderen Framework nicht vorbei. Angular. Also warum nicht mal Angular? Oder vielleicht besser: "Warum"? In dieser Session schauen wir uns die Beweggründe an, warum auch für JEE Projekte ein JavaScript-Frontend interessant sein kann und bringen in einem praktischen Beispiel "einfach" und "mal eben" JEE und Angular zusammen. Wie einfach ist die Verwendung von JavaScript-Anwendungen im Zusammenspiel mit Java EE? Welche Stolpersteine gibt es auf Java-Seite? Und worauf sollte geachtet werden wenn Java als Backend für ein JavaScript Anwendung verwendet wird?

# grundlegende Verwendung

(Aufruf im Ordner GED-ANGULAR-WWW-UI)

_Start des Development Servers + JSON Backend_
> npm run start-local


_Start des Development Servers (JEE Backend)_
> npm run start

_URL_
> http://localhost:4200

_Build für Produktion (in UI- und Backend-Projekt)_
> mvn install




# Demos / Konfigurationen, Wo ist was?

# Angular

- **package.json**, Abhängigkeiten und Registrierung der oben verwendeten Scripte
- **proxy.conf.backend.json**, Proxy Konfiguration für den Zugriff auf JEE Backend (verwendet im Script 'start')
- **proxy.conf.json**, Proxy Konfiguration für den Zugriff auf JSON-Server (verwendet im Script 'start-local')
- **pom.xml**, Registrierung von frontend-plugin um die UI als Maven Artefakt zu deployen

## JSON-Server

- grundlegender Start über: (verwendet im Script 'start-local')
  > json-server --routes xx.json

* konfigurierte Daten über **proxy.data.json** und zusätzliche (optionale) Routen über **proxy.routes.json**

## TypeScript Model

generiert über Maven Plugin aus Java Klassen oder Swagger (s. Java)

**src/app/app.models.ts**

= erlaubt optionale Typisierung (sehr zu empfehlen)

# Java

## UI
- angular-ui Einbindung über WAR-Overlay

## ModelMapper

- DTO + Mapper: **de.gedoplan.ged.angular.www.persistence.model.dto.BookMapper.java**
- Verwendung: **de.gedoplan.ged.angular.www.persistence.BookRepository#getBookOverview()**
- Resource: **http://localhost:8080/ged-angular-www-backend-1.0-SNAPSHOT/resources/books**

## Jackson

- @JsonIgnore : de.gedoplan.ged.angular.www.persistence.model.Publisher.java
- @JsonView : de.gedoplan.ged.angular.www.persistence.model.Author.java
- @JsonView : de.gedoplan.ged.angular.www.resources.Authors.java
- @JsonIdentityInfo (Mapping von Relationen): de.gedoplan.ged.angular.www.persistence.model.Publisher.java
- JPAResolver (passend zu @JsonIdentity, ObjectIdGenerators.PropertyGenerator): de.gedoplan.ged.angular.www.persistence.utils.JPAResolver.java

### Jackson im Wildfly > 13

- Überschreiben von JSON-B (Standard ab JEE8) über **jboss-deployment-structure.xml**, siehe auch: https://javaeeblog.wordpress.com/2018/08/30/jackson-und-java-ee-8/

## TypeScript Generierung

- über Maven Plugins
  - pom.xml#96, typescript-generator-maven-plugin
  - pom.xml#117, swagger-maven-plugin
