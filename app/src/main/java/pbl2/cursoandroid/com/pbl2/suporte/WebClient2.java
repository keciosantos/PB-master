package pbl2.cursoandroid.com.pbl2.suporte;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pbl2.cursoandroid.com.pbl2.DAO.AlunoDAO;
import pbl2.cursoandroid.com.pbl2.modelo.Aluno;

import static com.android.volley.Request.Method.GET;

/**
 * Created by rommel on 12/12/17.
 */

public class WebClient2 {

    String baseUrl = "http://raelpx.pythonanywhere.com/api/";
    String url;
    RequestQueue requestQueue;
    static ArrayList<Aluno> listaAluno;
    Aluno aluno;
    AlunoDAO alunoDao;

    public WebClient2(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        alunoDao = new AlunoDAO(context);
    }

    public void listarAluno (){
        url = baseUrl + "alunos";
        listaAluno = new ArrayList<>();
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    aluno = new Aluno();
                                    String id = jsonObject.getString("url");
                                    id = id.replaceFirst("http://raelpx.pythonanywhere.com/api/alunos/", "");
                                    id = id.replaceAll("/", "");
                                    System.out.println("valor a ser inserido no ID " + id);
                                    aluno.setId(Integer.valueOf(id));
                                    aluno.setNome(jsonObject.getString("nome"));
                                    System.out.println("Nome a ser inserido no banco" + aluno.getNome());
                                    alunoDao.insere(aluno);

                                } catch (JSONException e) {
                                    System.out.println(e);
                                }
                            }
                        } else {
                            System.out.println("Deu ruim");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        requestQueue.add(arrayRequest);
    }
}
