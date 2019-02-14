package com.example.lab3.clase13022019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtcorreo , edtnombre,edtclave,edtconfirmar;
    private RadioButton rbusuario,rbasistente,rbadministrador;
    private CheckBox cbfutball,cbciclismo,cbboligrafo;
    private Button btnguardar,btnlimpiar,btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edittext
        edtclave = findViewById(R.id.edtclave);
        edtconfirmar = findViewById(R.id.edtconfirmar);
        edtcorreo = findViewById(R.id.edtcorreo);
        edtnombre = findViewById(R.id.edtnombres);

        //radioButtons
        rbusuario = findViewById(R.id.rbusuario);
        rbadministrador = findViewById(R.id.rbadministrador);
        rbasistente = findViewById(R.id.rbasistente);

        //checkbox
        cbfutball = findViewById(R.id.cbfutball);
        cbboligrafo = findViewById(R.id.cbboligrafo);
        cbciclismo = findViewById(R.id.cbciclismo);

        btnguardar = findViewById(R.id.btnguardar);
        btnlimpiar = findViewById(R.id.btnlimpiar);
        btnsalir = findViewById(R.id.btnsalir);


        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarDatos();
            }
        });
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }
    private void comprobarDatos(){
        String nombre = edtnombre.getText().toString();
        String correo = edtcorreo.getText().toString();
        String clave = edtclave.getText().toString();
        String confirmar = edtconfirmar.getText().toString();
        if (TextUtils.isEmpty(correo)){
            edtcorreo.setError("Valor requerido");
            edtcorreo.requestFocus();
            //Toast.makeText(MainActivity.this,"no has ingresado un correo",Toast.LENGTH_SHORT).show();
        }
       else if (TextUtils.isEmpty(nombre)){
            edtnombre.setError("Valor requerido");
            edtnombre.requestFocus();
            //Toast.makeText(MainActivity.this,"no has ingresado un nombre",Toast.LENGTH_SHORT).show();
    }
        else if (TextUtils.isEmpty(clave)){
            edtclave.setError("valor requerido");
            edtclave.requestFocus();
            //Toast.makeText(MainActivity.this,"ingresa una contraseña",Toast.LENGTH_SHORT).show();
        }
       else if (TextUtils.isEmpty(confirmar)){
            edtconfirmar.setError("Valor Requirido");
            edtconfirmar.requestFocus();
            //Toast.makeText(MainActivity.this,"no as ingresado la comprobacion de la contraseña",Toast.LENGTH_SHORT).show();
        }
        else if (Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            /*
            * if (clave != confirmar){
                Toast.makeText(getApplicationContext(),"contraseñas distintas",Toast.LENGTH_SHORT).show();
                edtclave.setText("");
                edtconfirmar.setText("");
                edtclave.requestFocus();
            }else {
                edtcorreo.setError("formato no valido");
                edtcorreo.requestFocus();
            }
            * */

            if (!confirmar.equals(clave)){
                Toast.makeText(getApplicationContext(),"contraseñas distintas",Toast.LENGTH_SHORT).show();
                edtclave.setText("");
                edtconfirmar.setText("");
                edtclave.requestFocus();
            }
            else {
                Toast.makeText(getApplicationContext(), "todo correcto", Toast.LENGTH_SHORT).show();
            }

        }else {
            edtcorreo.setError("ingesa un correo valido");
            edtcorreo.requestFocus();
        }
    }
    private boolean verificarPassword(String cad1,String cad2){
        if (cad1.equals(cad2))
            return true;
        else return false;
    }
}
