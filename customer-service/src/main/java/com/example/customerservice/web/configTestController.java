package com.example.customerservice.web;

import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope // pour mettre à jour les injections.
public class configTestController {

    // La premier méthode d'injection

    // pour injecter la valeur de chaque parametre de config-repo au attribut de cette class
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${customer.params.x}")
    private int x;

    @Value("${customer.params.y}")
    private int y;

    @GetMapping("/testconfig")
    public Map<String, Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y );
    }

    // La deuxième méthode au lieu d'injecter chaque parametre, on va créer une class gére ces parametres
    //"GlobalConfig"

    // injection de GlobalConfig
    @Autowired
    private GlobalConfig globalConfig;

    // pour test
    @GetMapping("globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
