package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder = true)
@Component
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Nguoi")
public class Nguoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
