<template>
  <div class="container">
    <main-header/>
    <h3>Данные о тренерах</h3>
    <b-row>
      <b-col md="3">
        <b-form-input v-model="filter" type="search" placeholder="Найти"></b-form-input>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table
            striped
            hover
            :items="trainers"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updateTrainer(data.item.id_trainer)">Δ</b-button>
          </template>
          <template v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deleteTrainer(data.item.id_trainer)">-</b-button>
          </template>
        </b-table>
        <b-pagination
            class="pagination"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
        ></b-pagination>
      </b-col>
    </b-row>
    <div v-if="$keycloak.hasRealmRole('editTrainer')" class="row">
      <button class="btn" v-on:click="addTrainer()">Добавить</button>
    </div>
  </div>
</template>

<script>
import TrainerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: 'id_trainer', label: "ИД"},
        {key: 'last_name', label: "Фамилия", visible: true/*, sortable: true, sortDirection: 'desc'*/},
        {key: 'first_name', label: "Имя", visible: true},
        {key: "middle_name", label: "Отчество", visible: true},
        {key: "phone", label: "Телефон", visible: true},
        {key: "birthday", label: "Дата рождения", visible: true},
        {key: "Update", label: "Update", visible: false},
        {key: "Delete", label: "Delete", visible: false}],
      trainers: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshTrainers() {
      TrainerDataService.retrieveAllTrainers().then((res) => {
        this.trainers = res.data;
      });
    },
    addTrainer() {
      this.$router.push(`/trainers/-1`);
    },
    updateTrainer(id_trainer) {
      this.$router.push(`/trainers/${id_trainer}`);
    },
    deleteTrainer(id_trainer) {
      TrainerDataService.deleteTrainer(id_trainer).then(() => {
        this.refreshTrainers();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.trainers.length
    }
  },
  created() {
    this.refreshTrainers();
    this.fields[5].visible = this.$router.app.$keycloak.hasRealmRole('editTrainer')
    this.fields[6].visible = this.$router.app.$keycloak.hasRealmRole('editTrainer')
  },
};
</script>
