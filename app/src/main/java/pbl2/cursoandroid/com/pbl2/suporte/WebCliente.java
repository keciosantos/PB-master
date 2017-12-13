package pbl2.cursoandroid.com.pbl2.suporte;


import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by keciosantos on 11/12/17.
 */

public class WebCliente {

    private URI uri;
    private String url;

    public WebCliente(String url){
        this.url = url;
    }

    public String post(String json) throws IOException {

        URL url = new URL("http://raelpx.pythonanywhere.com/api/alunos/");

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        connection.setDoOutput(true);


        PrintStream printStream =
                new PrintStream(connection.getOutputStream());
        printStream.println(json);

        connection.connect();

        String jsonDeResposta =
                new Scanner(connection.getInputStream()).next();

        return jsonDeResposta;
    }

    public String get() throws IOException {

        URL url = new URL("http://raelpx.pythonanywhere.com/api/alunos/");

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", "application/json");

        connection.connect();

        String jsonDeResposta =
                new Scanner(connection.getInputStream()).next();



        return jsonDeResposta;
    }
}
