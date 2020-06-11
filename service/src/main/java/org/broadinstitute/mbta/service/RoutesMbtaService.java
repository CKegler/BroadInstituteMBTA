package org.broadinstitute.mbta.service;
/**
 * @author Colin Kegler
 * @verion The Service method specification to retrieve MBTA Routes
 */

import org.broadinstitute.mbta.core.Route;

import java.util.List;

public interface RoutesMbtaService {

    List<Route> getRoutes();
}
