package com.powerstation.service;

import com.powerstation.dao.StationRepository;
import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;
import com.powerstation.entity.Station;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// JUnit5 annotation
@ExtendWith(MockitoExtension.class)
public class LinkQueryServiceImplTest {

    @Mock
    private StationRepository stationRepository;

    // Mockito will automatically inject dependency
    @InjectMocks
    private LinkQueryServiceImpl LinkQueryServiceImpl;// = new LinkQueryServiceImpl(stationRepository);

    // JUnit5 only have beforeAll which require static, which is not suitable
    private void init() {
        Station[] stations = new Station[]{
                new Station(1,0,0,10),
                new Station(2,20,20,5),
                new Station(3, 10, 0, 12)};
        List<Station> list = Arrays.asList(stations);
        when(stationRepository.findAll()).thenReturn(list);
    }

    @Test
    public void linkFound() {
        init();
        LinkQuery linkQuery = new LinkQuery(1, 1);
        LinkQueryResponse linkQueryResponse = LinkQueryServiceImpl.findLink(linkQuery);
        assertEquals(true, linkQueryResponse.getIsLinkFound());
        assertEquals(0, linkQueryResponse.getXStation());
        assertEquals(0, linkQueryResponse.getYStation());
    }

    @Test
    public void linkNotFound() {
        init();
        LinkQuery linkQuery = new LinkQuery(100, 100);
        LinkQueryResponse linkQueryResponse = LinkQueryServiceImpl.findLink(linkQuery);
        assertEquals(false, linkQueryResponse.getIsLinkFound());
    }
}
