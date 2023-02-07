package ru.rgaru.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgaru.dto.TrainerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TrainerService {

    @Inject
    @RestClient
    TrainerServiceExtension trainerServiceExtension;

    //вставка данных
    @Transactional
    public TrainerDTO insertTrainer(TrainerDTO tr) {
        trainerServiceExtension.insertTrainer(tr);
        return tr;
    }

    //обновление данных
    @Transactional
    public TrainerDTO updateTrainer(TrainerDTO tr) {
        trainerServiceExtension.updateTrainer(tr);
        return tr;
    }

    //удаление данных
    @Transactional
    public void deleteTrainer(Long id_trainer) {
        trainerServiceExtension.deleteTrainer(id_trainer);
    }

    // Получение списка
    public List<TrainerDTO> getTrainers(){
        return trainerServiceExtension.getTrainers();
    }

    // Поиск по ID
    public TrainerDTO getTrainerById(Long id_trainer){
        return trainerServiceExtension.getTrainersById(id_trainer);
    }
}
