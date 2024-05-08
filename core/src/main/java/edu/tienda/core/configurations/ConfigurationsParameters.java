package edu.tienda.core.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ConfigurationsParameters {

    private String name;
    private String language;
    private String country;
    private String author;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ConfigurationParameters{" +
            "name=" + name + '\'' +
            ", country=" + country + '\'' +
            ", author=" + author + '\'' +
            ", language=" + language + '\'' +
            '}';

    }
}
