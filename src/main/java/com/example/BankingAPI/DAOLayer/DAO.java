package com.example.BankingAPI.DAOLayer;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.BankingAPI.DataModelLayer.Customer;


@Repository
public interface DAO extends JpaRepositoryImplementation<Customer, Integer>
{
	Customer findByName(String name);
   
}
