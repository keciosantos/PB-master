package pbl2.cursoandroid.com.pbl2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Aluno;
import pbl2.cursoandroid.com.pbl2.modelo.Sessao;

/**
 * Created by keciosantos on 11/12/17.
 */

public class SessaoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "BancoPBL";
    private static final int VERSAO = 1;
    private static final String TABELA = "Sessao";

    public SessaoDAO(Context ctx) {
        super(ctx, DATABASE, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =  "CREATE TABLE IF NOT EXISTS "+TABELA +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeTutor VARCHAR," +
                "idAvaliacao INTEGER ," +
                "FOREIGN KEY(idAvaliacao) REFERENCES Avaliacao(id))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS" + TABELA;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insere(Sessao sessao){
        ContentValues values = new ContentValues();
        values.put("idAvaliacao",sessao.getIdAvaliacao());
        values.put("NomeTutor", String.valueOf(sessao.getNomeTutor()));

        getWritableDatabase().insert(TABELA,null,values);

    }
    public List<Sessao> getLista(){
        ArrayList<Sessao> sessoes = new ArrayList<>();
        String sql = "SELECT * FROM" + TABELA + ";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            Sessao sessao = new Sessao();
            sessao.setId(cursor.getColumnIndex("id"));
            sessao.setIdAvaliacao(cursor.getColumnIndex("IdAvaliacao"));
            sessao.setNomeTutor(cursor.getColumnIndex("NomeTutor"));

            sessoes.add(sessao);
        }
        return sessoes;
    }

    public void deletar(Sessao sessao){
        String[] args = {""+ sessao.getId()};
        getWritableDatabase().delete(TABELA,"id=?",args);
    }
    public void atualizar(Sessao sessao){
        ContentValues values = new ContentValues();
        values.put("idAvaliacao",sessao.getIdAvaliacao());
        values.put("NomeTutor", String.valueOf(sessao.getNomeTutor()));
        String args[] = {""+sessao.getId()};
        getWritableDatabase().update("Sessao", values,"id=?", args);

    }

}
