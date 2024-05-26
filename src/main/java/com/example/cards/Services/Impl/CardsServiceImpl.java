package com.example.cards.Services.Impl;

import com.example.cards.Contants.CardConstants;
import com.example.cards.Dto.CardsDto;
import com.example.cards.Entities.Cards;
import com.example.cards.Exception.CardAlreadyExistsException;
import com.example.cards.Exception.ResourceNotFoundException;
import com.example.cards.Mapper.CardsMapper;
import com.example.cards.Repository.CardsRepository;
import com.example.cards.Services.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;


    /**
     * create card
     *
     * @param mobileNumber mobileNumber
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> foundEntity = cardsRepository.findByMobileNumber(mobileNumber);
        if (foundEntity.isPresent()) {
            throw new CardAlreadyExistsException("Cards with this mobile number already exists : " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }


    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return newCard;

    }

    /**
     * update card
     *
     * @param cardsDto cardsDto
     * @return {@link Boolean}
     * @see Boolean
     */
    @Override
    public Boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(() -> new ResourceNotFoundException("Card", "Mobile Number", cardsDto.getCardNumber()));
        CardsMapper.cardsDtoToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    /**
     * get card
     *
     * @param mobileNumber mobileNumber
     * @return {@link CardsDto}
     * @see CardsDto
     */
    @Override
    public CardsDto getCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber));
        return CardsMapper.cardsEntityToDto(cards,new CardsDto());
    }

    /**
     * delete card
     *
     * @param mobileNumber mobileNumber
     * @return {@link Boolean}
     * @see Boolean
     */
    @Override
    public Boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("Card","Mobile Number", mobileNumber));
        cardsRepository.delete(cards);
        return true;
    }


}
