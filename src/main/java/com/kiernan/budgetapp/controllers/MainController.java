package com.kiernan.budgetapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kiernan.budgetapp.services.ExpenseService;
import com.kiernan.budgetapp.services.UserService;

@Controller
public class MainController {

	private final UserService userServ;
	private final ExpenseService expenseServ;
	
	public MainController(UserService userServ, ExpenseService expenseServ) {
		this.userServ = userServ;
		this.expenseServ = expenseServ;
	}
	
	@GetMapping("/")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allExpenses", expenseServ.findAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}

}
