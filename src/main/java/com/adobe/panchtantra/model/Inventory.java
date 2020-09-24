package com.adobe.panchtantra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Inventory
 */
@Validated
@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")




public class Inventory   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("package")
  private ModelPackage _package = null;

  @JsonProperty("seller")
  private User seller = null;

  @JsonProperty("ottUsername")
  private String ottUsername = null;

  @JsonProperty("ottPassword")
  private String ottPassword = null;

  @JsonProperty("noOfSeats")
  private Long noOfSeats = null;

  @JsonProperty("booking")
  private Bookings booking = null;

  @JsonProperty("status")
  private Object status = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("createdDateAt")
  private LocalDate createdDateAt = null;

  @JsonProperty("updatedDateAt")
  private LocalDate updatedDateAt = null;

  public Inventory id(Long id) {
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

  public Inventory _package(ModelPackage _package) {
    this._package = _package;
    return this;
  }

  /**
   * Get _package
   * @return _package
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ModelPackage getPackage() {
    return _package;
  }

  public void setPackage(ModelPackage _package) {
    this._package = _package;
  }

  public Inventory seller(User seller) {
    this.seller = seller;
    return this;
  }

  /**
   * Get seller
   * @return seller
  **/
  @ApiModelProperty(value = "")

  @Valid

  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  public Inventory ottUsername(String ottUsername) {
    this.ottUsername = ottUsername;
    return this;
  }

  /**
   * Get ottUsername
   * @return ottUsername
  **/
  @ApiModelProperty(value = "")


  public String getOttUsername() {
    return ottUsername;
  }

  public void setOttUsername(String ottUsername) {
    this.ottUsername = ottUsername;
  }

  public Inventory ottPassword(String ottPassword) {
    this.ottPassword = ottPassword;
    return this;
  }

  /**
   * Get ottPassword
   * @return ottPassword
  **/
  @ApiModelProperty(value = "")


  public String getOttPassword() {
    return ottPassword;
  }

  public void setOttPassword(String ottPassword) {
    this.ottPassword = ottPassword;
  }

  public Inventory noOfSeats(Long noOfSeats) {
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

  public Inventory booking(Bookings booking) {
    this.booking = booking;
    return this;
  }

  /**
   * Get booking
   * @return booking
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Bookings getBooking() {
    return booking;
  }

  public void setBooking(Bookings booking) {
    this.booking = booking;
  }

  public Inventory status(Object status) {
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

  public Inventory startDate(LocalDate startDate) {
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

  public Inventory endDate(LocalDate endDate) {
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

  public Inventory createdDateAt(LocalDate createdDateAt) {
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

  public Inventory updatedDateAt(LocalDate updatedDateAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inventory inventory = (Inventory) o;
    return Objects.equals(this.id, inventory.id) &&
        Objects.equals(this._package, inventory._package) &&
        Objects.equals(this.seller, inventory.seller) &&
        Objects.equals(this.ottUsername, inventory.ottUsername) &&
        Objects.equals(this.ottPassword, inventory.ottPassword) &&
        Objects.equals(this.noOfSeats, inventory.noOfSeats) &&
        Objects.equals(this.booking, inventory.booking) &&
        Objects.equals(this.status, inventory.status) &&
        Objects.equals(this.startDate, inventory.startDate) &&
        Objects.equals(this.endDate, inventory.endDate) &&
        Objects.equals(this.createdDateAt, inventory.createdDateAt) &&
        Objects.equals(this.updatedDateAt, inventory.updatedDateAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _package, seller, ottUsername, ottPassword, noOfSeats, booking, status, startDate, endDate, createdDateAt, updatedDateAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inventory {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _package: ").append(toIndentedString(_package)).append("\n");
    sb.append("    seller: ").append(toIndentedString(seller)).append("\n");
    sb.append("    ottUsername: ").append(toIndentedString(ottUsername)).append("\n");
    sb.append("    ottPassword: ").append(toIndentedString(ottPassword)).append("\n");
    sb.append("    noOfSeats: ").append(toIndentedString(noOfSeats)).append("\n");
    sb.append("    booking: ").append(toIndentedString(booking)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    createdDateAt: ").append(toIndentedString(createdDateAt)).append("\n");
    sb.append("    updatedDateAt: ").append(toIndentedString(updatedDateAt)).append("\n");
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

