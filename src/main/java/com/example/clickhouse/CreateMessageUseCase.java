package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateMessageUseCase {

    private final MessageJdbcRepository messageJdbcRepository;

    public ResponseEntity<?> insert(CreateMessageRequest request) {
        var msg = new MessageEntity();
        msg.setUserId(request.getUserId());
        msg.setUserService(request.getUserService());
        msg.setItemId(request.getItemId());
        msg.setItemService(request.getItemService());
        msg.setMessageId(request.getMessageId());
        msg.setTime(request.getTime());

        log.info("insert msg: {}", msg);
        messageJdbcRepository.insert(
                msg.getUserId(), msg.getUserService(), msg.getItemId(), msg.getItemService(), msg.getMessageId(), msg.getTime());
        return ResponseEntity.ok(msg);
    }
}
