package pbl2.cursoandroid.com.pbl2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pbl2.cursoandroid.com.pbl2.modelo.Aluno;

/**
 * Created by keciosantos on 11/12/17.
 */

public class AlunoAdapter extends BaseAdapter {

    List<Aluno> alunos;
    Activity activity;

    public AlunoAdapter(List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Aluno aluno = alunos.get(i);

        LayoutInflater inflater = activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.itens, null);

        TextView nome = (TextView) linha.findViewById(R.id.NomeId);
        nome.setText(aluno.getNome());

        return linha;
    }

}
