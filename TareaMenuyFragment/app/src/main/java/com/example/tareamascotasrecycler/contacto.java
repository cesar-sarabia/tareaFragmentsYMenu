package com.example.tareamascotasrecycler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tareamascotasrecycler.utilities.TLSEmail;


public class contacto extends AppCompatActivity {

    private EditText edtName;
    private EditText edtMail;
    private EditText edtMessage;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        edtName = findViewById(R.id.tieNombre);
        edtMail= findViewById(R.id.tieEmail);
        edtMessage=findViewById(R.id.tieDescripcion);
        btnSend= findViewById(R.id.btnEviarMail);

        Toolbar toolbarContac= findViewById(R.id.toolBarContact);
        setSupportActionBar(toolbarContac);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sendMail();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void sendMail() throws Exception {
        String nombre= edtName.getText().toString().trim();
        String correo = edtMail.getText().toString().trim();
        String mensaje = edtMessage.getText().toString().trim();
        TLSEmail sender = new TLSEmail("aqui colocar su correo de gmail","aqui colocar clave");
        sender.senMail("tarea de android", mensaje,correo);
    }
}
