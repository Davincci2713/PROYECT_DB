package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.DetalleFactura;
import co.edu.unbosque.entity.DetalleFacturaId;
import co.edu.unbosque.repository.DetalleFacturaRepository;
import co.edu.unbosque.service.api.DetalleFacturaServiceAPI;

@Service
public class DetalleFacturaServiceImpl extends GenericServiceImpl<DetalleFactura, DetalleFacturaId> implements DetalleFacturaServiceAPI {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public CrudRepository<DetalleFactura, DetalleFacturaId> getDao() {
        return detalleFacturaRepository;
    }
}