package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Empleado;
import co.edu.unbosque.repository.EmpleadoRepository;
import co.edu.unbosque.service.api.EmpleadoServiceAPI;

@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Long> implements EmpleadoServiceAPI {

    @Autowired
    private EmpleadoRepository EmpleadoRepository;

    @Override
    public CrudRepository<Empleado, Long> getDao() {
        return EmpleadoRepository;
    }
}