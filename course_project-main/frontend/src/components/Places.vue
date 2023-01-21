<template>
  <div class="container">
    <main-header/>
    <h3>Места проведения секций</h3>
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
            :items="places"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updatePlace(data.item.id_place)">Δ</b-button>
          </template>
          <template v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deletePlace(data.item.id_place)">-</b-button>
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
    <div v-if="$keycloak.hasRealmRole('editPlace')" class="row">
      <button class="btn" v-on:click="addPlace()">Добавить</button>
    </div>
  </div>
</template>

<script>
import PlaceDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Places",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: 'id_place', label: "ИД"},
        {key: 'place_name', label: "Место проведения", visible: true/*, sortable: true, sortDirection: 'desc'*/},
        {key: "Update", label: "Update", visible: false},
        {key: "Delete", label: "Delete", visible: false}],
      places: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshPlaces() {
      PlaceDataService.retrieveAllPlaces().then((res) => {
        this.places = res.data;
      });
    },
    addPlace() {
      this.$router.push(`/places/-1`);
    },
    updatePlace(id_place) {
      this.$router.push(`/places/${id_place}`);
    },
    deletePlace(id_place) {
      PlaceDataService.deletePlace(id_place).then(() => {
        this.refreshPlaces();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.places.length
    }
  },
  created() {
    this.refreshPlaces();
    this.fields[1].visible = this.$router.app.$keycloak.hasRealmRole('editPlace')
    this.fields[2].visible = this.$router.app.$keycloak.hasRealmRole('editPlace')
  },
};
</script>
