package com.example.cards.Services;

import com.example.cards.Dto.CardsDto;

public interface ICardsService {


    /**
     * create card
     *
     * @param mobileNumber mobileNumber
     */
    public void createCard(String mobileNumber);

    /**
     * update card
     *
     * @param cardsDto cardsDto
     * @return {@link Boolean}
     * @see Boolean
     */
    public Boolean updateCard(CardsDto cardsDto);

    /**
     * get card
     *
     * @param mobileNumber mobileNumber
     * @return {@link CardsDto}
     * @see CardsDto
     */
    public CardsDto getCard(String mobileNumber);


    /**
     * delete card
     *
     * @param mobileNumber mobileNumber
     * @return {@link Boolean}
     * @see Boolean
     */
    public Boolean deleteCard(String mobileNumber);
}
