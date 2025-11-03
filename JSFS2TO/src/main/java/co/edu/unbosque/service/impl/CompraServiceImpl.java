package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Compra;
import co.edu.unbosque.repository.CompraRepository;
import co.edu.unbosque.service.api.CompraServiceAPI;

@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Long> implements CompraServiceAPI {

    @Autowired
    private CompraRepository CompraRepository;

    @Override
    public CrudRepository<Compra, Long> getDao() {
        return CompraRepository;
    }
}