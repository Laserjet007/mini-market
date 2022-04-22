package ru.geekbrains.mini.market.retrofit.test;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.mini.market.retrofit.dto.ProductDto;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.mini.market.retrofit.util.RetrofitUtil.getCategoryService;
import static ru.geekbrains.mini.market.retrofit.util.RetrofitUtil.getProductService;

//тест на создание и удаление продукта
public class ProductsTest {
    ProductDto productDto;                                                                        //для создания продукта делаем Dto
    int productId;                                                                                //создаём переменную для дальнейшей очистки результата

    @SneakyThrows
    @BeforeEach
    void setUp() {                                                                               //формируем productDto
        productDto = new ProductDto()
                .withCategoryTitle(Objects.requireNonNull(getCategoryService().getCategory(1).execute().body()).getTitle())
                .withTitle(new Faker().food().ingredient())
                .withPrice(300);
    }

    @SneakyThrows
    @Test
    void createProductTest(){
        Response<ProductDto> productDtoResponse = getProductService().createProducts(productDto)  //начинаем запрос получая сервис
                .execute();                                                                       //выполним используя аннотацию из lombok
        assertThat(productDtoResponse.isSuccessful()).isTrue();                                   //productDtoResponse.isSuccessful() -  проверяем что запрос успешный (200)
//        productDtoResponse.isSuccessful();                                                      //получаем bullean переменную isSuccessful (не ассерт)
        assertThat(productDtoResponse.body())                                                     //проверяем приходящий ответ на равенство productDto (тело = )
                .usingRecursiveComparison()                                                       //для того что бы воспользоваться ассерт джей
                .ignoringFields("id")                                            //игнорирование определенных полей (в данном случае id)
                .isEqualTo(productDto);                                                          //сравниваем тело
        productId = Objects.requireNonNull(productDtoResponse.body()).getId();                   //формируем данные для удаления id
    }
    @SneakyThrows
    @AfterEach                                                                                   //чистим данные (удаляем), формируем для этого метод
    void tearDown() {
        assertThat(getProductService().deleteProducts(productId).execute().isSuccessful())
                .isTrue();
    }



}
