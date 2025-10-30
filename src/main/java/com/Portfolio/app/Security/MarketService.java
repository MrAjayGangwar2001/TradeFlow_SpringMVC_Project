package com.Portfolio.app.Security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getQuote(String instrumentKey, String token) {

        String url = "https://api.upstox.com/v2/market/quotes?instrument_keys=" + instrumentKey + "&symbols=false";
        // String url = "https://api.upstox.com/v2/market/quote?instrument_key=" +
        // instrumentKey;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}