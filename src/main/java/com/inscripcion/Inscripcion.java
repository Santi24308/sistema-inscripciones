package com.inscripcion;

import java.util.List;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscripcion {
    private int plan_de_estudio;



        public  boolean aprobada(Materia materia, Alumno alumno){
            List<Materia> materias_correlativas = materia.correlativas();
            List<Materia> materias_del_alumno   = alumno.getMaterias_aprobadas();
            return materia.materia_base() || materias_del_alumno.containsAll(materias_correlativas);
        }

    }
    


