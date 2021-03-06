package com.powerstation.dao;

import com.powerstation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
public interface StationRepository extends JpaRepository<Station, Integer> {
}
