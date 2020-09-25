package com.adobe.panchtantra.entity;

import com.adobe.panchtantra.model.InventoryModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="inventories")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="num_seats")
    private Long noOfSeats;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private InventoryModel.StatusEnum status;
    
    @Column(name="ott_user_name")
    private String ottUserName;

    @Column(name="ott_password")
    private String ottPassword;
    
    @Column(name="starts_at")
    private Date startsAt;

    @Column(name="expires_at")
    private Date expiresAt;

    @Column(name="users_id")
    private String sellerId;

    @Column(name="packages_otts_id")
    private String packageId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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

    public InventoryModel.StatusEnum getStatus() {
        return status;
    }

    public void setStatus(InventoryModel.StatusEnum status) {
        this.status = status;
    }

    public String getOttUserName() {
        return ottUserName;
    }

    public void setOttUserName(String ottUserName) {
        this.ottUserName = ottUserName;
    }

    public String getOttPassword() {
        return ottPassword;
    }

    public void setOttPassword(String ottPassword) {
        this.ottPassword = ottPassword;
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
