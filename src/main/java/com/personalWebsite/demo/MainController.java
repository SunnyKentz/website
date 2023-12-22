package com.personalWebsite.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@Controller()
public class MainController {

    String errorPage = """
                        <div class="center">
                            <h2>This page is not accessible</h2>
                            <h3>Please Go back to the app</h3>
                        </div>
                        <div class="center">
                            <a href="http://localhost:8080">Application</a>
                        </div>
            """;

    @GetMapping("/")
    String mainPage(@RequestParam( required = false) String lang){
        if (lang == "en"){
                return "homeEnglish.html";
        }
        return "home.html";
    }

    @GetMapping("/presentation")
    @ResponseBody
    ResponseEntity<Map<String, Object>> presentation(@RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        if(lang == "en"){
                answer.put("Titre", "Profile");
                answer.put("Text", """
                        Two years of experience in software development to date, and I find that it's not 
                        enough. Yet, that's what's so impressive about the software field; one never stops learning, 
                        and you're never too good... At least, I haven't proven it yet. From DevOps 
                        CI to testing, from automation to CD deployment, I am familiar with the entire 
                        Agile SCRUM process.
                        """);
        }else{
                answer.put("Titre", "Présentation");
                answer.put("Text", """
                        Deux ans d’expérience en développement logiciel à ce jour, je trouve que ce 
                        n’est pas assez. C’est pourtant ce qui est si impressionnant, dans le domaine du 
                        software, on ne finit pas d’apprendre, on n’est jamais trop bon… Je ne l’ai pas
                        encore prouvé en tout cas. Du devops CI aux tests, de l’automatisation Jusqu’au 
                        déploiement CD, je connais tout le procédé Agile SCRUM.
                        """);
                }
        answer.put("src","profile.jpg");
        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/competence")
    @ResponseBody
    ResponseEntity<Map<String, Object>> competence(@RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        if(lang == "en"){
                answer.put("Titre", "Skills");
                answer.put("sousTitre1", "Social Skills");
                answer.put("Text1", """
                        Ability to speak and write in English and French, with a habit of delivering written and oral
                        reports, I have developed good communication skills and the ability to establish connections
                        with those around me.
                """);
                answer.put("sousTitre2", "Computer Skills");
                answer.put("Text2", """
                Ability to install and troubleshoot Windows 7 to 11 
                and knowledge of Unix/Linux (Ubuntu, Debian, Fedora).
                """);
                answer.put("sousTitre3", "Programming Skills");
                answer.put("Text3", """
                        Programmation en Java, C# & .NET, Go , NodeJS et Python. (Back-end)
                        Bash, Autohotkey. (Script, Automation)
                        React, Flutter & Qt6 (UI Front-end mobile app)
                        Docker, MariaDB, MySQL (system architecture & database)
                        Pytest, Playwright, Selenium. (Test)
                """);
        }else{
                answer.put("Titre", "Compétence");
                answer.put("sousTitre1", "Compétence Social");
                answer.put("Text1", """
                        Capacité de parler et d’écrire en anglais et en français, ayant l’habitude de rendre
                        des rapports écrits et orales, j’ai développé une bonne capacité à communiquer et à
                        établir des liens avec mon entourage.
                        """);
                answer.put("sousTitre2", "Compétence en informatique");
                answer.put("Text2", """
                        Capacité d’installer et de dépanner Windows 7 à 11, 
                        Connaissance de Unix/Linux (Ubuntu, Debian, Fedora).
                        """);
                answer.put("sousTitre3", "Compétence en Programation");
                answer.put("Text3", """
                        Programmation en Java, C# & .NET, Go , NodeJS et Python. (Back-end)
                        Bash, Autohotkey. (Script, Automation)
                        React, Flutter & Qt6 (UI Front-end Application mobile)
                        Docker, MariaDB, MySQL (architecture de système & base de données)
                        Pytest, Playwright, Selenium. (Test)
                        """);  
        }
        
        answer.put("src","social.jpg");

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/professionnel")
    @ResponseBody
    ResponseEntity<Map<String, Object>> professionnel(@RequestHeader(required = false) HttpHeaders orggin, @RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        Map<String,Object> answerFr = new HashMap<>();
        Map<String,Object> answerEn = new HashMap<>();

        answerFr.put("Titre", "Expérience professionnel");

        answerFr.put("sousTitre1", "Developeur d’application python");
        answerFr.put("Text1", """
                Telcobridges, QC, Boucherville Juin 2022 à août 2022.
                """);

        answerFr.put("Text2", """
                Création d’une application avec QT6 python en utilisation et Git pour commit et push.
                J'ai aussi utiliser  Jira pour CI/CD devops.
                """);

        answerFr.put("Text3", """
                J’ai automatisé des scripts sur Windows avec Autohotkey.
                """);

        answerFr.put("Text4", """
                 Mon application avait pour but d’augmenter et d’automatisé la production, ce qui est un succès.
                """);

        answer.put("English", answerEn);
        answer.put("francais",answerFr);
        answer.put("src","telcobridges.jpg");

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/travail")
    @ResponseBody
    ResponseEntity<Map<String, Object>> travail(@RequestHeader(required = false) HttpHeaders orggin, @RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        Map<String,Object> answerFr = new HashMap<>();
        Map<String,Object> answerEn = new HashMap<>();

        answerFr.put("Titre", "Expérience de Travail");

        answerFr.put("sousTitre1", "Commis (travail d’été)");
        answerFr.put("Text1", """
                Couche-Tard, QC, Terrebonne Juillet 2019 à octobre 2019
                """);

        answerFr.put("Text2", """
                Amélioration de mes expériences en service à la clientèle
                """);

        answerFr.put("sousTitre2", "Réceptionniste (travail d’été)");

        answerFr.put("Text3", """
                 Bistro L’aparté, QC, Terrebonne Juillet 2018
                """);
        answerFr.put("Text4", """
                 Amélioration de mes expériences en service à la clientèle
                """);

        answer.put("English", answerEn);
        answer.put("francais",answerFr);
        answer.put("src","couchetard.png");

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/projets")
    @ResponseBody
    ResponseEntity<Map<String, Object>> projets(@RequestHeader(required = false) HttpHeaders orggin, @RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        Map<String,Object> answerFr = new HashMap<>();
        Map<String,Object> answerEn = new HashMap<>();

        answerFr.put("Titre", "Projets personnels");

        answerFr.put("sousTitre1", "Application de clavardage");
        answerFr.put("Text1", """
                Une application mobile qui permet de clavarder avec Dart Flutter et sqlite.
                J’ai utilisé le langage SQL et Dart pour pouvoir envoyer des http et websocket request au backend.
                """);

        answerFr.put("Text2", """
                Backend en Golang et Frontend avec Flutter
                J’ai fait du json parsing et des fonctions http pour faire un API http et websocket.
                """);

        answerFr.put("sousTitre2", "Siteweb de mon C.V.");

        answerFr.put("Text3", """
                 Ce site web est un de mes projets personnels pour pratiquer mes abbilités en fullstack.
                 Le but est de faire mon C.V. en version web. Je compte faire ce site web avec Jquery et Spring boot,
                 React et Dotnet Core, Angular et nodeJs.
                """);

        answer.put("English", answerEn);
        answer.put("francais",answerFr);
        answer.put("src1","58710.png");
        answer.put("src2","58711.png");
        answer.put("src3","code.png");

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/autres")
    @ResponseBody
    ResponseEntity<Map<String, Object>> autres(@RequestHeader(required = false) HttpHeaders orggin, @RequestParam(value = "lang",required = false) String lang){

        Map<String,Object> answer = new HashMap<>();
        Map<String,Object> answerFr = new HashMap<>();
        Map<String,Object> answerEn = new HashMap<>();

        answerFr.put("Titre", "Autres versions de ce site");

        answerFr.put("sousTitre1", "Jquery et Spring boot");
        answerFr.put("Text1", """
                Ce site web va avoir un front-end en html/css/javascript avec un peu d'aide de jquery,
                Ce site web va avoir un backend en Java spring boot.
                """);

        answerFr.put("sousTitre2", "React et Dotnet Core");
        answerFr.put("Text2", """
                Ce site web va avoir un front-end fait avec React,
                Ce site web va avoir un backend en C#  dotNet Core.
                """);

        answerFr.put("sousTitre3", "Angular et nodeJs");
        answerFr.put("Text3", """
                Ce site web va avoir un front-end fait avec Angular,
                Ce site web va avoir un backend NodeJS et expressJS.
                """);

        answer.put("English", answerEn);
        answer.put("francais",answerFr);
        answer.put("src1","springboot.jpg");
        answer.put("src2","dotnet.png");
        answer.put("src3","nodejs.png");

        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }

    @GetMapping("/cv")
    String cv(@RequestParam( required = false) String lang){
        return "cv.pdf";
    }
}
