package ru.rgatu.service;

import ru.rgatu.pojo.Schedule;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ScheduleService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional
    public Schedule insertSchedule(Schedule sch) {
        //em.merge(sch);
        em.persist(sch);
        em.flush();
        return sch;
    }

    //обновление данных
    @Transactional
    public Schedule updateSchedule(Schedule sch) {
        em.merge(sch);
        em.flush();
        return sch;
    }

    //удаление данных
    @Transactional
    public void deleteSchedule(Long id_Schedule) {
        Schedule l = this.getScheduleById(id_Schedule);
        em.remove(l);
        em.flush();
    }

    // Получение списка
    public List<Schedule> getSchedules(){
       // return em.createQuery("select s from Schedule s", Schedule.class).getResultList();
        return em.createQuery("select sch, pl, hs, s from Schedule sch left join Place pl on sch.id_place = pl.id_place left join HeaderSchedule hs on sch.id_header_schedule = hs.id_header_schedule left join Section s on sch.id_section = s.id_section").getResultList();
    }

    // Поиск по ID
    public Schedule getScheduleById(Long id_schedule){
        Schedule sch = em.find(Schedule.class, id_schedule);
        return sch;
    }
}
