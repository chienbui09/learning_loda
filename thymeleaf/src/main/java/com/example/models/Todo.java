package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Todo {
    private int id;
    private String title;
    private String detail;
}
