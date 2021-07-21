package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>
{

}
