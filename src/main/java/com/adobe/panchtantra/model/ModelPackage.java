package com.adobe.panchtantra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ModelPackage
 */
@Validated
@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")




public class ModelPackage   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("noOfSeats")
  private Long noOfSeats = null;

  /**
   * Gets or Sets basis
   */
  public enum BasisEnum {
    MONTHLY("MONTHLY"),
    
    YEARLY("YEARLY");

    private String value;

    BasisEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BasisEnum fromValue(String text) {
      for (BasisEnum b : BasisEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("basis")
  private BasisEnum basis = null;

  @JsonProperty("pricing")
  private Double pricing = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("ACTIVE"),
    
    INACTIVE("INACTIVE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  public ModelPackage id(Long id) {
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

  public ModelPackage name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ModelPackage noOfSeats(Long noOfSeats) {
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

  public ModelPackage basis(BasisEnum basis) {
    this.basis = basis;
    return this;
  }

  /**
   * Get basis
   * @return basis
  **/
  @ApiModelProperty(value = "")


  public BasisEnum getBasis() {
    return basis;
  }

  public void setBasis(BasisEnum basis) {
    this.basis = basis;
  }

  public ModelPackage pricing(Double pricing) {
    this.pricing = pricing;
    return this;
  }

  /**
   * Get pricing
   * @return pricing
  **/
  @ApiModelProperty(value = "")


  public Double getPricing() {
    return pricing;
  }

  public void setPricing(Double pricing) {
    this.pricing = pricing;
  }

  public ModelPackage status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
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
    ModelPackage _package = (ModelPackage) o;
    return Objects.equals(this.id, _package.id) &&
        Objects.equals(this.name, _package.name) &&
        Objects.equals(this.noOfSeats, _package.noOfSeats) &&
        Objects.equals(this.basis, _package.basis) &&
        Objects.equals(this.pricing, _package.pricing) &&
        Objects.equals(this.status, _package.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, noOfSeats, basis, pricing, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelPackage {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    noOfSeats: ").append(toIndentedString(noOfSeats)).append("\n");
    sb.append("    basis: ").append(toIndentedString(basis)).append("\n");
    sb.append("    pricing: ").append(toIndentedString(pricing)).append("\n");
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

