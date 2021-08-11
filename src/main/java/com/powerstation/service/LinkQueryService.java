package com.powerstation.service;

import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;

public interface LinkQueryService {
    LinkQueryResponse findLink(LinkQuery linkQuery);
}
