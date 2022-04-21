package ru.geekbrains.mini.market.retrofit.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With                                    //аннотация для формирования продукт дто
public class CategoryDto{

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("products")
	private List<ProductDto> products;
}