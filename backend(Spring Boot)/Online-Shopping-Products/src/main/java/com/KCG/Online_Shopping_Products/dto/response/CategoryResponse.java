package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse() {
    }

    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}