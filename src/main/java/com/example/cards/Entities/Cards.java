package com.example.cards.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    public Long cardsId;

    @Column(name = "mobile_number")
    public String mobileNumber;

    @Column(name = "card_number")
    public String cardNumber;

    @Column(name = "card_type")
    public String cardType;

    @Column(name = "amount_used")
    public int amountUsed;

    @Column(name = "total_limit")
    public int totalLimit;

    @Column(name = "available_amount")
    public int availableAmount;

}
