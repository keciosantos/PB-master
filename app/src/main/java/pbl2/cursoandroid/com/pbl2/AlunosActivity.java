package pbl2.cursoandroid.com.pbl2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pbl2.cursoandroid.com.pbl2.suporte.WebClient2;

public class AlunosActivity extends AppCompatActivity {
    private ImageView addAluno;
    private ImageView buscarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alunos);

        addAluno = findViewById(R.id.imgAddAlunoId);
        buscarAluno = findViewById(R.id.imgBuscarAluno);


        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlunosActivity.this, Formulario.class ));
            }

        });
        buscarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(AlunosActivity.this,ListaAlunosActivity.class));
            }
        });
    }
}
