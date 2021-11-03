package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kz.onggar.collector.openapi.dto.NpcAbilitySet;
import kz.onggar.collector.openapi.dto.UserSetting;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class User   {
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

  @JsonProperty("settings")
  @Valid
  private List<UserSetting> settings = null;

  @JsonProperty("npcAbilitySets")
  @Valid
  private List<NpcAbilitySet> npcAbilitySets = null;

  public User id(UUID id) {
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

  public User steamId(String steamId) {
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

  public User simpleMmr(Integer simpleMmr) {
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

  public User competitiveMmr(Integer competitiveMmr) {
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

  public User relativeMmr(Integer relativeMmr) {
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

  public User settings(List<UserSetting> settings) {
    this.settings = settings;
    return this;
  }

  public User addSettingsItem(UserSetting settingsItem) {
    if (this.settings == null) {
      this.settings = new ArrayList<>();
    }
    this.settings.add(settingsItem);
    return this;
  }

  /**
   * Get settings
   * @return settings
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<UserSetting> getSettings() {
    return settings;
  }

  public void setSettings(List<UserSetting> settings) {
    this.settings = settings;
  }

  public User npcAbilitySets(List<NpcAbilitySet> npcAbilitySets) {
    this.npcAbilitySets = npcAbilitySets;
    return this;
  }

  public User addNpcAbilitySetsItem(NpcAbilitySet npcAbilitySetsItem) {
    if (this.npcAbilitySets == null) {
      this.npcAbilitySets = new ArrayList<>();
    }
    this.npcAbilitySets.add(npcAbilitySetsItem);
    return this;
  }

  /**
   * Get npcAbilitySets
   * @return npcAbilitySets
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<NpcAbilitySet> getNpcAbilitySets() {
    return npcAbilitySets;
  }

  public void setNpcAbilitySets(List<NpcAbilitySet> npcAbilitySets) {
    this.npcAbilitySets = npcAbilitySets;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.steamId, user.steamId) &&
        Objects.equals(this.simpleMmr, user.simpleMmr) &&
        Objects.equals(this.competitiveMmr, user.competitiveMmr) &&
        Objects.equals(this.relativeMmr, user.relativeMmr) &&
        Objects.equals(this.settings, user.settings) &&
        Objects.equals(this.npcAbilitySets, user.npcAbilitySets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, steamId, simpleMmr, competitiveMmr, relativeMmr, settings, npcAbilitySets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    steamId: ").append(toIndentedString(steamId)).append("\n");
    sb.append("    simpleMmr: ").append(toIndentedString(simpleMmr)).append("\n");
    sb.append("    competitiveMmr: ").append(toIndentedString(competitiveMmr)).append("\n");
    sb.append("    relativeMmr: ").append(toIndentedString(relativeMmr)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
    sb.append("    npcAbilitySets: ").append(toIndentedString(npcAbilitySets)).append("\n");
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

