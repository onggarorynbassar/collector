package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SteamIds
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SteamIds   {
  @JsonProperty("steamIds")
  @Valid
  private List<String> steamIds = null;

  public SteamIds steamIds(List<String> steamIds) {
    this.steamIds = steamIds;
    return this;
  }

  public SteamIds addSteamIdsItem(String steamIdsItem) {
    if (this.steamIds == null) {
      this.steamIds = new ArrayList<>();
    }
    this.steamIds.add(steamIdsItem);
    return this;
  }

  /**
   * Get steamIds
   * @return steamIds
  */
  @ApiModelProperty(value = "")


  public List<String> getSteamIds() {
    return steamIds;
  }

  public void setSteamIds(List<String> steamIds) {
    this.steamIds = steamIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SteamIds steamIds = (SteamIds) o;
    return Objects.equals(this.steamIds, steamIds.steamIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(steamIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SteamIds {\n");
    
    sb.append("    steamIds: ").append(toIndentedString(steamIds)).append("\n");
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

