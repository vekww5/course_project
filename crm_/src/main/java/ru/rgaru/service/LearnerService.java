package ru.rgaru.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgaru.dto.LearnerDTO;
//import ru.rgaru.entity.Learner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LearnerService {

    @Inject
    EntityManager em;

    @Inject
    @RestClient
    LearnerServiceExtension learnerServiceExtension;

    //вставка данных
    @Transactional
    public LearnerDTO insertLearner(LearnerDTO lnr) {
        learnerServiceExtension.insertLearner(lnr);
        return lnr;
    }

    //обновление данных
    @Transactional
    public LearnerDTO updateLearner(LearnerDTO lnr) {
        learnerServiceExtension.updateLearner(lnr);
        return lnr;
    }

    //удаление данных
    @Transactional
    public void deleteLearner(Long id_learner) {
        learnerServiceExtension.deleteLearner(id_learner);
    }

    // Получение списка
    public List<Object[]> getLearners(){
        return learnerServiceExtension.getLearners();
    }
    // Получение утвержденного списка
//    public List<Learner> getEnrolledLearners(){
//        return em.createQuery("select l from Learner l where enrolled = true", Learner.class).getResultList();
//    }
    // Поиск по ID
    public LearnerDTO getLearnerById(Long id_learner){
        return learnerServiceExtension.getLearnerById(id_learner);
    }
}
