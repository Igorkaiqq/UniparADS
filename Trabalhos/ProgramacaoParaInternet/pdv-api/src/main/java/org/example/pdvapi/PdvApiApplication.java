package org.example.pdvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class PdvApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdvApiApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void openSwaggerUI() {
      try {
          String url = "http://localhost:8080/swagger-ui.html";
        if (Desktop.isDesktopSupported()) {
          Desktop.getDesktop().browse(new URI(url));
        } else {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

}
