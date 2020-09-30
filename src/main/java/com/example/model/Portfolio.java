package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "portfolios")
public class Portfolio implements Serializable {

    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int stockId;
    private long quantity;
}
