<template>
  <div>
    <h3>Заполнение расписания</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Место проведения* </label>
<!--          <input type="text" class="form-control" v-model="id_place"/>-->
          <v-select
              class="v-select"
              placeholder="Выберите название из списка"
              v-model="id_place"
              :options="places"
              :reduce="(place) => place.id_place"
              :get-option-label="(place) =>  place.place_name">
            <div slot="no-options">Никого не нашлось</div>
          </v-select>
        </fieldset>
        <fieldset class="form-group">
          <label>Секция* </label>
<!--           <input type="text" class="form-control" v-model="id_section"/>-->
          <v-select
              class="v-select"
              placeholder="Выберите название из списка"
              v-model="id_section"
              :options="sections"
              :reduce="(section) => section.id_section"
              :get-option-label="(section) =>  section.section_name">
            <div slot="no-options">Никого не нашлось</div>
          </v-select>
        </fieldset>
        <fieldset class="form-group">
          <label>Заголовок* </label>
<!--          <input type="text" class="form-control" v-model="id_header_schedule"/>-->
          <v-select
              class="v-select"
              placeholder="Выберите название из списка"
              v-model="id_header_schedule"
              :options="headerSchedules"
              :reduce="(headerSchedule) => headerSchedule.id_header_schedule"
              :get-option-label="(headerSchedule) =>  headerSchedule.header_name">
            <div slot="no-options">Никого не нашлось</div>
          </v-select>
        </fieldset>
        <fieldset class="form-group">
          <label>Дата* </label>
          <input type="date" class="form-control" v-model="date"/>
        </fieldset>
        <fieldset class="form-group">
          <label>Время начала* </label>
          <input type="time" step = "1" class="form-control" v-model="time_start" />
        </fieldset>
        <fieldset class="form-group">
          <label>Время окончания* </label>
          <input type="time" step = "1" class="form-control" v-model="time_end" />
        </fieldset>
        <fieldset class="form-group">
          <label>Отмена занятия </label>
          <input type="checkbox" class="form-control" v-bind="[true, false]" v-model="cancell"/>
        </fieldset>
        <fieldset class="form-group">
          <label>Премичание </label>
<!--          <input type="text" class="form-control" v-model="note"/>-->

          <textarea rows="4" cols="70" v-model="note"></textarea>
        </fieldset>
		<div v-if="errors.length">
          <div
              class="alert alert-danger"
              v-bind:key="index"
              v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
        <button class="btn" type="submit">Сохранить</button>

      </form>
      <div class="row">
		<button class="btn" v-on:click="cansell()">Отмена</button>
      </div>
    </div>
  </div>
</template>
<script>
import ScheduleDataService from "../service/DataService";

export default {
  name: "Schedule",
  data() {
    return {
      id_place: "",
      id_section: "",
      id_header_schedule: "",
      date: "",
      time_start: "",
      time_end: "",
      cancell: false,
      note: "",
      sections: [],
      places: [],
      headerSchedules: [],
      errors: [],
    };
  },
  computed: {
    id_schedule() {
      return this.$route.params.id_schedule;
    },
  },
  methods: {
    cansell(){
		this.$router.push("/schedules");
	},
    refreshScheduleDetails() {
      ScheduleDataService.retrieveSchedule(this.id_schedule).then((res) => {
        this.id_place = res.data.id_place;
        this.id_section = res.data.id_section;
        this.id_header_schedule = res.data.id_header_schedule;
        this.date = res.data.date;
        this.time_start = res.data.time_start;
        this.time_end = res.data.time_end;
        this.cancell = res.data.cancell == null ? false : res.data.cancell;
        this.note = res.data.note;
      });
      ScheduleDataService.retrieveAllSections1().then((res) => {
        this.sections = res.data;
        console.log(res.data)
      });
      ScheduleDataService.retrieveAllPlaces().then((res) => {
        this.places = res.data;
        console.log(res.data)
      });
      ScheduleDataService.retrieveAllHeaderSchedules().then((res) => {
        this.headerSchedules = res.data;
        console.log(res.data)
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
    if ((!this.id_place)||(!this.id_section)||(!this.id_header_schedule)||(!this.date)||(!this.time_start)||(!this.time_end)) {
        this.errors.push("Заполните обязательные поля (*)");
    }
      if (this.errors.length === 0) {
        if (this.id_schedule == -1) {
          ScheduleDataService.createSchedule({
            id_place: this.id_place,
            id_section: this.id_section,
            id_header_schedule: this.id_header_schedule,
            date: this.date,
            time_start: this.time_start,//+':00',
            time_end: this.time_end,//+':00',
            cancell: this.cancell,
            note: this.note,
          }).then(() => {
            this.$router.push("/schedules");
          });
        } else {
          ScheduleDataService.updateSchedule(this.id_schedule, {
            id_schedule: this.id_schedule,
            id_place: this.id_place,
            id_section: this.id_section,
            id_header_schedule: this.id_header_schedule,
            date: this.date,
            time_start: this.time_start,//+':00',
            time_end: this.time_end,//+':00',
            cancell: this.cancell,
            note: this.note,
          }).then(() => {
            this.$router.push("/schedules");
          });
        }
      }
    },
  },
  created() {
    this.refreshScheduleDetails();
  },
};
</script>
