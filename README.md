# verwendete Abhängigkeiten
* Spring Boot
* Spring Security
* JPA und Hibernate über Spring JPA
  * zusätzlich JDBC von MariaDB
* thymeleaf für Templating zusammen mit Dialect
* Bootstrap für CSS

# Set Up
* Java/JDK 17 installieren
* maven ausführen
* MariaDB Datenbank Managementsystem bereitstellen
    * aktuelle Config in `src/resources/application.properties` verwendet
        * user: `root`
        * password <leer>
        * db `h2z`
        * host `localhost:3306`
    * aktuelle Config löscht den persistenten Speicher bei Neustart der Anwendung für eine komfortable Entwicklung lokal!

# sonstiges
* ausgewählte Datensätze entnommen von
  * Emissionen https://edgar.jrc.ec.europa.eu/report_2024?vis=co2tot#emissions_table
  * Ländervorwahlen https://en.wikipedia.org/wiki/List_of_telephone_country_codes
* beim Anwendungsstart erstellte Nutzer
  * `alice:alice`
  * `bob:bob`

![UML](uml.png "UML")