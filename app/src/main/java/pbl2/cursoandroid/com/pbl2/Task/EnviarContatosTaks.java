package pbl2.cursoandroid.com.pbl2.Task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import pbl2.cursoandroid.com.pbl2.DAO.AlunoDAO;
import pbl2.cursoandroid.com.pbl2.converter.AlunoConverter;
import pbl2.cursoandroid.com.pbl2.modelo.Aluno;
import pbl2.cursoandroid.com.pbl2.suporte.WebCliente;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by keciosantos on 11/12/17.
 */

public class EnviarContatosTaks extends AsyncTask<Object, Object ,String> {

    Context ctx;
    ProgressDialog progressDialog;

    public EnviarContatosTaks(Context ctx){
        this.ctx =ctx;
    }

    @Override
    protected void onPreExecute(){
        progressDialog = ProgressDialog.show(ctx, "Aguarde...", "Enviando dados para o servidor");
    }


    @Override
    protected String doInBackground(Object... objects) {

        AlunoDAO dao = new AlunoDAO(ctx);
        List<Aluno> alunos = dao.getLista();
        String json = new AlunoConverter().toJSON(alunos);
        try {
            String media = new WebCliente("http://raelpx.pythonanywhere.com/api/alunos/").post(json);
            return media;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String media){
        progressDialog.dismiss();
        Toast.makeText(ctx, media , Toast.LENGTH_LONG).show();
    }
}
