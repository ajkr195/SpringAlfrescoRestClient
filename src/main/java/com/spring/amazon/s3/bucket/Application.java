package com.spring.amazon.s3.bucket;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

		// The URL (end point)
		String uri = "http://someservername:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/12341234-1234-1234-1234-123412341234/children";

		try {
			// HttpHeaders
			HttpHeaders headers = new HttpHeaders();

			// SetContentType
			headers.setContentType(MediaType.APPLICATION_JSON);

			// SetBasicAuthentication
			headers.setBasicAuth("admin", "admin");

			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			// Get response for GET method
			System.out.println("Response status - " + response.getStatusCode());
			System.out.println("Response has body? - " + response.hasBody());
			System.out.println("Response body - " + response.getBody());

		} catch (Exception e) {
			System.out.println("Error occurred...");
			e.printStackTrace();
		}
		return null;

	}

}
