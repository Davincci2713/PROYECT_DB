package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.DetalleCompra;
import co.edu.unbosque.entity.DetalleCompraId;
import co.edu.unbosque.repository.DetalleCompraRepository;
import co.edu.unbosque.service.api.DetalleCompraServiceAPI;

@Service
public class DetalleCompraServiceImpl extends GenericServiceImpl<DetalleCompra, DetalleCompraId> implements DetalleCompraServiceAPI {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public CrudRepository<DetalleCompra, DetalleCompraId> getDao() {
        return detalleCompraRepository;
    }
}