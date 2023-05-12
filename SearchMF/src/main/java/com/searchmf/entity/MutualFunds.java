package com.searchmf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 
@Entity
@Table(name="mutual_funds")
public class MutualFunds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_id")
    private Long schemaId;
    private String fundHouse;
    private String symbol;
    private String schemaName;
    private String schemaCategory;
    private String description;
    private Double currentPrice;
    private Double delta;

    public MutualFunds() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MutualFunds(String fundHouse, String symbol, String schemaName, String schemaCategory, String description,
            Double currentPrice, Double delta) {
        super();
        this.fundHouse = fundHouse;
        this.symbol = symbol;
        this.schemaName = schemaName;
        this.schemaCategory = schemaCategory;
        this.description = description;
        this.currentPrice = currentPrice;
        this.delta = delta;
    }

 


    public MutualFunds(Long schemaId, String fundHouse, String symbol, String schemaName, String schemaCategory,
            String description, Double currentPrice, Double delta) {
        super();
        this.schemaId = schemaId;
        this.fundHouse = fundHouse;
        this.symbol = symbol;
        this.schemaName = schemaName;
        this.schemaCategory = schemaCategory;
        this.description = description;
        this.currentPrice = currentPrice;
        this.delta = delta;
    }

 

    public Long getSchemaId() {
        return schemaId;
    }

 

    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

 

    public String getFundHouse() {
        return fundHouse;
    }

 

    public void setFundHouse(String fundHouse) {
        this.fundHouse = fundHouse;
    }

 

    public String getSymbol() {
        return symbol;
    }

 

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

 

    public String getSchemaName() {
        return schemaName;
    }

 

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

 

    public String getSchemaCategory() {
        return schemaCategory;
    }

 

    public void setSchemaCategory(String schemaCategory) {
        this.schemaCategory = schemaCategory;
    }

 

    public String getDescription() {
        return description;
    }

 

    public void setDescription(String description) {
        this.description = description;
    }

 

    public Double getCurrentPrice() {
        return currentPrice;
    }

 

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

 

    public Double getDelta() {
        return delta;
    }

 

    public void setDelta(Double delta) {
        this.delta = delta;
    }

 

    @Override
    public String toString() {
        return "MutualFunds [schemaId=" + schemaId + ", fundHouse=" + fundHouse + ", symbol=" + symbol + ", schemaName="
                + schemaName + ", schemaCategory=" + schemaCategory + ", description=" + description + ", currentPrice="
                + currentPrice + ", delta=" + delta + "]";
    }


}