package com.example.cards.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // By default @data doesn't have @AllArgsConstructor
@Schema(name = "Response", description = "Status Response of APIs")
public class ResponseDto {


    private String statusCode; // 200,500,etc

    private String statusMessage;
}
