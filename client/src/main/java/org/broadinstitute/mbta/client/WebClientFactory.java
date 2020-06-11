package org.broadinstitute.mbta.client;
/**
 * @author Colin Kegler
 * @version
 *
 * The WebClient is a modern, alternative HTTP client to RestTemplate.
 * Not only does it provide a traditional synchronous API, but it also supports
 * an efficient non-blocking and asynchronous approach.
 * RestTemplate will be deprecated in future versions.
 */
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

public class WebClientFactory extends MbtaFactory{

    public WebClient create() {
        return  WebClient
                .builder()
                .baseUrl(BASE_URL_MBTA_V3)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", BASE_URL_MBTA_V3))
                .build();
    }
}
