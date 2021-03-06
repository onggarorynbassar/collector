package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Match
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Match   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("currentWave")
  private Integer currentWave;

  public Match id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Match currentWave(Integer currentWave) {
    this.currentWave = currentWave;
    return this;
  }

  /**
   * Get currentWave
   * @return currentWave
  */
  @ApiModelProperty(value = "")


  public Integer getCurrentWave() {
    return currentWave;
  }

  public void setCurrentWave(Integer currentWave) {
    this.currentWave = currentWave;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Match match = (Match) o;
    return Objects.equals(this.id, match.id) &&
        Objects.equals(this.currentWave, match.currentWave);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, currentWave);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Match {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    currentWave: ").append(toIndentedString(currentWave)).append("\n");
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

