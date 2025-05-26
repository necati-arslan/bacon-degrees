
# 🎬 Kevin Bacon Degree Applicatie

> _"Er wordt gezegd dat je van de ene filmacteur naar een andere kunt gaan via maximaal zes connecties op basis van films waarin ze samen hebben gespeeld. Dit wordt ook wel de Kevin Bacon Degree genoemd. Denk je dat dit klopt? Wil je het uitproberen? Dan is deze applicatie echt iets voor jou! Kies gewoon twee acteurs uit de vakjes en bekijk het resultaat. Veel succes!"_

---




## ☕ Backend (Spring Boot) Project Structure

```
📦 src
└── 📁 main
    ├── 📁 java
    │   └── 📁 com
    │       └── 📁 baconfinder
    │           └── 📁 bacon_degrees
    │               ├── 📄 BaconDegreesApplication.java
    │               ├── 📁 controller
    │               │   ├── 📄 ActorController.java
    │               │   ├── 📄 PathFinderController.java
    │               │   └── 📄 TitleBasicsController.java
    │               ├── 📁 dto
    │               │   └── 📄 PathResponse.java
    │               ├── 📁 model
    │               │   ├── 📄 NameBasics.java
    │               │   ├── 📄 TitleBasics.java
    │               │   └── 📄 TitlePrincipals.java
    │               ├── 📁 repository
    │               │   ├── 📄 NameBasicsRepository.java
    │               │   ├── 📄 TitleBasicsRepository.java
    │               │   └── 📄 TitlePrincipalsRepository.java
    │               └── 📁 service
    │                   ├── 📄 ActorService.java
    │                   ├── 📄 PathFinderService.java
    │                   └── 📄 TitleBasicsService.java
    └── 📁 resources
        ├── 📄 application.properties
        ├── 📄 application-dev.properties
        ├── 📄 application-prod.properties
        ├── 📄 schema.sql
        ├── 📄 data.sql
        ├── 📁 static
        └── 📁 templates
```
