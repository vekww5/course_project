<template>
  <div>
    <h3>Заполнение информации о тренере</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
		<fieldset class="form-group">
          <label>Фамилия* </label>
          <input type="text" class="form-control" v-model="last_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Имя* </label>
          <input type="text" class="form-control" v-model="first_name" />
        </fieldset>
		<fieldset class="form-group">
          <label>Отчество </label>
          <input type="text" class="form-control" v-model="middle_name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Телефон </label>
          <input type="text" class="form-control" v-model="phone" />
        </fieldset>
        <fieldset class="form-group">
          <label>Дата рождения </label>
          <input type="date" class="form-control" v-model="birthday" />
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
import TrainerDataService from "../service/DataService";

export default { 
  name: "Trainer",
  data() {
    return {
      last_name: "",
      first_name: "",
      middle_name: "",
      phone: "",
      birthday: "",
      errors: [],
    };
  },
  computed: {
    id_trainer() {
      return this.$route.params.id_trainer;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/trainers");
	},
    refreshTrainerDetails() {
      TrainerDataService.retrieveTrainer(this.id_trainer).then((res) => {
        this.last_name = res.data.last_name;
		this.first_name = res.data.first_name;
		this.middle_name = res.data.middle_name;
        this.phone = res.data.phone;
        this.birthday = res.data.birthday;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if ((!this.last_name)||(!this.first_name)) {
        this.errors.push("Заполните обязательные поля (*)"); 
      }

      if (this.errors.length === 0) {
        if (this.id_trainer == -1) {
          TrainerDataService.createTrainer({
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,
            phone: this.phone,
            birthday: this.birthday,
          }).then(() => {
            this.$router.push("/trainers");
          });
        } else {
          TrainerDataService.updateTrainer(this.id_trainer, {
            id_trainer: this.id_trainer,
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,			
            phone: this.phone,
            birthday: this.birthday,
          }).then(() => {
            this.$router.push("/trainers");
          });
        }
      }
    },
  },
  created() {
    this.refreshTrainerDetails();
  },
};
</script>
