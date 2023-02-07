package ru.rgatu.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rgatu.dto.PlaceDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlaceService {


    @Inject
    @RestClient
    PlaceServiceExtension placeServiceExtension;

    //вставка данных
    @Transactional 
    public PlaceDTO insertPlace(PlaceDTO pl) {
        placeServiceExtension.insertPlace(pl);
        return pl;
    }

    //обновление данных
    @Transactional
    public PlaceDTO updatePlace(PlaceDTO pl) {
        placeServiceExtension.updatePlace(pl);
        return pl;
    }

    //удаление данных
    @Transactional
    public void deletePlace(Long id_place) {
        placeServiceExtension.deletePlace(id_place);
    }

    // Получение списка
    public List<PlaceDTO> getPlaces(){
        return placeServiceExtension.getPlaces();
    }

    // Поиск по ID
    public PlaceDTO getPlaceById(Long id_place){
        return placeServiceExtension.getPlaceById(id_place);
    }
}
