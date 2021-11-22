package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SingleOptionNpcAbilitySet
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SingleOptionNpcAbilitySet   {
  @JsonProperty("npcName")
  private String npcName;

  @JsonProperty("option")
  private Integer option;

  public SingleOptionNpcAbilitySet npcName(String npcName) {
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

  public SingleOptionNpcAbilitySet option(Integer option) {
    this.option = option;
    return this;
  }

  /**
   * Get option
   * @return option
  */
  @ApiModelProperty(value = "")


  public Integer getOption() {
    return option;
  }

  public void setOption(Integer option) {
    this.option = option;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleOptionNpcAbilitySet singleOptionNpcAbilitySet = (SingleOptionNpcAbilitySet) o;
    return Objects.equals(this.npcName, singleOptionNpcAbilitySet.npcName) &&
        Objects.equals(this.option, singleOptionNpcAbilitySet.option);
  }

  @Override
  public int hashCode() {
    return Objects.hash(npcName, option);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SingleOptionNpcAbilitySet {\n");
    
    sb.append("    npcName: ").append(toIndentedString(npcName)).append("\n");
    sb.append("    option: ").append(toIndentedString(option)).append("\n");
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

