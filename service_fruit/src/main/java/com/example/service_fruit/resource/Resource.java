package com.example.service_fruit.resource;

import com.example.service_fruit.model.Fruit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Resource {


    @RequestMapping("/sendFruits")
    public Fruit sendFruit(@RequestParam int FruitId){
        Fruit fr = null;
        switch (FruitId){
            case 1:
                fr = new Fruit("Apple");
                break;
            case 2:
                fr = new Fruit("Banana");
                break;
        }

        RestTemplate restTemplate = new RestTemplate();
       Fruit fruit = restTemplate.postForObject("http://localhost:8302/rest/add", fr, Fruit.class);
       return fruit;


    }


}
