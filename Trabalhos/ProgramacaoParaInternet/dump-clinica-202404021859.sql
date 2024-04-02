--
-- PostgreSQL database cluster dump
--

-- Started on 2024-04-02 18:59:53

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-02 18:59:53

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

-- Completed on 2024-04-02 18:59:53

--
-- PostgreSQL database dump complete
--

--
-- Database "clinica" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-04-02 18:59:53

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

--
-- TOC entry 4843 (class 1262 OID 16419)
-- Name: clinica; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE clinica WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE clinica OWNER TO postgres;

\connect clinica

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
-- TOC entry 218 (class 1259 OID 16526)
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cidade (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    estadoid integer
);


ALTER TABLE public.cidade OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16525)
-- Name: cidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cidade_id_seq OWNER TO postgres;

--
-- TOC entry 4844 (class 0 OID 0)
-- Dependencies: 217
-- Name: cidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;


--
-- TOC entry 220 (class 1259 OID 16538)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    logradouro character varying(150) NOT NULL,
    numero integer NOT NULL,
    complemento character varying(100),
    bairro character varying(100) NOT NULL,
    cep character varying(12) NOT NULL,
    cidadeid integer
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16537)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 4845 (class 0 OID 0)
-- Dependencies: 219
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- TOC entry 226 (class 1259 OID 16592)
-- Name: especialidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especialidade (
    id integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.especialidade OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16591)
-- Name: especialidade_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.especialidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.especialidade_id_seq OWNER TO postgres;

--
-- TOC entry 4846 (class 0 OID 0)
-- Dependencies: 225
-- Name: especialidade_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.especialidade_id_seq OWNED BY public.especialidade.id;


--
-- TOC entry 216 (class 1259 OID 16519)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    sigla character varying(2) NOT NULL
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16518)
-- Name: estado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.estado_id_seq OWNER TO postgres;

--
-- TOC entry 4847 (class 0 OID 0)
-- Dependencies: 215
-- Name: estado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;


--
-- TOC entry 228 (class 1259 OID 16600)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medico (
    id integer NOT NULL,
    pessoaid integer,
    especialidadeid integer,
    crm character varying(9),
    statusregistro integer NOT NULL
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16599)
-- Name: medico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.medico_id_seq OWNER TO postgres;

--
-- TOC entry 4848 (class 0 OID 0)
-- Dependencies: 227
-- Name: medico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medico_id_seq OWNED BY public.medico.id;


--
-- TOC entry 224 (class 1259 OID 16566)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    pessoaid integer,
    statusregistro integer NOT NULL
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16565)
-- Name: paciente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.paciente_id_seq OWNER TO postgres;

--
-- TOC entry 4849 (class 0 OID 0)
-- Dependencies: 223
-- Name: paciente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_id_seq OWNED BY public.paciente.id;


--
-- TOC entry 222 (class 1259 OID 16550)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255),
    telefone character varying(15),
    cpf character varying(14),
    sexo character varying(20),
    enderecoid integer
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16549)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 4850 (class 0 OID 0)
-- Dependencies: 221
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.id;


--
-- TOC entry 4665 (class 2604 OID 16529)
-- Name: cidade id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);


--
-- TOC entry 4666 (class 2604 OID 16541)
-- Name: endereco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- TOC entry 4669 (class 2604 OID 16595)
-- Name: especialidade id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade ALTER COLUMN id SET DEFAULT nextval('public.especialidade_id_seq'::regclass);


--
-- TOC entry 4664 (class 2604 OID 16522)
-- Name: estado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);


--
-- TOC entry 4670 (class 2604 OID 16603)
-- Name: medico id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico ALTER COLUMN id SET DEFAULT nextval('public.medico_id_seq'::regclass);


--
-- TOC entry 4668 (class 2604 OID 16569)
-- Name: paciente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.paciente_id_seq'::regclass);


--
-- TOC entry 4667 (class 2604 OID 16553)
-- Name: pessoa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.pessoa_id_seq'::regclass);


--
-- TOC entry 4674 (class 2606 OID 16531)
-- Name: cidade cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);


--
-- TOC entry 4676 (class 2606 OID 16543)
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 4686 (class 2606 OID 16597)
-- Name: especialidade especialidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidade
    ADD CONSTRAINT especialidade_pkey PRIMARY KEY (id);


--
-- TOC entry 4672 (class 2606 OID 16524)
-- Name: estado estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);


--
-- TOC entry 4688 (class 2606 OID 16605)
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id);


--
-- TOC entry 4682 (class 2606 OID 16573)
-- Name: paciente paciente_pessoaid_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pessoaid_key UNIQUE (pessoaid);


--
-- TOC entry 4684 (class 2606 OID 16571)
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id);


--
-- TOC entry 4678 (class 2606 OID 16559)
-- Name: pessoa pessoa_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_cpf_key UNIQUE (cpf);


--
-- TOC entry 4680 (class 2606 OID 16557)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 4689 (class 2606 OID 16532)
-- Name: cidade cidade_estadoid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_estadoid_fkey FOREIGN KEY (estadoid) REFERENCES public.estado(id);


--
-- TOC entry 4690 (class 2606 OID 16544)
-- Name: endereco endereco_cidadeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_cidadeid_fkey FOREIGN KEY (cidadeid) REFERENCES public.cidade(id);


--
-- TOC entry 4693 (class 2606 OID 16611)
-- Name: medico medico_especialidadeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_especialidadeid_fkey FOREIGN KEY (especialidadeid) REFERENCES public.especialidade(id);


--
-- TOC entry 4694 (class 2606 OID 16606)
-- Name: medico medico_pessoaid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pessoaid_fkey FOREIGN KEY (pessoaid) REFERENCES public.pessoa(id);


--
-- TOC entry 4692 (class 2606 OID 16574)
-- Name: paciente paciente_pessoaid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pessoaid_fkey FOREIGN KEY (pessoaid) REFERENCES public.pessoa(id);


--
-- TOC entry 4691 (class 2606 OID 16560)
-- Name: pessoa pessoa_enderecoid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_enderecoid_fkey FOREIGN KEY (enderecoid) REFERENCES public.endereco(id);


-- Completed on 2024-04-02 18:59:53

--
-- PostgreSQL database dump complete
--

-- Completed on 2024-04-02 18:59:53

--
-- PostgreSQL database cluster dump complete
--

