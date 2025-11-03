package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Gerente;
import co.edu.unbosque.repository.GerenteRepository;
import co.edu.unbosque.service.api.GerenteServiceAPI;

@Service
public class GerenteServiceImpl extends GenericServiceImpl<Gerente, Long> implements GerenteServiceAPI {

    @Autowired
    private GerenteRepository GerenteRepository;

    @Override
    public CrudRepository<Gerente, Long> getDao() {
        return GerenteRepository;
    }
}