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
 * PlayerWithPlace
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-02T22:38:59.113612700+06:00[Asia/Almaty]")
public class PlayerWithPlace   {
  @JsonProperty("playerId")
  private UUID playerId;

  @JsonProperty("steamId")
  private String steamId;

  @JsonProperty("place")
  private Integer place;

  public PlayerWithPlace playerId(UUID playerId) {
    this.playerId = playerId;
    return this;
  }

  /**
   * Get playerId
   * @return playerId
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getPlayerId() {
    return playerId;
  }

  public void setPlayerId(UUID playerId) {
    this.playerId = playerId;
  }

  public PlayerWithPlace steamId(String steamId) {
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

  public PlayerWithPlace place(Integer place) {
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
    PlayerWithPlace playerWithPlace = (PlayerWithPlace) o;
    return Objects.equals(this.playerId, playerWithPlace.playerId) &&
        Objects.equals(this.steamId, playerWithPlace.steamId) &&
        Objects.equals(this.place, playerWithPlace.place);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, steamId, place);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerWithPlace {\n");
    
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
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

