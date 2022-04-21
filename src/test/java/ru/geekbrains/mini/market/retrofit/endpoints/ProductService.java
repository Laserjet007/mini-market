package ru.geekbrains.mini.market.retrofit.endpoints;

import retrofit2.Call;
import retrofit2.http.*;
import ru.geekbrains.mini.market.retrofit.dto.CategoryDto;
import ru.geekbrains.mini.market.retrofit.dto.ProductDto;

import java.util.List;
//retrofit идеально подходит для android
//в ретрофите уже заложена инфа как нужно делать
public interface ProductService {
    @GET("products/{ID}")                                                              //как так категория гет то аннотация соответствующая (ставим скобки и id вместо 1)
    Call<ProductDto> getProduct(@Path("id")int id);                                    //реализуем метод из свагера (возвращается класс типа call). <> - дженерик  - класс что мы должны вернуть dto. @Path("id")int id - прокидываем id в строку выше

    @GET("products")
    Call<List<ProductDto>> getProducts();                                              //(возвращаться будет list) параметров нет - поэтому ничего не передаем

    @POST("products")                                                                  //создание продукта
    Call<ProductDto> createProducts(@Body ProductDto productDto);                      //отправляем не параметры, а body. @Header("Autorization" String token)- прокинуть Header

    @PUT("products/{ID}")                                                              //изменение продукта
    Call<ProductDto> changeProducts(@Path("id")int id, @Body ProductDto productDto);

    @DELETE("products/{ID}")                                                              //удаление продукта
    Call<Void> deleteProducts(@Path("id")int id);
}
