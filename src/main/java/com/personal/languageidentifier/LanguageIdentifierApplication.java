package com.personal.languageidentifier;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class LanguageIdentifierApplication implements CommandLineRunner {
  
  @Autowired
  LanguageService languageService;
  
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(LanguageIdentifierApplication.class, args);
    context.close();
  }


  @Override
  public void run(String... args) throws Exception {
    String content = "<h3>Ça change vite: restons en contact.</h3><p>Rien ne semble correspondre à ton profil? Soumets ton CV et abonne-toi à nos alertes et notre infolettre: ça viendra!</p>";
    String parsed = Jsoup.parse(content).text();
    String language = languageService.determineLanguage(parsed);
    System.out.println(language);
  }

}
