--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.12
-- Dumped by pg_dump version 9.4.12
-- Started on 2019-09-01 21:33:23 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11870)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 183 (class 1259 OID 17989)
-- Name: com_chauff_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE com_chauff_seq
    START WITH 1247
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE com_chauff_seq OWNER TO manudomo;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 18000)
-- Name: com_chauff; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE com_chauff (
    id integer DEFAULT nextval('com_chauff_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    onoff boolean NOT NULL,
    done boolean DEFAULT false NOT NULL
);


ALTER TABLE com_chauff OWNER TO manudomo;

--
-- TOC entry 177 (class 1259 OID 16542)
-- Name: edfindex_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE edfindex_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE edfindex_seq OWNER TO manudomo;

--
-- TOC entry 179 (class 1259 OID 16546)
-- Name: edfindex; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE edfindex (
    id integer DEFAULT nextval('edfindex_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    value integer NOT NULL,
    type integer NOT NULL
);


ALTER TABLE edfindex OWNER TO manudomo;

--
-- TOC entry 191 (class 1259 OID 21389)
-- Name: error_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE error_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE error_seq OWNER TO manudomo;

--
-- TOC entry 181 (class 1259 OID 17971)
-- Name: hygro_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE hygro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE hygro_seq OWNER TO manudomo;

--
-- TOC entry 182 (class 1259 OID 17973)
-- Name: hygro; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE hygro (
    id integer DEFAULT nextval('hygro_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    value real NOT NULL
);


ALTER TABLE hygro OWNER TO manudomo;

--
-- TOC entry 178 (class 1259 OID 16544)
-- Name: intensity_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE intensity_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE intensity_seq OWNER TO manudomo;

--
-- TOC entry 180 (class 1259 OID 16553)
-- Name: intensity; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE intensity (
    id integer DEFAULT nextval('intensity_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    value integer NOT NULL
);


ALTER TABLE intensity OWNER TO manudomo;

--
-- TOC entry 187 (class 1259 OID 20280)
-- Name: mode_chauff_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE mode_chauff_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE mode_chauff_seq OWNER TO manudomo;

--
-- TOC entry 188 (class 1259 OID 20282)
-- Name: mode_chauff; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE mode_chauff (
    id integer DEFAULT nextval('mode_chauff_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    hourmode boolean NOT NULL
);


ALTER TABLE mode_chauff OWNER TO manudomo;

--
-- TOC entry 175 (class 1259 OID 16463)
-- Name: pression_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE pression_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE pression_seq OWNER TO manudomo;

--
-- TOC entry 176 (class 1259 OID 16465)
-- Name: pression; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE pression (
    id integer DEFAULT nextval('pression_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    valueabs real,
    valuerel real
);


ALTER TABLE pression OWNER TO manudomo;

--
-- TOC entry 192 (class 1259 OID 21391)
-- Name: serial_event; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE serial_event (
    id integer DEFAULT nextval('error_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    error_type character varying(5) DEFAULT '0'::character varying NOT NULL,
    success boolean DEFAULT false NOT NULL
);


ALTER TABLE serial_event OWNER TO manudomo;

--
-- TOC entry 184 (class 1259 OID 17991)
-- Name: temp_chauff_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE temp_chauff_seq
    START WITH 2
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE temp_chauff_seq OWNER TO manudomo;

--
-- TOC entry 185 (class 1259 OID 17993)
-- Name: temp_chauff; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE temp_chauff (
    id integer DEFAULT nextval('temp_chauff_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    temp smallint NOT NULL,
    start_hour time without time zone,
    end_hour time without time zone
);


ALTER TABLE temp_chauff OWNER TO manudomo;

--
-- TOC entry 173 (class 1259 OID 16454)
-- Name: temperature_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE temperature_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE temperature_seq OWNER TO manudomo;

--
-- TOC entry 174 (class 1259 OID 16456)
-- Name: temperature; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE temperature (
    id integer DEFAULT nextval('temperature_seq'::regclass) NOT NULL,
    date timestamp without time zone DEFAULT now() NOT NULL,
    value real NOT NULL,
    type integer DEFAULT 1 NOT NULL
);


ALTER TABLE temperature OWNER TO manudomo;

--
-- TOC entry 189 (class 1259 OID 20686)
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: manudomo
--

CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483648
    CACHE 1;


ALTER TABLE user_seq OWNER TO manudomo;

--
-- TOC entry 190 (class 1259 OID 20695)
-- Name: user; Type: TABLE; Schema: public; Owner: manudomo; Tablespace: 
--

CREATE TABLE "user" (
    id integer DEFAULT nextval('user_seq'::regclass) NOT NULL,
    username text NOT NULL,
    password text NOT NULL
);


ALTER TABLE "user" OWNER TO manudomo;

--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-09-01 21:33:26 CEST

--
-- PostgreSQL database dump complete
--

