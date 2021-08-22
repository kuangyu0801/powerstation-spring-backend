package com.powerstation.service;

import com.powerstation.dao.StationRepository;
import com.powerstation.dto.LinkQuery;
import com.powerstation.dto.LinkQueryResponse;
import com.powerstation.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class LinkQueryServiceImpl implements LinkQueryService {
    private StationRepository stationRepository;

    // need to inject station repository
    @Autowired
    public LinkQueryServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    @Transactional
    public LinkQueryResponse findLink(LinkQuery linkQuery) {
        List<Station> list = stationRepository.findAll();
        double maxPower = 0;
        int x = linkQuery.getX();
        int y = linkQuery.getY();
        LinkQueryResponse response = new LinkQueryResponse();
        response.setIsLinkFound(false);
        response.setXQuery(x);
        response.setYQuery(y);

        for (Station station : list) {
            int xStation = station.getX();
            int yStation = station.getY();
            double reach = station.getReach();
            double distance = calDistance(x, xStation, y, yStation);
            double curPower = (distance > reach) ? 0 : Math.pow(reach - distance, 2);
            if (curPower > maxPower) {
                maxPower = curPower;
                response.setPower(curPower);
                response.setIsLinkFound(true);
                response.setXStation(xStation);
                response.setYStation(yStation);
            }
        }
        return response;
    }

    public double calDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
