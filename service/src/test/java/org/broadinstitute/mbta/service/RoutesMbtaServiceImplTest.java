package org.broadinstitute.mbta.service;

import org.broadinstitute.mbta.client.RestTemplateClientFactory;
import org.broadinstitute.mbta.client.WebClientFactory;
import org.broadinstitute.mbta.core.Route;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoutesMbtaServiceImplTest {
    private WebClient webClient;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        WebClientFactory wcf = new WebClientFactory();
        webClient = wcf.create();

        RestTemplateClientFactory rtcf = new RestTemplateClientFactory();
        restTemplate = rtcf.create();
    }

    @AfterEach
    void tearDown() {
        webClient = null;
        restTemplate = null;
    }

    @Test
    void test_getRoutes() {
        RoutesMbtaServiceImpl routesService = new RoutesMbtaServiceImpl();
        final List<Route> routeList = routesService.getRoutes();
        // Determine that the number of subway MBTA routes is 8
        assertEquals(8, routeList.size());
    }

    @Test
    void test_RestTemplateValidConnection() {

        final String baseUrl = "https://api-v3.mbta.com/routes?filter[type]=0,1";
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
}