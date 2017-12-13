package pbl2.cursoandroid.com.pbl2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pbl2.cursoandroid.com.pbl2.DAO.AlunoDAO;
import pbl2.cursoandroid.com.pbl2.modelo.Aluno;
import pbl2.cursoandroid.com.pbl2.suporte.WebClient2;

public class ListaAlunosActivity extends Activity {
    protected ListView lista;
    Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        AlunoDAO alunoDAO = new AlunoDAO(getApplicationContext());
        lista = findViewById(R.id.listaId);
        registerForContextMenu(lista);

        WebClient2 client = new WebClient2(getApplicationContext());
        alunoDAO.limparTabela();
        client.listarAluno();
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) alunoDAO.getLista();
        System.out.println("Lista de Alunos "+listaAlunos.size());
        for (Aluno aluno : listaAlunos){
            System.out.println(aluno.getNome());
        }
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1
                , listaAlunos);

        lista.setAdapter(adapter);


        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {

                return false;
            }
        });
    }
}
