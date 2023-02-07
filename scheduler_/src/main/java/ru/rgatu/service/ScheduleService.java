package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import ru.rgatu.dto.ScheduleDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ScheduleService {

    private static final Logger LOG = Logger.getLogger(ScheduleDTO.class);

    @Inject
    @RestClient
    ScheduleServiceExtension scheduleServiceExtension;

    //вставка данных
    @Transactional
    public ScheduleDTO insertSchedule(ScheduleDTO sch) {
        scheduleServiceExtension.insertSchedule(sch);
        LOG.info(String.format("Добавлено новое расписание: %s", sch.getId_schedule()));
        return sch;
    }

    //обновление данных
    @Transactional
    public ScheduleDTO updateSchedule(ScheduleDTO sch) {
        scheduleServiceExtension.updateSchedule(sch);
        LOG.info(String.format("Расписание %s обновлено", sch.getId_schedule()));
        return sch;
    }

    //удаление данных
    @Transactional
    public void deleteSchedule(Long id_Schedule) {
        scheduleServiceExtension.deleteSchedule(id_Schedule);
        LOG.info(String.format("Расписание %s удалено", id_Schedule));
    }

    // Получение списка
    public List<Object[]> getSchedules(){
        return scheduleServiceExtension.getSchedules();
    }

    // Поиск по ID
    public ScheduleDTO getScheduleById(Long id_schedule){
        return scheduleServiceExtension.getScheduleById(id_schedule);
    }
}
