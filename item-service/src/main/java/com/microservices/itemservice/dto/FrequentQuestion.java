package com.microservices.itemservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FrequentQuestion {
    private String question;
    private String answer;
}
