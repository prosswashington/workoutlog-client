package com.rossprojects.workoutlogclient.model;

public class Exercise {
	
	private int id;
	
	private int workoutId;
	
	private String name;
	
	private String muscle;
	
	private String description;
	
	public Exercise() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMuscle() {
		return muscle;
	}

	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", workoutId=" + workoutId + ", name=" + name + ", muscle=" + muscle
				+ ", description=" + description + "]";
	}
}





