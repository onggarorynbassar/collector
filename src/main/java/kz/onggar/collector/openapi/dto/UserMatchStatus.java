package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kz.onggar.collector.openapi.dto.Defender;
import kz.onggar.collector.openapi.dto.Mercenary;
import kz.onggar.collector.openapi.dto.MercenarySpell;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserMatchStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserMatchStatus   {
  @JsonProperty("playerId")
  private UUID playerId;

  @JsonProperty("alive")
  private Boolean alive;

  @JsonProperty("defenders")
  @Valid
  private List<Defender> defenders = null;

  @JsonProperty("mercenaries")
  @Valid
  private List<Mercenary> mercenaries = null;

  @JsonProperty("spells")
  @Valid
  private List<MercenarySpell> spells = null;

  @JsonProperty("npcAbilitySetOption")
  private Integer npcAbilitySetOption;

  public UserMatchStatus playerId(UUID playerId) {
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

  public UserMatchStatus alive(Boolean alive) {
    this.alive = alive;
    return this;
  }

  /**
   * Get alive
   * @return alive
  */
  @ApiModelProperty(value = "")


  public Boolean getAlive() {
    return alive;
  }

  public void setAlive(Boolean alive) {
    this.alive = alive;
  }

  public UserMatchStatus defenders(List<Defender> defenders) {
    this.defenders = defenders;
    return this;
  }

  public UserMatchStatus addDefendersItem(Defender defendersItem) {
    if (this.defenders == null) {
      this.defenders = new ArrayList<>();
    }
    this.defenders.add(defendersItem);
    return this;
  }

  /**
   * Get defenders
   * @return defenders
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Defender> getDefenders() {
    return defenders;
  }

  public void setDefenders(List<Defender> defenders) {
    this.defenders = defenders;
  }

  public UserMatchStatus mercenaries(List<Mercenary> mercenaries) {
    this.mercenaries = mercenaries;
    return this;
  }

  public UserMatchStatus addMercenariesItem(Mercenary mercenariesItem) {
    if (this.mercenaries == null) {
      this.mercenaries = new ArrayList<>();
    }
    this.mercenaries.add(mercenariesItem);
    return this;
  }

  /**
   * Get mercenaries
   * @return mercenaries
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Mercenary> getMercenaries() {
    return mercenaries;
  }

  public void setMercenaries(List<Mercenary> mercenaries) {
    this.mercenaries = mercenaries;
  }

  public UserMatchStatus spells(List<MercenarySpell> spells) {
    this.spells = spells;
    return this;
  }

  public UserMatchStatus addSpellsItem(MercenarySpell spellsItem) {
    if (this.spells == null) {
      this.spells = new ArrayList<>();
    }
    this.spells.add(spellsItem);
    return this;
  }

  /**
   * Get spells
   * @return spells
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<MercenarySpell> getSpells() {
    return spells;
  }

  public void setSpells(List<MercenarySpell> spells) {
    this.spells = spells;
  }

  public UserMatchStatus npcAbilitySetOption(Integer npcAbilitySetOption) {
    this.npcAbilitySetOption = npcAbilitySetOption;
    return this;
  }

  /**
   * Get npcAbilitySetOption
   * @return npcAbilitySetOption
  */
  @ApiModelProperty(value = "")


  public Integer getNpcAbilitySetOption() {
    return npcAbilitySetOption;
  }

  public void setNpcAbilitySetOption(Integer npcAbilitySetOption) {
    this.npcAbilitySetOption = npcAbilitySetOption;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserMatchStatus userMatchStatus = (UserMatchStatus) o;
    return Objects.equals(this.playerId, userMatchStatus.playerId) &&
        Objects.equals(this.alive, userMatchStatus.alive) &&
        Objects.equals(this.defenders, userMatchStatus.defenders) &&
        Objects.equals(this.mercenaries, userMatchStatus.mercenaries) &&
        Objects.equals(this.spells, userMatchStatus.spells) &&
        Objects.equals(this.npcAbilitySetOption, userMatchStatus.npcAbilitySetOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, alive, defenders, mercenaries, spells, npcAbilitySetOption);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserMatchStatus {\n");
    
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    alive: ").append(toIndentedString(alive)).append("\n");
    sb.append("    defenders: ").append(toIndentedString(defenders)).append("\n");
    sb.append("    mercenaries: ").append(toIndentedString(mercenaries)).append("\n");
    sb.append("    spells: ").append(toIndentedString(spells)).append("\n");
    sb.append("    npcAbilitySetOption: ").append(toIndentedString(npcAbilitySetOption)).append("\n");
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

