package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Persona;
import co.edu.unbosque.repository.PersonaRepository;
import co.edu.unbosque.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }
}