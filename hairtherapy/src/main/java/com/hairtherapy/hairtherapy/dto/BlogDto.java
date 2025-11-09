package com.hairtherapy.hairtherapy.dto;

import lombok.Data;

@Data
public class BlogDto {

    private String title;
    private String content;
    private int authorId;  // Admin or Stylist ID
}
