package com.adobe.panchtantra.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="num_seats")
    private Long noOfSeats;

    @Column(name="status")
    private String status;

    @Column(name="starts_at")
    private Date startsAt;

    @Column(name="expires_at")
    private Date expiresAt;

    @Column(name="users_id")
    private String sellerId;

    @Column(name="packages_otts_id")
    private String packageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
}
