package com.myorg.ezdeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //Método main de la aplicación de spring para que se ejecute
    public static void main(String[] args) {
        //Inicia la aplicación
        SpringApplication.run(Application.class, args);
    }
}