package ru.geekbrains.mini.market.retrofit.util;

import lombok.experimental.UtilityClass;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.geekbrains.mini.market.entites.Product;
import ru.geekbrains.mini.market.retrofit.endpoints.CategoryService;
import ru.geekbrains.mini.market.retrofit.endpoints.ProductService;
import ru.geekbrains.mini.market.retrofit.test.ProductsTest;

import static ru.geekbrains.mini.market.retrofit.config.MiniMarketConfig.miniMarketConfig;

//для прокидывания параметров подключения
@UtilityClass                                                                      //аннотация из ломбок: все методы в util будут статическими
public class RetrofitUtil {
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()                                             //билдим ретрофит с нужными параметрами
                .baseUrl(miniMarketConfig.baseURI())                              //прописываем url
                .addConverterFactory(JacksonConverterFactory.create())            //прописываем что будем работать с jackson
                .build();

    }

    public CategoryService getCategoryService() {                                    //регистрируем сервис для прокидывания url из categoryServise
        return getRetrofit().create(CategoryService.class);                         //создали объект класса - который имплементирует CategoryService (теперь им можно пользоваться как эндпоинтом)
    }

    public static ProductService getProductService() {                                    //регистрируем сервис для прокидывания url из productServise
        return getRetrofit().create(ProductService.class);
    }
}