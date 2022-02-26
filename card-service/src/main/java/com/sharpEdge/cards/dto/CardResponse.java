package com.sharpEdge.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.Format;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    private long id;
    private String front;
    private String back;
    private String username;
    private long created;
    private long modified;
}
