package com.inscripcion;


import java.util.List;
import java.util.stream.Collectors;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {
    List<Materia> materias_aprobadas;
    List<Materia> materias_inscriptas;
    Inscripcion sistema_inscripcion;
    int legajo;
    String nombre;
    String apellido;
    

    public boolean solicitud_inscripcion(Materia materia){
        return !this.tiene_aprobada(materia) && sistema_inscripcion.aprobada(materia, this);
    }

    public void inscribir(Materia materia){
        if(this.solicitud_inscripcion(materia) == true){
            materias_aprobadas.add(materia);
            System.out.println("Incripcion exitosa en: " + materia.getNombre());        
        }
        else System.out.println("Ocurrio un error, verifique nuevamente.");
    }
    
    public boolean tiene_aprobada(Materia materia){
        return materias_aprobadas.contains(materia);
    }

    public List<Materia> materias_disponibles(){
        List<Materia> materias = materias_aprobadas.stream().flatMap(materia -> materia.correlativas().stream()).distinct().collect(Collectors.toList()) ;
        return materias;
    }    
}
