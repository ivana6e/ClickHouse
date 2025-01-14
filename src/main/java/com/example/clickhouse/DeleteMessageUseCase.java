package com.example.clickhouse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMessageUseCase {

    private final MessageJpaRepository messageJpaRepository;

    public void delete() {
        messageJpaRepository.delete();
    }
}
