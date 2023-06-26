package com.example.citymaps;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;
public class MapWay extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        MapKitFactory.setApiKey("be0b8046-95a5-43d9-b8d9-ad5f1440352e");
    }
    //Новая сущность - отель или гостиница. Характеризуется точка и цена за ночь, название. Рекомендовать отель по расстоянию рядом с достопримечательностью. Сделать с помощью стандартного метода.
}
