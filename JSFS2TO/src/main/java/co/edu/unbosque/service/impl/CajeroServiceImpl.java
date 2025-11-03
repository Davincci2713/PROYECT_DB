package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Cajero;
import co.edu.unbosque.repository.CajeroRepository;
import co.edu.unbosque.service.api.CajeroServiceAPI;

@Service
public class CajeroServiceImpl extends GenericServiceImpl<Cajero, Long> implements CajeroServiceAPI {

    @Autowired
    private CajeroRepository CajeroRepository;

    @Override
    public CrudRepository<Cajero, Long> getDao() {
        return CajeroRepository;
    }
}