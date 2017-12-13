package pbl2.cursoandroid.com.pbl2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Turma;

/**
 * Created by keciosantos on 11/12/17.
 */

public class TurmaDAO extends SQLiteOpenHelper {


    private static final String DATABASE = "BancoPBL";
    private static final int VERSAO = 1;
    private static final String TABELA = "Turma";

    public TurmaDAO(Context ctx) {
        super(ctx, DATABASE, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =  "CREATE TABLE IF NOT EXISTS "+TABELA +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR," +
                "idsessao INTEGER ," +
                "FOREIGN KEY(idsessao) REFERENCES Sessao(id))";
        sqLiteDatabase.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS" + TABELA;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public List<Turma> getLista(){
        ArrayList<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM" + TABELA + ";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            Turma turma = new Turma();
            turma.setId(cursor.getColumnIndex("id"));
            turma.setNome(String.valueOf(cursor.getColumnIndex("nome")));
            turma.setIdSessao(cursor.getColumnIndex("idSessao"));
            turmas.add(turma);
        }
        return turmas;
    }

    public void deletar(Turma turma){
        String[] args = {""+ turma.getId()};
        getWritableDatabase().delete(TABELA,"id=?",args);
    }
    public void atualizar(Turma turma){
        ContentValues values = new ContentValues();
        values.put("nome",turma.getNome());
        values.put("idSessao", turma.getIdSessao());
        String args[] = {""+turma.getId()};
        getWritableDatabase().update("Turma", values,"id=?", args);

    }

}
