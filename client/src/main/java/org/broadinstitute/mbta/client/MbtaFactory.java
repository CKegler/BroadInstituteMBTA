package org.broadinstitute.mbta.client;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Colin Kegler
 * @verion
 *
 *  MBTA Service is the root interface for the "client" classes which implement it.
 *  MBTAService is essentially the root or beginning of the Factory method for Rest clients.
 */
public abstract class MbtaFactory {

    public static String BASE_URL_MBTA_V3 = "https://api-v3.mbta.com";
    public static String API_KEY = "4aed9e7edb924d52bccd040e10f783a7";

    public abstract Object create();
}
