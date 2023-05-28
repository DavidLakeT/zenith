package me.davidlake.zenith.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterRequestDTO {
    @DecimalMin(value = "0.0", message = "Min price must be greater than or equal to 0")
    private Double minPrice;

    @DecimalMin(value = "0.0", message = "Max price must be greater than or equal to 0")
    @GreaterThanField(value = "minPrice", message = "Max price must be greater than min price")
    private Double maxPrice;

    private String color;
    private String brand;
    private Boolean freeShipping;
}