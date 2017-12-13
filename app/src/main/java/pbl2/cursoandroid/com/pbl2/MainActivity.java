package pbl2.cursoandroid.com.pbl2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import pbl2.cursoandroid.com.pbl2.suporte.WebClient2;

public class MainActivity extends AppCompatActivity {
    private ImageView turmas;
    private ImageView alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turmas =findViewById(R.id.imgTurmaId);
        alunos = findViewById(R.id.imgAlunosId);

        alunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AlunosActivity.class));
            }
        });

        turmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TurmaActivity.class));
            }
        });

    }
}
