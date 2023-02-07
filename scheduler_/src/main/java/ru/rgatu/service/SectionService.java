package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import ru.rgatu.dto.SectionDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SectionService {

    private static final Logger LOG = Logger.getLogger(SectionDTO.class);

    @Inject
    @RestClient
    SectionServiceExtension sectionServiceExtension;

    //вставка данных
    @Transactional
    public SectionDTO insertSection(SectionDTO sc) {
        sectionServiceExtension.insertSection(sc);
        LOG.info(String.format("Добавлена новоя секция: %s", sc.getSection_name()));
        return sc;
    }

    //обновление данных
    @Transactional
    public SectionDTO updateSection(SectionDTO sc) {
        sectionServiceExtension.updateSection(sc);
        LOG.info(String.format("Секция %s изменена", sc.getSection_name()));
        return sc;
    }

    //удаление данных
    @Transactional
    public void deleteSection(Long id_section) {
        sectionServiceExtension.deleteSection(id_section);
        LOG.info(String.format("Секция %s удалена", id_section));
    }

    // Получение списка
    public List<SectionDTO> getSections1(){
        return sectionServiceExtension.getSections1();
    }

    public List<Object[]> getSections(){
        return sectionServiceExtension.getSections();
    }


    // Поиск по ID
    public SectionDTO getSectionById(Long id_section){
        return sectionServiceExtension.getSectionById(id_section);
    }
}
