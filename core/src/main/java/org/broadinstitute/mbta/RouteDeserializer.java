package org.broadinstitute.mbta;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class RouteDeserializer extends StdDeserializer<Route> {

    public RouteDeserializer(){
        this(null);
    }

    protected RouteDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Route deserialize(JsonParser jp,
                             DeserializationContext deserializationContext)
            throws IOException {

        final JsonNode routeNode = jp.getCodec().readTree(jp);
        final JsonNode dataNode = routeNode.get("data");
        return new Route(
                dataNode.get("id").asText(),
                dataNode.get("attributes").get("color").asText(),
                dataNode.get("attributes").get("description").asText(),
                dataNode.get("attributes").withArray("direction_destinations").asText().split(","),
                dataNode.get("attributes").withArray("direction_names").asText().split(","),
                dataNode.get("attributes").get("fare_class").asText(),
                dataNode.get("attributes").get("long_name").asText(),
                dataNode.get("attributes").get("short_name").asText(),
                dataNode.get("attributes").get("sort_order").asText(),
                dataNode.get("attributes").get("type").asInt()
        );

    }
}
