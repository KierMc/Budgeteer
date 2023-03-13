package com.kiernan.budgetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kiernan.budgetapp.models.Expense;
import com.kiernan.budgetapp.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepo;

	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public Expense getOne(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		return expense.isPresent() ? expense.get() : null;
	}
	
	public List<Expense> findAll() {
		return (List<Expense>) expenseRepo.findAll();
	}
	
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense update(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void delete (Long id) {
		expenseRepo.deleteById(id);
	}

}
