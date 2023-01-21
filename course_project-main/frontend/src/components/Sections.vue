<template>
  <div class="container">
    <main-header/>
    <h3>Данные о секциях</h3>
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
            :items="sections"
            :per-page="perPage"
            :current-page="currentPage"
            :filter="filter"
            :fields="visibleFields">
          <template v-slot:cell(Update)="data">
            <b-button variant="btn" @click="updateSection(data.item[0].id_section)">Δ</b-button>
          </template>
          <template  v-slot:cell(Delete)="data">
            <b-button variant="btn" @click="deleteSection(data.item[0].id_section)">-</b-button>
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
    <div v-if="$keycloak.hasRealmRole('editSection')" class="row">
      <button class="btn" v-on:click="addSection()">Добавить</button>
    </div>
  </div>
</template>

<script>
import SectionDataService from "../service/DataService";
import MainHeader from "@/components/MainHeader";

export default {
  name: "Section",
  components: {MainHeader},
  data() {
    return {
      fields: [
        //{key: '0.id_section', label: "ИД"},
        {key: '0.section_name', label: "Наименование секции", visible: true},
        //{key: '0.id_trainer', label: "ИД"},
        {key: '1.last_name', label: "", visible: true},
        {key: '1.first_name', label: "Тренер", visible: true},
        {key: '1.middle_name', label: "", visible: true},
        {key: "Update", label: "Update", visible: true},
        {key: "Delete", label: "Delete", visible: true}],
      sections: [],
      filter: "",
      message: "",
      perPage: 5,
      currentPage: 1,
    };
  },
  methods: {
    refreshSections() {
      SectionDataService.retrieveAllSections().then((res) => {
        this.sections = res.data;
      });
    },
    addSection() {
      this.$router.push(`/sections/-1`);
    },
    updateSection(id_section) {
      this.$router.push(`/sections/${id_section}`);
    },
    deleteSection(id_section) {
      SectionDataService.deleteSection(id_section).then(() => {
        this.refreshSections();
      });
    },
  },
  computed: {
    visibleFields() {
      return this.fields.filter(field => field.visible)
    },
    rows() {
      return this.sections.length
    }
  },
  created() {
    this.refreshSections()
    this.fields[4].visible = this.$router.app.$keycloak.hasRealmRole('editSection')
    this.fields[5].visible = this.$router.app.$keycloak.hasRealmRole('editSection')
  }
}
</script>
