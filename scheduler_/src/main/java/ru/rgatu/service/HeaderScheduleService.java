package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgatu.dto.HeaderScheduleDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import org.jboss.logging.Logger;

@ApplicationScoped
public class HeaderScheduleService {

    private static final Logger LOG = Logger.getLogger(HeaderScheduleDTO.class);

    @Inject
    @RestClient
    HeaderScheduleServiceExtension headerScheduleServiceExtensions;

    //вставка данных
    @Transactional
    public HeaderScheduleDTO insertHeaderSchedule(HeaderScheduleDTO hsch) {
        headerScheduleServiceExtensions.insertHeaderSchedule(hsch);
        LOG.info(String.format("Добавлен новый заголовок расписания: %s", hsch.getHeader_name()));
        return hsch;
    }

    //обновление данных
    @Transactional
    public HeaderScheduleDTO updateHeaderSchedule(HeaderScheduleDTO hsch) {;
        headerScheduleServiceExtensions.updateHeaderSchedule(hsch);
        LOG.info(String.format("Изменен заголовок расписания: %s", hsch.getHeader_name()));
        return hsch;
    }

    //удаление данных
    @Transactional
    public void deleteHeaderSchedule(Long id_HeaderSchedule) {
        headerScheduleServiceExtensions.deleteHeaderSchedule(id_HeaderSchedule);
        LOG.info(String.format("Удален заголовок расписания: %s",id_HeaderSchedule));
    }

    // Получение списка
    public List<HeaderScheduleDTO> getHeaderSchedules(){
        return headerScheduleServiceExtensions.getHeaderSchedules();
    }

    // Поиск по ID
    public HeaderScheduleDTO getHeaderScheduleById(Long id_header_schedule){
        return headerScheduleServiceExtensions.getHeaderScheduleById(id_header_schedule);
    }
}
