import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [
        {
            path: "/",
            name: "mainForm",
            component: () => import("./components/mainForm"),
        },
        {
            path: "/maneform",
            name: "mainForm",
            component: () => import("./components/mainForm"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/trainers",
            name: "Trainers",
            component: () => import("./components/Trainers"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/learners",
            name: "Learners",
            component: () => import("./components/Learners"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/sections",
            name: "Sections",
            component: () => import("./components/Sections"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/places",
            name: "Places",
            component: () => import("./components/Places"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/schedules",
            name: "Schedules",
            component: () => import("./components/Schedules"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/headerschedules",
            name: "HeaderSchedules",
            component: () => import("./components/HeaderSchedules"),
            meta: {
                requiresAuth: true
            }
        },//add
        {
            path: "/trainers/:id_trainer",
            name: "Trainer",
            component: () => import("./components/addTrainer"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/learners/:id_learner",
            name: "Learner",
            component: () => import("./components/addLearner"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/sections/:id_section",
            name: "Section",
            component: () => import("./components/addSection"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/places/:id_place",
            name: "Place",
            component: () => import("./components/addPlace"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/schedules/:id_schedule",
            name: "Schedule",
            component: () => import("./components/addSchedule"),
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/headerschedules/:id_header_schedule",
            name: "HeaderSchedules",
            component: () => import("./components/addHeaderSchedule"),
            meta: {
                requiresAuth: true
            }
        },
    ]
});

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms))
}

router.beforeEach(async (to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // We wait for Keycloak init, then we can call all methods safely
        while (router.app.$keycloak.createLoginUrl === null) {
            await sleep(100)
        }
        if (router.app.$keycloak.authenticated) {
            //next()
            
            switch (to.name) {
                case 'Places' : !router.app.$keycloak.hasRealmRole("watchP") ? next('/schedules') : next(); break
                case 'HeaderSchedules' : !router.app.$keycloak.hasRealmRole("watchTH") ? next('/schedules'): next(); break
				case 'Trainers' : !router.app.$keycloak.hasRealmRole("watchTH") ? next('/schedules'): next(); break
                default:next()
            }            
            
        } else {
            const loginUrl = router.app.$keycloak.createLoginUrl()
            window.location.replace(loginUrl)
        }
    } else {
        next()
    }
})

export default router;
