package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import kz.onggar.collector.openapi.dto.PlayerWithPlace;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-02T20:37:05.876957300+06:00[Asia/Almaty]")
public class MatchResult   {
  @JsonProperty("playersWithPlaces")
  @Valid
  private List<PlayerWithPlace> playersWithPlaces = null;

  @JsonProperty("steamId")
  private String steamId;

  @JsonProperty("place")
  private Integer place;

  public MatchResult playersWithPlaces(List<PlayerWithPlace> playersWithPlaces) {
    this.playersWithPlaces = playersWithPlaces;
    return this;
  }

  public MatchResult addPlayersWithPlacesItem(PlayerWithPlace playersWithPlacesItem) {
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

  public MatchResult steamId(String steamId) {
    this.steamId = steamId;
    return this;
  }

  /**
   * Get steamId
   * @return steamId
  */
  @ApiModelProperty(value = "")


  public String getSteamId() {
    return steamId;
  }

  public void setSteamId(String steamId) {
    this.steamId = steamId;
  }

  public MatchResult place(Integer place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  */
  @ApiModelProperty(value = "")


  public Integer getPlace() {
    return place;
  }

  public void setPlace(Integer place) {
    this.place = place;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchResult matchResult = (MatchResult) o;
    return Objects.equals(this.playersWithPlaces, matchResult.playersWithPlaces) &&
        Objects.equals(this.steamId, matchResult.steamId) &&
        Objects.equals(this.place, matchResult.place);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playersWithPlaces, steamId, place);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchResult {\n");
    
    sb.append("    playersWithPlaces: ").append(toIndentedString(playersWithPlaces)).append("\n");
    sb.append("    steamId: ").append(toIndentedString(steamId)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
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

