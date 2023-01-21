<template>
  <div>
    <h3>Заполнение информации об ученике</h3>
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
		<fieldset class="form-group">
          <label>Секция </label>
          <!--<input type="text" class="form-control" v-model="id_section" />-->
		<v-select
              class="v-select"
              placeholder="Выберите секцию из списка"
              v-model="id_section"
              :options="sections"
              :reduce="(section) => section.id_section"
              :get-option-label="(section) =>  section.section_name">
            <div slot="no-options">Никаких не нашлось</div>
          </v-select>
        </fieldset>
		<fieldset v-if="$keycloak.hasRealmRole('editLearner')" class="form-group">
          <label>Зачисление </label>
          <input type="checkbox" class="form-control" v-model="enrolled"/>
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
import LearnerDataService from "../service/DataService";

export default { 
  name: "Learner",
  data() {
    return {
      last_name: "",
      first_name: "",
      middle_name: "",
      phone: "",
      birthday: "",
      id_section: "",
      enrolled: "", 
      sections: [],
      errors: [],
    };
  },
  computed: {
    id_learner() {
      return this.$route.params.id_learner;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/learners");
	},
    refreshLearnerDetails() {
      LearnerDataService.retrieveLearner(this.id_learner).then((res) => {
        this.last_name = res.data.last_name;
		this.first_name = res.data.first_name;
		this.middle_name = res.data.middle_name;
        this.phone = res.data.phone;
        this.birthday = res.data.birthday;
		this.id_section = res.data.id_section;
        this.enrolled =  res.data.enrolled == null ? false : res.data.enrolled;
      });
      LearnerDataService.retrieveAllSections1().then((res) => {
        this.sections = res.data;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
     if ((!this.last_name)||(!this.first_name)) {
         this.errors.push("Заполните обязательные поля (*)"); 
      }
      if (this.errors.length === 0) {
        if (this.id_learner == -1) {
          LearnerDataService.createLearner({
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,
            phone: this.phone,
            birthday: this.birthday,
			id_section: this.id_section,
            enrolled: this.enrolled,
          }).then(() => {
            this.$router.push("/learners");
          });
        } else {
          LearnerDataService.updateLearner(this.id_learner, {
            id_learner: this.id_learner,
            last_name: this.last_name,
			first_name: this.first_name,
			middle_name: this.middle_name,
            phone: this.phone,
            birthday: this.birthday,
			id_section: this.id_section,
            enrolled: this.enrolled,
          }).then(() => {
            this.$router.push("/learners");
          });
        }
      }
    },
  },
  created() {
    this.refreshLearnerDetails();
  },
};
</script>
