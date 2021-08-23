package model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Persona implements Serializable {

    // Persona natural
    String dni;
    String nombre;
    String apePaterno;
    String apeMaterno;
    
    // Persona jurídica
    String ruc;
    String razon;
    String dirección;
    String ubigeo;
}
