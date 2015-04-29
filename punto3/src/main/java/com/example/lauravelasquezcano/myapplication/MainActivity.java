package com.example.lauravelasquezcano.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    double n_quices,n_expo,n_lab,n_pfinal,n_def;
    String nota_final;
    TextView definitiva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText quices= (EditText) findViewById(R.id.e_quices);
        final EditText exposicion = (EditText) findViewById(R.id.e_exposiciones);
        final EditText lab = (EditText) findViewById(R.id.e_laboratorio);
        final EditText p_final = (EditText) findViewById(R.id.e_proyecto_final);

        Button calcular = (Button) findViewById(R.id.b_calcular);

         definitiva = (TextView) findViewById(R.id.t_definitiva);



        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n_quices = Double.parseDouble(quices.getText().toString());
                n_expo = Double.parseDouble(exposicion.getText().toString());
                n_lab = Double.parseDouble(lab.getText().toString());
                n_pfinal = Double.parseDouble(p_final.getText().toString());
                n_def = n_quices * 0.15 + n_expo * 0.1 + n_lab * 0.4 + n_pfinal * 0.35;
                nota_final=String.valueOf(n_def);
                definitiva.setText(nota_final);
            }
        });




    }

    protected void onSaveInstanceState(Bundle sostener){
        super.onSaveInstanceState(sostener);
        sostener.putString("clave",nota_final);
    }

    protected void onRestoreInstanceState(Bundle rehacer){
        super.onRestoreInstanceState(rehacer);
        nota_final=rehacer.getString("clave");
        definitiva.setText(nota_final);
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
