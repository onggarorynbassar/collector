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
 * NpcAbilitySet
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NpcAbilitySet   {
  @JsonProperty("npcName")
  private String npcName;

  @JsonProperty("options")
  @Valid
  private List<Integer> options = null;

  public NpcAbilitySet npcName(String npcName) {
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

  public NpcAbilitySet options(List<Integer> options) {
    this.options = options;
    return this;
  }

  public NpcAbilitySet addOptionsItem(Integer optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Get options
   * @return options
  */
  @ApiModelProperty(value = "")


  public List<Integer> getOptions() {
    return options;
  }

  public void setOptions(List<Integer> options) {
    this.options = options;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NpcAbilitySet npcAbilitySet = (NpcAbilitySet) o;
    return Objects.equals(this.npcName, npcAbilitySet.npcName) &&
        Objects.equals(this.options, npcAbilitySet.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(npcName, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NpcAbilitySet {\n");
    
    sb.append("    npcName: ").append(toIndentedString(npcName)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

