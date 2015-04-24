package com.example.lauravelasquezcano.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    int operacion;
    double lado,base,altura,radio;
    String finalresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton rb_cuadrado=(RadioButton) findViewById(R.id.rb_cuadrado);
        RadioButton rb_triangulo=(RadioButton) findViewById(R.id.rb_triangulo);
        RadioButton rb_rectangulo=(RadioButton) findViewById(R.id.rb_rectangulo);
        RadioButton rb_circulo=(RadioButton) findViewById(R.id.rb_circulo);

        final TextView resultado=(TextView) findViewById(R.id.t_area);

        Button calcular=(Button) findViewById(R.id.b_calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText(finalresult);
            }
        });


    }

    private boolean isEmpty(EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    }

    public void onRadioButtonClicked(View view){

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        final EditText lado1=(EditText) findViewById(R.id.e_lado);
        final EditText base1=(EditText) findViewById(R.id.e_base);
        final EditText altura1=(EditText) findViewById(R.id.e_altura);
        final EditText radio1=(EditText) findViewById(R.id.e_radio);

        final TextView obligatorio=(TextView) findViewById(R.id.t_obligatorio);




        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_cuadrado:
                if (checked)
                    operacion=1;
                break;
            case R.id.rb_triangulo:
                if (checked) {
                    operacion = 2;
                }
                break;
            case R.id.rb_rectangulo:
                if(checked) {
                    operacion = 3;

                }
                break;
            case R.id.rb_circulo:
                if(checked){
                    operacion=4;

                }

                break;
            default:
                break;
        }

        double resultado;
        switch(operacion) {
            case 1:
                if (isEmpty(lado1)==false){
                    lado = Double.parseDouble(lado1.getText().toString());
                    resultado = lado * lado;
                    finalresult = new Double(resultado).toString();

               }else {
                    obligatorio.setText("Lado es obligatorio");
                }
                break;
            case 2:
                if (isEmpty(base1)==false & isEmpty(altura1)==false) {

                    base=Double.parseDouble(base1.getText().toString());
                    altura=Double.parseDouble(altura1.getText().toString());
                    resultado=base*altura/2;
                    finalresult = new Double(resultado).toString();

                } else {
                    if (isEmpty(base1)==true) {
                        obligatorio.setText("Base es obligatoria");
                    } else if (isEmpty(altura1)==true) {
                       obligatorio.setText("Altura es obligatoria");
                    }
                }

                break;
            case 3:
                if (isEmpty(base1)==false & isEmpty(altura1)==false) {
                    base=Double.parseDouble(base1.getText().toString());
                    altura=Double.parseDouble(altura1.getText().toString());
                    resultado=base*altura;
                    finalresult = new Double(resultado).toString();

                } else {
                    if (isEmpty(base1)==true) {
                       obligatorio.setText("Base es obligatoria");
                    } else if (isEmpty(altura1)==true) {
                        obligatorio.setText("Altura es obligatoria");
                    }
                }

                break;
            case 4:
                if(isEmpty(radio1)==false){
                    radio=Double.parseDouble(radio1.getText().toString());
                    resultado=Math.PI*Math.pow(radio,2);
                    finalresult = new Double(resultado).toString();

                }else{
                    obligatorio.setText("radio es obligatorio");
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
