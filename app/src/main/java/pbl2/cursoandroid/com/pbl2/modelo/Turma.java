package pbl2.cursoandroid.com.pbl2.modelo;

import java.io.Serializable;

/**
 * Created by keciosantos on 11/12/17.
 */

public class Turma implements Serializable {

    private long id;
    private String nome;
    private long idSessao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(long idSessao) {
        this.idSessao = idSessao;
    }
}
