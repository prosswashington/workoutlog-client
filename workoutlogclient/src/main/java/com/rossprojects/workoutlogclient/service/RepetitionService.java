package com.rossprojects.workoutlogclient.service;

import java.util.List;

import com.rossprojects.workoutlogclient.model.Repetition;

public interface RepetitionService {

	public List<Repetition> getRepetitions();
	
	public List<Repetition> getRepetitions(int exerciseId);

	public void saveRepetition(Repetition theRepetition);

	public Repetition getRepetition(int theId);

	public void deleteRepetition(int theId);
	
}
