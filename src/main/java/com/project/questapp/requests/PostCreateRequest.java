package com.project.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long id;
    String texts;
    String title;
    Long userId;
}
