package ru.geekbrains.mini.market.retrofit.endpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.mini.market.retrofit.dto.CategoryDto;

//в ретрофите уже заложена инфа как нужно делать
public interface CategoryService {
    @GET("categories/{ID}")                                                            //как так категория гет то аннотация соответствующая (ставим скобки и id вместо 1)
    Call<CategoryDto> getCategory(@Path("id")int id);                                  //реализуем метод из свагера (возвращается класс типа call). <> - дженерик  - класс что мы должны вернуть dto. @Path("id")int id - прокидываем id в строку выше
}
