package com.example.cards.Dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "cards")
public record CardsApplicationFetchingDto(String message, Map<String,String> contactDetails, List<String> support) {
}
