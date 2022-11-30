package br.com.alura.escolaalura.javamongo.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;

import br.com.alura.escolaalura.javamongo.models.Contato;

@Service
public class GeolocalizacaoService {

    public List<Double> obterLatELongPor(Contato contato) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext().setApiKey("API_KEY");
        GeocodingApiRequest request = GeocodingApi.newRequest(context).address(contato.getEndereco());

        GeocodingResult[] results = request.await();
        GeocodingResult resultado = results[0];

        Geometry geometry = resultado.geometry;
        LatLng location = geometry.location;

        return Arrays.asList(location.lat, location.lng);
    }

}