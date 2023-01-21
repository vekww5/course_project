<template>
  <div class="container">
    <main-header/>
    <h3>Заголовки расписания</h3>
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
            :items="headerschedules"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template  v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updateHeaderSchedule(data.item.id_header_schedule)">Δ</b-button>
          </template>
          <template v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deleteHeaderSchedule(data.item.id_header_schedule)">-</b-button>
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
    <div v-if="$keycloak.hasRealmRole('editHeader')" class="row">
      <button class="btn" v-on:click="addHeaderSchedule()">Добавить</button>
    </div>
  </div>
</template>

<script>
import HeaderSchedulesDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "HeaderSchedules",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: 'id_header_schedule', label: "ИД"},
        {key: 'header_name', label: "Заголовок", visible: true/*, sortable: true, sortDirection: 'desc'*/},
        {key: 'approved', label: "Утверждено", visible: true},
        {key: "Update", label: "Update", visible: false},
        {key: "Delete", label: "Delete", visible: false}],
      headerschedules: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshHeaderSchedules() {
      HeaderSchedulesDataService.retrieveAllHeaderSchedules().then((res) => {
        this.headerschedules = res.data;
      });
    },
    addHeaderSchedule() {
      this.$router.push(`/headerschedules/-1`);
    },
    updateHeaderSchedule(id_header_schedule) {
      this.$router.push(`/headerschedules/${id_header_schedule}`);
    },
    deleteHeaderSchedule(id_header_schedule) {
      HeaderSchedulesDataService.deleteHeaderSchedule(id_header_schedule).then(() => {
        this.refreshHeaderSchedules();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.headerschedules.length
    }
  },
  created() {
    this.refreshHeaderSchedules();
    this.fields[2].visible = this.$router.app.$keycloak.hasRealmRole('editHeader')
    this.fields[3].visible = this.$router.app.$keycloak.hasRealmRole('editHeader')
  },
};
</script>
