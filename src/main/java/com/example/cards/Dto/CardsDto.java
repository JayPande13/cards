package com.example.cards.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Cards", description = "Details for Cards listed on Account")
public class CardsDto {

    @Schema(description = "Mobile Number Linked with the card",example = "7351733655")
    public String mobileNumber;

    @Schema(description = "Cards Number",example = "5548 5544 5548 7584")
    public String cardNumber;

    @Schema(description = "Type Of card",example = "Platinium, Rubyx etc")
    public String cardType;

    @Schema(description = "Amount used up from Card" , example = "65485")
    public int amountUsed;

    @Schema(description = "Total Limit in Card" , example = "80000")
    public int totalLimit;

    @Schema(description = "Available Balance in Card" , example = "14515")
    public int availableAmount;
}
