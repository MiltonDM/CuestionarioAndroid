package com.example.android.cuestionario;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    private Button BtnBorrar;
    private EditText txtCampo1;
    private EditText txtCampo2;
    private EditText nombre;
    private EditText apellido;
    private EditText NombreArchivo;
    private TextView semestre;
    private Button botao;

    //variables del radio button para validar la seleccion.
    private RadioButton opcionCheck1;
    private RadioButton opcionCheck2;
    private RadioButton opcionCheck;
    private RadioButton opcion2Check;
    private RadioButton opcion3Check;
    private RadioButton opcion4Check;
    private RadioButton opcion5Check;
    private RadioButton opcion6Check;
    private RadioButton opcion7Check;
    private RadioButton opcion8Check;
    private RadioButton opcion9Check;
    private RadioButton opcion10Check;
    private RadioButton opcion11Check;
    private RadioButton opcion12Check;
    private RadioButton opcion13Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name = (EditText) findViewById(R.id.name_field);
        BtnBorrar = (Button) findViewById(R.id.BtnBorrar);
        txtCampo1 = (EditText) findViewById(R.id.name_field);
        txtCampo2 = (EditText) findViewById(R.id.last_name);

        //Limpia controles borra todos los campos seleccionados con el boton
        //BtnBorrar.
        BtnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCampo1.setText("");
                txtCampo2.setText("");
                if (opcionCheck1.isChecked()) {
                    opcionCheck1.setChecked(false);
                }
                if (opcionCheck2.isChecked()) {
                    opcionCheck2.setChecked(false);
                }
                if (opcionCheck.isChecked()) {
                    opcionCheck.setChecked(false);
                }
                if (opcion2Check.isChecked()) {
                    opcion2Check.setChecked(false);
                }
                if (opcion3Check.isChecked()) {
                    opcion3Check.setChecked(false);
                }
                if (opcion4Check.isChecked()) {
                    opcion4Check.setChecked(false);
                }
                if (opcion5Check.isChecked()) {
                    opcion5Check.setChecked(false);
                }
                if (opcion6Check.isChecked()) {
                    opcion6Check.setChecked(false);
                }
                if (opcion7Check.isChecked()) {
                    opcion7Check.setChecked(false);
                }
                if (opcion8Check.isChecked()) {
                    opcion8Check.setChecked(false);
                }
                if (opcion9Check.isChecked()) {
                    opcion9Check.setChecked(false);
                }
                if (opcion10Check.isChecked()) {
                    opcion10Check.setChecked(false);
                }
                if (opcion11Check.isChecked()) {
                    opcion11Check.setChecked(false);
                }
                if (opcion12Check.isChecked()) {
                    opcion12Check.setChecked(false);
                }
                if (opcion13Check.isChecked()) {
                    opcion13Check.setChecked(false);
                }
            }
        });
        //Metodo para sobrescribir el archivo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }
        //Delcaramos todas las variables que vamos a usar para poder tomarlas para generar
        //las peticiones
        NombreArchivo = (EditText) findViewById(R.id.textoNombreArchivo);
        nombre = (EditText) findViewById(R.id.name_field);
        apellido = (EditText) findViewById(R.id.last_name);
        semestre = (TextView) findViewById(R.id.quantity_text);
        botao = (Button) findViewById(R.id.botonSalvar);

        opcionCheck1 = (RadioButton) findViewById(R.id.primeraOpcion1);
        opcionCheck2 = (RadioButton) findViewById(R.id.primeraOpcion2);

        opcionCheck = (RadioButton) findViewById(R.id.segundaOpcion1);
        opcion2Check = (RadioButton) findViewById(R.id.segundaOpcion2);

        opcion3Check = (RadioButton ) findViewById(R.id.terceraOpcion1);
        opcion4Check = (RadioButton ) findViewById(R.id.terceraOpcion2);

        opcion5Check = (RadioButton ) findViewById(R.id.cuartaOpcion1);
        opcion6Check = (RadioButton ) findViewById(R.id.cuartaOpcion2);

        opcion7Check = (RadioButton ) findViewById(R.id.quintaOpcion1);
        opcion8Check = (RadioButton ) findViewById(R.id.quintaOpcion2);
        opcion9Check = (RadioButton ) findViewById(R.id.quintaOpcion3);

        opcion10Check = (RadioButton ) findViewById(R.id.sextaOpcion1);
        opcion11Check = (RadioButton ) findViewById(R.id.sextaOpcion2);

        opcion12Check = (RadioButton ) findViewById(R.id.septimaOpcion1);
        opcion13Check = (RadioButton) findViewById(R.id.septimaOpcion2);

        //Esto es lo que que se imprimira en el archivo de texto plano
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = nombre.getText().toString();
                String res2 = apellido.getText().toString();
                String res3 = semestre.getText().toString();
                String res4 = "";
                String res5= "";
                String res6= "";
                String res7="";
                String res8="";
                String res9="";
                String res10="";

                //Lo que va aguardar en el archivo plano
                //pregunta 1
                if (opcionCheck1.isChecked()==true){
                    res4= opcionCheck1.getText().toString();

                }else if (opcionCheck2.isChecked()==true){
                    res4= opcionCheck2.getText().toString();

                }
                //pregunta 2
                if (opcionCheck.isChecked()==true){
                    res5=opcionCheck .getText().toString();
                }else if (opcion2Check.isChecked()==true){
                    res5=opcion2Check.getText().toString();
                }
                //pregunta 3
                if (opcion3Check.isChecked()==true){
                    res6=opcion3Check.getText().toString();
                }else if (opcion4Check.isChecked()==true){
                    res6=opcion4Check.getText().toString();
                }

                //Pregunta 4
                if (opcion5Check.isChecked()==true){
                    res7=opcion5Check.getText().toString();
                }else if (opcion6Check.isChecked()==true){
                    res7=opcion6Check.getText().toString();
                }

                //pregunta 5
                if (opcion7Check.isChecked()==true){
                    res8=opcion7Check.getText().toString();
                }   if (opcion8Check.isChecked()==true){
                    res8=opcion8Check.getText().toString();
                }   else if (opcion9Check.isChecked()==true){
                    res8=opcion9Check.getText().toString();
                }

                //pregunta 6
                if (opcion10Check.isChecked()==true){
                    res9=opcion10Check.getText().toString();
                }else if (opcion11Check.isChecked()==true){
                    res9=opcion11Check.getText().toString();
                }
                //Pregunta 7
                if (opcion12Check.isChecked()==true){
                    res10=opcion12Check.getText().toString();
                }else if (opcion13Check.isChecked()==true){
                    res10=opcion13Check.getText().toString();
                }
                //La impresion se veria asi.
                String conteud = " ";
                conteud +="DATOS PERSONALES\n"+res + "\n" + res2 + "\nSemestre: " + res3 +
                        "\nPREGUNTA 1 \n" + res4 + "\nPREGUNTA 2\n"+res5+"\nPREGUNTA 3\n"+res6
                        +"\nPREGUNTA 4\n"+res7+"\nPREGUNTA 5\n"+res8+"\nPREGUNTA 6\n"+res9
                        +"\nPREGUNTA 7\n"+res10;
                salvarArchivo(conteud);

            }
        });
    }
    //Cuando el archivo es creado correctamente
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permiso Concedido", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permiso no concedido", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    //La ubicacion del archivo de texto y donde lo guarda junot con el metodo del correo
    //donde se adjuntara.
    public void salvarArchivo(String contteudoArquivo) {

        File folder = new File(Environment.getExternalStorageDirectory() + "/PASTA_TUTORIAL");
        if (folder.exists()) {
            folder.mkdir();
        }
        String nameArchivo = NombreArchivo.getText().toString();
        File archivo = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/PASTA_TUTORIAL/" + nameArchivo);

        //declaracion si se pudo duardar o no
        try {
            FileOutputStream salvar = new FileOutputStream(archivo);
            salvar.write(contteudoArquivo.getBytes());
            salvar.close();
            Toast.makeText(this, "Archivo salvado", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Archivo no salvado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        try{
            //Send the order summary in the email body
            Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/PASTA_TUTORIAL/"
                    + nameArchivo));
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("plain/text");
            intent.setData(Uri.parse("mailto:"));//only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT,
                    getString(R.string.order_email, "Hola"));
            intent.putExtra(Intent.EXTRA_TEXT, "Hola te envio este archivo TXT is attached in this mail.");
            intent.putExtra(Intent.EXTRA_STREAM,uri);
            //startActivity(Intent.createChooser(intent, "Send email using:"));

            if (intent.resolveActivity(getPackageManager()) !=null){
                startActivity(intent);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //metodo de incrementar para ver el semestre que seleccione
    public void increment(View view) {
        if (quantity == 12) {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    //metodo de decrementar para ver el semestre que seleccione
    public void decrement(View view) {
        if (quantity == 1) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    //donde se reflejara el semestre seleccionado
    public void displayQuantity(int numberS) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text);
        quantityTextView.setText("" + numberS);
    }
}
