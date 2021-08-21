package com.powerstation.dto;

import lombok.Data;

// DTO: data transfer object

@Data
public class LinkQuery {
    private Integer x;
    private Integer y;

    public LinkQuery() {
    }

    public LinkQuery(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
