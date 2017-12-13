package pbl2.cursoandroid.com.pbl2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pbl2.cursoandroid.com.pbl2.DAO.AlunoDAO;
import pbl2.cursoandroid.com.pbl2.modelo.Aluno;

public class Formulario extends Activity {
    private FormularioHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        helper = new FormularioHelper(this);
        final Aluno alunoParaSerAlterado = (Aluno) getIntent().getSerializableExtra("alunoSelecionado");
        if (alunoParaSerAlterado != null){
            helper.colocarAlunoNoFormulario(alunoParaSerAlterado);
        }
        final Button botao = findViewById(R.id.botaoCadastrarId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Formulario.this,"Clicou no botão",
                        Toast.LENGTH_SHORT).show();
                Aluno aluno = helper.pegaAlunoAlunoDoFormulario();
                AlunoDAO alunoDAO = new AlunoDAO(Formulario.this);
                if (alunoParaSerAlterado != null){
                    aluno.setId((alunoParaSerAlterado.getId()));
                    botao.setText("Alterar");
                    alunoDAO.insere(aluno);
                }else {
                    alunoDAO.insere(aluno);
                }
                alunoDAO.close();
                finish();
            }
        });

    }
}
