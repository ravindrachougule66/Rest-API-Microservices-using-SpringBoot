package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Country;
import com.demo.services.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List<Country> getCountries()
	{
		return countryService.getAllCountried();
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id)
	{
		try
		{
			Country country=countryService.getCountrybyID(id);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getcountries/countryName")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String countryName)
	{
		try
		{
			Country country=countryService.getCountrybyName(countryName);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id, @RequestBody Country country)
	{
		try
		{
			
			Country existcountry = countryService.getCountrybyID(id);
			
			existcountry.setCountryName(country.getCountryName());
			existcountry.setCountryCapital(country.getCountryCapital());
		
			Country updatedcountry = countryService.updateCountry(existcountry);
			return new ResponseEntity<Country>(updatedcountry,HttpStatus.OK);
		
		}
		catch(Exception e)
		{
			return new ResponseEntity<Country>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id)
	{
		return countryService.deleteCountry(id);
	}

}
