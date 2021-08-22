package com.powerstation.controller;

import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;
import com.powerstation.service.LinkQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:4200/", "http://frontend:4200/"})
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
        log.info("Received a query request x: {}, y: {}", linkQuery.getX(), linkQuery.getY());
        return linkQueryService.findLink(linkQuery);
    }

    @GetMapping("/test")
    public LinkQueryResponse test() {
        log.info("Received a test request");
        return new LinkQueryResponse();
    }
}
