package com.adobe.panchtantra.entity;

import com.adobe.panchtantra.model.BookingModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="inventories_id")
    private Long inventoryId;

    @Column(name="users_id")
    private Long buyerId;
    
    @Column(name="num_seats")
    private Long noOfSeats;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private BookingModel.StatusEnum status;

    @Column(name="booked_at")
    private Date bookedAt;

    @Column(name="expires_at")
    private Date expiresAt;

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

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Long noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public BookingModel.StatusEnum  getStatus() {
        return status;
    }

    public void setStatus(BookingModel.StatusEnum  status) {
        this.status = status;
    }

    public Date getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Date bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
}
