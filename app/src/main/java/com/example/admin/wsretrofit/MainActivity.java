package com.example.admin.wsretrofit;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.wsretrofit.api.Server;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String nome[];
    String telefone[];
    String info[];
    String id[];

//    Contatinho contatinho = new Contatinho();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatinho_list);
        ListView userList = (ListView) findViewById(R.id.usuarioList);

        retreave();


        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view.findViewById(R.id.id);
                final Integer  id = Integer.parseInt(textView.getText().toString());
                IContatinho sv = Server.getClient().create(IContatinho.class);
                Call<Contatinho> deleteContato = sv.delete(id);
                deleteContato.enqueue(new Callback<Contatinho>() {
                                          @Override
                                          public void onResponse(Call<Contatinho> call, Response<Contatinho> response) {
                                                if(response.code() == 200){
                                              Toast t = Toast.makeText(getApplicationContext(), "Foi pro beleléuss"+id+"", Toast.LENGTH_SHORT);
                                              t.show();

                                              retreave();}else{
                                                    Toast t3 = Toast.makeText(getApplicationContext(), "Erou "+response.code()+"", Toast.LENGTH_SHORT);
                                                    t3.show();
                                                }
                                          }

                                          @Override
                                          public void onFailure(Call<Contatinho> call, Throwable t) {
                                              Toast t2 = Toast.makeText(getApplicationContext(), "Desiste da crush não doido!", Toast.LENGTH_SHORT);
                                              t2.show();
                                          }
                                      });



                return true;
            }
        });
    }

    public void retreave() {
        IContatinho sv = Server.getClient().create(IContatinho.class);
        Call<ArrayList<Contatinho>> getAllContatos = sv.listaTodos();

        getAllContatos.enqueue(new Callback<ArrayList<Contatinho>>() {
            @Override
            public void onResponse(Call<ArrayList<Contatinho>> call, Response<ArrayList<Contatinho>> response) {
                List<Contatinho> contatinhos = response.body();
                id = new String[contatinhos.size()];
                nome = new String[contatinhos.size()];
                telefone = new String[contatinhos.size()];
                int i = 0;
                for (Contatinho c : contatinhos) {
                    id[i] = String.valueOf(c.getId());
                    nome[i] = c.getNome();
                    telefone[i] = c.getTelefone();
                    i++;
                }
                ListView listView = (ListView) findViewById(R.id.usuarioList);
                Adapter adapter = new Adapter(getApplicationContext(), id, nome, telefone);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Contatinho>> call, Throwable t) {

            }
        });

    }

    private class Adapter extends ArrayAdapter<String> {
        Context context;
        int[] img;
        String id[];
        String nome[];
        String telefone[];

        Adapter(Context c, String[] id, String[] nome, String[] telefone) {
            super(c, R.layout.row, R.id.id, nome);
            this.img = img;
            this.id = id;
            this.nome = nome;
            this.telefone = telefone;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);

            TextView textViewNome = row.findViewById(R.id.contatoNome);
            TextView textId = row.findViewById(R.id.id);
            TextView textViewTelefone = row.findViewById(R.id.contatoTelefone);
            textViewNome.setText(nome[position]);
            textId.setText(id[position]);
            textViewTelefone.setText(telefone[position]);
            return row;
        }


    }
}