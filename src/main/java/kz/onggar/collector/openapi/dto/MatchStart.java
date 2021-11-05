package kz.onggar.collector.openapi.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import kz.onggar.collector.openapi.dto.Match;
import kz.onggar.collector.openapi.dto.User;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MatchStart
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MatchStart   {
  @JsonProperty("match")
  private Match match;

  @JsonProperty("Users")
  @Valid
  private List<User> users = null;

  public MatchStart match(Match match) {
    this.match = match;
    return this;
  }

  /**
   * Get match
   * @return match
  */
  @ApiModelProperty(value = "")

  @Valid

  public Match getMatch() {
    return match;
  }

  public void setMatch(Match match) {
    this.match = match;
  }

  public MatchStart users(List<User> users) {
    this.users = users;
    return this;
  }

  public MatchStart addUsersItem(User usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchStart matchStart = (MatchStart) o;
    return Objects.equals(this.match, matchStart.match) &&
        Objects.equals(this.users, matchStart.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(match, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchStart {\n");
    
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

