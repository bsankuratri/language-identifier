package com.personal.languageidentifier;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;

import org.springframework.stereotype.Service;

@Service("languageService")
public class LanguageService {
  
  public enum Languages {
    
    
    ENGLISH(Language.ENGLISH.name()),
    FRENCH(Language.FRENCH.name()),
    ITALIAN(Language.ITALIAN.name()),
    SPANISH(Language.SPANISH.name()),
    GERMAN(Language.GERMAN.name()),
    DUTCH(Language.DUTCH.name());
    
    
    private String language;
    
    Languages(String language) {
      this.language = language;
    }
    
    @Override
    public String toString() {
      return this.language;
    }
  }
  
  public boolean isValidLanguage(String language) {
    for (Languages validLanguage: Languages.values()) {
      if (validLanguage.toString().equalsIgnoreCase(language)) {
        return true;
      }
    }
    return false;
  }
  
  public String determineLanguage(String content) {
    return LanguageDetectorBuilder.fromLanguages(
        Language.ENGLISH,
        Language.FRENCH,
        Language.ITALIAN,
        Language.SPANISH,
        Language.GERMAN,
        Language.DUTCH
    ).build().detectLanguageOf(content).toString();
  }

}
