package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Pedido;
import co.edu.unbosque.repository.PedidoRepository;
import co.edu.unbosque.service.api.PedidoServiceAPI;

@Service
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Long> implements PedidoServiceAPI {

    @Autowired
    private PedidoRepository PedidoRepository;

    @Override
    public CrudRepository<Pedido, Long> getDao() {
        return PedidoRepository;
    }
}