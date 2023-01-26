--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-01-02 21:26:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 32795)
-- Name: HeaderSchedule; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."HeaderSchedule" (
    id_header_schedule integer NOT NULL,
    header_name character varying NOT NULL
);


ALTER TABLE public."HeaderSchedule" OWNER TO "Admin";

--
-- TOC entry 216 (class 1259 OID 32808)
-- Name: HeaderSchedule_id_header_schedule_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."HeaderSchedule_id_header_schedule_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."HeaderSchedule_id_header_schedule_seq" OWNER TO "Admin";

--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 216
-- Name: HeaderSchedule_id_header_schedule_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."HeaderSchedule_id_header_schedule_seq" OWNED BY public."HeaderSchedule".id_header_schedule;


--
-- TOC entry 211 (class 1259 OID 32786)
-- Name: Learner; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."Learner" (
    id_learner integer NOT NULL,
    last_name character varying NOT NULL,
    first_name character varying NOT NULL,
    middle_name character varying,
    phone character varying,
    birthday date,
    id_section integer
);


ALTER TABLE public."Learner" OWNER TO "Admin";

--
-- TOC entry 219 (class 1259 OID 32840)
-- Name: Learner_id_learner_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."Learner_id_learner_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Learner_id_learner_seq" OWNER TO "Admin";

--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 219
-- Name: Learner_id_learner_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."Learner_id_learner_seq" OWNED BY public."Learner".id_learner;


--
-- TOC entry 212 (class 1259 OID 32789)
-- Name: Place; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."Place" (
    id_place integer NOT NULL,
    place_name character varying NOT NULL
);


ALTER TABLE public."Place" OWNER TO "Admin";

--
-- TOC entry 215 (class 1259 OID 32798)
-- Name: Place_id_place_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."Place_id_place_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Place_id_place_seq" OWNER TO "Admin";

--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 215
-- Name: Place_id_place_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."Place_id_place_seq" OWNED BY public."Place".id_place;


--
-- TOC entry 213 (class 1259 OID 32792)
-- Name: Schedule; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."Schedule" (
    id_schedule integer NOT NULL,
    id_place integer,
    id_section integer,
    id_header_schedule integer,
    date date NOT NULL,
    time_start time without time zone NOT NULL,
    time_end integer NOT NULL,
    cancell boolean,
    approved boolean,
    note character varying
);


ALTER TABLE public."Schedule" OWNER TO "Admin";

--
-- TOC entry 220 (class 1259 OID 32854)
-- Name: Schedule_id_schedule_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."Schedule_id_schedule_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Schedule_id_schedule_seq" OWNER TO "Admin";

--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 220
-- Name: Schedule_id_schedule_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."Schedule_id_schedule_seq" OWNED BY public."Schedule".id_schedule;


--
-- TOC entry 210 (class 1259 OID 32783)
-- Name: Section; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."Section" (
    id_section integer NOT NULL,
    section_name character varying NOT NULL,
    id_trainer integer
);


ALTER TABLE public."Section" OWNER TO "Admin";

--
-- TOC entry 218 (class 1259 OID 32826)
-- Name: Section_id_section_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."Section_id_section_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Section_id_section_seq" OWNER TO "Admin";

--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 218
-- Name: Section_id_section_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."Section_id_section_seq" OWNED BY public."Section".id_section;


--
-- TOC entry 209 (class 1259 OID 32780)
-- Name: Trainer; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public."Trainer" (
    id_trainer integer NOT NULL,
    last_name character varying NOT NULL,
    first_name character varying NOT NULL,
    middle_name character varying,
    phone character varying,
    birthday date
);


ALTER TABLE public."Trainer" OWNER TO "Admin";

--
-- TOC entry 217 (class 1259 OID 32817)
-- Name: Trainer_id_trainer_seq; Type: SEQUENCE; Schema: public; Owner: Admin
--

CREATE SEQUENCE public."Trainer_id_trainer_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Trainer_id_trainer_seq" OWNER TO "Admin";

--
-- TOC entry 3416 (class 0 OID 0)
-- Dependencies: 217
-- Name: Trainer_id_trainer_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Admin
--

ALTER SEQUENCE public."Trainer_id_trainer_seq" OWNED BY public."Trainer".id_trainer;


--
-- TOC entry 221 (class 1259 OID 32878)
-- Name: headerschedule; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.headerschedule (
    id_header_schedule bigint NOT NULL,
    header_name character varying(255)
);


ALTER TABLE public.headerschedule OWNER TO "Admin";

--
-- TOC entry 222 (class 1259 OID 32883)
-- Name: learner; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.learner (
    id_trainer bigint NOT NULL,
    birthday date,
    first_name character varying(255),
    id_section bigint,
    last_name character varying(255),
    middle_name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.learner OWNER TO "Admin";

--
-- TOC entry 223 (class 1259 OID 32890)
-- Name: place; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.place (
    id_place bigint NOT NULL,
    place_name character varying(255)
);


ALTER TABLE public.place OWNER TO "Admin";

--
-- TOC entry 224 (class 1259 OID 32895)
-- Name: schedule; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.schedule (
    id_schedule bigint NOT NULL,
    approved boolean,
    cansell boolean,
    date date,
    id_header_schedule bigint,
    id_place bigint,
    id_section bigint,
    note character varying(255),
    time_end time without time zone,
    time_start time without time zone
);


ALTER TABLE public.schedule OWNER TO "Admin";

--
-- TOC entry 225 (class 1259 OID 32900)
-- Name: section; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.section (
    id_section bigint NOT NULL,
    id_trainer bigint,
    section_name character varying(255)
);


ALTER TABLE public.section OWNER TO "Admin";

--
-- TOC entry 226 (class 1259 OID 32905)
-- Name: trainer; Type: TABLE; Schema: public; Owner: Admin
--

CREATE TABLE public.trainer (
    id_trainer bigint NOT NULL,
    birthday date,
    first_name character varying(255),
    last_name character varying(255),
    middle_name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.trainer OWNER TO "Admin";

--
-- TOC entry 3218 (class 2604 OID 32809)
-- Name: HeaderSchedule id_header_schedule; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."HeaderSchedule" ALTER COLUMN id_header_schedule SET DEFAULT nextval('public."HeaderSchedule_id_header_schedule_seq"'::regclass);


--
-- TOC entry 3215 (class 2604 OID 32841)
-- Name: Learner id_learner; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Learner" ALTER COLUMN id_learner SET DEFAULT nextval('public."Learner_id_learner_seq"'::regclass);


--
-- TOC entry 3216 (class 2604 OID 32799)
-- Name: Place id_place; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Place" ALTER COLUMN id_place SET DEFAULT nextval('public."Place_id_place_seq"'::regclass);


--
-- TOC entry 3217 (class 2604 OID 32855)
-- Name: Schedule id_schedule; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Schedule" ALTER COLUMN id_schedule SET DEFAULT nextval('public."Schedule_id_schedule_seq"'::regclass);


--
-- TOC entry 3214 (class 2604 OID 32827)
-- Name: Section id_section; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Section" ALTER COLUMN id_section SET DEFAULT nextval('public."Section_id_section_seq"'::regclass);


--
-- TOC entry 3213 (class 2604 OID 32818)
-- Name: Trainer id_trainer; Type: DEFAULT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Trainer" ALTER COLUMN id_trainer SET DEFAULT nextval('public."Trainer_id_trainer_seq"'::regclass);


--
-- TOC entry 3393 (class 0 OID 32795)
-- Dependencies: 214
-- Data for Name: HeaderSchedule; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."HeaderSchedule" (id_header_schedule, header_name) FROM stdin;
\.


--
-- TOC entry 3390 (class 0 OID 32786)
-- Dependencies: 211
-- Data for Name: Learner; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."Learner" (id_learner, last_name, first_name, middle_name, phone, birthday, id_section) FROM stdin;
\.


--
-- TOC entry 3391 (class 0 OID 32789)
-- Dependencies: 212
-- Data for Name: Place; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."Place" (id_place, place_name) FROM stdin;
\.


--
-- TOC entry 3392 (class 0 OID 32792)
-- Dependencies: 213
-- Data for Name: Schedule; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."Schedule" (id_schedule, id_place, id_section, id_header_schedule, date, time_start, time_end, cancell, approved, note) FROM stdin;
\.


--
-- TOC entry 3389 (class 0 OID 32783)
-- Dependencies: 210
-- Data for Name: Section; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."Section" (id_section, section_name, id_trainer) FROM stdin;
\.


--
-- TOC entry 3388 (class 0 OID 32780)
-- Dependencies: 209
-- Data for Name: Trainer; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public."Trainer" (id_trainer, last_name, first_name, middle_name, phone, birthday) FROM stdin;
\.


--
-- TOC entry 3400 (class 0 OID 32878)
-- Dependencies: 221
-- Data for Name: headerschedule; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.headerschedule (id_header_schedule, header_name) FROM stdin;
\.


--
-- TOC entry 3401 (class 0 OID 32883)
-- Dependencies: 222
-- Data for Name: learner; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.learner (id_trainer, birthday, first_name, id_section, last_name, middle_name, phone) FROM stdin;
\.


--
-- TOC entry 3402 (class 0 OID 32890)
-- Dependencies: 223
-- Data for Name: place; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.place (id_place, place_name) FROM stdin;
\.


--
-- TOC entry 3403 (class 0 OID 32895)
-- Dependencies: 224
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.schedule (id_schedule, approved, cansell, date, id_header_schedule, id_place, id_section, note, time_end, time_start) FROM stdin;
\.


--
-- TOC entry 3404 (class 0 OID 32900)
-- Dependencies: 225
-- Data for Name: section; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.section (id_section, id_trainer, section_name) FROM stdin;
\.


--
-- TOC entry 3405 (class 0 OID 32905)
-- Dependencies: 226
-- Data for Name: trainer; Type: TABLE DATA; Schema: public; Owner: Admin
--

COPY public.trainer (id_trainer, birthday, first_name, last_name, middle_name, phone) FROM stdin;
\.


--
-- TOC entry 3417 (class 0 OID 0)
-- Dependencies: 216
-- Name: HeaderSchedule_id_header_schedule_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."HeaderSchedule_id_header_schedule_seq"', 1, false);


--
-- TOC entry 3418 (class 0 OID 0)
-- Dependencies: 219
-- Name: Learner_id_learner_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."Learner_id_learner_seq"', 1, false);


--
-- TOC entry 3419 (class 0 OID 0)
-- Dependencies: 215
-- Name: Place_id_place_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."Place_id_place_seq"', 1, false);


--
-- TOC entry 3420 (class 0 OID 0)
-- Dependencies: 220
-- Name: Schedule_id_schedule_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."Schedule_id_schedule_seq"', 1, false);


--
-- TOC entry 3421 (class 0 OID 0)
-- Dependencies: 218
-- Name: Section_id_section_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."Section_id_section_seq"', 1, false);


--
-- TOC entry 3422 (class 0 OID 0)
-- Dependencies: 217
-- Name: Trainer_id_trainer_seq; Type: SEQUENCE SET; Schema: public; Owner: Admin
--

SELECT pg_catalog.setval('public."Trainer_id_trainer_seq"', 1, false);


--
-- TOC entry 3231 (class 2606 OID 32816)
-- Name: HeaderSchedule headerschedule_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."HeaderSchedule"
    ADD CONSTRAINT headerschedule_pk PRIMARY KEY (id_header_schedule);


--
-- TOC entry 3233 (class 2606 OID 32882)
-- Name: headerschedule headerschedule_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.headerschedule
    ADD CONSTRAINT headerschedule_pkey PRIMARY KEY (id_header_schedule);


--
-- TOC entry 3224 (class 2606 OID 32848)
-- Name: Learner learner_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Learner"
    ADD CONSTRAINT learner_pk PRIMARY KEY (id_learner);


--
-- TOC entry 3235 (class 2606 OID 32889)
-- Name: learner learner_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.learner
    ADD CONSTRAINT learner_pkey PRIMARY KEY (id_trainer);


--
-- TOC entry 3226 (class 2606 OID 32807)
-- Name: Place place_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Place"
    ADD CONSTRAINT place_pk PRIMARY KEY (id_place);


--
-- TOC entry 3237 (class 2606 OID 32894)
-- Name: place place_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.place
    ADD CONSTRAINT place_pkey PRIMARY KEY (id_place);


--
-- TOC entry 3229 (class 2606 OID 32862)
-- Name: Schedule schedule_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Schedule"
    ADD CONSTRAINT schedule_pk PRIMARY KEY (id_schedule);


--
-- TOC entry 3239 (class 2606 OID 32899)
-- Name: schedule schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (id_schedule);


--
-- TOC entry 3222 (class 2606 OID 32834)
-- Name: Section section_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Section"
    ADD CONSTRAINT section_pk PRIMARY KEY (id_section);


--
-- TOC entry 3241 (class 2606 OID 32904)
-- Name: section section_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.section
    ADD CONSTRAINT section_pkey PRIMARY KEY (id_section);


--
-- TOC entry 3220 (class 2606 OID 32825)
-- Name: Trainer trainer_pk; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Trainer"
    ADD CONSTRAINT trainer_pk PRIMARY KEY (id_trainer);


--
-- TOC entry 3243 (class 2606 OID 32911)
-- Name: trainer trainer_pkey; Type: CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT trainer_pkey PRIMARY KEY (id_trainer);


--
-- TOC entry 3227 (class 1259 OID 32805)
-- Name: place_place_name_uindex; Type: INDEX; Schema: public; Owner: Admin
--

CREATE UNIQUE INDEX place_place_name_uindex ON public."Place" USING btree (place_name);


--
-- TOC entry 3245 (class 2606 OID 32849)
-- Name: Learner learner_fk; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Learner"
    ADD CONSTRAINT learner_fk FOREIGN KEY (id_section) REFERENCES public."Section"(id_section) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3246 (class 2606 OID 32863)
-- Name: Schedule schedule_headerschedule_fk; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Schedule"
    ADD CONSTRAINT schedule_headerschedule_fk FOREIGN KEY (id_header_schedule) REFERENCES public."HeaderSchedule"(id_header_schedule) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3247 (class 2606 OID 32868)
-- Name: Schedule schedule_place_fk; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Schedule"
    ADD CONSTRAINT schedule_place_fk FOREIGN KEY (id_place) REFERENCES public."Place"(id_place) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3248 (class 2606 OID 32873)
-- Name: Schedule schedule_section_fk; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Schedule"
    ADD CONSTRAINT schedule_section_fk FOREIGN KEY (id_section) REFERENCES public."Section"(id_section) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3244 (class 2606 OID 32835)
-- Name: Section section_fk; Type: FK CONSTRAINT; Schema: public; Owner: Admin
--

ALTER TABLE ONLY public."Section"
    ADD CONSTRAINT section_fk FOREIGN KEY (id_trainer) REFERENCES public."Trainer"(id_trainer) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2022-01-02 21:26:31

--
-- PostgreSQL database dump complete
--
