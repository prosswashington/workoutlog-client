package com.rossprojects.workoutlogclient.model;

public class Workout {

	private int id;
	
	private String workoutName;
	
	private int userId;
	
	private String description;
	
	public Workout() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", workoutName=" + workoutName + ", userId=" + userId + ", description="
				+ description + "]";
	}

	
}	





