package com.example.citymaps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {
    ArrayList<Sight> sights = new ArrayList<>();
    public static ArrayList<Hotel> hotels = new ArrayList<>();
    Client client;

    @SuppressLint("SetText18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

        Bundle arguments = getIntent().getExtras();
        client = (Client) arguments.getSerializable("client");

        TextView information = findViewById(R.id.name);
        information.setText("Welcome, " + client.getName());

        ListView list = findViewById(R.id.sights);

        sights.add(new Sight("Бранденбургские ворота", "Как и подобает любому средневековому городу, Калининград некогда был окружен мощной крепостной стеной. Одним из 7 въездов служили Бранденбургские ворота, прекрасно сохранившиеся до наших дней.",
                R.drawable.vorota, new Point(54.697266, 20.494675)));
        sights.add(new Sight("Музей Марципана", "Узнать о технологии производства и посмотреть на настоящие шедевры кондитерского искусства вы можете в музее Марципана, который в 2017 году открылся в здании Бранденбургских ворот.",
                R.drawable.nopicture, new Point(54.697292,20.494686)));
        sights.add(new Sight("Замок Нессельбек", "Нессельбек — это средневековый рыцарский замок, воссозданный по старинным чертежам в 2011 году. Как и положено любой крепости, Нессельбек оснащен рвом с водой, подъемным мостом, бойницами, опускной решеткой на воротах и цветными витражами.",
                R.drawable.nopicture, new Point(54.793075,20.533628)));
        sights.add(new Sight("Рыбная деревня", "Рыбная деревня в Калининграде лишь подражает архитектуре Кенигсберга, ведь построена она около 10 лет назад. Да и деревней она лишь называется, ведь по факту — это большой гостинично-деловой комплекс. Изначальной здесь действительно хотели сделать этнографический музей, где можно было бы подробнее познакомиться с культурой и бытом кенигсбергцев, но в итоге здания отдали под офисы, гостиницы и заведения общественного питания.",
                R.drawable.nopicture, new Point(54.705085,20.514539)));
        sights.add(new Sight("Фридландские ворота", "Фридландские ворота середины XIX века стали последними из семи ворот Кенигсберга. В начале XX столетия они утратили оборонительное значение, а въезжать в город стали сбоку от ворот, так как был убран оборонительный вал.",
                R.drawable.nopicture, new Point(54.695409,20.521671)));
        sights.add(new Sight("Кирха Святого Семейства", "Чаще всего, кирхами в Германии называли храмы. Одна из самых известных в Калининграде — это кирха Святого Семейства, построенная в начале XX века известным архитектором Фридрихом Хайтманном. Известен храм тем, что в нем часто проводились венчания молодоженов и крещения детей, но никогда не было панихид.",
                R.drawable.nopicture, new Point(54.697589,20.509472)));


        hotels.add(new Hotel("Чайковский", 3500, new Point(54.725886, 20.483159)));
        hotels.add(new Hotel("Тоскана", 3000, new Point(54.716898, 20.473515)));
        hotels.add(new Hotel("Европа", 2900, new Point(54.717455, 20.500149)));
        hotels.add(new Hotel("Китай-Город", 4000, new Point(54.710693, 20.548146)));
        hotels.add(new Hotel("Обертайх-Люкс", 4650, new Point(54.732024, 20.522512)));

        ArrayAdapter<Sight> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sights);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Sight selected = (Sight) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainListActivity.this, MapActivity.class);
                intent.putExtra("Sight", selected);
                startActivity(intent);
            }
        });
    }
}