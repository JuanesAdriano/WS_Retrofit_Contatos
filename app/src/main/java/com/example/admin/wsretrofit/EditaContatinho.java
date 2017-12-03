package com.example.admin.wsretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.wsretrofit.api.Server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditaContatinho extends AppCompatActivity {

    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_contatinho);

        final EditText etNome = (EditText) findViewById(R.id.etName);
        final EditText etTel = (EditText) findViewById(R.id.etTel);
        final EditText etInfo = (EditText) findViewById(R.id.etInfo);
        Button btUpdate = (Button) findViewById(R.id.btUpdate);

        Intent it = getIntent();
        if(it != null){
            Bundle dados = it.getExtras();
            if(dados != null){
                etNome.setText(dados.getString("nome"));
                etTel.setText(dados.getString("telefone"));
                etInfo.setText(dados.getString("info"));
                id = dados.getInt("id");
            }
        }

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = etNome.getText().toString();
                String telefone= etTel.getText().toString();
                String info = etInfo.getText().toString();

                if (nome == null || nome.equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Insira um Nome!", Toast.LENGTH_SHORT);
                    t.show();
                } else if (telefone == null || telefone.equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Insira o Telefone!", Toast.LENGTH_SHORT);
                    t.show();
                } else if (info == null || info.equals("")) {
                    Toast t = Toast.makeText(getApplicationContext(), "Insira um cpf!", Toast.LENGTH_SHORT);
                    t.show();
                }else {
                    IContatinho sv = Server.getClient().create(IContatinho.class);
                Call<Contatinho> update = sv.alterar(nome, telefone, info, id);
                update.enqueue(new Callback<Contatinho>() {
                    @Override
                    public void onResponse(Call<Contatinho> call, Response<Contatinho> response) {
                        Toast t = Toast.makeText(getApplicationContext(), "Contatinho Alterado com Successo!", Toast.LENGTH_SHORT);
                        t.show();
                        Intent it = new Intent(EditaContatinho.this, MainActivity.class);
                        startActivity(it);
                    }

                    @Override
                    public void onFailure(Call<Contatinho> call, Throwable t) {
                        Toast t1 = Toast.makeText(getApplicationContext(), "Mudo é nada. chá era.", Toast.LENGTH_SHORT);
                        t1.show();
                    }
                });
                }
            }
        });






    }
}
