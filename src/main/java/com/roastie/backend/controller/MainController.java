package com.roastie.backend.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roastie.backend.jpa.RoastRepository;
import com.roastie.backend.jpa.entity.Roast;
//@CrossOrigin(origins = "http://localhost:4200")

@RestController  // This means that this class is a Controller
@RequestMapping(path="/roast") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {
	
	@Autowired
	private RoastRepository roastRepository;

	@PostMapping(path="/add", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
	public Roast addNewRoast (@Valid @RequestBody Roast roast) {
	
		roastRepository.save(roast);
		return roast;
		//return "Saved Roast";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Roast> getAllRoasts() {
	return roastRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	//@DeleteMapping(path="/delete/{id}")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json" )
	public @ResponseBody Optional<Roast>delete(@RequestParam int id) {
		Optional<Roast> roast = roastRepository.findById(id);

        roastRepository.deleteById(id);
        
        return roast;
	}
	
	

}
