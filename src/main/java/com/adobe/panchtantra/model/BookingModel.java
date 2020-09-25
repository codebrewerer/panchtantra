package com.adobe.panchtantra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * BookingModel
 */
@Validated
@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")




public class BookingModel {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("inventory")
  private InventoryModel inventory = null;

  @JsonProperty("buyer")
  private UserModel buyer = null;

  @JsonProperty("noOfSeats")
  private Long noOfSeats = null;

  @JsonProperty("link")
  private String link = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("createdDateAt")
  private LocalDate createdDateAt = null;

  @JsonProperty("updatedDateAt")
  private LocalDate updatedDateAt = null;

  @JsonProperty("status")
  private Object status = null;

  public BookingModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BookingModel inventory(InventoryModel inventory) {
    this.inventory = inventory;
    return this;
  }

  /**
   * Get inventory
   * @return inventory
  **/
  @ApiModelProperty(value = "")

  @Valid

  public InventoryModel getInventory() {
    return inventory;
  }

  public void setInventory(InventoryModel inventory) {
    this.inventory = inventory;
  }

  public BookingModel buyer(UserModel buyer) {
    this.buyer = buyer;
    return this;
  }

  /**
   * Get buyer
   * @return buyer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserModel getBuyer() {
    return buyer;
  }

  public void setBuyer(UserModel buyer) {
    this.buyer = buyer;
  }

  public BookingModel noOfSeats(Long noOfSeats) {
    this.noOfSeats = noOfSeats;
    return this;
  }

  /**
   * Get noOfSeats
   * @return noOfSeats
  **/
  @ApiModelProperty(value = "")


  public Long getNoOfSeats() {
    return noOfSeats;
  }

  public void setNoOfSeats(Long noOfSeats) {
    this.noOfSeats = noOfSeats;
  }

  public BookingModel link(String link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   * @return link
  **/
  @ApiModelProperty(value = "")


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public BookingModel startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public BookingModel endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public BookingModel createdDateAt(LocalDate createdDateAt) {
    this.createdDateAt = createdDateAt;
    return this;
  }

  /**
   * Get createdDateAt
   * @return createdDateAt
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getCreatedDateAt() {
    return createdDateAt;
  }

  public void setCreatedDateAt(LocalDate createdDateAt) {
    this.createdDateAt = createdDateAt;
  }

  public BookingModel updatedDateAt(LocalDate updatedDateAt) {
    this.updatedDateAt = updatedDateAt;
    return this;
  }

  /**
   * Get updatedDateAt
   * @return updatedDateAt
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getUpdatedDateAt() {
    return updatedDateAt;
  }

  public void setUpdatedDateAt(LocalDate updatedDateAt) {
    this.updatedDateAt = updatedDateAt;
  }

  public BookingModel status(Object status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public Object getStatus() {
    return status;
  }

  public void setStatus(Object status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingModel booking = (BookingModel) o;
    return Objects.equals(this.id, booking.id) &&
        Objects.equals(this.inventory, booking.inventory) &&
        Objects.equals(this.buyer, booking.buyer) &&
        Objects.equals(this.noOfSeats, booking.noOfSeats) &&
        Objects.equals(this.link, booking.link) &&
        Objects.equals(this.startDate, booking.startDate) &&
        Objects.equals(this.endDate, booking.endDate) &&
        Objects.equals(this.createdDateAt, booking.createdDateAt) &&
        Objects.equals(this.updatedDateAt, booking.updatedDateAt) &&
        Objects.equals(this.status, booking.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, inventory, buyer, noOfSeats, link, startDate, endDate, createdDateAt, updatedDateAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    inventory: ").append(toIndentedString(inventory)).append("\n");
    sb.append("    buyer: ").append(toIndentedString(buyer)).append("\n");
    sb.append("    noOfSeats: ").append(toIndentedString(noOfSeats)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    createdDateAt: ").append(toIndentedString(createdDateAt)).append("\n");
    sb.append("    updatedDateAt: ").append(toIndentedString(updatedDateAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

