package co.edu.unbosque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import co.edu.unbosque.utils.GenericServiceImpl;
import co.edu.unbosque.entity.Hogar;
import co.edu.unbosque.repository.HogarRepository;
import co.edu.unbosque.service.api.HogarServiceAPI;

@Service
public class HogarServiceImpl extends GenericServiceImpl<Hogar, Long> implements HogarServiceAPI {

    @Autowired
    private HogarRepository HogarRepository;

    @Override
    public CrudRepository<Hogar, Long> getDao() {
        return HogarRepository;
    }
}