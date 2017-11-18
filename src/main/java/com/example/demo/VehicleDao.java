package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VehicleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Vehicle vehicle){
        entityManager.merge(vehicle);
        return;
    }

    public Vehicle getById(int id){
        return entityManager.find(Vehicle.class,id);
    }

    public Vehicle update(Vehicle vehicle){
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle){
        entityManager.remove(vehicle);
    }

    public List<Vehicle> getLatestList(String query){
        Query q = entityManager.createNativeQuery(query, Vehicle.class);
        List<Vehicle> vehicleList = q.getResultList();
        return vehicleList;
    }

}
