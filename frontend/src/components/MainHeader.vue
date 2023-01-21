<template>
  <header>
    <div class="container">
      <div class="links">
        <img src="@/assets/sport_logo.png" class="img-logo" alt="logo" >
        <router-link :to="{ name: 'Schedules' }" v-if="$keycloak.hasRealmRole('watchSSL')">
          Расписание
        </router-link>
        <router-link :to="{ name: 'Sections' }" v-if="$keycloak.hasRealmRole('watchSSL')" >
          Секции
        </router-link>
        <router-link :to="{ name: 'Trainers' }" v-if="$keycloak.hasRealmRole('watchTH')">
          Тренера
        </router-link>
        <router-link :to="{ name: 'Learners' }" v-if="$keycloak.hasRealmRole('watchSSL')">
          Учащиеся
        </router-link>
		<router-link :to="{ name: 'Places' }" v-if="$keycloak.hasRealmRole('watchP')">
          Места
        </router-link>
        <router-link :to="{ name: 'HeaderSchedules' }" v-if="$keycloak.hasRealmRole('watchTH')">
          Заголовки расписания
        </router-link>
		<!--<p class="kcName">{{ $keycloak.tokenParsed.preferred_username   }}</p>-->
		<router-link :to="{ name: 'mainForm' }" class="kcName">
          {{ $keycloak.tokenParsed.preferred_username   }}
        </router-link>
		
        <button type="button" class="btn btn-in-out" @click="$keycloak.logoutFn"> Выход
          <!--{{ 'Войти' /*auth ? 'Выйти' : 'Войти'*/ }}-->
        </button>		
      </div>
    </div>
  </header>

</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
.router-link-active {
  color: red;
}

.container {
  margin-top: 0;
  display: flex;
  align-items: baseline;
  background: #f7f8f2;
}

a {
  text-decoration: none;
  color: #2c7ecc;
  font-size: 25px;
  padding-right: 30px;
}

.links {
  display: flex;
  flex-grow: 1;
  align-items: center;
}

.btn {
  width: auto;
  margin-bottom: 0;
}
.img-logo{
  padding: 12px 30px;
  width: 50px;
}

.kcName{
  color: #2c7ecc;
  text-align: right;
  float: right;
  margin-left: auto;
  padding-right: 25px;
}

</style>
