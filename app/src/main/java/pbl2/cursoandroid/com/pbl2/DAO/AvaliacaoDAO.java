package pbl2.cursoandroid.com.pbl2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Avaliacao;

/**
 * Created by keciosantos on 11/12/17.
 */

public class AvaliacaoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoPBL";
    private static final int VERSAO = 1;
    private static final String TABELA = "Avaliacao";

    public AvaliacaoDAO(Context ctx) {
        super(ctx, DATABASE, null, VERSAO);

    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =  "CREATE TABLE IF NOT EXISTS "+TABELA +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nParticipacao DOUBLE, " +
                "nPresenca DOUBLE, " +
                "nComprometimento DOUBLE,";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS" + TABELA;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insere(Avaliacao avaliacao){
        ContentValues values = new ContentValues();
        values.put("nParticipacao",avaliacao.getnParticipacao());
        values.put("nPresenca", avaliacao.getnPresenca());
        values.put("nComprometimento",avaliacao.getnComprometimento());

        getWritableDatabase().insert(TABELA,null,values);

    }
    public List<Avaliacao> getListaAvalicao(){
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM" + TABELA + ";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            Avaliacao avaliacao= new Avaliacao();
            avaliacao.setId(cursor.getColumnIndex("id"));
            avaliacao.setnParticipacao(cursor.getColumnIndex("participação"));
            avaliacao.setnPresenca(cursor.getColumnIndex("presenca"));
            avaliacao.setnComprometimento(cursor.getColumnIndex("comprometimento"));
            avaliacoes.add(avaliacao);
        }
        return avaliacoes;
    }

    public void deletar(Avaliacao avaliacao){
        String[] args = {""+ avaliacao.getId()};
        getWritableDatabase().delete(TABELA,"id=?",args);
    }
    public void atualizar(Avaliacao avaliacao){
        ContentValues values = new ContentValues();
        values.put("nParticipacao",avaliacao.getnParticipacao());
        values.put("nPresenca", avaliacao.getnPresenca());
        values.put("nComprometimento",avaliacao.getnComprometimento());
        String args[] = {""+avaliacao.getId()};
        getWritableDatabase().update("Avaliacao", values,"id=?", args);

    }

}
