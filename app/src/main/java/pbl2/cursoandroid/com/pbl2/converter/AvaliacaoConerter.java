package pbl2.cursoandroid.com.pbl2.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Aluno;
import pbl2.cursoandroid.com.pbl2.modelo.Avaliacao;

/**
 * Created by keciosantos on 11/12/17.
 */

public class AvaliacaoConerter {

    public String toJSON(List<Avaliacao> avalicoes){
        JSONStringer js = new JSONStringer();
        try{
            js.object().key("list").array();
            js.object().key("avaliacao").array();
            for (Avaliacao avaliacao:avalicoes){
                js.key("nParticipacao").value(avaliacao.getnParticipacao());
                js.key("nPresenca").value(avaliacao.getnPresenca());
                js.key("nComprometimento").value(avaliacao.getnComprometimento());
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
