package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Limpieza;
import co.edu.unbosque.repository.LimpiezaRepository;
import co.edu.unbosque.service.api.LimpiezaServiceAPI;

@Service
public class LimpiezaServiceImpl extends GenericServiceImpl<Limpieza, Long> implements LimpiezaServiceAPI {

    @Autowired
    private LimpiezaRepository LimpiezaRepository;

    @Override
    public CrudRepository<Limpieza, Long> getDao() {
        return LimpiezaRepository;
    }
}