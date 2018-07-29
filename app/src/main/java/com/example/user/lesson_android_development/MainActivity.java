package com.example.user.lesson_android_development;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    public int brojNeki;

    public String[] brojList;
    public ImageButton imageButton;
    private ArrayList<String> brojLista;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        simpleList = (ListView) findViewById(R.id.simpleListView);
        ImageButton myFab = findViewById(R.id.fab);

        // ArrayLista
        final ArrayList<String> brojLista = new ArrayList<String>();
        brojLista.add("Two-line item 1");
        brojLista.add("Two-line item 2");


        //ImageButton onClickListenere
        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //izracunjavanje zadnjeg cell u arrayListi i dodajem jedan
                final int brojNeki = brojLista.size() + 1;

                brojLista.add("Two-line item " + brojNeki);
                arrayAdapter.notifyDataSetChanged();


            }
        });

        //ArrayAdapter
        arrayAdapter = new ArrayAdapter<>
                (this, R.layout.list_view, R.id.textView, brojLista);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //intent
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("course", brojLista.get(i));
                intent.putExtra("course2", i + 1);
                startActivity(intent);

            }
        });


    }
}
