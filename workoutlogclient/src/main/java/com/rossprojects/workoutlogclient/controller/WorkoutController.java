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

import com.rossprojects.workoutlogclient.model.Workout;
import com.rossprojects.workoutlogclient.service.WorkoutService;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

	// need to inject our customer service
	@Autowired
	private WorkoutService workoutService;
	
	@GetMapping("/list")
	public String listWorkouts(Model theModel) {
		
		// get customers from the service
		List<Workout> theWorkouts = workoutService.getWorkouts();
				
		// add the customers to the model
		theModel.addAttribute("workouts", theWorkouts);
		
		return "list-workouts";
	}
	
	@GetMapping("/userList")
	public String userListWorkouts(@RequestParam("userId") int theId, Model theModel) {
		
		// get customers from the service
		List<Workout> theWorkouts = workoutService.getWorkouts(theId);
				
		// add the customers to the model
		theModel.addAttribute("workouts", theWorkouts);
		
		return "list-workouts";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Workout theWorkout = new Workout();
		
		theModel.addAttribute("workout", theWorkout);
		
		return "workout-form";
	}
	
	@PostMapping("/saveWorkout")
	public String saveWorkout(@ModelAttribute("workout") Workout theWorkout) {
		
		// save the customer using our service
		workoutService.saveWorkout(theWorkout);	
		
		return "redirect:/workout/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("workoutId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Workout theWorkout = workoutService.getWorkout(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("workout", theWorkout);
		
		// send over to our form		
		return "workout-form";
	}
	
	@GetMapping("/delete")
	public String deleteWorkout(@RequestParam("workoutId") int theId) {
		
		// delete the workout
		workoutService.deleteWorkout(theId);
		
		return "redirect:/workout/list";
	}
}










