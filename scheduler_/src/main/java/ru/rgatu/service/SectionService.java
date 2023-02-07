package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgatu.dto.SectionDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SectionService {

    @Inject
    @RestClient
    SectionServiceExtension sectionServiceExtension;

    //вставка данных
    @Transactional
    public SectionDTO insertSection(SectionDTO sc) {
        sectionServiceExtension.insertSection(sc);
        return sc;
    }

    //обновление данных
    @Transactional
    public SectionDTO updateSection(SectionDTO sc) {
        sectionServiceExtension.updateSection(sc);
        return sc;
    }

    //удаление данных
    @Transactional
    public void deleteSection(Long id_section) {
        sectionServiceExtension.deleteSection(id_section);
    }

    // Получение списка
    /*public List<Section> getSections(){
        //return em.createQuery("select s from Section s", Section.class).getResultList();
        return em.createQuery("select s, t from Section s left join Trainer t on s.id_trainer = t.id_trainer", Section.class).getResultList();
    }*/

    public List<Object[]> getSections(){
        return sectionServiceExtension.getSections();
    }


    // Поиск по ID
    public SectionDTO getSectionById(Long id_section){
        return sectionServiceExtension.getSectionById(id_section);
    }
}
