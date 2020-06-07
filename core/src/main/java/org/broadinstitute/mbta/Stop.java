package org.broadinstitute.mbta;

public class Stop {

    private final String id;
    private final String municipality; // "Cambridge"
    private final String name; //"Alewife"
    private final String address;
        //	"Alewife Brook Pkwy and Cambridge Park Dr, Cambridge, MA 02140"

    private final double latitude; //	42.395428
    private final double longitude; // -71.142483
    private final String location_type; // 1
    private final String route; // e.g. Red, Blue

    public Stop(String id,
                String municipality,
                String name,
                String address,
                double latitude,
                double longitude,
                String location_type,
                String route) {
        this.id = id;
        this.municipality = municipality;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_type = location_type;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLocation_type() {
        return location_type;
    }

    public String getRoute() {
        return route;
    }
}
