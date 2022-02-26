package com.sharpEdge.cards.service;

import com.sharpEdge.cards.dao.CardDao;
import com.sharpEdge.cards.dto.CardRequest;
import com.sharpEdge.cards.dto.CardResponse;
import com.sharpEdge.cards.model.Card;
import com.sharpEdge.clients.user.CustomerResponse;
import com.sharpEdge.clients.user.UserClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardService {
    private final CardDao cardDao;
    private final ModelMapper modelMapper;
    private final UserClient userClient;

    @Autowired
    public CardService(CardDao cardDao, ModelMapper modelMapper, UserClient userClient) {
        this.cardDao = cardDao;
        this.modelMapper = modelMapper;
        this.userClient = userClient;
    }

    public List<Card> getAllCards(){return this.cardDao.findAll();}

    public CardResponse getCard(long id){
        return modelMapper.map(this.cardDao.getById(id), CardResponse.class);
    }

    public CardResponse save(CardRequest cardRequest){
        Card card =  this.cardDao.save(modelMapper.map(cardRequest, Card.class));
        return modelMapper.map(card, CardResponse.class);
    }

    public CustomerResponse getCustomer(String username){
        return userClient.getCardOwner(username);
    }

}
