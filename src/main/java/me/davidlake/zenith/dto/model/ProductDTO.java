package me.davidlake.zenith.dto.model;

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
public class ProductDTO {
    @Min(value = 1, message = "ID must be greater than 0")
    private long id;

    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotNull(message = "Free shipping must be specified")
    private Boolean freeShipping;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than 0")
    private double price;
}