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

import com.rossprojects.workoutlogclient.model.Exercise;
import com.rossprojects.workoutlogclient.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

	// need to inject our customer service
	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/list")
	public String listExercises(Model theModel) {
		
		// get customers from the service
		List<Exercise> theExercises = exerciseService.getExercises();
				
		// add the customers to the model
		theModel.addAttribute("exercises", theExercises);
		
		return "list-exercises";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Exercise theExercise = new Exercise();
		
		theModel.addAttribute("exercise", theExercise);
		
		return "exercise-form";
	}
	
	@PostMapping("/saveExercise")
	public String saveExercise(@ModelAttribute("exercise") Exercise theExercise) {
		
		// save the customer using our service
		exerciseService.saveExercise(theExercise);	
		
		return "redirect:/exercise/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("exerciseId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Exercise theExercise = exerciseService.getExercise(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("exercise", theExercise);
		
		// send over to our form		
		return "exercise-form";
	}
	
	@GetMapping("/delete")
	public String deleteExercise(@RequestParam("exerciseId") int theId) {
		
		// delete the exercise
		exerciseService.deleteExercise(theId);
		
		return "redirect:/exercise/list";
	}
}










