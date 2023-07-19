package com.handling.exception.product.model;

import com.handling.exception.product.entity.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class ProductInput {

    @NotBlank
    private String name;

    @NotNull
    private Double price;

    private Double weight;

    private Category category;

}
