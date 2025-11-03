package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Alimento;
import co.edu.unbosque.repository.AlimentoRepository;
import co.edu.unbosque.service.api.AlimentoServiceAPI;

@Service
public class AlimentoServiceImpl extends GenericServiceImpl<Alimento, Long> implements AlimentoServiceAPI {

    @Autowired
    private AlimentoRepository AlimentoRepository;

    @Override
    public CrudRepository<Alimento, Long> getDao() {
        return AlimentoRepository;
    }
}