package cl.duoc.start_up.service;

import cl.duoc.start_up.model.Departamento;
import cl.duoc.start_up.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository DepartamentoRepository;

    public List<Departamento> findAll(){
        return DepartamentoRepository.findAll();
    }

    public Optional<Departamento> findById(String codigo){
        return DepartamentoRepository.findById(codigo);
    }

    public Departamento save(Departamento Departamento){
        return DepartamentoRepository.save(Departamento);
    }

    public void delete(String codigo){
        DepartamentoRepository.deleteById(codigo);
    }
}
