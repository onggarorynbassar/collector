package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kz.onggar.collector.openapi.dto.PlayerWithPlace;
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

  @JsonProperty("playersWithPlaces")
  @Valid
  private List<PlayerWithPlace> playersWithPlaces = null;

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

  public Match playersWithPlaces(List<PlayerWithPlace> playersWithPlaces) {
    this.playersWithPlaces = playersWithPlaces;
    return this;
  }

  public Match addPlayersWithPlacesItem(PlayerWithPlace playersWithPlacesItem) {
    if (this.playersWithPlaces == null) {
      this.playersWithPlaces = new ArrayList<>();
    }
    this.playersWithPlaces.add(playersWithPlacesItem);
    return this;
  }

  /**
   * Get playersWithPlaces
   * @return playersWithPlaces
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<PlayerWithPlace> getPlayersWithPlaces() {
    return playersWithPlaces;
  }

  public void setPlayersWithPlaces(List<PlayerWithPlace> playersWithPlaces) {
    this.playersWithPlaces = playersWithPlaces;
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
        Objects.equals(this.playersWithPlaces, match.playersWithPlaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, playersWithPlaces);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Match {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    playersWithPlaces: ").append(toIndentedString(playersWithPlaces)).append("\n");
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

