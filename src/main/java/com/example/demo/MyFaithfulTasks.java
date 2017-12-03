package com.example.demo;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Component
@EnableScheduling
public class MyFaithfulTasks {
    RestTemplate restTemplate = new RestTemplate();
    Random r = new Random();

    /**
     * Lists to hold coffee, coffeeHouse, subjects
     */
    ArrayList<String> coffee = new ArrayList<>(Arrays.asList("Americano", "Cold Brew", "Machiatto", "Latte", "Turkish Coffee"));
    ArrayList<String> coffeeHouse = new ArrayList<>(Arrays.asList("Arcade Coffee", "Molinos", "Augies", "Lift Roasters", "Dripp Coffee"));
    ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Software Construction", "Engineering Statistics", "SQA", "Economics", "Computer Architecture"));

    /**
     * Call eat at interval
     */
    @Scheduled(cron="*/20 * * * * *")
    public void eating(){
        String url = "http://localhost:8080/eat/";
        restTemplate.getForObject(url + selectRandomObject(coffee), String.class);
    }

    /**
     * Call eatWithFriends at interval
     */
    @Scheduled(cron="*/20 * * * * *")
    public void eatingWithFriends(){
        String url = "http://localhost:8080/eatWithFriends/";
        restTemplate.getForObject(url + selectRandomObject(coffee), String.class);
    }

    /**
     * Call studying at interval
     */
    @Scheduled(cron="*/20 * * * * *")
    public void studying(){
        String url = "http://localhost:8080/study/";
        restTemplate.getForObject(url + selectRandomObject(subjects), String.class);
    }

    /**
     * Call meetWithFriends at interval
     */
    @Scheduled(cron="*/20 * * * * *")
    public void meetingWithFriends(){
        String url = "http://localhost:8080/meetWithFriends/";
        restTemplate.getForObject(url + selectRandomObject(coffeeHouse), String.class);
    }

    /**
     * Call playing at interval
     */
    @Scheduled(cron="*/20 * * * * *")
    public void playing(){
        String url = "http://localhost:8080/play/";
        restTemplate.getForObject(url + selectRandomObject(coffeeHouse), String.class);
    }

    /**
     * Get random object from one of the lists
     * @param list - the list of string
     * @return
     */
    private String selectRandomObject(ArrayList<String> list){
        return list.get(r.nextInt(list.size()));
    }
}
