<template>
  <div class="container">
    <main-header/>
    <h3>Данные обо всех учениках</h3>
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
            :items="learners"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updateLearner(data.item[0].id_learner)">Δ</b-button>
          </template>
          <template v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deleteLearner(data.item[0].id_learner)">-</b-button>
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
    <div v-if="$keycloak.hasRealmRole('editLearner')||$keycloak.hasRealmRole('addLearner')" class="row">
      <button class="btn" v-on:click="addLearner()">Добавить</button>
    </div>
  </div>
</template>

<script>
import LearnerDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Trainers",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: 'id_learner', label: "ИД"},
        {key: '0.last_name', label: "Фамилия", visible: true/*, sortable: true, sortDirection: 'desc'*/},
        {key: '0.first_name', label: "Имя", visible: true},
        {key: "0.middle_name", label: "Отчество", visible: true},
        {key: "0.phone", label: "Телефон", visible: true},
        {key: "0.birthday", label: "Дата рождения", visible: true},
        //{key:"id_section", label: "Секция"},
        {key: "1.section_name", label: "Секция", visible: true},
        {key: "0.enrolled", label: "Зачислен", visible: true},
        {key: "Update", label: "Update", visible: false},
        {key: "Delete", label: "Delete", visible: false}],
      learners: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshLearners() {
      LearnerDataService.retrieveAllLearners().then((res) => {
        this.learners = res.data;
      });
    },
    addLearner() {
      this.$router.push(`/learners/-1`);
    },
    updateLearner(id_learner) {
      this.$router.push(`/learners/${id_learner}`);
    },
    deleteLearner(id_learner) {
      LearnerDataService.deleteLearner(id_learner).then(() => {
        this.refreshLearners();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.learners.length
    }
  },
  created() {
    this.refreshLearners();
    this.fields[7].visible = this.$router.app.$keycloak.hasRealmRole('editLearner')
    this.fields[8].visible = this.$router.app.$keycloak.hasRealmRole('editLearner')
  },
};
</script>
