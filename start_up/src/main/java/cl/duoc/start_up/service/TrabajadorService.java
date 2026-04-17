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
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public TrabajadorDTO findOne ( Long id ) {
        Trabajador t = trabajadorRepository.findById( id ).orElse( null );
        return conversionDTO( t );
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

    public TrabajadorDTO conversionDTO ( Trabajador t ) {
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

    public TrabajadorDTO findByEmail ( String e ) {
        Trabajador t = trabajadorRepository.findByEmail( e );
        return conversionDTO( t );
    }

    public List<TrabajadorDTO> findAllByEspecialidad ( String e ) {
        List<Trabajador> trabajadores = trabajadorRepository.findAllByEspecialidad( e );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public List<TrabajadorDTO> findAllByDepartamento_Codigo ( String cod ) {
        List<Trabajador> trabajadores = trabajadorRepository.findAllByDepartamento_Codigo( cod );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public List<TrabajadorDTO> findSueldoMayor ( int sld ) {
        List<Trabajador> trabajadores = trabajadorRepository.findSueldoMayor( sld );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public List<TrabajadorDTO> findSueldoMenor ( int sld ) {
        List<Trabajador> trabajadores = trabajadorRepository.findSueldoMenor( sld );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public List<TrabajadorDTO> findSueldoEntre ( int sld_a, int sld_b ) {
        List<Trabajador> trabajadores = trabajadorRepository.findSueldoEntre( sld_a, sld_b );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public List<TrabajadorDTO> findAllExperiencia ( int e ) {
        List<Trabajador> trabajadores = trabajadorRepository.findAllExperiencia( e );
        List<TrabajadorDTO> lista = new ArrayList<>();

        for( Trabajador t : trabajadores ) {
            lista.add( conversionDTO( t ) );
        }
        return lista;
    }

    public int findSueldoDepartamento ( String cod ) {
        return trabajadorRepository.findSueldoDepartamento( cod );
    }

}
