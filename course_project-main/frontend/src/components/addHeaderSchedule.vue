<template>
  <div>
    <h3>Заполнение заголовка расписания</h3>
    <div class="container">
      <form @submit="validateAndSubmit">        
		<fieldset class="form-group">
          <label>Заголовок* </label>
          <input type="text" class="form-control" v-model="header_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Утверждено </label>
          <input type="checkbox" class="form-control" v-bind="[true, false]" v-model="approved" />
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
import HeaderScheduleDataService from "../service/DataService";

export default { 
  name: "HeaderSchedule",
  data() {
    return {
      header_name: "",
      approved: false,
      errors: [],
    };
  },
  computed: {
    id_header_schedule() {
      return this.$route.params.id_header_schedule;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/headerschedules");
	},
    refreshHeaderScheduleDetails() {
      HeaderScheduleDataService.retrieveHeaderSchedule(this.id_header_schedule).then((res) => {
        this.header_name = res.data.header_name;
		this.approved = res.data.approved == null ? false : res.data.approved;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.header_name) {
        this.errors.push("Заполните обязательные поля (*)"); 
      }

      if (this.errors.length === 0) {
        if (this.id_header_schedule == -1) {
          HeaderScheduleDataService.createHeaderSchedule({
            header_name: this.header_name,
			approved: this.approved,
          }).then(() => {
            this.$router.push("/headerschedules");
          });
        } else {
          HeaderScheduleDataService.updateHeaderSchedule(this.id_header_schedule, {
            id_header_schedule: this.id_header_schedule,
            header_name: this.header_name,
			approved: this.approved,
          }).then(() => {
            this.$router.push("/headerschedules");
          });
        }
      }
    },
  },
  created() {
    this.refreshHeaderScheduleDetails();
  },
};
</script>
