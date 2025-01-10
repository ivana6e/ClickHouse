package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Component
public class MessageJdbcRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String INSERT_SQL = """
		INSERT INTO message (user_id, user_service, item_id, item_service, message_id, time)
		 VALUES (:userId, :userService, :itemId, :itemService, :messageId, :time)""";
    public void insert(String userId, UserService userService, Long itemId, ItemService itemService, Long messageId, OffsetDateTime time) {
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("userService", userService.name())
                .addValue("itemId", itemId)
                .addValue("itemService", itemService.name())
                .addValue("messageId", messageId)
                .addValue("time", time);
        namedParameterJdbcTemplate.update(INSERT_SQL, params);
    }
}
