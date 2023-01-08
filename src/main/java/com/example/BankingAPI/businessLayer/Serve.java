package com.example.BankingAPI.businessLayer;

import java.util.List;

import com.example.BankingAPI.DataModelLayer.BalanceTransaction;
import com.example.BankingAPI.DataModelLayer.Customer;
import com.example.BankingAPI.ExceptionHandler.UserDefinedException;

public interface Serve {

	public abstract void  add(Customer c1) throws UserDefinedException;

	public abstract List<Customer> All() throws UserDefinedException;

	public abstract Customer getOne(int id) throws UserDefinedException;

	public abstract void updateAccount(Customer c1) throws UserDefinedException;

	public abstract void trans(BalanceTransaction b1);

	public abstract Customer searchName(String name);

	public abstract void delete(int id);

}
