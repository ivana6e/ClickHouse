package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final CreateMessageUseCase createMessageUseCase;
    private final ReadMessageUseCase readMessageUseCase;
    private final DeleteMessageUseCase deleteMessageUseCase;

    @PostMapping("/insert")
    public ResponseEntity<?> insertMessage(@RequestBody CreateMessageRequest request) {
        return createMessageUseCase.insert(request);
    }

    @GetMapping("/read")
    public List<MessageEntity> readAllMessage() {
        return readMessageUseCase.readAll();
    }

    @GetMapping("/read/{userId}/{userService}")
    public List<MessageSelectViewEntity> readOneUMessage(@PathVariable String userId, @PathVariable UserService userService) {
        return readMessageUseCase.readByUserIdAndUserService(userId, userService);
    }

    @DeleteMapping("/delete")
    public void deleteMessage() {
        deleteMessageUseCase.delete();
    }

}
