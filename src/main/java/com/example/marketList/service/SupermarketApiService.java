package com.example.marketList.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SupermarketApiService {

    private static final String API_URL = "https://api.supermarket.com/product"; // Exemplo de URL

    public Double getCurrentPrice(String productName) {
        // Fazer a chamada à API externa para pegar o preço atual
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?product=" + productName;
        ResponseEntity<SupermarketApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, SupermarketApiResponse.class);
        return response.getBody().getPrice();
    }
}
