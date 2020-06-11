package org.broadinstitute.mbta.service;

import org.broadinstitute.mbta.core.Route;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoutesMbtaServiceImpl implements RoutesMbtaService {
    private final WebClient webClient;

    public RoutesMbtaServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Retrieve a list of the routes on the MBTA subway
     *
     * @return a List<Route> or an empty list of size 0
     */
    public List<Route> getRoutes() {
        // use Optional to prevent returning a null list.
        Optional<List<Route>> results = Optional.empty();

        final List<Route> finalResults = results.orElseGet(ArrayList::new);
        return finalResults;
    }
}
