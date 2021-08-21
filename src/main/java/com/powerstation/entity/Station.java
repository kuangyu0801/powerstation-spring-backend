package com.powerstation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="station")
@Data
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @Column(name = "reach")
    private Integer reach;

    public Station() {
    }

    public Station(Integer id, Integer x, Integer y, Integer reach) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.reach = reach;
    }
}
