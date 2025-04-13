package com.example.books.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@Setter
@Getter
public class BookDto {
    private Long id;
    @NotBlank
    private String vendorCode;
    @NotBlank
    private String title;
    @NotNull
    private Long year;
    private String brand;
    private String stock;
    @NotNull
    private BigDecimal price;
}
