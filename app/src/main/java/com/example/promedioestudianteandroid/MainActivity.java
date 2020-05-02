package com.example.promedioestudianteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText codigo;
    private EditText nombre;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private Button calcular;
    private Button salir;
    private TextView promedio;





    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = findViewById(R.id.txtcodigo);
        nombre = findViewById(R.id.txtnombre);
        nota1 = findViewById(R.id.txtnota1);
        nota2 = findViewById(R.id.txtnota2);
        nota3 = findViewById(R.id.txtnota3);
        calcular = findViewById(R.id.btncalcular);
        salir = findViewById(R.id.btnsalir);
        promedio= findViewById(R.id.lblresultado);





        databaseReference = FirebaseDatabase.getInstance().getReference("Estudiante");
        progressDialog = new ProgressDialog(this);



        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String code = codigo.getText().toString().trim();
                String nom = nombre.getText().toString().trim();
                String not1 = nota1.getText().toString().trim();
                String not2 = nota2.getText().toString().trim();
                String not3 = nota3.getText().toString().trim();

                double prom1 = Double.parseDouble(not1);
                double prom2 = Double.parseDouble(not2);
                double prom3 = Double.parseDouble(not3);
                double promedio =((prom1+prom2+prom3)/3);




                progressDialog.setMessage("Realizando registro");
                progressDialog.show();


                String id = databaseReference.push().getKey();

                DtoEstudiante dtoestudiante = new DtoEstudiante(id,code,nom,not1,not2,not3,promedio);

                databaseReference.child(id).setValue(dtoestudiante);


                Toast.makeText(MainActivity.this,"Guardado",Toast.LENGTH_LONG).show();

                codigo.setText("");
                nombre.setText("");
                nota1.setText("");
                nota2.setText("");
                nota3.setText("");
                codigo.requestFocus();

                progressDialog.dismiss();

            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
