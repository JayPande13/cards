package com.example.cards.Controller;

import com.example.cards.Contants.CardConstants;
import com.example.cards.Dto.CardsDto;
import com.example.cards.Dto.ErrorResponseDto;
import com.example.cards.Dto.ResponseDto;
import com.example.cards.Services.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/cards/")
@AllArgsConstructor
@Tag(name = "Cards Controller",
        description = "All APIs for Cards Creation,Upgrading and Deletion"
)

public class CardsController {

    private ICardsService cardsService;

    @Operation(
            description = "Create Card API",
            summary = "This API helps to create new Card"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Card Has been Created"
    )
    @PostMapping("create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber) {
        cardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));

    }

    @Operation(
            description = "Update Card API",
            summary = "This API helps to update old Card"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Card Has been Updated"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Card update failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @PostMapping("update")
    public ResponseEntity<ResponseDto> updateCard(@RequestBody CardsDto cardsDto) {
        Boolean isUpdated = false;
        isUpdated = cardsService.updateCard(cardsDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_UPDATE));

        }

    }

    @Operation(
            description = "Get Card API",
            summary = "This API helps to find old Card on the basic of Mobile Number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Card Has been found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @GetMapping("get")
    public ResponseEntity<CardsDto> getCard(@RequestParam String mobileNumber) {
        CardsDto cardsDto = cardsService.getCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.FOUND).body(cardsDto);
    }

    @Operation(
            description = "Update Card API",
            summary = "This API helps to update old Card"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Card Has been Updated"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Card update failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })

    @DeleteMapping("delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam String mobileNumber) {
        Boolean isUpdated = false;
        isUpdated = cardsService.deleteCard(mobileNumber);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_DELETE));

        }

    }
}
