package com.example.lauravelasquezcano.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    int operacion;
    double num1;
    double num2,resultado;
    String finalresult;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result=(TextView) findViewById(R.id.t_resultado);

        Button b_calcular=(Button) findViewById(R.id.b_calcular);

        RadioButton rb_suma=(RadioButton) findViewById(R.id.rb_suma);
        RadioButton rb_resta=(RadioButton) findViewById(R.id.rb_resta);
        RadioButton rb_multiplicacion=(RadioButton) findViewById(R.id.rb_multiplicacion);
        RadioButton rb_division=(RadioButton) findViewById(R.id.rb_division);



        b_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(finalresult);
            }
        });

    }

    protected void onSaveInstanceState(Bundle sostener){
        super.onSaveInstanceState(sostener);
        sostener.putString("clave",finalresult);
    }

    protected void onRestoreInstanceState(Bundle rehacer){
        super.onRestoreInstanceState(rehacer);
        finalresult=rehacer.getString("clave");
        result.setText(finalresult);
    }



    public void onRadioButtonClicked(View view){

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        final EditText numero1=(EditText) findViewById(R.id.e_numero1);
        final EditText numero2=(EditText) findViewById(R.id.e_numero2);

        num1=Double.parseDouble(numero1.getText().toString());
        num2=Double.parseDouble(numero2.getText().toString());

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_suma:
                if (checked)
                    operacion=1;
                break;
            case R.id.rb_resta:
                if (checked)
                    operacion=2;
                break;
            case R.id.rb_multiplicacion:
                if(checked)
                    operacion=3;
                break;
            case R.id.rb_division:
                if(checked)
                    operacion=4;
                break;
            default:
                break;
        }


        switch(operacion){
            case 1:
                resultado=num1+num2;
                finalresult = new Double(resultado).toString();
                break;
            case 2:
                resultado=num1-num2;
                finalresult = new Double(resultado).toString();
                break;
            case 3:
                resultado=num1*num2;
                finalresult = new Double(resultado).toString();
                break;
            case 4:
                resultado=num1/num2;
                finalresult = new Double(resultado).toString();
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
