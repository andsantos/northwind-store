package br.com.andsantos.northwind.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration
//@ComponentScan(basePackages={"br.com.andsantos.northwind"})
//@EntityScan(basePackages="br.com.andsantos.northwind.domain")
@SpringBootApplication
public class CatalogoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);
    }
}
