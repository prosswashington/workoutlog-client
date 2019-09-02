package com.rossprojects.workoutlogclient.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Repetition {
	
	private int id;
	
	private int exerciseId;
	
	private int weight;
	
	private int repetitions;
	
	// Jackson default time zone is GMT. Need to convert from GMT. Central time is -05:00 ("date": "2020-11-10-0500")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddz")
	private Date date;
	
	public Repetition() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public Date getDate() {	
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Repetition [id=" + id + ", exerciseId=" + exerciseId + ", weight=" + weight + ", repetitions="
				+ repetitions + ", date=" + date + "]";
	}
}





