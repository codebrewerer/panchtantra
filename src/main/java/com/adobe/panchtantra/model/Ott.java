package com.adobe.panchtantra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Ott
 */
@Validated
@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")




public class Ott   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("ottName")
  private String ottName = null;

  @JsonProperty("status")
  private Object status = null;

  public Ott id(Long id) {
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

  public Ott ottName(String ottName) {
    this.ottName = ottName;
    return this;
  }

  /**
   * Get ottName
   * @return ottName
  **/
  @ApiModelProperty(value = "")


  public String getOttName() {
    return ottName;
  }

  public void setOttName(String ottName) {
    this.ottName = ottName;
  }

  public Ott status(Object status) {
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
    Ott ott = (Ott) o;
    return Objects.equals(this.id, ott.id) &&
        Objects.equals(this.ottName, ott.ottName) &&
        Objects.equals(this.status, ott.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, ottName, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ott {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    ottName: ").append(toIndentedString(ottName)).append("\n");
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

