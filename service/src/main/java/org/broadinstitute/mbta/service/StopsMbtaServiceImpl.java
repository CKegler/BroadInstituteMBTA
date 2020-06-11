package org.broadinstitute.mbta.service;

import org.broadinstitute.mbta.core.Stop;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StopsMbtaServiceImpl implements StopsMbtaService {
    private final WebClient webClient;

    public StopsMbtaServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Retrieve a list of Stops on the MBTA subway routes.
     *
     * @return a List<Stop> of MBTA stops or an empty list of size 0
     */
    public List<Stop> getStops() {
        // use Optional to prevent returning a null list.
        Optional<List<Stop>> results = Optional.empty();

        final List<Stop> finalResults = results.orElseGet(ArrayList::new);
        return finalResults;
    }
}
