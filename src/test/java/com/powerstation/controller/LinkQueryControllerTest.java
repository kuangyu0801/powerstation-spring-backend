package com.powerstation.controller;

import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;
import com.powerstation.service.LinkQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LinkQueryController.class)
@ExtendWith(MockitoExtension.class)
public class LinkQueryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // Bean need to specify with mock
    @MockBean
    private LinkQueryService linkQueryService;

    @Test
    public void testResponse() throws Exception {
        LinkQueryResponse linkQueryResponse = new LinkQueryResponse();
        when(linkQueryService.findLink(any(LinkQuery.class))).thenReturn(linkQueryResponse);

        // call GET "/api/link-query/test" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/link-query/test")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{isLinkFound:false}"))
                .andReturn();
    }

    @Test
    public void queryResponse() throws Exception {
        when(linkQueryService.findLink(any(LinkQuery.class))).thenReturn(new LinkQueryResponse());
        LinkQuery linkQuery = new LinkQuery(1, 1);
        // call GET "/api/link-query/test" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/link-query/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"x\":1,\"y\":1}")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{isLinkFound:false}"))
                .andReturn();
        ArgumentCaptor<LinkQuery> captor = ArgumentCaptor.forClass(LinkQuery.class);

        // verify the service received exact query
        verify(linkQueryService).findLink(captor.capture());
        assertEquals(linkQuery, captor.getValue());

        // verify sure method from service is called once
        verify(linkQueryService, times(1)).findLink(any(LinkQuery.class));
    }

}
