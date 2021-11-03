package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Defender
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Defender   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("positionX")
  private Integer positionX;

  @JsonProperty("positionY")
  private Integer positionY;

  public Defender name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Defender positionX(Integer positionX) {
    this.positionX = positionX;
    return this;
  }

  /**
   * Get positionX
   * @return positionX
  */
  @ApiModelProperty(value = "")


  public Integer getPositionX() {
    return positionX;
  }

  public void setPositionX(Integer positionX) {
    this.positionX = positionX;
  }

  public Defender positionY(Integer positionY) {
    this.positionY = positionY;
    return this;
  }

  /**
   * Get positionY
   * @return positionY
  */
  @ApiModelProperty(value = "")


  public Integer getPositionY() {
    return positionY;
  }

  public void setPositionY(Integer positionY) {
    this.positionY = positionY;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Defender defender = (Defender) o;
    return Objects.equals(this.name, defender.name) &&
        Objects.equals(this.positionX, defender.positionX) &&
        Objects.equals(this.positionY, defender.positionY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, positionX, positionY);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Defender {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    positionX: ").append(toIndentedString(positionX)).append("\n");
    sb.append("    positionY: ").append(toIndentedString(positionY)).append("\n");
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

