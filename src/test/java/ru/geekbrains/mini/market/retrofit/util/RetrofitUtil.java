package ru.geekbrains.mini.market.retrofit.util;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import ru.geekbrains.mini.market.retrofit.endpoints.CategoryService;
import ru.geekbrains.mini.market.retrofit.endpoints.ProductService;


import static ru.geekbrains.mini.market.retrofit.config.MiniMarketConfig.miniMarketConfig;

//для прокидывания параметров подключения
@UtilityClass                                                                      //аннотация из ломбок: все методы в util будут статическими
public class RetrofitUtil {
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(miniMarketConfig.baseURL())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor(new PrettyLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                        .addInterceptor(new AllureOkHttp3())
                        .build())
                .build();

    public CategoryService getCategoryService() {                                    //регистрируем сервис для прокидывания url из categoryServise
        return getRetrofit().create(CategoryService.class);                         //создали объект класса - который имплементирует CategoryService (теперь им можно пользоваться как эндпоинтом)
    }

    public static ProductService getProductService() {                                    //регистрируем сервис для прокидывания url из productServise
        return getRetrofit().create(ProductService.class);
    }
}