package ru.rgatu.service;

import ru.rgatu.entity.Place;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlaceService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional 
    public Place insertPlace(Place pl) {
        //em.merge(pl);
        em.persist(pl);
        em.flush();
        return pl;
    }

    //обновление данных
    @Transactional
    public Place updatePlace(Place pl) {
        em.merge(pl);
        em.flush();
        return pl;
    }

    //удаление данных
    @Transactional
    public void deletePlace(Long id_place) {
        Place pl = this.getPlaceById(id_place);
        em.remove(pl);
        em.flush();
    }

    // Получение списка
    public List<Place> getPlaces(){
        return em.createQuery("select pl from Place pl", Place.class).getResultList();
    }

    // Поиск по ID
    public Place getPlaceById(Long id_place){
        Place pl = em.find(Place.class, id_place);
        return pl;
    }
}
