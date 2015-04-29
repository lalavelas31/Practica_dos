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


    String genero,hobbie,nombre1,correo1,telefono1,genero1,hobbie1,fecha1,ciudad1;
    int posicion;
    TextView mostrar_nombre,mostrar_correo,mostrar_telefono,mostrar_genero,mostrar_hobbies,mostrar_ciudad,mostrar_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre=(EditText) findViewById(R.id.e_nombre);
        final EditText correo=(EditText) findViewById(R.id.e_correo);
        final EditText telefono=(EditText) findViewById(R.id.e_telefono);

        mostrar_nombre=(TextView) findViewById(R.id.t_nombre);
        mostrar_correo=(TextView) findViewById(R.id.t_correo);
        mostrar_telefono=(TextView) findViewById(R.id.t_telefono);
        mostrar_genero=(TextView) findViewById(R.id.t_genero);
        mostrar_hobbies=(TextView) findViewById(R.id.t_hobbies);
        mostrar_ciudad=(TextView) findViewById(R.id.t_ciudad);
        mostrar_fecha=(TextView) findViewById(R.id.t_fecha);

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



                    mostrar_nombre.setText(nombre1=nombre.getText().toString());
                    mostrar_correo.setText(correo1=correo.getText().toString());
                    mostrar_telefono.setText(telefono1=telefono.getText().toString());
                    mostrar_genero.setText(genero1=genero);
                    mostrar_hobbies.setText(hobbie1=hobbie);
                    mostrar_ciudad.setText(ciudad1=(ciudad_array.getItem(posicion)).toString());
                    mostrar_fecha.setText(fecha1=calendario.getDayOfMonth()+"/"+(calendario.getMonth()+1)+"/"+calendario.getYear());

            }
        });
    }

    protected void onSaveInstanceState(Bundle sostener){
        super.onSaveInstanceState(sostener);
        sostener.putString("clave",nombre1);
        sostener.putString("clave1",correo1);
        sostener.putString("clave2",telefono1);
        sostener.putString("clave3",genero1);
        sostener.putString("clave4",hobbie1);
        sostener.putString("clave5",ciudad1);
        sostener.putString("clave6",fecha1);
    }

    protected void onRestoreInstanceState(Bundle rehacer){
        super.onRestoreInstanceState(rehacer);
        nombre1=rehacer.getString("clave");
        mostrar_nombre.setText(nombre1);
        correo1=rehacer.getString("clave1");
        mostrar_correo.setText(correo1);
        telefono1=rehacer.getString("clave2");
        mostrar_telefono.setText(telefono1);
        genero1=rehacer.getString("clave3");
        mostrar_genero.setText(genero1);
        hobbie1=rehacer.getString("clave4");
        mostrar_hobbies.setText(hobbie1);
        ciudad1=rehacer.getString("clave5");
        mostrar_ciudad.setText(ciudad1);
        fecha1=rehacer.getString("clave6");
        mostrar_fecha.setText(fecha1);

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
