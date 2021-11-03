package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kz.onggar.collector.openapi.dto.UserMatchStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchUpdate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MatchUpdate   {
  @JsonProperty("UserMatchStatus")
  private UserMatchStatus userMatchStatus;

  @JsonProperty("wave")
  private Integer wave;

  public MatchUpdate userMatchStatus(UserMatchStatus userMatchStatus) {
    this.userMatchStatus = userMatchStatus;
    return this;
  }

  /**
   * Get userMatchStatus
   * @return userMatchStatus
  */
  @ApiModelProperty(value = "")

  @Valid

  public UserMatchStatus getUserMatchStatus() {
    return userMatchStatus;
  }

  public void setUserMatchStatus(UserMatchStatus userMatchStatus) {
    this.userMatchStatus = userMatchStatus;
  }

  public MatchUpdate wave(Integer wave) {
    this.wave = wave;
    return this;
  }

  /**
   * Get wave
   * @return wave
  */
  @ApiModelProperty(value = "")


  public Integer getWave() {
    return wave;
  }

  public void setWave(Integer wave) {
    this.wave = wave;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchUpdate matchUpdate = (MatchUpdate) o;
    return Objects.equals(this.userMatchStatus, matchUpdate.userMatchStatus) &&
        Objects.equals(this.wave, matchUpdate.wave);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userMatchStatus, wave);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchUpdate {\n");
    
    sb.append("    userMatchStatus: ").append(toIndentedString(userMatchStatus)).append("\n");
    sb.append("    wave: ").append(toIndentedString(wave)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

