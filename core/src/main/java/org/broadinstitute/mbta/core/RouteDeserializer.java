package org.broadinstitute.mbta.core;
/**
 * @author Colin Kegler
 * @verion
 * @see https://api-v3.mbta.com/docs/swagger/index.html#/Route
 * @link Route.java
 *
 *  RouteDeserializer is a custom deserializer transform JSON representations in a Route object, which
 *  models an MBTA route
 */
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class RouteDeserializer extends StdDeserializer<Route> {

    private static ObjectMapper routeMapper = new ObjectMapper();

    public RouteDeserializer() {
        this(null);
    }

    protected RouteDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Route deserialize(JsonParser jp,
                             DeserializationContext deserializationContext)
            throws IOException {

        final JsonNode dataNode = jp.getCodec().readTree(jp);

        return new Route(
                dataNode.get("id").asText(),
                dataNode.get("attributes").get("color").asText(),
                dataNode.get("attributes").get("description").asText(),
                routeMapper.convertValue(dataNode.get("attributes").get("direction_destinations"), String[].class),
                routeMapper.convertValue(dataNode.get("attributes").get("direction_names"), String[].class),
                dataNode.get("attributes").get("fare_class").asText(),
                dataNode.get("attributes").get("long_name").asText(),
                dataNode.get("attributes").get("short_name").asText(),
                dataNode.get("attributes").get("sort_order").asText(),
                dataNode.get("attributes").get("type").asInt()
        );

    }
}