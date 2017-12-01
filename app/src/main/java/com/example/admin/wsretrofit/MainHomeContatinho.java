package com.example.admin.wsretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 30/11/2017.
 */

public class MainHomeContatinho extends AppCompatActivity{

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final Intent it = getIntent();

    final EditText etNome = (EditText) findViewById(R.id.et_nome);
    final EditText etTelefone = (EditText) findViewById(R.id.et_telefone);
    final EditText etInfo = (EditText) findViewById(R.id.et_cpf);
    final EditText etEmail = (EditText) findViewById(R.id.et_mail);
    final Button btList = (Button) findViewById(R.id.bt_list);
//    Contatinho ct = new Contatinho();

//    Button btcad = (Button) findViewById(R.id.bt_cad);
//    Log.d("IDTE", String.valueOf(it.getStringExtra("id") ));
//    if(it.getStringExtra("id") != null){
//        UsuarioDao daos = new UsuarioDao(getApplicationContext());
//        ct = daos.retreaveUsuariosById(Integer.parseInt(it.getStringExtra("id")));
//        etNome.setText(ct.getNome());
//        etInfo.setText(ct.getInfo());
//        etEmail.setText(ct.getEmail());
//        etTelefone.setText(ct.getTelefone());
//    }
//

    btList.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(MainHomeContatinho.this, MainActivity.class);
            startActivity(it);
        }
    });


//    btcad.setOnClickListener(new View.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//            //Pegando atributos
//            String usuarioNome = etNome.getText().toString();
//            String usuarioTelefone= etTelefone.getText().toString();
//            String usuarioEmail = etEmail.getText().toString();
//            String usuarioCpf = etInfo.getText().toString();
//
//            //validando para evitar valores vazios
//            if (usuarioNome == null || usuarioNome.equals("")) {
//                Toast t = Toast.makeText(getApplicationContext(), "Insira um Nome!", Toast.LENGTH_SHORT);
//                t.show();
//            } else if (usuarioTelefone == null || usuarioTelefone.equals("")) {
//                Toast t = Toast.makeText(getApplicationContext(), "Insira o Telefone!", Toast.LENGTH_SHORT);
//                t.show();
//            } else if (usuarioCpf == null || usuarioCpf.equals("")) {
//                Toast t = Toast.makeText(getApplicationContext(), "Insira um cpf!", Toast.LENGTH_SHORT);
//                t.show();
//            } else if (usuarioEmail == null || usuarioEmail.equals("")) {
//                Toast t = Toast.makeText(getApplicationContext(), "Insira um Email", Toast.LENGTH_SHORT);
//                t.show();
//            }
//            else{
//                Usuario usuario = new Usuario();
//                UsuarioDao dao = new UsuarioDao(getApplicationContext());
//                Log.d("cadastrero", String.valueOf(it.getStringExtra("id")));
//                if(String.valueOf(it.getStringExtra("id")) != null) {
//                    usuario.setNome(usuarioNome);
//                    usuario.setTelefone(usuarioTelefone);
//                    usuario.setEmail(usuarioEmail);
//                    usuario.setInfo(usuarioCpf);
//
//
//
//
//                    if(dao.insertUsuario(usuario)) {
//                        Toast.makeText(getApplicationContext(), "Usuario " + usuarioNome + " Cadastrado!", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Usuario " + usuarioNome + " Não foi cadastrado com sucessage", Toast.LENGTH_SHORT).show();
//
//                    }
//                }else{
//                    UsuarioDao daos = new UsuarioDao(getApplicationContext());
//                    Usuario ct = daos.retreaveUsuariosById(Integer.parseInt(it.getStringExtra("id")));
//                    ct.setNome(usuarioNome);
//                    ct.setTelefone(usuarioTelefone);
//                    ct.setEmail(usuarioEmail);
//                    ct.setInfo(usuarioCpf);
//                    Log.d("editero", "Editou");
//                    if(dao.editarUsuario(usuario)) {
//                        Toast.makeText(getApplicationContext(), "Usuario " + usuarioNome + " Cadastrado!", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(getApplicationContext(), "Usuario " + usuarioNome + " Não foi Editado com sucessage", Toast.LENGTH_SHORT).show();
//
//                    }
//
//
//
//
//
//
//
//                }
//            }
//
//        }
//    }
//    );


}
}