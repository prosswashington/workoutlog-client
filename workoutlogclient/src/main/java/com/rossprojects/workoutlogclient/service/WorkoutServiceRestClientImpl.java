package com.rossprojects.workoutlogclient.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rossprojects.workoutlogclient.model.Workout;

@Service
public class WorkoutServiceRestClientImpl implements WorkoutService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public WorkoutServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url.workouts}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Workout> getWorkouts() {
		
		logger.info("in getWorkouts(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Workout>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Workout>>() {});

		// get the list of workouts from response
		List<Workout> workouts = responseEntity.getBody();

		logger.info("in getWorkouts(): workouts" + workouts);
		
		return workouts;
	}

	@Override
	public Workout getWorkout(int theId) {

		logger.info("in getWorkout(): Calling REST API " + crmRestUrl);

		// make REST call
		Workout theWorkout = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Workout.class);

		logger.info("in saveWorkout(): theWorkout=" + theWorkout);
		
		return theWorkout;
	}

	@Override
	public void saveWorkout(Workout theWorkout) {

		logger.info("in saveWorkout(): Calling REST API " + crmRestUrl);
		
		int workoutId = theWorkout.getId();

		// make REST call
		if (workoutId == 0) {
			// add workout
			restTemplate.postForEntity(crmRestUrl, theWorkout, String.class);			
		
		} else {
			// update workout
			restTemplate.put(crmRestUrl, theWorkout);
		}

		logger.info("in saveWorkout(): success");	
	}

	@Override
	public void deleteWorkout(int theId) {

		logger.info("in deleteWorkout(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteWorkout(): deleted workout theId=" + theId);
	}

	@Override
	public List<Workout> getWorkouts(int userId) {
		
		logger.info("in getWorkouts(userId): Calling REST API " + crmRestUrl + "/user/" + userId);

		// make REST call
		ResponseEntity<List<Workout>> responseEntity = 
											restTemplate.exchange(crmRestUrl + "/user/" + userId, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Workout>>() {});
		
		// get the list of workouts from response
		List<Workout> workouts = responseEntity.getBody();

		logger.info("in getWorkouts(userId): workouts" + workouts);
		
		return workouts;
	}

}
