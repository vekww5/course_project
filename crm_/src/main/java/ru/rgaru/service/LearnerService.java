package ru.rgaru.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import ru.rgaru.dto.LearnerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LearnerService {

    private static final Logger LOG = Logger.getLogger(LearnerDTO.class);

    @Inject
    @RestClient
    LearnerServiceExtension learnerServiceExtension;

    //вставка данных
    @Transactional
    public LearnerDTO insertLearner(LearnerDTO lnr) {
        learnerServiceExtension.insertLearner(lnr);
        LOG.info(String.format("Добавлен новый ученик: %s", lnr));
        return lnr;
    }

    //обновление данных
    @Transactional
    public LearnerDTO updateLearner(LearnerDTO lnr) {
        learnerServiceExtension.updateLearner(lnr);
        LOG.info(String.format("Изменены данные ученика: %s", lnr.getId_learner()));
        return lnr;
    }

    //удаление данных
    @Transactional
    public void deleteLearner(Long id_learner) {
        learnerServiceExtension.deleteLearner(id_learner);
        LOG.info(String.format("Удален ученик: %s", id_learner));
    }

    // Получение списка
    public List<Object[]> getLearners(){
        return learnerServiceExtension.getLearners();
    }


    // Поиск по ID
    public LearnerDTO getLearnerById(Long id_learner){
        return learnerServiceExtension.getLearnerById(id_learner);
    }
}
