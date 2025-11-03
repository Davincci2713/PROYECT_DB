package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.DetallePedido;
import co.edu.unbosque.entity.DetallePedidoId;
import co.edu.unbosque.repository.DetallePedidoRepository;
import co.edu.unbosque.service.api.DetallePedidoServiceAPI;

@Service
public class DetallePedidoServiceImpl extends GenericServiceImpl<DetallePedido, DetallePedidoId> implements DetallePedidoServiceAPI {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public CrudRepository<DetallePedido, DetallePedidoId> getDao() {
        return detallePedidoRepository;
    }
}