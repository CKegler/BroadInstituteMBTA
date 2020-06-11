package org.broadinstitute.mbta.service;
/**
 * @author Colin Kegler
 * @verion The Service method specification to retrieve MBTA Stops
 */

import org.broadinstitute.mbta.core.Stop;

import java.util.List;

public interface StopsMbtaService {

    List<Stop> getStops();
}
