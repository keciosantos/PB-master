package pbl2.cursoandroid.com.pbl2.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Aluno;

/**
 * Created by keciosantos on 11/12/17.
 */

public class AlunoConverter {

    public String toJSON(List<Aluno> alunos){
        JSONStringer js = new JSONStringer();
        try{
            js.object().key("list").array();
            js.object().key("aluno").array();
            for (Aluno aluno:alunos){
                js.key("nome").value(aluno.getNome());
                js.key("ano").value(aluno.getAno());
                js.key("semestre").value(aluno.getSemestre());
                js.key("idTurma").value(aluno.getIdTurma());
                js.endObject();
            }
            js.endArray().endObject();
            js.endArray().endObject();
        }catch (JSONException e){
            e.printStackTrace();
        }
        return js.toString();
    }
}
