package siso.project.etc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GeoCoder {
    public LatLng geoCoding(String location) {

        if (location == null)
            return null;

        Geocoder geocoder = new Geocoder();
        // setAddress : 변환하려는 주소 (경기도 성남시 분당구 등)
        // setLanguate : 인코딩 설정

        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(location).setLanguage("ko")
                .getGeocoderRequest();

        GeocodeResponse geocoderResponse;

        try {

            geocoderResponse = geocoder.geocode(geocoderRequest);
            if (geocoderResponse.getStatus() == GeocoderStatus.OK & !geocoderResponse.getResults().isEmpty()) {
                GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();
                LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
                return latitudeLongitude;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;

    }

}
