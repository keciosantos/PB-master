package pbl2.cursoandroid.com.pbl2;

import android.widget.EditText;
import android.widget.RatingBar;

import pbl2.cursoandroid.com.pbl2.modelo.Aluno;

/**
 * Created by keciosantos on 11/12/17.
 */

public class FormularioHelper {

    private EditText campoNome;
    private EditText campoAno;
    private EditText campoSemestre;
    private RatingBar campoParticipacao;
    private RatingBar campoPresenca;
    private RatingBar campoComprometimento;

    private Aluno aluno;

    public FormularioHelper(Formulario activity){
        aluno= new Aluno();
        campoNome = activity.findViewById(R.id.NomeId);
        campoAno = activity.findViewById(R.id.AnoId);
        campoSemestre = activity.findViewById(R.id.SemestreId);
        campoParticipacao = activity.findViewById(R.id.ParticipacaoId);
        campoPresenca = activity.findViewById(R.id.PresencaId);
        campoComprometimento = activity.findViewById(R.id.ComprometimentoId);
    }
    public Aluno pegaAlunoAlunoDoFormulario(){
        aluno.setNome(campoNome.getText().toString());
        aluno.setAno(campoAno.getText().toString());
        aluno.setSemestre(Integer.parseInt(campoSemestre.getText().toString()));
//        aluno.setParticipacao(Double.valueOf(campoParticipacao.getRating()));
//        aluno.setPresenca(Double.valueOf(campoPresenca.getRating()));
//        aluno.setComprometimento(Double.valueOf(campoComprometimento.getRating()));
        return aluno;
    }
    public void colocarAlunoNoFormulario(Aluno alunoParaSerAlterado){
        aluno = alunoParaSerAlterado;
        campoNome.setText(alunoParaSerAlterado.getNome());
        campoAno.setText(alunoParaSerAlterado.getAno());
        campoSemestre.setText(alunoParaSerAlterado.getSemestre());
//        campoParticipacao.setRating((float) alunoParaSerAlterado.getParticipacao());
//        campoPresenca.setRating((float) alunoParaSerAlterado.getPresenca());
//        campoComprometimento.setRating((float) alunoParaSerAlterado.getComprometimento());

    }

}
