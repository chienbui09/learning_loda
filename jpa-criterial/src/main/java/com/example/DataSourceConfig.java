package com.example;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {
    // inject bởi RequiredArgsConstructor
    private final IUserRepository userRepository;

    @PostConstruct
    public void initData() {
        // Insert 100 User vào H2 Database sau khi
        // DatasourceConfig được khởi tạo
        final Random r = new Random();
        userRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> User.builder()
                        .name("name-" + i)
                        .type(r.nextDouble() >= 0.5 ? User.UserType.VIP : User.UserType.NORMAL)
                        .build())
                .collect(Collectors.toList())
        );
    }
}