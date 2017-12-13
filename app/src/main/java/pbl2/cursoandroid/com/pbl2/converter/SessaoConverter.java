package pbl2.cursoandroid.com.pbl2.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Avaliacao;
import pbl2.cursoandroid.com.pbl2.modelo.Sessao;

/**
 * Created by keciosantos on 11/12/17.
 */

public class SessaoConverter {
    public String toJSON(List<Sessao> sessoes){
        JSONStringer js = new JSONStringer();
        try{
            js.object().key("list").array();
            js.object().key("avaliacao").array();
            for (Sessao sessao:sessoes){
                js.key("IdAvaliacao").value(sessao.getIdAvaliacao());
                js.key("NomeTutor").value(sessao.getNomeTutor());
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
