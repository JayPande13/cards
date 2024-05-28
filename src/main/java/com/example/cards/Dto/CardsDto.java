package com.example.cards.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Cards", description = "Details for Cards listed on Account")
public class CardsDto {

    @Schema(description = "Mobile Number Linked with the card",example = "7351733655")
    @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must be 10 digits")
    public String mobileNumber;

    @Schema(description = "Cards Number",example = "5548 5544 5548 7584")
    @NotEmpty(message = "Card Number Cannot be Empty")
    public String cardNumber;

    @Schema(description = "Type Of card",example = "Platinium, Rubyx etc")
    @NotEmpty(message = "Card Type Cannot be Empty")
    public String cardType;

    @Schema(description = "Amount used up from Card" , example = "65485")
    @NotEmpty(message = "Amount used Cannot be Empty")
    public int amountUsed;

    @Schema(description = "Total Limit in Card" , example = "80000")
    @NotEmpty(message = "Total Limit Cannot be Empty")
    public int totalLimit;

    @Schema(description = "Available Balance in Card" , example = "14515")
    @NotEmpty(message = "Available Amount Cannot be Empty")
    public int availableAmount;
}
