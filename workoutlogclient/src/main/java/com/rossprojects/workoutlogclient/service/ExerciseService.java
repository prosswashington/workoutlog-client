package com.rossprojects.workoutlogclient.service;

import java.util.List;

import com.rossprojects.workoutlogclient.model.Exercise;

public interface ExerciseService {

	public List<Exercise> getExercises();
	
	public List<Exercise> getExercises(int workoutId);

	public void saveExercise(Exercise theExercise);

	public Exercise getExercise(int theId);

	public void deleteExercise(int theId);
	
}
