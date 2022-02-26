package com.sharpEdge.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification extends Auditable{
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    private long id;
    private String message;
    private String sender;
    private String receiver;
}
