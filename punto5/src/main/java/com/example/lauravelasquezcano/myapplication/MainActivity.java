package com.example.lauravelasquezcano.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    String genero,hobbie;
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre=(EditText) findViewById(R.id.e_nombre);
        final EditText correo=(EditText) findViewById(R.id.e_correo);
        final EditText telefono=(EditText) findViewById(R.id.e_telefono);

        final TextView mostrar_nombre=(TextView) findViewById(R.id.t_nombre);
        final TextView mostrar_correo=(TextView) findViewById(R.id.t_correo);
        final TextView mostrar_telefono=(TextView) findViewById(R.id.t_telefono);
        final TextView mostrar_genero=(TextView) findViewById(R.id.t_genero);
        final TextView mostrar_hobbies=(TextView) findViewById(R.id.t_hobbies);
        final TextView mostrar_ciudad=(TextView) findViewById(R.id.t_ciudad);
        final TextView mostrar_fecha=(TextView) findViewById(R.id.t_fecha);

        final Spinner ciudad=(Spinner) findViewById(R.id.sp_ciudad);
        final ArrayAdapter<CharSequence> ciudad_array=ArrayAdapter.createFromResource(this,R.array.ciudades,android.R.layout.simple_spinner_item);
        ciudad_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudad.setAdapter(ciudad_array);

        Button boton_ok=(Button) findViewById(R.id.b_ok);

        final DatePicker calendario=(DatePicker) findViewById(R.id.dp_fecha);

        final CheckBox bailar= (CheckBox) findViewById(R.id.cb_bailar);
        final CheckBox patinar=(CheckBox) findViewById(R.id.cb_patinar);
        final CheckBox dormir=(CheckBox) findViewById(R.id.cb_dormir);
        final CheckBox leer=(CheckBox) findViewById(R.id.cb_leer);

        ciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posicion=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



        boton_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bailar.isChecked()) {
                    hobbie="Bailar ";
                }
                if(patinar.isChecked()){
                    hobbie=hobbie+"Patinar ";
                }
                if(dormir.isChecked()){
                    hobbie=hobbie+"Dormir ";
                }

                if(leer.isChecked()){
                    hobbie=hobbie+"Leer ";
                }



                    mostrar_nombre.setText(nombre.getText().toString());
                    mostrar_correo.setText(correo.getText().toString());
                    mostrar_telefono.setText(telefono.getText().toString());
                    mostrar_genero.setText(genero);
                    mostrar_hobbies.setText(hobbie);
                    mostrar_ciudad.setText(ciudad_array.getItem(posicion));
                    mostrar_fecha.setText(calendario.getDayOfMonth()+"/"+(calendario.getMonth()+1)+"/"+calendario.getYear());

            }
        });
    }



    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        RadioButton rb_femenino=(RadioButton) findViewById(R.id.rb_femenino);
        RadioButton rb_masculino=(RadioButton) findViewById(R.id.rb_masculino);


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_femenino:
                if (checked)
                    genero="Femenino";
                break;
            case R.id.rb_masculino:
                if (checked) {
                    genero="Masculino";
                }
                break;
            default:
                break;
        }
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
