package com.example.clickhouse;

import java.io.Serializable;

public class MessageUPK implements Serializable {

    private String userId;
    private UserService userService;
    private Long itemId;
    private ItemService itemService;
    private Long messageId;
}
