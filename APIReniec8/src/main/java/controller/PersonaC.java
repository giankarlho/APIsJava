package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.Persona;
import services.ReniecS;

@Data
@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    Persona persona;

    public PersonaC() {
        persona = new Persona();
    }

    public void buscarDNI() {
        try {            
            ReniecS.buscarDni(persona);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "DNI no encontrado"));
            System.out.println("error en Busqueda DNI" + e.getMessage());
        }
    }

    public void buscarRUC() {
        try {            
            ReniecS.buscarRuc(persona);            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "RUC no encontrado"));
            System.out.println("error en Busqueda RUC" + e.getMessage());
        }
    }

}
