package com.ella.studium.emissions.Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Emission implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(length = 10)
    private Integer phoneCountryCode;

    @Column(length = 100)
    private String countryName;

    @Column
    private Date updatedAt;

    @Column(nullable = true)
    private Integer emissionInMegaTons;

    public Emission() {};

    public Emission(
        Integer phoneCountryCode,
        String countryName,
        Date updatedAt,
        Integer emissionInMegaTons
    ) {
        this.phoneCountryCode = phoneCountryCode;
        this.countryName = countryName;
        this.updatedAt = updatedAt;
        this.emissionInMegaTons = emissionInMegaTons;
    }

    @PrePersist
    public void setInitialDate() {
        if (updatedAt == null) {
            updatedAt = new Date();
        }
    }

    @PreUpdate
    public void touchUpdatedAt() {
        updatedAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(Integer phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getEmissionInMegaTons() {
        return emissionInMegaTons;
    }

    public void setEmissionInMegaTons(Integer emissionInMegaTons) {
        this.emissionInMegaTons = emissionInMegaTons;
    }
}
