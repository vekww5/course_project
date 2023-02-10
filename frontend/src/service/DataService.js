import axios from 'axios'
import router from "@/routes";


const API_URL_1 = 'http://192.168.122.1/crm'
const API_URL_2 = 'http://192.168.122.1/scheduler'

//можно и так
//const header = {'Authorization': 'Bearer ' + router.app.$keycloak.token};

class DataService {
//Trainer
    retrieveAllTrainers() {
        return axios.get(`${API_URL_1}/trainers/getTrainers`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})

        //можно и так
        //return axios.get(`${API_URL}/trainers/getTrainers`, {headers: header})
    }

    retrieveTrainer(id_trainer) {
        return axios.get(`${API_URL_1}/trainers/${id_trainer}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deleteTrainer(id_trainer) {
        return axios.delete(`${API_URL_1}/trainers/${id_trainer}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updateTrainer(id_trainer, trainer) {
        return axios.post(`${API_URL_1}/trainers/updateTrainer`, trainer,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createTrainer(trainer) {
        return axios.post(`${API_URL_1}/trainers/insertTrainer`, trainer,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }


//Learner-------------------
    retrieveAllLearners() {
        return axios.get(`${API_URL_1}/learners/getLearners`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrieveLearner(id_learner) {
        return axios.get(`${API_URL_1}/learners/${id_learner}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deleteLearner(id_learner) {
        return axios.delete(`${API_URL_1}/learners/${id_learner}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updateLearner(id_learner, learner) {
        console.log(id_learner, learner)
        return axios.post(`${API_URL_1}/learners/updateLearner`, learner,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createLearner(learner) {
        return axios.post(`${API_URL_1}/learners/insertLearner`, learner,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

//Place
    retrieveAllPlaces() {
        return axios.get(`${API_URL_2}/places/getPlaces`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrievePlace(id_place) {
        return axios.get(`${API_URL_2}/places/${id_place}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deletePlace(id_place) {
        return axios.delete(`${API_URL_2}/places/${id_place}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updatePlace(id_place, place) {
        return axios.post(`${API_URL_2}/places/updatePlace`, place,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createPlace(place) {
        return axios.post(`${API_URL_2}/places/insertPlace`, place,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

//Section--------------------
    retrieveAllSections() {
        return axios.get(`${API_URL_2}/sections/getSections`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrieveAllSections1() {
        return axios.get(`${API_URL_2}/sections/getSections1`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrieveSection(id_section) {
        return axios.get(`${API_URL_2}/sections/${id_section}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deleteSection(id_section) {
        return axios.delete(`${API_URL_2}/sections/${id_section}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updateSection(id_section, section) {
        return axios.post(`${API_URL_2}/sections/updateSection`, section,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createSection(section) {
        return axios.post(`${API_URL_2}/sections/insertSection`, section,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

//Schedule----------------- 
    retrieveAllSchedules() {
        return axios.get(`${API_URL_2}/schedules/getSchedules`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrieveSchedule(id_schedule) {
        return axios.get(`${API_URL_2}/schedules/${id_schedule}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deleteSchedule(id_schedule) {
        return axios.delete(`${API_URL_2}/schedules/${id_schedule}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updateSchedule(id_schedule, schedule) {
        return axios.post(`${API_URL_2}/schedules/updateSchedule`, schedule,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createSchedule(schedule) {
        return axios.post(`${API_URL_2}/schedules/insertSchedule`, schedule,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

//HeaderSchedule
    retrieveAllHeaderSchedules() {
        return axios.get(`${API_URL_2}/headerschedules/getHeaderSchedules`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    retrieveHeaderSchedule(id_header_schedule) {
        return axios.get(`${API_URL_2}/headerschedules/${id_header_schedule}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    deleteHeaderSchedule(id_header_schedule) {
        return axios.delete(`${API_URL_2}/headerschedules/${id_header_schedule}`,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}})
    }

    updateHeaderSchedule(id_header_schedule, headerschedule) {
        return axios.post(`${API_URL_2}/headerschedules/updateHeaderSchedule`, headerschedule,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

    createHeaderSchedule(headerschedule) {
        return axios.post(`${API_URL_2}/headerschedules/insertHeaderSchedule`, headerschedule,
            {headers: {'Authorization': 'Bearer ' + router.app.$keycloak.token}});
    }

}

export default new DataService()
