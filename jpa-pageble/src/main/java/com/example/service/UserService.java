package com.example.service;

import com.example.entity.Nguoi;
import com.example.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    IUserRepository userRepository;

    public void findAll(){
        Page<Nguoi> page = userRepository.findAll(PageRequest.of(0, 5));
        while (true){
            System.out.println("total page:: " + page.getTotalPages());
            System.out.println("total element::" + page.getTotalElements());
            System.out.println("number:::" + page.getNumber());
            System.out.println("number:::" + page.getContent());
            System.out.println("number:::" + page.getSize());

            page.stream().iterator().forEachRemaining(System.out::println);
            if (!page.hasNext()){
                break;
            }
        }
    }
}
