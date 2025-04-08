import org.junit.Test;

import com.inscripcion.Alumno;
import com.inscripcion.Inscripcion;
import com.inscripcion.Materia;

import static org.junit.Assert.*;

import java.util.List;


public class InscripcionTest {
    //Materias
    Materia algoritmos = new Materia(List.of() , "Algoritmos" , 2008);
    Materia paradigmas = new Materia(List.of(algoritmos), "Paradigma de programacion" , 2008);
    Materia disenio = new Materia(List.of(paradigmas, algoritmos), "Diseño de Sistemas", 2008);

    //sistema
    Inscripcion siuGuaraniUTN = new Inscripcion(2008);
    //Alumno
    Alumno santi = new Alumno(List.of(algoritmos, paradigmas), List.of(),siuGuaraniUTN , 1, "santiago","cueliche");
    Alumno pablo = new Alumno(List.of(algoritmos), List.of(), siuGuaraniUTN, 2, "pablo","cueliche" );
 
    @Test 
    public void inscripcion_santi_disenio(){
        assertTrue("Santi deberia poder inscribirse" , santi.solicitud_inscripcion(disenio));
    }
    
    @Test
    public void inscripcion_santi_algoritmos(){
        assertFalse("Santi deberia NO poder inscribirse", santi.solicitud_inscripcion(algoritmos));
    }

    @Test
    public void inscripcion_pablo_disenio(){
        assertFalse("No deberia poder incribirse en disenio", pablo.solicitud_inscripcion(disenio));
    }

    @Test
    public void inscripcion_pablo_paradigmas(){
        assertTrue("Pablo deberia poder inscribirse en paradigmas", pablo.solicitud_inscripcion(paradigmas));
    }
}
