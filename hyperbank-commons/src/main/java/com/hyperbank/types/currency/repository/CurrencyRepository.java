package com.hyperbank.types.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.types.currency.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
