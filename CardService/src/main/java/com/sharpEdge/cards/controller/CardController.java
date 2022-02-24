package com.sharpEdge.cards.controller;

import com.sharpEdge.cards.dto.CardRequest;
import com.sharpEdge.cards.dto.CardResponse;
import com.sharpEdge.cards.model.Card;
import com.sharpEdge.cards.service.CardService;
import com.sharpEdge.clients.user.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/card")
@Transactional
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }
    @GetMapping("{id}")
    public CardResponse getCard(@PathVariable("id") long id){
        return cardService.getCard(id);
    }

    @PostMapping
    public RedirectView createCard(@RequestBody CardRequest cardRequest){
        CardResponse response = cardService.save(cardRequest);
        return new RedirectView("/api/v1/card/"+response.getId());
    }

    @GetMapping("{id}/user")
    public CustomerResponse getCardOwner(@PathVariable("id") long id){
        CardResponse cardResponse = cardService.getCard(id);
        System.out.println(cardResponse.getUsername());
        CustomerResponse customerResponse = cardService.getCustomer(cardResponse.getUsername());
//        CustomerResponse customerResponse = restTemplate.getForObject(
//                "http://USERSERVICE:8080/api/v1/user/{username}",
//                CustomerResponse.class,
//                cardResponse.getUsername()
//        );
        return customerResponse;
    }
}
