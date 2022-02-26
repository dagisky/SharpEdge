package com.sharpEdge.cards.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card extends Auditable{
    @Id
    @SequenceGenerator(
            name = "card_id_sequence",
            sequenceName = "card_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_sequence")
    private long id;
    private String front;
    @Lob
    private String back;
    private String username;
}
