package com.example.configuration;

import com.example.entity.Nguoi;
import com.example.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
@AllArgsConstructor
public class DataSourceConfig {
    private IUserRepository userRepository;

    @PostConstruct
    public void initData(){
        userRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> Nguoi.builder()
                        .name("name-" + i)
                        .build())
                .collect(Collectors.toList())
        );
    }
}
