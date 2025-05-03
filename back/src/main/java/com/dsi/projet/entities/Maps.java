package com.dsi.projet.entities;

import java.util.ArrayList;
import java.util.List;

public class Maps  {
    private String display_name;  // Le nom du lieu (par exemple : "Paris, France")
    private Double lat;           // Latitude
    private Double lon;           // Longitude

    public Maps(String display_name, Double lat, Double lon) {
        this.display_name = display_name;
        this.lat = lat;
        this.lon = lon;
    }

    public Maps() {
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}