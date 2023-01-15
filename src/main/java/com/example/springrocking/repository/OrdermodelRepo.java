package com.example.springrocking.repository;


import com.example.springrocking.entity.Ordermodel;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrdermodelRepo extends CrudRepository<Ordermodel, Long>{
    List<Ordermodel> findAll();

    Ordermodel save(Ordermodel model);
    
}
