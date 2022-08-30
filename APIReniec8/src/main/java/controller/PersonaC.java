package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.Persona;
import org.json.JSONObject;

import services.ReniecS1;
import services.ReniecS2;
import services.ReniecS3;

@Data
@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    Persona persona;

    public PersonaC() {
        persona = new Persona();
    }

    public void buscarDNI1() {
        try {
            ReniecS1.buscarDni(persona);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "DNI no encontrado"));
            System.out.println("error en Busqueda DNI" + e.getMessage());
        }
    }

    public void buscarRUC() {
        try {
            ReniecS1.buscarRuc(persona);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "RUC no encontrado"));
            System.out.println("error en Busqueda RUC" + e.getMessage());
        }
    }

    public void buscarDNI2() {
        try {
            JSONObject cadenaJson = ReniecS2.buscarDni(persona);
            persona.setApePaterno(cadenaJson.getString("apellido_paterno"));
            persona.setApeMaterno(cadenaJson.getString("apellido_materno"));
            persona.setNombre(cadenaJson.getString("nombres"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "DNI no encontrado"));
            System.out.println("error en Busqueda DNI" + e.getMessage());
        }
    }

    public void buscarDNI3() {
        try {
            JSONObject cadenaJson = ReniecS3.buscarDni(persona);
            persona.setApePaterno(cadenaJson.getString("apellido_paterno"));
            persona.setApeMaterno(cadenaJson.getString("apellido_materno"));
            persona.setNombre(cadenaJson.getString("nombres"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "DNI no encontrado"));
            System.out.println("error en Busqueda DNI" + e.getMessage());
        }
    }

}
