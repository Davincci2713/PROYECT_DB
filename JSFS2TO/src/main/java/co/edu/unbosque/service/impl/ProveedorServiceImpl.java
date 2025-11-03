package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Proveedor;
import co.edu.unbosque.repository.ProveedorRepository;
import co.edu.unbosque.service.api.ProveedorServiceAPI;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor, Long> implements ProveedorServiceAPI {

    @Autowired
    private ProveedorRepository ProveedorRepository;

    @Override
    public CrudRepository<Proveedor, Long> getDao() {
        return ProveedorRepository;
    }
}