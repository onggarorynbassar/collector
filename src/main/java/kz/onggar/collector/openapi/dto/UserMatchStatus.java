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
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserMatchStatus
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UserMatchStatus   {
  @JsonProperty("id")
  private UUID id;

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
  private List<String> spells = null;

  @JsonProperty("npcAbilityOption")
  private Integer npcAbilityOption;

  public UserMatchStatus id(UUID id) {
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

  public UserMatchStatus spells(List<String> spells) {
    this.spells = spells;
    return this;
  }

  public UserMatchStatus addSpellsItem(String spellsItem) {
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


  public List<String> getSpells() {
    return spells;
  }

  public void setSpells(List<String> spells) {
    this.spells = spells;
  }

  public UserMatchStatus npcAbilityOption(Integer npcAbilityOption) {
    this.npcAbilityOption = npcAbilityOption;
    return this;
  }

  /**
   * Get npcAbilityOption
   * @return npcAbilityOption
  */
  @ApiModelProperty(value = "")


  public Integer getNpcAbilityOption() {
    return npcAbilityOption;
  }

  public void setNpcAbilityOption(Integer npcAbilityOption) {
    this.npcAbilityOption = npcAbilityOption;
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
    return Objects.equals(this.id, userMatchStatus.id) &&
        Objects.equals(this.alive, userMatchStatus.alive) &&
        Objects.equals(this.defenders, userMatchStatus.defenders) &&
        Objects.equals(this.mercenaries, userMatchStatus.mercenaries) &&
        Objects.equals(this.spells, userMatchStatus.spells) &&
        Objects.equals(this.npcAbilityOption, userMatchStatus.npcAbilityOption);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, alive, defenders, mercenaries, spells, npcAbilityOption);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserMatchStatus {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    alive: ").append(toIndentedString(alive)).append("\n");
    sb.append("    defenders: ").append(toIndentedString(defenders)).append("\n");
    sb.append("    mercenaries: ").append(toIndentedString(mercenaries)).append("\n");
    sb.append("    spells: ").append(toIndentedString(spells)).append("\n");
    sb.append("    npcAbilityOption: ").append(toIndentedString(npcAbilityOption)).append("\n");
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

