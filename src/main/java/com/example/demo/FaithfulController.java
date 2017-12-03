package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class FaithfulController {
    @Timed
    @RequestMapping(value = "/eat/{coffee}", method = RequestMethod.GET)
    public void eating(@PathVariable("coffee") String coffee) throws IOException {
        if(coffee == null) {
            System.out.println(" before drinking a coffee!");
        } else {
            System.out.println(" before drinking a " + coffee + "!");
        }
    }

    @Timed
    @RequestMapping(value = "/eatWithFriends/{coffee}", method = RequestMethod.GET)
    public void eatWithFriends(@PathVariable("coffee") String coffee) throws IOException {
        if(coffee == null)
            System.out.println(" when drinking coffee with friends!");
        else
            System.out.println(" when drinking a " + coffee + " with friends!");
    }

    @Timed
    @RequestMapping(value = "/study/{subject}", method = RequestMethod.GET)
    public void studying(@PathVariable("subject") String subject) throws IOException {
        if(subject == null) {
            System.out.println(" when I am studying for class!");
        } else {
            System.out.println(" when I am studying for " + subject + "!");
        }
    }

    @Timed
    @RequestMapping(value = "/meetWithFriends/{place}", method = RequestMethod.GET)
    public void meetWithFriends(@PathVariable("place") String place) throws IOException {
        if (place == null) {
            System.out.println(" before meeting with friends!");
        } else {
            System.out.println(" before meeting with friends at " + place + "!");
        }
    }

    @Timed
    @RequestMapping(value = "/play/{coffeeShop}", method = RequestMethod.GET)
    public void playing(@PathVariable("coffeeShop") String coffeeShop) throws IOException {
        if(coffeeShop == null) {
            System.out.println(" before I go get coffee!");
        } else {
            System.out.println(" before I go to " + coffeeShop + "!");
        }
    }
}
