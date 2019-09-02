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

import com.rossprojects.workoutlogclient.model.User;

@Service
public class UserServiceRestClientImpl implements UserService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public UserServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url.users}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<User> getUsers() {
		
		logger.info("in getUsers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<User>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<User>>() {});

		// get the list of users from response
		List<User> users = responseEntity.getBody();

		logger.info("in getUsers(): users" + users);
		
		return users;
	}

	@Override
	public User getUser(int theId) {

		logger.info("in getUser(): Calling REST API " + crmRestUrl);

		// make REST call
		User theUser = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  User.class);

		logger.info("in saveUser(): theUser=" + theUser);
		
		return theUser;
	}

	@Override
	public void saveUser(User theUser) {

		logger.info("in saveUser(): Calling REST API " + crmRestUrl);
		
		int userId = theUser.getId();

		// make REST call
		if (userId == 0) {
			// add user
			restTemplate.postForEntity(crmRestUrl, theUser, String.class);			
		
		} else {
			// update user
			restTemplate.put(crmRestUrl, theUser);
		}

		logger.info("in saveUser(): success");	
	}

	@Override
	public void deleteUser(int theId) {

		logger.info("in deleteUser(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteUser(): deleted user theId=" + theId);
	}

}
