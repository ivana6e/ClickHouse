package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMessageUseCase {

    private final MessageJpaRepository messageJpaRepository;

    public void deleteByUserIdAndUserService(String userId, UserService userService) {
        messageJpaRepository.deleteByUserIdAndUserService(userId, userService.name());
    }
}
