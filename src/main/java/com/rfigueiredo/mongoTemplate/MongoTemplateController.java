package com.rfigueiredo.mongoTemplate;


import static com.rfigueiredo.mongoTemplate.common.Constant.CREATE_SUCCESS;
import static com.rfigueiredo.mongoTemplate.common.Constant.DELETE_SUCCESS;
import static com.rfigueiredo.mongoTemplate.common.Constant.UPDATE_SUCCESS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rfigueiredo.mongoTemplate.common.Response;
import com.rfigueiredo.mongoTemplate.model.Car;
import com.rfigueiredo.mongoTemplate.service.CarService;


@RestController
@RequestMapping("/cars")
public class MongoTemplateController {
	
	@Autowired
	CarService service;
	
	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> getAll() {
		List<Car> cars = service.findAll();
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Car> create(@RequestBody Car car){
        service.create(car);
        return new ResponseEntity<Car>(car, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Car> update(@RequestBody Car car){
        service.update(car);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Response delete(@RequestBody Car car){
        service.delete(car);
        return new Response(0, DELETE_SUCCESS.replace("{1}", car.getModel()), car);
    }
}
