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

import com.rossprojects.workoutlogclient.model.Repetition;

@Service
public class RepetitionServiceRestClientImpl implements RepetitionService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public RepetitionServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Repetition> getRepetitions() {
		
		logger.info("in getRepetitions(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Repetition>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Repetition>>() {});

		// get the list of repetitions from response
		List<Repetition> repetitions = responseEntity.getBody();

		logger.info("in getRepetitions(): repetitions" + repetitions);
		
		return repetitions;
	}

	@Override
	public Repetition getRepetition(int theId) {

		logger.info("in getRepetition(): Calling REST API " + crmRestUrl);

		// make REST call
		Repetition theRepetition = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Repetition.class);

		logger.info("in saveRepetition(): theRepetition=" + theRepetition);
		
		return theRepetition;
	}

	@Override
	public void saveRepetition(Repetition theRepetition) {

		logger.info("in saveRepetition(): Calling REST API " + crmRestUrl);
		
		int repetitionId = theRepetition.getId();

		// make REST call
		if (repetitionId == 0) {
			// add repetition
			restTemplate.postForEntity(crmRestUrl, theRepetition, String.class);			
		
		} else {
			// update repetition
			restTemplate.put(crmRestUrl, theRepetition);
		}

		logger.info("in saveRepetition(): success");	
	}

	@Override
	public void deleteRepetition(int theId) {

		logger.info("in deleteRepetition(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteRepetition(): deleted repetition theId=" + theId);
	}

	@Override
	public List<Repetition> getRepetitions(int exerciseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
