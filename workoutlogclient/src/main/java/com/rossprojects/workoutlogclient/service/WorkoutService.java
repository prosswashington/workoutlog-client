package com.rossprojects.workoutlogclient.service;

import java.util.List;

import com.rossprojects.workoutlogclient.model.Workout;

public interface WorkoutService {

	public List<Workout> getWorkouts();
	
	public List<Workout> getWorkouts(int userId);

	public void saveWorkout(Workout theWorkout);

	public Workout getWorkout(int theId);

	public void deleteWorkout(int theId);
	
}
