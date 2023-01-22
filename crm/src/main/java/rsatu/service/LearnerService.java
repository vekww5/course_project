package rsatu.service;

import rsatu.pojo.Learner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LearnerService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional
    public Learner insertLearner(Learner lnr) {
        //em.merge(lnr);
        em.persist(lnr);
        em.flush();
        return lnr;
    }

    //обновление данных
    @Transactional
    public Learner updateLearner(Learner lnr) {
        em.merge(lnr);
        em.flush();
        return lnr;
    }

    //удаление данных
    @Transactional
    public void deleteLearner(Long id_learner) {
        Learner l = this.getLearnerById(id_learner);
        em.remove(l);
        em.flush();
    }

    // Получение списка
    public List<Learner> getLearners(){
       // return em.createQuery("select l from Learner l", Learner.class).getResultList();
        return em.createQuery("select l, s from Learner l left join Section s on l.id_section = s.id_section").getResultList();
    }
    // Получение утвержденного списка
//    public List<Learner> getEnrolledLearners(){
//        return em.createQuery("select l from Learner l where enrolled = true", Learner.class).getResultList();
//    }
    // Поиск по ID
    public Learner getLearnerById(Long id_learner){
        Learner lnr = em.find(Learner.class, id_learner);
        return lnr;
    }
}
