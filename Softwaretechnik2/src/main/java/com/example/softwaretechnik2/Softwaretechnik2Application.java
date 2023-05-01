package com.example.softwaretechnik2;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Softwaretechnik2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Softwaretechnik2Application.class, args);

        Produkt salamibrötchen = new Produkt();
        salamibrötchen.setProductName("Salamibrötchen");

        ProduktRepository repo = applicationContext.getBean(ProduktRepository.class);
        repo.save(salamibrötchen);
    }

}
