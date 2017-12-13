package pbl2.cursoandroid.com.pbl2.modelo;

import java.io.Serializable;

/**
 * Created by keciosantos on 11/12/17.
 */

public class Avaliacao implements Serializable {

    private long id;
    private double nParticipacao;
    private double nPresenca;
    private double nComprometimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getnParticipacao() {
        return nParticipacao;
    }

    public void setnParticipacao(double nParticipacao) {
        this.nParticipacao = nParticipacao;
    }

    public double getnPresenca() {
        return nPresenca;
    }

    public void setnPresenca(double nPresenca) {
        this.nPresenca = nPresenca;
    }

    public double getnComprometimento() {
        return nComprometimento;
    }

    public void setnComprometimento(double nComprometimento) {
        this.nComprometimento = nComprometimento;
    }
}
