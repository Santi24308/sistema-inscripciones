package com.inscripcion;


import java.util.List;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
    private List<Materia> materias_correlativas;
    private String nombre; 
    private int plan; 
    
    //Seria como un getter pero con otro nombre mas declarativo 
    public List<Materia> correlativas() {
        return materias_correlativas;
    }
    public  boolean materia_base(){
        return materias_correlativas.size()== 0;
    }
    
}
