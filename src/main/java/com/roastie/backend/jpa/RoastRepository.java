package com.roastie.backend.jpa;

import org.springframework.data.repository.CrudRepository;

import com.roastie.backend.jpa.entity.Roast;

public interface RoastRepository extends CrudRepository<Roast, Integer>{

}
