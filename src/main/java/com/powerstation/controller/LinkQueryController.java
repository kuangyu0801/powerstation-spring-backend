package com.powerstation.controller;

import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;
import com.powerstation.service.LinkQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("api/link-query")
public class LinkQueryController {

    private LinkQueryService linkQueryService;

    @Autowired
    public LinkQueryController(LinkQueryService linkQueryService) {
        this.linkQueryService = linkQueryService;
    }

    @PostMapping("query")
    public LinkQueryResponse query(@RequestBody LinkQuery linkQuery) {
        return linkQueryService.findLink(linkQuery);
    }
}
