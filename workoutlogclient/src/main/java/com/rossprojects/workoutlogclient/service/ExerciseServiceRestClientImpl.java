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

import com.rossprojects.workoutlogclient.model.Exercise;

@Service
public class ExerciseServiceRestClientImpl implements ExerciseService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public ExerciseServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Exercise> getExercises() {
		
		logger.info("in getExercises(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Exercise>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Exercise>>() {});

		// get the list of exercises from response
		List<Exercise> exercises = responseEntity.getBody();

		logger.info("in getExercises(): exercises" + exercises);
		
		return exercises;
	}

	@Override
	public Exercise getExercise(int theId) {

		logger.info("in getExercise(): Calling REST API " + crmRestUrl);

		// make REST call
		Exercise theExercise = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Exercise.class);

		logger.info("in saveExercise(): theExercise=" + theExercise);
		
		return theExercise;
	}

	@Override
	public void saveExercise(Exercise theExercise) {

		logger.info("in saveExercise(): Calling REST API " + crmRestUrl);
		
		int exerciseId = theExercise.getId();

		// make REST call
		if (exerciseId == 0) {
			// add exercise
			restTemplate.postForEntity(crmRestUrl, theExercise, String.class);			
		
		} else {
			// update exercise
			restTemplate.put(crmRestUrl, theExercise);
		}

		logger.info("in saveExercise(): success");	
	}

	@Override
	public void deleteExercise(int theId) {

		logger.info("in deleteExercise(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteExercise(): deleted exercise theId=" + theId);
	}

	@Override
	public List<Exercise> getExercises(int workoutId) {
		// TODO Auto-generated method stub
		return null;
	}

}
