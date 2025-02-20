package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ProcessReceipts200Response
 */

@JsonTypeName("processReceipts_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T14:10:27.920136800-08:00[America/Los_Angeles]")
public class ProcessReceipts200Response {

  private String id;

  /**
   * Default constructor
   * @deprecated Use {@link ProcessReceipts200Response#ProcessReceipts200Response(String)}
   */
  @Deprecated
  public ProcessReceipts200Response() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProcessReceipts200Response(String id) {
    this.id = id;
  }

  public ProcessReceipts200Response id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Pattern(regexp = "^\\S+$") 
  @Schema(name = "id", example = "adb6b560-0eef-42bc-9d16-df48f30e89b2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessReceipts200Response processReceipts200Response = (ProcessReceipts200Response) o;
    return Objects.equals(this.id, processReceipts200Response.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessReceipts200Response {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

