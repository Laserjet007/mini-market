package ru.geekbrains.mini.market.retrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With                                                                //аннотация для формирования продукт дто
public class ProductDto {

	@JsonProperty("price")
	private int price;

	@JsonProperty("categoryTitle")
	private String categoryTitle;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

}