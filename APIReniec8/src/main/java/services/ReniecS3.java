package services;

import model.Persona;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/**
 *
 * @author Giancarlo Valencia Sotomayor
 *
 * Consumo de apis DNI y RUC de https://apiperu.dev/
 *
 */

public class ReniecS3 {

    public static JSONObject buscarDni(Persona per) throws Exception {
        
        String token = "6c963d5109585ed9e893ff72ef0707bdb482d81c1d276683381919161691ccf2";                
        
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://apiperu.dev/api/dni/" + per.getDni())                
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject cadenaJson = jsonObject.getJSONObject("data");                                                             
        return cadenaJson;
    }

    public static void main(String[] args) {
        try {
            Persona per = new Persona();
            per.setDni("41298813");
            JSONObject cadenaJson = ReniecS3.buscarDni(per); 
            System.out.println("nombre completo: " + cadenaJson.getString("nombre_completo"));                        
        } catch (Exception e) {
            System.out.println("Error en obtenerJsonDNI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

//Response: Body
//        
//{
//    "success": true,
//    "data": {
//        "numero": "41298813",
//        "nombre_completo": "VALENCIA SOTOMAYOR, GIANCARLO",
//        "nombres": "GIANCARLO",
//        "apellido_paterno": "VALENCIA",
//        "apellido_materno": "SOTOMAYOR",
//        "ubigeo_sunat": null,
//        "ubigeo": [
//            null,
//            null,
//            null
//        ]
//    },
//    "source": "apiperu.dev"
//}
