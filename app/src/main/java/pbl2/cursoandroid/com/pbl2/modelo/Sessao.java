package pbl2.cursoandroid.com.pbl2.modelo;

import java.io.Serializable;

/**
 * Created by keciosantos on 11/12/17.
 */

public class Sessao implements Serializable {

    private long id;
    private long idAvaliacao;
    private  String nomeTutor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(int nomeTutor) {
//        this.nomeTutor = nomeTutor;
    }
}
