<template>
  <div>
    <h3>Заполнение информации о месте проведения занятия</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
		<fieldset class="form-group">
          <label>Место проведения* </label>
          <input type="text" class="form-control" v-model="place_name" />
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
import PlaceDataService from "../service/DataService";

export default { 
  name: "Place",
  data() {
    return {
      place_name: "",
      errors: [],
    };
  },
  computed: {
    id_place() {
      return this.$route.params.id_place;
    },
  },
  methods: {
	cansell(){
		this.$router.push("/places");
	},
    refreshPlaceDetails() {
      PlaceDataService.retrievePlace(this.id_place).then((res) => {
        this.place_name = res.data.place_name;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.place_name) {
        this.errors.push("Заполните обязательные поля (*)");
      }
      if (this.errors.length === 0) {
        if (this.id_place == -1) {
          PlaceDataService.createPlace({
            place_name: this.place_name,
          }).then(() => {
            this.$router.push("/places");
          });
        } else {
          PlaceDataService.updatePlace(this.id_place, {
            id_place: this.id_place,
            place_name: this.place_name,
          }).then(() => {
            this.$router.push("/places");
          });
        }
      }
    },
  },
  created() {
    this.refreshPlaceDetails();
  },
};
</script>
