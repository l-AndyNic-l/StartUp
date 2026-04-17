package cl.duoc.start_up.service;

import cl.duoc.start_up.dto.TrabajadorDTO;
import cl.duoc.start_up.model.Trabajador;
import cl.duoc.start_up.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<TrabajadorDTO> findAll () {
        List<Trabajador> trabajadores = trabajadorRepository.findAll();
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversion( t ) );
        }
        return lista;
    }

    public TrabajadorDTO findOne ( Long id ) {
        Trabajador t = trabajadorRepository.findById( id ).orElse( null );
        return conversion( t );
    }

    public Trabajador save ( Trabajador t ) {
        if(
                t.getEspecialidad().equalsIgnoreCase( "Desarrollo" ) ||
                t.getEspecialidad().equalsIgnoreCase( "Administración" ) ||
                t.getEspecialidad().equalsIgnoreCase( "Testing" )
        ) {
            return trabajadorRepository.save( t );
        } else {
            throw new RuntimeException( "ERROR! La especialidad debe ser [Desarrollo, Administración, Testing]" );
        }
    }

    public void delete ( Long id ) {
        trabajadorRepository.deleteById( id );
    }

    public TrabajadorDTO conversion ( Trabajador t ) {
        TrabajadorDTO t_dto = new TrabajadorDTO();
        LocalDate fechaActual = LocalDate.now();
        double anios = ChronoUnit.MONTHS.between( t.getFechaContrato(), fechaActual ) / 12;
        NumberFormat nf = NumberFormat.getInstance( new Locale( "es", "CL" ));

        t_dto.setId( t.getId() );
        t_dto.setNombreCompleto( t.getNombre() + ' ' + t.getApellido() );
        t_dto.setTiempoExperiencia(
                (long) anios
                + " años y " +
                Math.round( anios - anios )
                + " mese"
        );
        t_dto.setSueldo( "$" + nf.format( t.getSueldo() ) );
        t_dto.setEspecialidad( t.getEspecialidad() );
        t_dto.setNombreDepartamento( t.getDepartamento().getNombre() );

        return t_dto;
    }

}
