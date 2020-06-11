package org.broadinstitute.mbta.service;

import org.broadinstitute.mbta.client.RestTemplateClientFactory;
import org.broadinstitute.mbta.client.WebClientFactory;
import org.broadinstitute.mbta.core.Stop;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopsMbtaServiceImplTest {
    private WebClient webClient;
    private RestTemplate restTemplate;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        WebClientFactory wcf = new WebClientFactory();
        webClient = wcf.create();

        RestTemplateClientFactory rtcf = new RestTemplateClientFactory();
        restTemplate = rtcf.create();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        webClient = null;
        restTemplate = null;
    }

    @Test
    void test_getStops() {
        StopsMbtaServiceImpl stopsService = new StopsMbtaServiceImpl();
        final List<Stop> stopList = stopsService.getStops();
        // Determine that the number of subway MBTA stops is approximately 254 +/- 10
        assertEquals(254, stopList.size(), 10);
    }


    @Test
    void test_RestTemplateValidConnection() {

        final String baseUrl = "https://api-v3.mbta.com/stops?filter[route_type]=0,1&include=route,parent_station";
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void test4() throws URISyntaxException {
        final String baseUrl = "https://api-v3.mbta.com/stops?filter[route_type]=0,1&include=route,parent_station";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        final String response =
                restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class).getBody();

        //List<Stop> rates = rateResponse.getBody();
        //assertTrue(rates.size() > 0);
    }
}