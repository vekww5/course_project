<template>
  <div>
    <h3>Заполнение информации о секции</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        
		<fieldset class="form-group">
          <label>Наименование секции* </label>
          <input type="text" class="form-control" v-model="section_name" />
        </fieldset>
	<fieldset class="form-group">
          <label>Тренер* </label>
            <v-select
                class="v-select"
                placeholder="Выберите тренера из списка"
                v-model="id_trainer"
                :options="trainers"
                :reduce="(trainer) => trainer.id_trainer"
                :get-option-label="(trainer) =>  trainer.last_name +' '+ trainer.first_name+ ' ' + trainer.middle_name" >
              <div slot="no-options">Никого не нашлось</div>
            </v-select>
          <!--<input type="text" class="form-control" v-model="id_trainer" />
		<select v-model="id_trainer" class="combobox">
            <option v-for="trainer in trainers" :key="trainer.first_name" :value="trainer.id_trainer" >
              {{ trainer.first_name + " " +  trainer.middle_name}}
            </option>
          </select>-->
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
import SectionDataService from "../service/DataService";
import TrainerDataService from "@/service/DataService";

export default { 
  name: "Section",
  data() {
    return {
      section_name: "",
      id_trainer: "",
      trainers:[],
      errors: [],
    };
  },
  computed: {
    id_section() {
      return this.$route.params.id_section;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/sections");
	},
    refreshSectionDetails() {
    
      SectionDataService.retrieveSection(this.id_section).then((res) => {
        this.section_name = res.data.section_name;
		this.id_trainer = res.data.id_trainer;
      });
      
      TrainerDataService.retrieveAllTrainers().then((res) => {
        this.trainers = res.data;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if ((!this.section_name)||(!this.id_trainer)) {
        this.errors.push("Заполните обязательные поля (*)");
      }

      if (this.errors.length === 0) {
        if (this.id_section == -1) {
          SectionDataService.createSection({
            section_name: this.section_name,
			id_trainer: this.id_trainer,
          }).then(() => {
            this.$router.push("/sections");
          });
        } else {
          SectionDataService.updateSection(this.id_section, {
            id_section: this.id_section,
            section_name: this.section_name,
			id_trainer: this.id_trainer,
          }).then(() => {
            this.$router.push("/sections");
          });
        }
      }
    },
  },
  created() {
    this.refreshSectionDetails();
  },
};
</script>
