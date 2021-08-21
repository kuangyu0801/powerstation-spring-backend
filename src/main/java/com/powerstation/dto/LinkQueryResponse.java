package com.powerstation.dto;

import lombok.Data;

@Data
public class LinkQueryResponse {
    private Integer xQuery;
    private Integer yQuery;
    private Integer xStation;
    private Integer yStation;
    private Double power;
    private Boolean isLinkFound;

    public LinkQueryResponse() {
        isLinkFound = false;
    }
}
