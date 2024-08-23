package com.globallogic.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.entity.Laptop;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop, Integer>{

}
