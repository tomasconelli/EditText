package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText etID;
    private RadioButton rb1, rb2;
    private ToggleButton toggleButton;
    private Button btn1, btn2, btn3;
    private ProgressBar pb;
    int contador = 0;
    private CheckBox cb1, cb2, cb3;
    private RatingBar rbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText) findViewById(R.id.etID);

        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        btn1 = (Button) findViewById(R.id.btn1);
        btn3 = (Button) findViewById(R.id.btn3);

        pb = (ProgressBar) findViewById(R.id.pb);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);

        rbar1 = (RatingBar) findViewById(R.id.rbar1);

        comprobarRb1();
        comprobarRb2();
        cambiaEstado();
        prog();
    }

    public void capturarID(View v){
        if (etID.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"El ID esta vacío!!",Toast.LENGTH_SHORT).show();
        }else {
            int id = Integer.parseInt(etID.getText().toString());
            Toast.makeText(MainActivity.this,"El ID es : "+id,Toast.LENGTH_SHORT).show();

        }

    }

    /*public void comprobarRadio(View v){
        String tipo = "";
        if (rb1.isChecked()){
            tipo = rb1.getText().toString();
        }else{
            tipo = rb2.getText().toString();
        }
        Toast.makeText(MainActivity.this, "Radio : "+ tipo, Toast.LENGTH_SHORT).show();
    }*/

    public void comprobarRb1(){
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "Radio : "+ tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void comprobarRb2(){
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "Radio : "+ tipo, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cambiaEstado(){
        toggleButton.setTextOff("Controles Desactivados");
        toggleButton.setTextOn("Controles Activados");

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()){
                    etID.setEnabled(true);
                    btn1.setEnabled(true);
                }else{
                    etID.setEnabled(false);
                    btn1.setEnabled(false);
                }
            }
        });
    }

    public  void prog(){
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        pb.setProgress(contador);

                        if(contador == 100)
                            t.cancel();
                    }
                };
                t.schedule(tt,0,100);
            }
        });

    }

    public void comprobarCBox(View v){
        String comprobarCB1 = "";
        String comprobarCB2 = "";
        String comprobarCB3 = "";
        String etiqueta = "";
        if (cb1.isChecked()==true){
            comprobarCB1 = cb1.getText().toString();
        }else {
            comprobarCB1 = "";
        }
        if (cb2.isChecked()==true){
            comprobarCB2 = cb2.getText().toString();
        }else {
            comprobarCB2 = "";
        }
        if (cb3.isChecked()==true){
            comprobarCB3 = cb3.getText().toString();
        }else {
            comprobarCB3 = "";
        }
        etiqueta = (comprobarCB1 +" "+ comprobarCB2+" " + comprobarCB3);

        Toast.makeText(MainActivity.this, "Las opciones seleccionadas son: "+etiqueta, Toast.LENGTH_LONG).show();
    }

    public void cuantasEstrellas(View v){
        Toast.makeText(MainActivity.this, "Usted a otorgado: "+rbar1.getRating()+" estrellas!!!", Toast.LENGTH_LONG).show();

    }

}