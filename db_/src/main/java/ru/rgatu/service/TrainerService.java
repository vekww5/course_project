package ru.rgatu.service;

import ru.rgatu.entity.Trainer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TrainerService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional
    public Trainer insertTrainer(Trainer tr) {
        em.persist(tr);
        em.flush();
        return tr;
    }

    //обновление данных
    @Transactional
    public Trainer updateTrainer(Trainer tr) {
        em.merge(tr);
        em.flush();
        return tr;
    }

    //удаление данных
    @Transactional
    public void deleteTrainer(Long id_trainer) {
        Trainer t = this.getTrainerById(id_trainer);
        em.remove(t);
        em.flush();
    }

    // Получение списка
    public List<Trainer> getTrainers(){
        return em.createQuery("select t from Trainer t", Trainer.class).getResultList();
    }

    // Поиск по ID
    public Trainer getTrainerById(Long id_trainer){
        return em.find(Trainer.class, id_trainer);
    }
}
