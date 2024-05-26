package com.example.cards.Repository;

import com.example.cards.Entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
    public Optional<Cards> findByMobileNumber(String mobileNumber);
    public Optional<Cards> findByCardNumber(String cardNumber);
}
