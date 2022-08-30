package services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import model.Persona;
import org.json.JSONObject;

/**
 * @author Giancarlo Valencia Sotomayor Consumo de apis DNI y RUC de
 * https://apiperu.dev/ ************* Unirest *************
 */
public class ReniecS2 {

    public static JSONObject buscarDni(Persona per) throws Exception {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://apiperu.dev/api/dni/41298813")
                .header("Authorization", "Bearer 6c963d5109585ed9e893ff72ef0707bdb482d81c1d276683381919161691ccf2")
                .header("Content-Type", "application/json")
                .asString();
        JSONObject jsonObject = new JSONObject(response.getBody().toString());
        JSONObject cadenaJson = jsonObject.getJSONObject("data");
        return cadenaJson;
    }

    public static void main(String[] args) {
        try {
            Persona per = new Persona();
            per.setDni("41298813");
            JSONObject cadenaJson = ReniecS2.buscarDni(per);
            System.out.println("nombre completo: " + cadenaJson.getString("nombre_completo"));
        } catch (Exception e) {
            System.out.println("Error en obtenerJsonDNI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
