package com.rfigueiredo.mongoTemplate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.rfigueiredo.mongoTemplate.model.Car;
 
 
@Repository
@Qualifier("carDao")
public class CarDaoImpl implements CarDao {
 
    @Autowired
    MongoTemplate mongoTemplate;
 
    final String COLLECTION = "cars";
 
    public void create(Car car) 
    {
        mongoTemplate.insert(car);
    }
 
    public void update(Car car) 
    {
        mongoTemplate.save(car);
    }
 
    public void delete(Car car) 
    {
        mongoTemplate.remove(car);
    }
 
    public void deleteAll() 
    {
        mongoTemplate.remove(new Query(), COLLECTION);
    }
 
    public Car find(Car car) 
    {
        Query query = new Query(Criteria.where("_id").is(car.getId()));
        return mongoTemplate.findOne(query, Car.class, COLLECTION);
    }
 
    public List < Car > findAll() 
    {
        return (List < Car > ) mongoTemplate.findAll(Car.class);
    }
 
}