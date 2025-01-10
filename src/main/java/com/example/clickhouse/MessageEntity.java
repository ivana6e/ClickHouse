package com.example.clickhouse;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "message")
@IdClass(MessageUPK.class)
public class MessageEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "user_service")
    @Enumerated(EnumType.STRING)
    private UserService userService;

    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Id
    @Column(name = "item_service")
    @Enumerated(EnumType.STRING)
    private ItemService itemService;

    @Id
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "time")
    private OffsetDateTime time;
}
