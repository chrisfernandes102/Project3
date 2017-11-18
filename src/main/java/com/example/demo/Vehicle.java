package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehicle implements Serializable{

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;

    private String makeModel;
    private int year;
    private double retailPrice;

    public Vehicle(){

    }

    public Vehicle(int id, String makeModel, int year, double retailPrice) {
        this.id = id;
        this.makeModel = makeModel;
        this.year = year;
        this.retailPrice = retailPrice;
    }

    public int getId() {
        return id;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.makeModel + ", Year: " + this.year + ", Price: " + this.retailPrice;
    }
}
