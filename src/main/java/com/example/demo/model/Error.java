package com.example.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

/**
 * Fejl
 */
public class Error {
  @JsonProperty("type")
  private String type;

  @JsonProperty("kode")
  private String kode;

  @JsonProperty("besked")
  private String besked;

  @JsonProperty("data")
  private String data;

  @JsonProperty("status")
  private String status;

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Error kode(String kode) {
    this.kode = kode;
    return this;
  }

  /**
   * Fejlkode
   * @return kode
  */
  @NotNull


  public String getKode() {
    return kode;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public Error besked(String besked) {
    this.besked = besked;
    return this;
  }

  /**
   * Fejlbeskrivelse
   * @return besked
  */
  @NotNull


  public String getBesked() {
    return besked;
  }

  public void setBesked(String besked) {
    this.besked = besked;
  }

  public Error data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Data der indeholder fejl
   * @return data
  */

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Error status(String status) {
    this.status = status;
    return this;
  }

  /**
   * HTTP status kode
   * @return status
  */


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  // @Override
  // public boolean equals(Object o) {
  //   if (this == o) {
  //     return true;
  //   }
  //   if (o == null || getClass() != o.getClass()) {
  //     return false;
  //   }
  //   Error fejl = (Error) o;
  //   return Objects.equals(this.type, fejl.type) &&
  //       Objects.equals(this.kode, fejl.kode) &&
  //       Objects.equals(this.besked, fejl.besked) &&
  //       Objects.equals(this.data, fejl.data) &&
  //       Objects.equals(this.status, fejl.status);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(type, kode, besked, data, status);
  // }

  // @Override
  // public String toString() {
  //   StringBuilder sb = new StringBuilder();
  //   sb.append("class Fejl {\n");
    
  //   sb.append("    type: ").append(toIndentedString(type)).append("\n");
  //   sb.append("    kode: ").append(toIndentedString(kode)).append("\n");
  //   sb.append("    besked: ").append(toIndentedString(besked)).append("\n");
  //   sb.append("    data: ").append(toIndentedString(data)).append("\n");
  //   sb.append("    status: ").append(toIndentedString(status)).append("\n");
  //   sb.append("}");
  //   return sb.toString();
  // }

  // /**
  //  * Convert the given object to string with each line indented by 4 spaces
  //  * (except the first line).
  //  */
  // private String toIndentedString(Object o) {
  //   if (o == null) {
  //     return "null";
  //   }
  //   return o.toString().replace("\n", "\n    ");
  // }
}

