package com.gmp.dungeonsanddragons.external;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DndClient {

    private static final URI BASE_URI = URI.create("https://www.dnd5eapi.co");

    private static final RestTemplate RESTAPI = new RestTemplate();

    private interface Endpoints {
        String CLASSES = "/api/classes";
        String RACES = "/api/races";
    }

    public List<ApiReference> getRace() {
        return getApiValues(Endpoints.RACES);
    }

    public List<ApiReference> getCharacterClass() {
        return getApiValues(Endpoints.CLASSES);
    }
    
    public List<ApiReference> getApiValues(String endpoint) {
    	ResponseEntity<ResourceList> responseEntity = 
    			  RESTAPI.exchange(getApiUri(endpoint), HttpMethod.GET, null,
    					  new ParameterizedTypeReference<ResourceList>() {}
    			  );
		return responseEntity.getBody().getResults();
    }

    private URI getApiUri(String endpoint) {
        if (!endpoint.startsWith("/")) {
            endpoint = "/" + endpoint;
        }
        return BASE_URI.resolve(endpoint);
    }

    private URI getApiUri(String endpoint, String index) {
        if (!endpoint.startsWith("/")) {
            endpoint = "/" + endpoint;
        }
        return BASE_URI.resolve(endpoint + "/" + index);
    }
}
