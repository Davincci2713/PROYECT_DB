package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Factura;
import co.edu.unbosque.repository.FacturaRepository;
import co.edu.unbosque.service.api.FacturaServiceAPI;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Long> implements FacturaServiceAPI {

    @Autowired
    private FacturaRepository FacturaRepository;

    @Override
    public CrudRepository<Factura, Long> getDao() {
        return FacturaRepository;
    }
}