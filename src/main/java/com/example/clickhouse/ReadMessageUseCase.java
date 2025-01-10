package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadMessageUseCase {

    private final MessageJpaRepository messageJpaRepository;

    public List<MessageEntity> readAll() {
        return messageJpaRepository.findAll();
    }

    public List<MessageSelectViewEntity> readByUserIdAndUserService(String userId, UserService userService) {
        return messageJpaRepository.findByUserIdAndUserService(userId, userService.name());
    }
}
