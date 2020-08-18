package com.example.proj;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter mArrayAdapter;
    PlaceAdapter mPlaceAdapter;
    players[] players=new players[]{
            new players("Lionel Andrés Messi Cuccittini", 1.7,"leo",33,70758000,"Argentine"),
            new players("Gerard Piqué Bernabeu ",1.94,"pique",33,12740000,"Spanish"),
            new players("Ivan Rakitić ",1.84,"ivan",32,13354000,"Croatian"),
            new players("Sergio Busquets Burgos",1.89,"sergio",32,14949000,"Spanish"),
            new players("Luis Alberto Suárez Díaz",1.82,"suarez",33,23400000,"Uruguayan"),
            new players("Antoine Griezmann ",1.75,"griezm",29,45834000,"French"),
            new players("Frenkie de Jong",1.8,"frenkie",23,20834000,"Dutch"),
            new players("Arthur Henrique Ramos de Oliveira Melo",1.71,"arthur",23,4883000,"Brazilian"),
            new players("Masour Ousmane Dembélé",1.78,"dembele",23,12000000,"French"),
            new players("Anssumane Fati Vieira",1.78,"ansu",17,0," Guinean"),
            new players("Ricard Puig Martí",1.69,"puig",20,15000000,"Spanish"),
            new players("Arturo Erasmo Vidal Pardo",1.8,"vidal",33,9000000,"Chilean"),
            new players("Marc-André ter Stegen",1.87,"ter",28,8580000,"German")
    };
    String[] st=new String[]
            {
                    "first list",
                    "Second List",
                    "third List ",
                    "forth List",
                    "fifth List",
                    "Sixth LIst",
                    "7 th list",
                    "8th list",
                    "9th List",
                    "10 List"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         listView = (ListView) findViewById(R.id.newL);
         mPlaceAdapter = new PlaceAdapter(getApplicationContext(),R.layout.row,players);
        if(listView != null){
            listView.setAdapter(mPlaceAdapter);
             }
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 @Override
public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Log.v("PLACE", players[i].name);
                 }
 });

         }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
