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
 * Player
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-02T20:37:05.876957300+06:00[Asia/Almaty]")
public class Player   {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("steamId")
  private String steamId;

  @JsonProperty("simpleMmr")
  private Integer simpleMmr;

  @JsonProperty("competitiveMmr")
  private Integer competitiveMmr;

  @JsonProperty("relativeMmr")
  private Integer relativeMmr;

  public Player id(UUID id) {
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

  public Player steamId(String steamId) {
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

  public Player simpleMmr(Integer simpleMmr) {
    this.simpleMmr = simpleMmr;
    return this;
  }

  /**
   * Get simpleMmr
   * @return simpleMmr
  */
  @ApiModelProperty(value = "")


  public Integer getSimpleMmr() {
    return simpleMmr;
  }

  public void setSimpleMmr(Integer simpleMmr) {
    this.simpleMmr = simpleMmr;
  }

  public Player competitiveMmr(Integer competitiveMmr) {
    this.competitiveMmr = competitiveMmr;
    return this;
  }

  /**
   * Get competitiveMmr
   * @return competitiveMmr
  */
  @ApiModelProperty(value = "")


  public Integer getCompetitiveMmr() {
    return competitiveMmr;
  }

  public void setCompetitiveMmr(Integer competitiveMmr) {
    this.competitiveMmr = competitiveMmr;
  }

  public Player relativeMmr(Integer relativeMmr) {
    this.relativeMmr = relativeMmr;
    return this;
  }

  /**
   * Get relativeMmr
   * @return relativeMmr
  */
  @ApiModelProperty(value = "")


  public Integer getRelativeMmr() {
    return relativeMmr;
  }

  public void setRelativeMmr(Integer relativeMmr) {
    this.relativeMmr = relativeMmr;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(this.id, player.id) &&
        Objects.equals(this.steamId, player.steamId) &&
        Objects.equals(this.simpleMmr, player.simpleMmr) &&
        Objects.equals(this.competitiveMmr, player.competitiveMmr) &&
        Objects.equals(this.relativeMmr, player.relativeMmr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, steamId, simpleMmr, competitiveMmr, relativeMmr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Player {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    steamId: ").append(toIndentedString(steamId)).append("\n");
    sb.append("    simpleMmr: ").append(toIndentedString(simpleMmr)).append("\n");
    sb.append("    competitiveMmr: ").append(toIndentedString(competitiveMmr)).append("\n");
    sb.append("    relativeMmr: ").append(toIndentedString(relativeMmr)).append("\n");
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

