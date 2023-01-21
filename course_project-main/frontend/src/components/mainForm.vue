<template>
  <div id="container" align="center" class="mainform">
    <main-header/>
	<img alt="Sport logo" style="margin-top:10px;" src="../assets/sport_logo.png">
	<h3>SportsTraining</h3>
    <p class="kcName">Добро пожаловать, {{$keycloak.tokenParsed.preferred_username  }}!</p> 
  </div>
</template>

<script>
import MainHeader from "@/components/MainHeader";
export default {
  name: "mainForm",
  components: {MainHeader}
}
</script>