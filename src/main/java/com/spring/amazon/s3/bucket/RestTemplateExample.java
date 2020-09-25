package com.spring.amazon.s3.bucket;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {

	public static void main(String[] args) {
		getFolderContentList();
	}

	private static void getFolderContentList() {
		String uri = "http://someservername:8080/alfresco/api/-default-/public/alfresco/versions/1/nodes/12341234-1234-1234-1234-123412341234/children";

		RestTemplate restTemplate = new RestTemplate();

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

	}

}
