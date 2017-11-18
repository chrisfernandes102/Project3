package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Component
public class MyTasks {
    RestTemplate restTemplate = new RestTemplate();
    private static int id = 1;


    @Scheduled(cron = "*/10 * * * * *")
    public void addVehicle(){
        String url = "http://localhost:8080/addVehicle";
        String string = generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 17);
        int randomYear = generateRandomNumbers(1986,2016);
        int randomPrice = generateRandomNumbers(15000,45000);

        Vehicle vehicle = new Vehicle(0,string,randomYear,randomPrice);

        restTemplate.postForObject(url,vehicle,Vehicle.class);

    }

    @Scheduled(cron = "0 0 */2 * * *")
    public void deleteVehicle(){
        int randId = generateRandomNumbers(0,100);
        String url = "http://localhost:8080/deleteVehicle/";
        String newUrl = url + randId;
        System.out.println(newUrl);
        restTemplate.delete(newUrl);

    }

    @Scheduled(cron = "0 30 * * * *")
    public void updateVehicle(){
        int randId = generateRandomNumbers(0,100);
        String url = "http://localhost:8080/updateVehicle";
        String getUrl = "http://localhost:8080/getVehicle/"+randId;
        Vehicle vehicle = new Vehicle(randId,"Ford Focus", 2019,20900);
        restTemplate.put(url,vehicle,Vehicle.class);
        Vehicle v = restTemplate.getForObject(getUrl,Vehicle.class);
        System.out.println(getUrl);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void latestVehicleReport() {
        String getUrl = "http://localhost:8080/getLatestVehicle";
        List report = restTemplate.getForObject(getUrl,List.class);
        for(int i = 0; i < report.size(); i++){
            System.out.println(report.get(i));
        }
    }


    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }

        return sb.toString();
    }

    public static int generateRandomNumbers(int min, int max) {
        Random rand = new Random();
        int random = min + rand.nextInt((max - min) + 1);
        return random;
    }

}
