package com.sharpEdge.cards.dao;

import com.sharpEdge.cards.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDao extends JpaRepository<Card, Long> {
}
