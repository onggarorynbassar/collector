package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kz.onggar.collector.openapi.dto.UserMatchStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchUpdate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MatchUpdate   {
  @JsonProperty("userMatchStatuses")
  @Valid
  private List<UserMatchStatus> userMatchStatuses = null;

  @JsonProperty("wave")
  private Integer wave;

  @JsonProperty("npcName")
  private String npcName;

  @JsonProperty("matchId")
  private UUID matchId;

  public MatchUpdate userMatchStatuses(List<UserMatchStatus> userMatchStatuses) {
    this.userMatchStatuses = userMatchStatuses;
    return this;
  }

  public MatchUpdate addUserMatchStatusesItem(UserMatchStatus userMatchStatusesItem) {
    if (this.userMatchStatuses == null) {
      this.userMatchStatuses = new ArrayList<>();
    }
    this.userMatchStatuses.add(userMatchStatusesItem);
    return this;
  }

  /**
   * Get userMatchStatuses
   * @return userMatchStatuses
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<UserMatchStatus> getUserMatchStatuses() {
    return userMatchStatuses;
  }

  public void setUserMatchStatuses(List<UserMatchStatus> userMatchStatuses) {
    this.userMatchStatuses = userMatchStatuses;
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

  public MatchUpdate npcName(String npcName) {
    this.npcName = npcName;
    return this;
  }

  /**
   * Get npcName
   * @return npcName
  */
  @ApiModelProperty(value = "")


  public String getNpcName() {
    return npcName;
  }

  public void setNpcName(String npcName) {
    this.npcName = npcName;
  }

  public MatchUpdate matchId(UUID matchId) {
    this.matchId = matchId;
    return this;
  }

  /**
   * Get matchId
   * @return matchId
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getMatchId() {
    return matchId;
  }

  public void setMatchId(UUID matchId) {
    this.matchId = matchId;
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
    return Objects.equals(this.userMatchStatuses, matchUpdate.userMatchStatuses) &&
        Objects.equals(this.wave, matchUpdate.wave) &&
        Objects.equals(this.npcName, matchUpdate.npcName) &&
        Objects.equals(this.matchId, matchUpdate.matchId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userMatchStatuses, wave, npcName, matchId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchUpdate {\n");
    
    sb.append("    userMatchStatuses: ").append(toIndentedString(userMatchStatuses)).append("\n");
    sb.append("    wave: ").append(toIndentedString(wave)).append("\n");
    sb.append("    npcName: ").append(toIndentedString(npcName)).append("\n");
    sb.append("    matchId: ").append(toIndentedString(matchId)).append("\n");
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

