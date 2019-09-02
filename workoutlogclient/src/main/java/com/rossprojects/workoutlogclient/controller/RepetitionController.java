package com.rossprojects.workoutlogclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rossprojects.workoutlogclient.model.Repetition;
import com.rossprojects.workoutlogclient.service.RepetitionService;

@Controller
@RequestMapping("/repetition")
public class RepetitionController {

	// need to inject our customer service
	@Autowired
	private RepetitionService repetitionService;
	
	@GetMapping("/list")
	public String listRepetitions(Model theModel) {
		
		// get customers from the service
		List<Repetition> theRepetitions = repetitionService.getRepetitions();
				
		// add the customers to the model
		theModel.addAttribute("repetitions", theRepetitions);
		
		return "list-repetitions";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Repetition theRepetition = new Repetition();
		
		theModel.addAttribute("repetition", theRepetition);
		
		return "repetition-form";
	}
	
	@PostMapping("/saveRepetition")
	public String saveRepetition(@ModelAttribute("repetition") Repetition theRepetition) {
		
		// save the customer using our service
		repetitionService.saveRepetition(theRepetition);	
		
		return "redirect:/repetition/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("repetitionId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Repetition theRepetition = repetitionService.getRepetition(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("repetition", theRepetition);
		
		// send over to our form		
		return "repetition-form";
	}
	
	@GetMapping("/delete")
	public String deleteRepetition(@RequestParam("repetitionId") int theId) {
		
		// delete the repetition
		repetitionService.deleteRepetition(theId);
		
		return "redirect:/repetition/list";
	}
}










