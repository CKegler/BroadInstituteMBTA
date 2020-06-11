package org.broadinstitute.mbta.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
/**
 * @author Colin Kegler
 * @version RestTemplate, the SpringBoot REST client, will be deprecated in future versions
 * of SpringBoot.  This RestTemplateClientFactory is used as a stub here.
 */
public class RestTemplateClientFactory extends MbtaFactory {

    @Override
    public RestTemplate create() {
        int timeout = 5000;

        return new RestTemplateBuilder()
                .rootUri(BASE_URL_MBTA_V3)
                .setConnectTimeout(timeout)
                .setReadTimeout(timeout)
                .build();
    }
}
