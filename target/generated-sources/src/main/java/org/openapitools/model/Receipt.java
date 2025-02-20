package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.Item;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Receipt
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T14:10:27.920136800-08:00[America/Los_Angeles]")
public class Receipt {

  private String retailer;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate purchaseDate;

  private String purchaseTime;

  @Valid
  private List<@Valid Item> items = new ArrayList<>();

  private String total;

  /**
   * Default constructor
   * @deprecated Use {@link Receipt#Receipt(String, LocalDate, String, List<@Valid Item>, String)}
   */
  @Deprecated
  public Receipt() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Receipt(String retailer, LocalDate purchaseDate, String purchaseTime, List<@Valid Item> items, String total) {
    this.retailer = retailer;
    this.purchaseDate = purchaseDate;
    this.purchaseTime = purchaseTime;
    this.items = items;
    this.total = total;
  }

  public Receipt retailer(String retailer) {
    this.retailer = retailer;
    return this;
  }

  /**
   * The name of the retailer or store the receipt is from.
   * @return retailer
  */
  @NotNull @Pattern(regexp = "^[\\w\\s\\-&]+$") 
  @Schema(name = "retailer", example = "M&M Corner Market", description = "The name of the retailer or store the receipt is from.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("retailer")
  public String getRetailer() {
    return retailer;
  }

  public void setRetailer(String retailer) {
    this.retailer = retailer;
  }

  public Receipt purchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
    return this;
  }

  /**
   * The date of the purchase printed on the receipt.
   * @return purchaseDate
  */
  @NotNull @Valid 
  @Schema(name = "purchaseDate", example = "Fri Dec 31 16:00:00 PST 2021", description = "The date of the purchase printed on the receipt.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("purchaseDate")
  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public Receipt purchaseTime(String purchaseTime) {
    this.purchaseTime = purchaseTime;
    return this;
  }

  /**
   * The time of the purchase printed on the receipt. 24-hour time expected.
   * @return purchaseTime
  */
  @NotNull 
  @Schema(name = "purchaseTime", example = "13:01", description = "The time of the purchase printed on the receipt. 24-hour time expected.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("purchaseTime")
  public String getPurchaseTime() {
    return purchaseTime;
  }

  public void setPurchaseTime(String purchaseTime) {
    this.purchaseTime = purchaseTime;
  }

  public Receipt items(List<@Valid Item> items) {
    this.items = items;
    return this;
  }

  public Receipt addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @NotNull @Valid @Size(min = 1) 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid Item> getItems() {
    return items;
  }

  public void setItems(List<@Valid Item> items) {
    this.items = items;
  }

  public Receipt total(String total) {
    this.total = total;
    return this;
  }

  /**
   * The total amount paid on the receipt.
   * @return total
  */
  @NotNull @Pattern(regexp = "^\\d+\\.\\d{2}$") 
  @Schema(name = "total", example = "6.49", description = "The total amount paid on the receipt.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Receipt receipt = (Receipt) o;
    return Objects.equals(this.retailer, receipt.retailer) &&
        Objects.equals(this.purchaseDate, receipt.purchaseDate) &&
        Objects.equals(this.purchaseTime, receipt.purchaseTime) &&
        Objects.equals(this.items, receipt.items) &&
        Objects.equals(this.total, receipt.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retailer, purchaseDate, purchaseTime, items, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Receipt {\n");
    sb.append("    retailer: ").append(toIndentedString(retailer)).append("\n");
    sb.append("    purchaseDate: ").append(toIndentedString(purchaseDate)).append("\n");
    sb.append("    purchaseTime: ").append(toIndentedString(purchaseTime)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

