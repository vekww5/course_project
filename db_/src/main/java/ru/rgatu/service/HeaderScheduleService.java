package ru.rgatu.service;

import ru.rgatu.entity.HeaderSchedule;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class HeaderScheduleService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional
    public HeaderSchedule insertHeaderSchedule(HeaderSchedule hsch) {
        //em.merge(hsch);
        em.persist(hsch);
        em.flush();
        return hsch;
    }

    //обновление данных
    @Transactional
    public HeaderSchedule updateHeaderSchedule(HeaderSchedule hsch) {
        em.merge(hsch);
        em.flush();
        return hsch;
    }

    //удаление данных
    @Transactional
    public void deleteHeaderSchedule(Long id_HeaderSchedule) {
        HeaderSchedule l = this.getHeaderScheduleById(id_HeaderSchedule);
        em.remove(l);
        em.flush();
    }

    // Получение списка
    public List<HeaderSchedule> getHeaderSchedules(){
        return em.createQuery("select hs from HeaderSchedule hs", HeaderSchedule.class).getResultList();
    }

    // Поиск по ID
    public HeaderSchedule getHeaderScheduleById(Long id_header_schedule){
        HeaderSchedule hsch = em.find(HeaderSchedule.class, id_header_schedule);
        return hsch;
    }
}
