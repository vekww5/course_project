<template>
  <div class="container">
    <main-header/>
    <h3>Общее расписание</h3>
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
            :items="schedules"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updateSchedule(data.item[0].id_schedule)">Δ</b-button>
          </template>
          <template v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deleteSchedule(data.item[0].id_schedule)">-</b-button>
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
    <div v-if="$keycloak.hasRealmRole('editSch')" class="row">
      <button class="btn" v-on:click="addSchedule()">Добавить</button>
    </div>
  </div>
</template>

<script>
import ScheduleDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Schedules",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: 'id_schedule', label: "ИД"},
        {key: "2.header_name", label: "Заголовок", visible:true},
        {key: "2.approved", label: "", visible:true},
        {key: '3.section_name', label: "Секция", visible:true},
        {key: '1.place_name', label: "Место проведения", visible:true/*, sortable: true, sortDirection: 'desc'*/},
        {key: "0.date", label: "Дата", visible:true},
        {key: "0.time_start", label: "Время начала", visible:true},
        {key: "0.time_end", label: "Время окончания", visible:true},
        {key: "0.cancell", label: "Отмена занятия", visible:true},
        {key: "0.note", label: "Примечание", visible:true},
        {key: "Update", label: "Update", visible:false},
        {key: "Delete", label: "Delete", visible:false}],
      schedules: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshSchedules() {
      ScheduleDataService.retrieveAllSchedules().then((res) => {
        this.schedules = res.data;
      });
    },
    addSchedule() {
      this.$router.push(`/schedules/-1`);
    },
    updateSchedule(id_schedule) {
      this.$router.push(`/schedules/${id_schedule}`);
    },
    deleteSchedule(id_schedule) {
      ScheduleDataService.deleteSchedule(id_schedule).then(() => {
        this.refreshSchedules();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.schedules.length
    }
  },
  created() {
    this.refreshSchedules();
    this.fields[9].visible = this.$router.app.$keycloak.hasRealmRole('editSch') || this.$router.app.$keycloak.hasRealmRole('updateSch')
    this.fields[10].visible = this.$router.app.$keycloak.hasRealmRole('editSch')
  },
};
</script>
