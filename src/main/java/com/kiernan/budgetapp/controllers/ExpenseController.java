package com.kiernan.budgetapp.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiernan.budgetapp.models.Expense;
import com.kiernan.budgetapp.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	private final ExpenseService expenseServ;
	
	public ExpenseController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	@GetMapping("/create")
	public String createExpense(@ModelAttribute("expense") Expense expense, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "expense/create.jsp";
	}
	
	@PostMapping("/create")
	public String processCreateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "expense/create.jsp";
		}
		expenseServ.create(expense);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Expense expense = expenseServ.getOne(id);
		model.addAttribute("expense", expense);
		return "expense/edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditExpense(@PathVariable("id") Long id, @Valid @ModelAttribute("exense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "expense/edit.jsp";
		}
		expenseServ.update(expense);
		return "redirect:/";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String viewExpense(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Expense expense = expenseServ.getOne(id);
		model.addAttribute("expense", expense);
		return "expense/view.jsp";
	}

}
