package com.sharpEdge.cards.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardRequest {
    private String front;
    private String back;
    private String username;
}
