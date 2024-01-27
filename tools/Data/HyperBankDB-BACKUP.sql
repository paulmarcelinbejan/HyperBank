--
-- PostgreSQL database dump
--

-- Dumped from database version 15.5
-- Dumped by pg_dump version 15.5

-- Started on 2024-01-22 23:18:36 CET

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

ALTER DATABASE "HyperBankDB" OWNER TO paulmarcelinbejan;

\connect "HyperBankDB"

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3907 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16438)
-- Name: account; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account (
    id_account bigint NOT NULL,
    fk_account_type integer NOT NULL
);


ALTER TABLE public.account OWNER TO paulmarcelinbejan;

--
-- TOC entry 231 (class 1259 OID 16584)
-- Name: account_external; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account_external (
    id_account bigint NOT NULL,
    fk_bank integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.account_external OWNER TO paulmarcelinbejan;

--
-- TOC entry 230 (class 1259 OID 16579)
-- Name: account_internal; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account_internal (
    id_account bigint NOT NULL,
    fk_customer bigint NOT NULL,
    fk_account_internal_type integer NOT NULL,
    fk_currency integer NOT NULL,
    balance numeric(12,2) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);


ALTER TABLE public.account_internal OWNER TO paulmarcelinbejan;

--
-- TOC entry 3908 (class 0 OID 0)
-- Dependencies: 230
-- Name: COLUMN account_internal.balance; Type: COMMENT; Schema: public; Owner: paulmarcelinbejan
--

COMMENT ON COLUMN public.account_internal.balance IS 'Current Balance on account';


--
-- TOC entry 238 (class 1259 OID 16897)
-- Name: account_internal_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account_internal_type (
    id_account_internal_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.account_internal_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 261 (class 1259 OID 17532)
-- Name: account_notification; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account_notification (
    id_account_notification bigint NOT NULL,
    fk_account bigint NOT NULL,
    title character varying(255) NOT NULL,
    message character varying(255) NOT NULL,
    date_time timestamp(6) with time zone NOT NULL
);


ALTER TABLE public.account_notification OWNER TO paulmarcelinbejan;

--
-- TOC entry 256 (class 1259 OID 17116)
-- Name: account_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.account_type (
    id_account_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.account_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 232 (class 1259 OID 16592)
-- Name: bank; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.bank (
    id_bank integer NOT NULL,
    bank_name character varying NOT NULL
);


ALTER TABLE public.bank OWNER TO paulmarcelinbejan;

--
-- TOC entry 217 (class 1259 OID 16419)
-- Name: bank_branch; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.bank_branch (
    id_bank_branch integer NOT NULL,
    fk_bank integer NOT NULL,
    fk_location bigint
);


ALTER TABLE public.bank_branch OWNER TO paulmarcelinbejan;

--
-- TOC entry 216 (class 1259 OID 16405)
-- Name: city; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.city (
    id_city integer NOT NULL,
    fk_country integer NOT NULL,
    city_name character varying(255) NOT NULL
);


ALTER TABLE public.city OWNER TO paulmarcelinbejan;

--
-- TOC entry 214 (class 1259 OID 16391)
-- Name: continent; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.continent (
    id_continent integer NOT NULL,
    continent_name character varying(255) NOT NULL
);


ALTER TABLE public.continent OWNER TO paulmarcelinbejan;

--
-- TOC entry 215 (class 1259 OID 16398)
-- Name: country; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.country (
    id_country integer NOT NULL,
    fk_continent integer NOT NULL,
    country_name character varying(255) NOT NULL
);


ALTER TABLE public.country OWNER TO paulmarcelinbejan;

--
-- TOC entry 258 (class 1259 OID 17180)
-- Name: currency; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.currency (
    id_currency integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.currency OWNER TO paulmarcelinbejan;

--
-- TOC entry 237 (class 1259 OID 16719)
-- Name: customer; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.customer (
    id_customer bigint NOT NULL,
    fk_customer_type integer NOT NULL
);


ALTER TABLE public.customer OWNER TO paulmarcelinbejan;

--
-- TOC entry 219 (class 1259 OID 16431)
-- Name: customer_individual; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.customer_individual (
    id_customer bigint NOT NULL,
    fk_nationality integer NOT NULL,
    fk_residence bigint NOT NULL,
    fk_sex_type integer NOT NULL,
    birth_date date NOT NULL,
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    phone_number character varying(255) NOT NULL
);


ALTER TABLE public.customer_individual OWNER TO paulmarcelinbejan;

--
-- TOC entry 227 (class 1259 OID 16540)
-- Name: customer_legal_entity; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.customer_legal_entity (
    id_customer bigint NOT NULL,
    fk_headquarters bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.customer_legal_entity OWNER TO paulmarcelinbejan;

--
-- TOC entry 257 (class 1259 OID 17148)
-- Name: customer_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.customer_type (
    id_customer_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.customer_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 260 (class 1259 OID 17527)
-- Name: deposit_account_details; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.deposit_account_details (
    id_account bigint NOT NULL,
    fk_interest_rate_fixed bigint NOT NULL
);


ALTER TABLE public.deposit_account_details OWNER TO paulmarcelinbejan;

--
-- TOC entry 218 (class 1259 OID 16424)
-- Name: employee; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.employee (
    id_employee bigint NOT NULL,
    fk_nationality integer NOT NULL,
    fk_residence bigint NOT NULL,
    fk_sex_type integer NOT NULL,
    fk_bank_branch integer NOT NULL,
    birth_date date NOT NULL,
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    phone_number character varying(255) NOT NULL
);


ALTER TABLE public.employee OWNER TO paulmarcelinbejan;

--
-- TOC entry 263 (class 1259 OID 17800)
-- Name: id_account_notification_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_account_notification_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_account_notification_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 245 (class 1259 OID 17088)
-- Name: id_account_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 5;


ALTER TABLE public.id_account_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 247 (class 1259 OID 17090)
-- Name: id_bank_branch_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_bank_branch_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 5;


ALTER TABLE public.id_bank_branch_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 246 (class 1259 OID 17089)
-- Name: id_bank_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_bank_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_bank_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 240 (class 1259 OID 17082)
-- Name: id_city_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_city_seq
    AS integer
    START WITH 222
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_city_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 241 (class 1259 OID 17083)
-- Name: id_continent_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_continent_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_continent_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 242 (class 1259 OID 17084)
-- Name: id_country_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_country_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_country_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 259 (class 1259 OID 17475)
-- Name: id_customer_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_customer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 10;


ALTER TABLE public.id_customer_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 244 (class 1259 OID 17087)
-- Name: id_employee_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_employee_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 5;


ALTER TABLE public.id_employee_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 248 (class 1259 OID 17092)
-- Name: id_interest_rate_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_interest_rate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 5;


ALTER TABLE public.id_interest_rate_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 249 (class 1259 OID 17093)
-- Name: id_interest_rate_variable_history_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_interest_rate_variable_history_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_interest_rate_variable_history_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 251 (class 1259 OID 17095)
-- Name: id_loan_history_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_loan_history_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_loan_history_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 250 (class 1259 OID 17094)
-- Name: id_loan_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_loan_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_loan_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 253 (class 1259 OID 17097)
-- Name: id_loan_status_history_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_loan_status_history_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_loan_status_history_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 252 (class 1259 OID 17096)
-- Name: id_loan_status_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_loan_status_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_loan_status_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 254 (class 1259 OID 17099)
-- Name: id_loan_transaction_history_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_loan_transaction_history_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 10;


ALTER TABLE public.id_loan_transaction_history_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 243 (class 1259 OID 17085)
-- Name: id_location_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_location_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_location_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 255 (class 1259 OID 17100)
-- Name: id_transaction_seq; Type: SEQUENCE; Schema: public; Owner: paulmarcelinbejan
--

CREATE SEQUENCE public.id_transaction_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 10;


ALTER TABLE public.id_transaction_seq OWNER TO paulmarcelinbejan;

--
-- TOC entry 225 (class 1259 OID 16518)
-- Name: interest_rate; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.interest_rate (
    id_interest_rate bigint NOT NULL,
    fk_interest_rate_type integer NOT NULL
);


ALTER TABLE public.interest_rate OWNER TO paulmarcelinbejan;

--
-- TOC entry 235 (class 1259 OID 16642)
-- Name: interest_rate_fixed; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.interest_rate_fixed (
    id_interest_rate bigint NOT NULL,
    percentage numeric(5,2) NOT NULL
);


ALTER TABLE public.interest_rate_fixed OWNER TO paulmarcelinbejan;

--
-- TOC entry 228 (class 1259 OID 16559)
-- Name: interest_rate_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.interest_rate_type (
    id_interest_rate_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.interest_rate_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 234 (class 1259 OID 16637)
-- Name: interest_rate_variable; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.interest_rate_variable (
    id_interest_rate bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.interest_rate_variable OWNER TO paulmarcelinbejan;

--
-- TOC entry 262 (class 1259 OID 17735)
-- Name: interest_rate_variable_history; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.interest_rate_variable_history (
    id_interest_rate_variable_history bigint NOT NULL,
    fk_interest_rate_variable bigint NOT NULL,
    percentage numeric(5,2) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);


ALTER TABLE public.interest_rate_variable_history OWNER TO paulmarcelinbejan;

--
-- TOC entry 222 (class 1259 OID 16448)
-- Name: loan; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan (
    id_loan bigint NOT NULL,
    fk_loan_type integer NOT NULL,
    fk_customer bigint NOT NULL,
    loan_principal numeric(12,2) NOT NULL
);


ALTER TABLE public.loan OWNER TO paulmarcelinbejan;

--
-- TOC entry 3909 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN loan.loan_principal; Type: COMMENT; Schema: public; Owner: paulmarcelinbejan
--

COMMENT ON COLUMN public.loan.loan_principal IS 'The amount of money that is being borrowed';


--
-- TOC entry 239 (class 1259 OID 17006)
-- Name: loan_history; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan_history (
    id_loan_history bigint NOT NULL,
    fk_loan bigint NOT NULL,
    fk_interest_type integer NOT NULL,
    fk_bank_branch integer NOT NULL,
    loan_term integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);


ALTER TABLE public.loan_history OWNER TO paulmarcelinbejan;

--
-- TOC entry 3910 (class 0 OID 0)
-- Dependencies: 239
-- Name: COLUMN loan_history.loan_term; Type: COMMENT; Schema: public; Owner: paulmarcelinbejan
--

COMMENT ON COLUMN public.loan_history.loan_term IS 'The months that the borrower has to repay the loan.';


--
-- TOC entry 224 (class 1259 OID 16511)
-- Name: loan_status; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan_status (
    id_loan_status integer NOT NULL,
    code character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE public.loan_status OWNER TO paulmarcelinbejan;

--
-- TOC entry 233 (class 1259 OID 16628)
-- Name: loan_status_history; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan_status_history (
    id_loan_status_history bigint NOT NULL,
    fk_loan bigint NOT NULL,
    fk_loan_status integer NOT NULL,
    start_date_time timestamp(6) with time zone NOT NULL,
    end_date_time timestamp(6) with time zone NOT NULL
);


ALTER TABLE public.loan_status_history OWNER TO paulmarcelinbejan;

--
-- TOC entry 229 (class 1259 OID 16574)
-- Name: loan_transaction_history; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan_transaction_history (
    id_loan_transaction_history bigint NOT NULL,
    fk_loan_history bigint NOT NULL,
    fk_interest_rate bigint NOT NULL,
    fk_transaction bigint NOT NULL,
    total_amount numeric(8,2) NOT NULL,
    interest_amount numeric(8,2) NOT NULL,
    service_fee numeric(6,2) NOT NULL
);


ALTER TABLE public.loan_transaction_history OWNER TO paulmarcelinbejan;

--
-- TOC entry 226 (class 1259 OID 16525)
-- Name: loan_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.loan_type (
    id_loan_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.loan_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 223 (class 1259 OID 16497)
-- Name: location; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.location (
    id_location bigint NOT NULL,
    fk_city integer NOT NULL,
    street_name character varying(255) NOT NULL,
    street_number integer NOT NULL,
    postal_code character varying(255) NOT NULL
);


ALTER TABLE public.location OWNER TO paulmarcelinbejan;

--
-- TOC entry 236 (class 1259 OID 16692)
-- Name: sex_type; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.sex_type (
    id_sex_type integer NOT NULL,
    code character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE public.sex_type OWNER TO paulmarcelinbejan;

--
-- TOC entry 221 (class 1259 OID 16443)
-- Name: transaction; Type: TABLE; Schema: public; Owner: paulmarcelinbejan
--

CREATE TABLE public.transaction (
    id_transaction bigint NOT NULL,
    fk_account_sender bigint NOT NULL,
    fk_account_receiver bigint NOT NULL,
    fk_currency integer NOT NULL,
    value numeric(12,2) NOT NULL,
    transaction_date_time timestamp(6) with time zone NOT NULL
);


ALTER TABLE public.transaction OWNER TO paulmarcelinbejan;

--
-- TOC entry 3857 (class 0 OID 16438)
-- Dependencies: 220
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3868 (class 0 OID 16584)
-- Dependencies: 231
-- Data for Name: account_external; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3867 (class 0 OID 16579)
-- Dependencies: 230
-- Data for Name: account_internal; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3875 (class 0 OID 16897)
-- Dependencies: 238
-- Data for Name: account_internal_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.account_internal_type VALUES (1, 'CHECKING', 'Unlimited access to money.');
INSERT INTO public.account_internal_type VALUES (2, 'SAVINGS', 'Limited access to money to earn small interest.');
INSERT INTO public.account_internal_type VALUES (3, 'DEPOSIT', 'Unability to access money for a specified period of time to earn fixed interest rate.');


--
-- TOC entry 3898 (class 0 OID 17532)
-- Dependencies: 261
-- Data for Name: account_notification; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3893 (class 0 OID 17116)
-- Dependencies: 256
-- Data for Name: account_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.account_type VALUES (1, 'INTERNAL', 'Bank account of a customer.');
INSERT INTO public.account_type VALUES (2, 'EXTERNAL', 'Bank account of a non-customer.');


--
-- TOC entry 3869 (class 0 OID 16592)
-- Dependencies: 232
-- Data for Name: bank; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.bank VALUES (1, 'UniCredit');
INSERT INTO public.bank VALUES (2, 'Intesa Sanpaolo');
INSERT INTO public.bank VALUES (3, 'Monte dei Paschi di Siena');
INSERT INTO public.bank VALUES (4, 'Fineco Bank');
INSERT INTO public.bank VALUES (5, 'Mediolanum');
INSERT INTO public.bank VALUES (6, 'BCR');
INSERT INTO public.bank VALUES (7, 'BRD');
INSERT INTO public.bank VALUES (8, 'Banca Transilvania');
INSERT INTO public.bank VALUES (9, 'CEC Bank');
INSERT INTO public.bank VALUES (10, 'Raiffeisen Bank');
INSERT INTO public.bank VALUES (11, 'Bank of America');
INSERT INTO public.bank VALUES (12, 'Citybank');
INSERT INTO public.bank VALUES (13, 'Wells Fargo');
INSERT INTO public.bank VALUES (14, 'Deutsche Bank');


--
-- TOC entry 3854 (class 0 OID 16419)
-- Dependencies: 217
-- Data for Name: bank_branch; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.bank_branch VALUES (1, 1, 2);
INSERT INTO public.bank_branch VALUES (6, 8, 7);
INSERT INTO public.bank_branch VALUES (11, 14, 44);
INSERT INTO public.bank_branch VALUES (16, 10, NULL);


--
-- TOC entry 3853 (class 0 OID 16405)
-- Dependencies: 216
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.city VALUES (2, 143, 'Alba Iulia');
INSERT INTO public.city VALUES (3, 143, 'Arad');
INSERT INTO public.city VALUES (4, 143, 'Bacău');
INSERT INTO public.city VALUES (5, 143, 'Baia Mare');
INSERT INTO public.city VALUES (6, 143, 'Bistrița');
INSERT INTO public.city VALUES (7, 143, 'Brașov');
INSERT INTO public.city VALUES (8, 143, 'Brăila');
INSERT INTO public.city VALUES (9, 143, 'Cluj-Napoca');
INSERT INTO public.city VALUES (10, 143, 'Constanța');
INSERT INTO public.city VALUES (11, 143, 'Craiova');
INSERT INTO public.city VALUES (12, 143, 'Deva');
INSERT INTO public.city VALUES (13, 143, 'Galați');
INSERT INTO public.city VALUES (14, 143, 'Iași');
INSERT INTO public.city VALUES (15, 143, 'Oradea');
INSERT INTO public.city VALUES (16, 143, 'Piatra Neamț');
INSERT INTO public.city VALUES (17, 143, 'Pitești');
INSERT INTO public.city VALUES (18, 143, 'Ploiești');
INSERT INTO public.city VALUES (19, 143, 'Râmnicu Vâlcea');
INSERT INTO public.city VALUES (20, 143, 'Reșița');
INSERT INTO public.city VALUES (21, 143, 'Satu Mare');
INSERT INTO public.city VALUES (22, 143, 'Sibiu');
INSERT INTO public.city VALUES (23, 143, 'Suceava');
INSERT INTO public.city VALUES (24, 143, 'Târgoviște');
INSERT INTO public.city VALUES (25, 143, 'Târgu Jiu');
INSERT INTO public.city VALUES (26, 143, 'Timișoara');
INSERT INTO public.city VALUES (27, 143, 'Tulcea');
INSERT INTO public.city VALUES (28, 143, 'Vaslui');
INSERT INTO public.city VALUES (29, 143, 'Zalău');
INSERT INTO public.city VALUES (30, 85, 'L''Aquila');
INSERT INTO public.city VALUES (31, 85, 'Potenza');
INSERT INTO public.city VALUES (32, 85, 'Catanzaro');
INSERT INTO public.city VALUES (33, 85, 'Napoli');
INSERT INTO public.city VALUES (34, 85, 'Bologna');
INSERT INTO public.city VALUES (35, 85, 'Trieste');
INSERT INTO public.city VALUES (36, 85, 'Roma');
INSERT INTO public.city VALUES (37, 85, 'Genova');
INSERT INTO public.city VALUES (38, 85, 'Milano');
INSERT INTO public.city VALUES (39, 85, 'Ancona');
INSERT INTO public.city VALUES (40, 85, 'Campobasso');
INSERT INTO public.city VALUES (41, 85, 'Torino');
INSERT INTO public.city VALUES (42, 85, 'Bari');
INSERT INTO public.city VALUES (43, 85, 'Cagliari');
INSERT INTO public.city VALUES (44, 85, 'Palermo');
INSERT INTO public.city VALUES (45, 85, 'Firenze');
INSERT INTO public.city VALUES (46, 85, 'Trento');
INSERT INTO public.city VALUES (47, 85, 'Perugia');
INSERT INTO public.city VALUES (48, 85, 'Aosta');
INSERT INTO public.city VALUES (49, 85, 'Venezia');
INSERT INTO public.city VALUES (50, 186, 'Birmingham');
INSERT INTO public.city VALUES (51, 186, 'Anchorage');
INSERT INTO public.city VALUES (52, 186, 'Phoenix');
INSERT INTO public.city VALUES (53, 186, 'Little Rock');
INSERT INTO public.city VALUES (54, 186, 'Los Angeles');
INSERT INTO public.city VALUES (55, 186, 'Denver');
INSERT INTO public.city VALUES (56, 186, 'Bridgeport');
INSERT INTO public.city VALUES (57, 186, 'Wilmington');
INSERT INTO public.city VALUES (58, 186, 'Miami');
INSERT INTO public.city VALUES (59, 186, 'Atlanta');
INSERT INTO public.city VALUES (60, 186, 'Honolulu');
INSERT INTO public.city VALUES (61, 186, 'Boise');
INSERT INTO public.city VALUES (62, 186, 'Chicago');
INSERT INTO public.city VALUES (63, 186, 'Indianapolis');
INSERT INTO public.city VALUES (64, 186, 'Des Moines');
INSERT INTO public.city VALUES (65, 186, 'Wichita');
INSERT INTO public.city VALUES (66, 186, 'Louisville');
INSERT INTO public.city VALUES (67, 186, 'New Orleans');
INSERT INTO public.city VALUES (68, 186, 'Portland');
INSERT INTO public.city VALUES (69, 186, 'Baltimore');
INSERT INTO public.city VALUES (70, 186, 'Boston');
INSERT INTO public.city VALUES (71, 186, 'Detroit');
INSERT INTO public.city VALUES (72, 186, 'Minneapolis');
INSERT INTO public.city VALUES (73, 186, 'Jackson');
INSERT INTO public.city VALUES (74, 186, 'Kansas City');
INSERT INTO public.city VALUES (75, 186, 'Billings');
INSERT INTO public.city VALUES (76, 186, 'Omaha');
INSERT INTO public.city VALUES (77, 186, 'Las Vegas');
INSERT INTO public.city VALUES (78, 186, 'Manchester');
INSERT INTO public.city VALUES (79, 186, 'Newark');
INSERT INTO public.city VALUES (80, 186, 'Albuquerque');
INSERT INTO public.city VALUES (81, 186, 'New York City');
INSERT INTO public.city VALUES (82, 186, 'Charlotte');
INSERT INTO public.city VALUES (83, 186, 'Fargo');
INSERT INTO public.city VALUES (84, 186, 'Columbus');
INSERT INTO public.city VALUES (85, 186, 'Oklahoma City');
INSERT INTO public.city VALUES (86, 186, 'Portland');
INSERT INTO public.city VALUES (87, 186, 'Philadelphia');
INSERT INTO public.city VALUES (88, 186, 'Providence');
INSERT INTO public.city VALUES (89, 186, 'Charleston');
INSERT INTO public.city VALUES (90, 186, 'Sioux Falls');
INSERT INTO public.city VALUES (91, 186, 'Nashville');
INSERT INTO public.city VALUES (92, 186, 'Houston');
INSERT INTO public.city VALUES (93, 186, 'Salt Lake City');
INSERT INTO public.city VALUES (94, 186, 'Burlington');
INSERT INTO public.city VALUES (95, 186, 'Richmond');
INSERT INTO public.city VALUES (96, 186, 'Seattle');
INSERT INTO public.city VALUES (97, 186, 'Charleston');
INSERT INTO public.city VALUES (98, 186, 'Milwaukee');
INSERT INTO public.city VALUES (99, 186, 'Cheyenne');
INSERT INTO public.city VALUES (100, 184, 'Bath');
INSERT INTO public.city VALUES (101, 184, 'Birmingham');
INSERT INTO public.city VALUES (102, 184, 'Bradford');
INSERT INTO public.city VALUES (103, 184, 'Brighton & Hove');
INSERT INTO public.city VALUES (104, 184, 'Bristol');
INSERT INTO public.city VALUES (105, 184, 'Cambridge');
INSERT INTO public.city VALUES (106, 184, 'Canterbury');
INSERT INTO public.city VALUES (107, 184, 'Carlisle');
INSERT INTO public.city VALUES (108, 184, 'Chelmsford');
INSERT INTO public.city VALUES (109, 184, 'Chester');
INSERT INTO public.city VALUES (110, 184, 'Chichester');
INSERT INTO public.city VALUES (111, 184, 'Colchester');
INSERT INTO public.city VALUES (112, 184, 'Coventry');
INSERT INTO public.city VALUES (113, 184, 'Derby');
INSERT INTO public.city VALUES (114, 184, 'Doncaster');
INSERT INTO public.city VALUES (115, 184, 'Durham');
INSERT INTO public.city VALUES (116, 184, 'Ely');
INSERT INTO public.city VALUES (117, 184, 'Exeter');
INSERT INTO public.city VALUES (118, 184, 'Gloucester');
INSERT INTO public.city VALUES (119, 184, 'Hereford');
INSERT INTO public.city VALUES (120, 184, 'Kingston-upon-Hull');
INSERT INTO public.city VALUES (121, 184, 'Lancaster');
INSERT INTO public.city VALUES (122, 184, 'Leeds');
INSERT INTO public.city VALUES (123, 184, 'Leicester');
INSERT INTO public.city VALUES (124, 184, 'Lichfield');
INSERT INTO public.city VALUES (125, 184, 'Lincoln');
INSERT INTO public.city VALUES (126, 184, 'Liverpool');
INSERT INTO public.city VALUES (127, 184, 'London');
INSERT INTO public.city VALUES (128, 184, 'Manchester');
INSERT INTO public.city VALUES (129, 184, 'Milton Keynes');
INSERT INTO public.city VALUES (130, 184, 'Newcastle-upon-Tyne');
INSERT INTO public.city VALUES (131, 184, 'Norwich');
INSERT INTO public.city VALUES (132, 184, 'Nottingham');
INSERT INTO public.city VALUES (133, 184, 'Oxford');
INSERT INTO public.city VALUES (134, 184, 'Peterborough');
INSERT INTO public.city VALUES (135, 184, 'Plymouth');
INSERT INTO public.city VALUES (136, 184, 'Portsmouth');
INSERT INTO public.city VALUES (137, 184, 'Preston');
INSERT INTO public.city VALUES (138, 184, 'Ripon');
INSERT INTO public.city VALUES (139, 184, 'Salford');
INSERT INTO public.city VALUES (140, 184, 'Salisbury');
INSERT INTO public.city VALUES (141, 184, 'Sheffield');
INSERT INTO public.city VALUES (142, 184, 'Southampton');
INSERT INTO public.city VALUES (143, 184, 'Southend-on-Sea');
INSERT INTO public.city VALUES (144, 184, 'St Albans');
INSERT INTO public.city VALUES (145, 184, 'Stoke on Trent');
INSERT INTO public.city VALUES (146, 184, 'Sunderland');
INSERT INTO public.city VALUES (147, 184, 'Truro');
INSERT INTO public.city VALUES (148, 184, 'Wakefield');
INSERT INTO public.city VALUES (149, 184, 'Wells');
INSERT INTO public.city VALUES (150, 184, 'Westminster');
INSERT INTO public.city VALUES (151, 184, 'Winchester');
INSERT INTO public.city VALUES (152, 184, 'Wolverhampton');
INSERT INTO public.city VALUES (153, 184, 'Worcester');
INSERT INTO public.city VALUES (154, 184, 'York');
INSERT INTO public.city VALUES (155, 184, 'Armagh');
INSERT INTO public.city VALUES (156, 184, 'Bangor');
INSERT INTO public.city VALUES (157, 184, 'Belfast');
INSERT INTO public.city VALUES (158, 184, 'Lisburn');
INSERT INTO public.city VALUES (159, 184, 'Londonderry');
INSERT INTO public.city VALUES (160, 184, 'Newry');
INSERT INTO public.city VALUES (161, 184, 'Aberdeen');
INSERT INTO public.city VALUES (162, 184, 'Dundee');
INSERT INTO public.city VALUES (163, 184, 'Dunfermline');
INSERT INTO public.city VALUES (164, 184, 'Edinburgh');
INSERT INTO public.city VALUES (165, 184, 'Glasgow');
INSERT INTO public.city VALUES (166, 184, 'Inverness');
INSERT INTO public.city VALUES (167, 184, 'Perth');
INSERT INTO public.city VALUES (168, 184, 'Stirling');
INSERT INTO public.city VALUES (169, 184, 'Bangor');
INSERT INTO public.city VALUES (170, 184, 'Cardiff');
INSERT INTO public.city VALUES (171, 184, 'Newport');
INSERT INTO public.city VALUES (172, 184, 'St Asaph');
INSERT INTO public.city VALUES (173, 184, 'St Davids');
INSERT INTO public.city VALUES (174, 184, 'Swansea');
INSERT INTO public.city VALUES (175, 184, 'Wrexham');
INSERT INTO public.city VALUES (176, 164, 'Seville');
INSERT INTO public.city VALUES (177, 164, 'Zaragoza');
INSERT INTO public.city VALUES (178, 164, 'Oviedo');
INSERT INTO public.city VALUES (179, 164, 'Palma');
INSERT INTO public.city VALUES (180, 164, 'Bilbao');
INSERT INTO public.city VALUES (181, 164, 'Las Palmas de Gran Canaria');
INSERT INTO public.city VALUES (182, 164, 'Santander');
INSERT INTO public.city VALUES (183, 164, 'Valladolid');
INSERT INTO public.city VALUES (184, 164, 'Toledo');
INSERT INTO public.city VALUES (185, 164, 'Barcelona');
INSERT INTO public.city VALUES (186, 164, 'Merida');
INSERT INTO public.city VALUES (187, 164, 'Santiago de Compostela');
INSERT INTO public.city VALUES (188, 164, 'Logrono');
INSERT INTO public.city VALUES (189, 164, 'Madrid');
INSERT INTO public.city VALUES (190, 164, 'Murcia');
INSERT INTO public.city VALUES (191, 164, 'Pamplona');
INSERT INTO public.city VALUES (192, 164, 'Valencia');
INSERT INTO public.city VALUES (193, 63, 'Paris');
INSERT INTO public.city VALUES (194, 63, 'Lyon');
INSERT INTO public.city VALUES (195, 63, 'Marseille');
INSERT INTO public.city VALUES (196, 63, 'Toulouse');
INSERT INTO public.city VALUES (197, 63, 'Lille');
INSERT INTO public.city VALUES (198, 63, 'Rennes');
INSERT INTO public.city VALUES (199, 63, 'Bordeaux');
INSERT INTO public.city VALUES (200, 63, 'Strasbourg');
INSERT INTO public.city VALUES (201, 63, 'Nantes');
INSERT INTO public.city VALUES (202, 63, 'Orleans');
INSERT INTO public.city VALUES (203, 63, 'Rouen');
INSERT INTO public.city VALUES (204, 63, 'Ajaccio');
INSERT INTO public.city VALUES (205, 63, 'Dijon');
INSERT INTO public.city VALUES (206, 63, 'Saint-Pierre');
INSERT INTO public.city VALUES (207, 63, 'Saint-Denis');
INSERT INTO public.city VALUES (208, 67, 'Berlin');
INSERT INTO public.city VALUES (209, 67, 'Hamburg');
INSERT INTO public.city VALUES (210, 67, 'Munich');
INSERT INTO public.city VALUES (211, 67, 'Cologne');
INSERT INTO public.city VALUES (212, 67, 'Frankfurt');
INSERT INTO public.city VALUES (213, 67, 'Stuttgart');
INSERT INTO public.city VALUES (214, 67, 'Dusseldorf');
INSERT INTO public.city VALUES (215, 67, 'Leipzig');
INSERT INTO public.city VALUES (216, 67, 'Dortmund');
INSERT INTO public.city VALUES (217, 67, 'Essen');
INSERT INTO public.city VALUES (218, 67, 'Bremen');
INSERT INTO public.city VALUES (219, 67, 'Dresden');
INSERT INTO public.city VALUES (220, 67, 'Hanover');
INSERT INTO public.city VALUES (221, 67, 'Nuremberg');
INSERT INTO public.city VALUES (222, 67, 'Duisburg');
INSERT INTO public.city VALUES (223, 186, 'Cupertino');
INSERT INTO public.city VALUES (224, 186, 'Mountain View');
INSERT INTO public.city VALUES (1, 143, 'București');
INSERT INTO public.city VALUES (225, 9, 'Sydney');


--
-- TOC entry 3851 (class 0 OID 16391)
-- Dependencies: 214
-- Data for Name: continent; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.continent VALUES (1, 'Africa');
INSERT INTO public.continent VALUES (2, 'Asia');
INSERT INTO public.continent VALUES (3, 'Europe');
INSERT INTO public.continent VALUES (4, 'North America');
INSERT INTO public.continent VALUES (5, 'South America');
INSERT INTO public.continent VALUES (6, 'Antarctica');
INSERT INTO public.continent VALUES (7, 'Oceania');


--
-- TOC entry 3852 (class 0 OID 16398)
-- Dependencies: 215
-- Data for Name: country; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.country VALUES (1, 2, 'Afghanistan');
INSERT INTO public.country VALUES (2, 3, 'Albania');
INSERT INTO public.country VALUES (3, 1, 'Algeria');
INSERT INTO public.country VALUES (4, 3, 'Andorra');
INSERT INTO public.country VALUES (5, 1, 'Angola');
INSERT INTO public.country VALUES (6, 5, 'Antigua and Barbuda');
INSERT INTO public.country VALUES (7, 5, 'Argentina');
INSERT INTO public.country VALUES (8, 3, 'Armenia');
INSERT INTO public.country VALUES (9, 7, 'Australia');
INSERT INTO public.country VALUES (10, 3, 'Austria');
INSERT INTO public.country VALUES (11, 2, 'Azerbaijan');
INSERT INTO public.country VALUES (12, 4, 'Bahamas');
INSERT INTO public.country VALUES (13, 2, 'Bahrain');
INSERT INTO public.country VALUES (14, 2, 'Bangladesh');
INSERT INTO public.country VALUES (15, 4, 'Barbados');
INSERT INTO public.country VALUES (16, 3, 'Belarus');
INSERT INTO public.country VALUES (17, 3, 'Belgium');
INSERT INTO public.country VALUES (18, 5, 'Belize');
INSERT INTO public.country VALUES (19, 1, 'Benin');
INSERT INTO public.country VALUES (20, 2, 'Bhutan');
INSERT INTO public.country VALUES (21, 5, 'Bolivia');
INSERT INTO public.country VALUES (22, 3, 'Bosnia and Herzegovina');
INSERT INTO public.country VALUES (23, 1, 'Botswana');
INSERT INTO public.country VALUES (24, 5, 'Brazil');
INSERT INTO public.country VALUES (25, 2, 'Brunei Darussalam');
INSERT INTO public.country VALUES (26, 3, 'Bulgaria');
INSERT INTO public.country VALUES (27, 1, 'Burkina Faso');
INSERT INTO public.country VALUES (28, 1, 'Burundi');
INSERT INTO public.country VALUES (29, 1, 'Cabo Verde');
INSERT INTO public.country VALUES (30, 2, 'Cambodia');
INSERT INTO public.country VALUES (31, 1, 'Cameroon');
INSERT INTO public.country VALUES (32, 4, 'Canada');
INSERT INTO public.country VALUES (33, 1, 'Central African Republic');
INSERT INTO public.country VALUES (34, 1, 'Chad');
INSERT INTO public.country VALUES (35, 5, 'Chile');
INSERT INTO public.country VALUES (36, 2, 'China');
INSERT INTO public.country VALUES (37, 5, 'Colombia');
INSERT INTO public.country VALUES (38, 1, 'Comoros');
INSERT INTO public.country VALUES (39, 1, 'Congo');
INSERT INTO public.country VALUES (40, 7, 'Cook Islands');
INSERT INTO public.country VALUES (41, 4, 'Costa Rica');
INSERT INTO public.country VALUES (42, 1, 'Cote d''Ivoire');
INSERT INTO public.country VALUES (43, 3, 'Croatia');
INSERT INTO public.country VALUES (44, 4, 'Cuba');
INSERT INTO public.country VALUES (45, 3, 'Cyprus');
INSERT INTO public.country VALUES (46, 3, 'Czechia');
INSERT INTO public.country VALUES (47, 2, 'Democratic People''s Republic of Korea');
INSERT INTO public.country VALUES (48, 1, 'Democratic Republic of the Congo');
INSERT INTO public.country VALUES (49, 3, 'Denmark');
INSERT INTO public.country VALUES (50, 1, 'Djibouti');
INSERT INTO public.country VALUES (51, 5, 'Dominica');
INSERT INTO public.country VALUES (52, 5, 'Dominican Republic');
INSERT INTO public.country VALUES (53, 5, 'Ecuador');
INSERT INTO public.country VALUES (54, 1, 'Egypt');
INSERT INTO public.country VALUES (55, 4, 'El Salvador');
INSERT INTO public.country VALUES (56, 1, 'Equatorial Guinea');
INSERT INTO public.country VALUES (57, 1, 'Eritrea');
INSERT INTO public.country VALUES (58, 3, 'Estonia');
INSERT INTO public.country VALUES (59, 1, 'Eswatini');
INSERT INTO public.country VALUES (60, 1, 'Ethiopia');
INSERT INTO public.country VALUES (61, 7, 'Fiji');
INSERT INTO public.country VALUES (62, 3, 'Finland');
INSERT INTO public.country VALUES (63, 3, 'France');
INSERT INTO public.country VALUES (64, 1, 'Gabon');
INSERT INTO public.country VALUES (65, 1, 'Gambia');
INSERT INTO public.country VALUES (66, 3, 'Georgia');
INSERT INTO public.country VALUES (67, 3, 'Germany');
INSERT INTO public.country VALUES (68, 1, 'Ghana');
INSERT INTO public.country VALUES (69, 3, 'Greece');
INSERT INTO public.country VALUES (70, 5, 'Grenada');
INSERT INTO public.country VALUES (71, 5, 'Guatemala');
INSERT INTO public.country VALUES (72, 1, 'Guinea');
INSERT INTO public.country VALUES (73, 1, 'Guinea-Bissau');
INSERT INTO public.country VALUES (74, 5, 'Guyana');
INSERT INTO public.country VALUES (75, 5, 'Haiti');
INSERT INTO public.country VALUES (76, 5, 'Honduras');
INSERT INTO public.country VALUES (77, 3, 'Hungary');
INSERT INTO public.country VALUES (78, 3, 'Iceland');
INSERT INTO public.country VALUES (79, 2, 'India');
INSERT INTO public.country VALUES (80, 2, 'Indonesia');
INSERT INTO public.country VALUES (81, 2, 'Iran');
INSERT INTO public.country VALUES (82, 2, 'Iraq');
INSERT INTO public.country VALUES (83, 3, 'Ireland');
INSERT INTO public.country VALUES (84, 2, 'Israel');
INSERT INTO public.country VALUES (85, 3, 'Italy');
INSERT INTO public.country VALUES (86, 5, 'Jamaica');
INSERT INTO public.country VALUES (87, 2, 'Japan');
INSERT INTO public.country VALUES (88, 2, 'Jordan');
INSERT INTO public.country VALUES (89, 2, 'Kazakhstan');
INSERT INTO public.country VALUES (90, 1, 'Kenya');
INSERT INTO public.country VALUES (91, 7, 'Kiribati');
INSERT INTO public.country VALUES (92, 2, 'Kuwait');
INSERT INTO public.country VALUES (93, 2, 'Kyrgyzstan');
INSERT INTO public.country VALUES (94, 2, 'Lao People''s Democratic Republic');
INSERT INTO public.country VALUES (95, 3, 'Latvia');
INSERT INTO public.country VALUES (96, 2, 'Lebanon');
INSERT INTO public.country VALUES (97, 1, 'Lesotho');
INSERT INTO public.country VALUES (98, 1, 'Liberia');
INSERT INTO public.country VALUES (99, 1, 'Libya');
INSERT INTO public.country VALUES (100, 3, 'Lithuania');
INSERT INTO public.country VALUES (101, 3, 'Luxembourg');
INSERT INTO public.country VALUES (102, 1, 'Madagascar');
INSERT INTO public.country VALUES (103, 1, 'Malawi');
INSERT INTO public.country VALUES (104, 2, 'Malaysia');
INSERT INTO public.country VALUES (105, 2, 'Maldives');
INSERT INTO public.country VALUES (106, 1, 'Mali');
INSERT INTO public.country VALUES (107, 3, 'Malta');
INSERT INTO public.country VALUES (108, 7, 'Marshall Islands');
INSERT INTO public.country VALUES (109, 1, 'Mauritania');
INSERT INTO public.country VALUES (110, 1, 'Mauritius');
INSERT INTO public.country VALUES (111, 4, 'Mexico');
INSERT INTO public.country VALUES (112, 7, 'Micronesia');
INSERT INTO public.country VALUES (113, 3, 'Monaco');
INSERT INTO public.country VALUES (114, 2, 'Mongolia');
INSERT INTO public.country VALUES (115, 3, 'Montenegro');
INSERT INTO public.country VALUES (116, 1, 'Morocco');
INSERT INTO public.country VALUES (117, 1, 'Mozambique');
INSERT INTO public.country VALUES (118, 2, 'Myanmar');
INSERT INTO public.country VALUES (119, 1, 'Namibia');
INSERT INTO public.country VALUES (120, 7, 'Nauru');
INSERT INTO public.country VALUES (121, 2, 'Nepal');
INSERT INTO public.country VALUES (122, 3, 'Netherlands');
INSERT INTO public.country VALUES (123, 7, 'New Zealand');
INSERT INTO public.country VALUES (124, 5, 'Nicaragua');
INSERT INTO public.country VALUES (125, 1, 'Niger');
INSERT INTO public.country VALUES (126, 1, 'Nigeria');
INSERT INTO public.country VALUES (127, 7, 'Niue');
INSERT INTO public.country VALUES (128, 3, 'North Macedonia');
INSERT INTO public.country VALUES (129, 3, 'Norway');
INSERT INTO public.country VALUES (130, 2, 'Oman');
INSERT INTO public.country VALUES (131, 2, 'Pakistan');
INSERT INTO public.country VALUES (132, 7, 'Palau');
INSERT INTO public.country VALUES (133, 4, 'Panama');
INSERT INTO public.country VALUES (134, 7, 'Papua New Guinea');
INSERT INTO public.country VALUES (135, 5, 'Paraguay');
INSERT INTO public.country VALUES (136, 5, 'Peru');
INSERT INTO public.country VALUES (137, 2, 'Philippines');
INSERT INTO public.country VALUES (138, 3, 'Poland');
INSERT INTO public.country VALUES (139, 3, 'Portugal');
INSERT INTO public.country VALUES (140, 2, 'Qatar');
INSERT INTO public.country VALUES (141, 2, 'Republic of Korea');
INSERT INTO public.country VALUES (142, 3, 'Republic of Moldova');
INSERT INTO public.country VALUES (143, 3, 'Romania');
INSERT INTO public.country VALUES (144, 3, 'Russian Federation');
INSERT INTO public.country VALUES (145, 1, 'Rwanda');
INSERT INTO public.country VALUES (146, 5, 'Saint Kitts and Nevis');
INSERT INTO public.country VALUES (147, 5, 'Saint Lucia');
INSERT INTO public.country VALUES (148, 5, 'Saint Vincent and the Grenadines');
INSERT INTO public.country VALUES (149, 7, 'Samoa');
INSERT INTO public.country VALUES (150, 3, 'San Marino');
INSERT INTO public.country VALUES (151, 1, 'Sao Tome and Principe');
INSERT INTO public.country VALUES (152, 2, 'Saudi Arabia');
INSERT INTO public.country VALUES (153, 1, 'Senegal');
INSERT INTO public.country VALUES (154, 3, 'Serbia');
INSERT INTO public.country VALUES (155, 1, 'Seychelles');
INSERT INTO public.country VALUES (156, 1, 'Sierra Leone');
INSERT INTO public.country VALUES (157, 7, 'Singapore');
INSERT INTO public.country VALUES (158, 3, 'Slovakia');
INSERT INTO public.country VALUES (159, 3, 'Slovenia');
INSERT INTO public.country VALUES (160, 7, 'Solomon Islands');
INSERT INTO public.country VALUES (161, 1, 'Somalia');
INSERT INTO public.country VALUES (162, 1, 'South Africa');
INSERT INTO public.country VALUES (163, 1, 'South Sudan');
INSERT INTO public.country VALUES (164, 3, 'Spain');
INSERT INTO public.country VALUES (165, 2, 'Sri Lanka');
INSERT INTO public.country VALUES (166, 1, 'Sudan');
INSERT INTO public.country VALUES (167, 5, 'Suriname');
INSERT INTO public.country VALUES (168, 3, 'Sweden');
INSERT INTO public.country VALUES (169, 3, 'Switzerland');
INSERT INTO public.country VALUES (170, 2, 'Syrian Arab Republic');
INSERT INTO public.country VALUES (171, 2, 'Tajikistan');
INSERT INTO public.country VALUES (172, 2, 'Thailand');
INSERT INTO public.country VALUES (173, 2, 'Timor-Leste');
INSERT INTO public.country VALUES (174, 1, 'Togo');
INSERT INTO public.country VALUES (175, 7, 'Tonga');
INSERT INTO public.country VALUES (176, 5, 'Trinidad and Tobago');
INSERT INTO public.country VALUES (177, 1, 'Tunisia');
INSERT INTO public.country VALUES (178, 3, 'Türkiye');
INSERT INTO public.country VALUES (179, 2, 'Turkmenistan');
INSERT INTO public.country VALUES (180, 7, 'Tuvalu');
INSERT INTO public.country VALUES (181, 1, 'Uganda');
INSERT INTO public.country VALUES (182, 3, 'Ukraine');
INSERT INTO public.country VALUES (183, 2, 'United Arab Emirates');
INSERT INTO public.country VALUES (184, 3, 'United Kingdom of Great Britain and Northern Ireland');
INSERT INTO public.country VALUES (185, 1, 'United Republic of Tanzania');
INSERT INTO public.country VALUES (186, 4, 'United States of America');
INSERT INTO public.country VALUES (187, 5, 'Uruguay');
INSERT INTO public.country VALUES (188, 2, 'Uzbekistan');
INSERT INTO public.country VALUES (189, 7, 'Vanuatu');
INSERT INTO public.country VALUES (190, 5, 'Venezuela');
INSERT INTO public.country VALUES (191, 2, 'Viet Nam');
INSERT INTO public.country VALUES (192, 2, 'Yemen');
INSERT INTO public.country VALUES (193, 1, 'Zambia');
INSERT INTO public.country VALUES (194, 1, 'Zimbabwe');


--
-- TOC entry 3895 (class 0 OID 17180)
-- Dependencies: 258
-- Data for Name: currency; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.currency VALUES (1, 'USD', 'United States Dollar');
INSERT INTO public.currency VALUES (2, 'EUR', 'Euro');
INSERT INTO public.currency VALUES (3, 'JPY', 'Japanese Yen');
INSERT INTO public.currency VALUES (4, 'GBP', 'British Pound');
INSERT INTO public.currency VALUES (5, 'AUD', 'Australian Dollar');
INSERT INTO public.currency VALUES (6, 'CAD', 'Canadian Dollar');
INSERT INTO public.currency VALUES (7, 'CHF', 'Swiss Franc');
INSERT INTO public.currency VALUES (8, 'CNY', 'Chinese Yuan');
INSERT INTO public.currency VALUES (9, 'SEK', 'Swedish Krona');
INSERT INTO public.currency VALUES (10, 'NZD', 'New Zealand Dollar');
INSERT INTO public.currency VALUES (11, 'MXN', 'Mexican Peso');
INSERT INTO public.currency VALUES (12, 'SGD', 'Singapore Dollar');
INSERT INTO public.currency VALUES (13, 'HKD', 'Hong Kong Dollar');
INSERT INTO public.currency VALUES (14, 'NOK', 'Norwegian Krone');
INSERT INTO public.currency VALUES (15, 'KRW', 'South Korean Won');
INSERT INTO public.currency VALUES (16, 'TRY', 'Turkish Lira');
INSERT INTO public.currency VALUES (17, 'RUB', 'Russian Ruble');
INSERT INTO public.currency VALUES (18, 'INR', 'Indian Rupee');
INSERT INTO public.currency VALUES (19, 'BRL', 'Brazilian Real');
INSERT INTO public.currency VALUES (20, 'ZAR', 'South African Rand');
INSERT INTO public.currency VALUES (21, 'PLN', 'Polish Zloty');
INSERT INTO public.currency VALUES (22, 'PHP', 'Philippine Peso');
INSERT INTO public.currency VALUES (23, 'DKK', 'Danish Krone');
INSERT INTO public.currency VALUES (24, 'THB', 'Thai Baht');
INSERT INTO public.currency VALUES (25, 'IDR', 'Indonesian Rupiah');
INSERT INTO public.currency VALUES (26, 'MYR', 'Malaysian Ringgit');
INSERT INTO public.currency VALUES (27, 'HUF', 'Hungarian Forint');
INSERT INTO public.currency VALUES (28, 'CZK', 'Czech Koruna');
INSERT INTO public.currency VALUES (29, 'ILS', 'Israeli Shekel');
INSERT INTO public.currency VALUES (30, 'AED', 'United Arab Emirates Dirham');
INSERT INTO public.currency VALUES (31, 'CLP', 'Chilean Peso');
INSERT INTO public.currency VALUES (32, 'COP', 'Colombian Peso');
INSERT INTO public.currency VALUES (33, 'SAR', 'Saudi Riyal');
INSERT INTO public.currency VALUES (34, 'BHD', 'Bahraini Dinar');
INSERT INTO public.currency VALUES (35, 'VND', 'Vietnamese Dong');
INSERT INTO public.currency VALUES (36, 'ARS', 'Argentine Peso');
INSERT INTO public.currency VALUES (37, 'ISK', 'Icelandic Krona');
INSERT INTO public.currency VALUES (38, 'KWD', 'Kuwaiti Dinar');
INSERT INTO public.currency VALUES (39, 'TWD', 'Taiwan Dollar');
INSERT INTO public.currency VALUES (40, 'ZMW', 'Zambian Kwacha');
INSERT INTO public.currency VALUES (41, 'NGN', 'Nigerian Naira');
INSERT INTO public.currency VALUES (42, 'UAH', 'Ukrainian Hryvnia');
INSERT INTO public.currency VALUES (43, 'PEN', 'Peruvian Sol');
INSERT INTO public.currency VALUES (44, 'QAR', 'Qatari Riyal');
INSERT INTO public.currency VALUES (45, 'PKR', 'Pakistani Rupee');
INSERT INTO public.currency VALUES (46, 'LKR', 'Sri Lankan Rupee');
INSERT INTO public.currency VALUES (47, 'RON', 'Romanian Leu');
INSERT INTO public.currency VALUES (48, 'BGN', 'Bulgarian Lev');
INSERT INTO public.currency VALUES (49, 'HRK', 'Croatian Kuna');
INSERT INTO public.currency VALUES (50, 'EGP', 'Egyptian Pound');


--
-- TOC entry 3874 (class 0 OID 16719)
-- Dependencies: 237
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.customer VALUES (1, 1);
INSERT INTO public.customer VALUES (2, 1);
INSERT INTO public.customer VALUES (3, 1);
INSERT INTO public.customer VALUES (4, 1);
INSERT INTO public.customer VALUES (5, 1);
INSERT INTO public.customer VALUES (11, 2);
INSERT INTO public.customer VALUES (12, 2);
INSERT INTO public.customer VALUES (13, 2);
INSERT INTO public.customer VALUES (14, 2);


--
-- TOC entry 3856 (class 0 OID 16431)
-- Dependencies: 219
-- Data for Name: customer_individual; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.customer_individual VALUES (1, 186, 9, 1, '1998-09-18', 'Christian', 'Pulisic', 'christianpulisic@gmail.com', '+15136850137');
INSERT INTO public.customer_individual VALUES (2, 186, 14, 2, '1989-07-02', 'Alex', 'Morgan', 'alexmorgan@gmail.com', '+12105804358');
INSERT INTO public.customer_individual VALUES (3, 184, 22, 1, '1975-05-02', 'David', 'Beckham', 'davidbeckham@gmail.com', '+447868225473');
INSERT INTO public.customer_individual VALUES (4, 85, 26, 1, '1959-06-10', 'Carlo', 'Ancelotti', 'carloancelotti@gmail.com', '+34651714110');
INSERT INTO public.customer_individual VALUES (5, 67, 35, 2, '1973-06-01', 'Heidi', 'Klum', 'heidiklum@gmail.com', '+4915212467699');


--
-- TOC entry 3864 (class 0 OID 16540)
-- Dependencies: 227
-- Data for Name: customer_legal_entity; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.customer_legal_entity VALUES (11, 38, 'Apple Inc');
INSERT INTO public.customer_legal_entity VALUES (12, 39, 'Alphabet Inc');
INSERT INTO public.customer_legal_entity VALUES (13, 40, 'Microsoft Corporation');
INSERT INTO public.customer_legal_entity VALUES (14, 42, 'In house pastrami & more');


--
-- TOC entry 3894 (class 0 OID 17148)
-- Dependencies: 257
-- Data for Name: customer_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.customer_type VALUES (1, 'INDIVIDUAL', 'A customer that is person.');
INSERT INTO public.customer_type VALUES (2, 'LEGAL_ENTITY', 'A customer that is a legal entity.');


--
-- TOC entry 3897 (class 0 OID 17527)
-- Dependencies: 260
-- Data for Name: deposit_account_details; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3855 (class 0 OID 16424)
-- Dependencies: 218
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.employee VALUES (1, 9, 43, 2, 11, '1990-07-02', 'Margot', 'Robbie', 'margot.robbie@hollywood.com', '+61911666874');
INSERT INTO public.employee VALUES (6, 63, 2, 1, 11, '1990-07-02', 'Mike', 'Meignan', 'mike.meignan@hollywood.com', '+61911666810');
INSERT INTO public.employee VALUES (7, 139, 14, 1, 11, '1990-07-02', 'Cristiano', 'Ronaldo', 'cristiano.ronaldo@hollywood.com', '+61911666820');
INSERT INTO public.employee VALUES (8, 85, 30, 1, 11, '1990-07-02', 'Francesco', 'Totti', 'francesco.totti@hollywood.com', '+61911666830');


--
-- TOC entry 3862 (class 0 OID 16518)
-- Dependencies: 225
-- Data for Name: interest_rate; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.interest_rate VALUES (1, 1);
INSERT INTO public.interest_rate VALUES (2, 1);
INSERT INTO public.interest_rate VALUES (3, 1);
INSERT INTO public.interest_rate VALUES (4, 1);
INSERT INTO public.interest_rate VALUES (5, 1);
INSERT INTO public.interest_rate VALUES (6, 1);
INSERT INTO public.interest_rate VALUES (7, 1);
INSERT INTO public.interest_rate VALUES (8, 1);
INSERT INTO public.interest_rate VALUES (9, 1);
INSERT INTO public.interest_rate VALUES (10, 1);
INSERT INTO public.interest_rate VALUES (11, 1);
INSERT INTO public.interest_rate VALUES (12, 1);
INSERT INTO public.interest_rate VALUES (13, 1);
INSERT INTO public.interest_rate VALUES (14, 1);
INSERT INTO public.interest_rate VALUES (15, 1);
INSERT INTO public.interest_rate VALUES (16, 1);
INSERT INTO public.interest_rate VALUES (17, 1);
INSERT INTO public.interest_rate VALUES (18, 1);
INSERT INTO public.interest_rate VALUES (19, 1);
INSERT INTO public.interest_rate VALUES (20, 1);
INSERT INTO public.interest_rate VALUES (21, 1);
INSERT INTO public.interest_rate VALUES (26, 2);
INSERT INTO public.interest_rate VALUES (31, 2);


--
-- TOC entry 3872 (class 0 OID 16642)
-- Dependencies: 235
-- Data for Name: interest_rate_fixed; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.interest_rate_fixed VALUES (1, 1.00);
INSERT INTO public.interest_rate_fixed VALUES (2, 1.10);
INSERT INTO public.interest_rate_fixed VALUES (3, 1.20);
INSERT INTO public.interest_rate_fixed VALUES (4, 1.30);
INSERT INTO public.interest_rate_fixed VALUES (5, 1.40);
INSERT INTO public.interest_rate_fixed VALUES (6, 1.50);
INSERT INTO public.interest_rate_fixed VALUES (7, 1.60);
INSERT INTO public.interest_rate_fixed VALUES (8, 1.70);
INSERT INTO public.interest_rate_fixed VALUES (9, 1.80);
INSERT INTO public.interest_rate_fixed VALUES (10, 1.90);
INSERT INTO public.interest_rate_fixed VALUES (11, 2.00);
INSERT INTO public.interest_rate_fixed VALUES (12, 2.10);
INSERT INTO public.interest_rate_fixed VALUES (13, 2.20);
INSERT INTO public.interest_rate_fixed VALUES (14, 2.30);
INSERT INTO public.interest_rate_fixed VALUES (15, 2.40);
INSERT INTO public.interest_rate_fixed VALUES (16, 2.50);
INSERT INTO public.interest_rate_fixed VALUES (17, 2.60);
INSERT INTO public.interest_rate_fixed VALUES (18, 2.70);
INSERT INTO public.interest_rate_fixed VALUES (19, 2.80);
INSERT INTO public.interest_rate_fixed VALUES (20, 2.90);
INSERT INTO public.interest_rate_fixed VALUES (21, 3.00);


--
-- TOC entry 3865 (class 0 OID 16559)
-- Dependencies: 228
-- Data for Name: interest_rate_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.interest_rate_type VALUES (1, 'FIXED', 'Fixed interest rate');
INSERT INTO public.interest_rate_type VALUES (2, 'VARIABLE', 'Variable interest rate');


--
-- TOC entry 3871 (class 0 OID 16637)
-- Dependencies: 234
-- Data for Name: interest_rate_variable; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.interest_rate_variable VALUES (26, 'European Central Bank');


--
-- TOC entry 3899 (class 0 OID 17735)
-- Dependencies: 262
-- Data for Name: interest_rate_variable_history; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.interest_rate_variable_history VALUES (7, 26, 0.00, '2016-03-01', '2022-07-31');
INSERT INTO public.interest_rate_variable_history VALUES (12, 26, 0.50, '2022-08-01', '2022-09-30');
INSERT INTO public.interest_rate_variable_history VALUES (13, 26, 1.25, '2022-10-01', '2022-10-31');
INSERT INTO public.interest_rate_variable_history VALUES (14, 26, 2.00, '2022-11-01', '2022-12-31');
INSERT INTO public.interest_rate_variable_history VALUES (15, 26, 2.50, '2023-01-01', '2023-01-31');
INSERT INTO public.interest_rate_variable_history VALUES (17, 26, 3.75, '2023-06-01', '2023-06-30');
INSERT INTO public.interest_rate_variable_history VALUES (18, 26, 4.00, '2023-07-01', '2023-07-31');
INSERT INTO public.interest_rate_variable_history VALUES (16, 26, 3.00, '2023-02-01', '2023-10-31');
INSERT INTO public.interest_rate_variable_history VALUES (21, 26, 4.50, '2023-10-01', '9999-12-31');
INSERT INTO public.interest_rate_variable_history VALUES (19, 26, 4.25, '2023-08-01', '2023-09-30');


--
-- TOC entry 3859 (class 0 OID 16448)
-- Dependencies: 222
-- Data for Name: loan; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3876 (class 0 OID 17006)
-- Dependencies: 239
-- Data for Name: loan_history; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3861 (class 0 OID 16511)
-- Dependencies: 224
-- Data for Name: loan_status; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.loan_status VALUES (1, 'SUBMITTED', 'The request for the loan was submitted to the bank.');
INSERT INTO public.loan_status VALUES (2, 'ACCEPTED', 'The request was accepted.');
INSERT INTO public.loan_status VALUES (3, 'REJECTED', 'The request was rejected.');
INSERT INTO public.loan_status VALUES (4, 'ACTIVE', 'The loan is under payment.');
INSERT INTO public.loan_status VALUES (5, 'SUSPENDED', 'The loan is suspended for a period of time.');
INSERT INTO public.loan_status VALUES (6, 'CREDIT_COLLECTION', 'The loan is under credit collection.');
INSERT INTO public.loan_status VALUES (7, 'SOLD', 'The loan was sold to other bank.');
INSERT INTO public.loan_status VALUES (8, 'COMPLETED', 'The loan is completed. (No further action).');


--
-- TOC entry 3870 (class 0 OID 16628)
-- Dependencies: 233
-- Data for Name: loan_status_history; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3866 (class 0 OID 16574)
-- Dependencies: 229
-- Data for Name: loan_transaction_history; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3863 (class 0 OID 16525)
-- Dependencies: 226
-- Data for Name: loan_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.loan_type VALUES (1, 'MORTGAGE', 'Loan to purchase a home');
INSERT INTO public.loan_type VALUES (2, 'AUTO', 'Loan to purchase a car');
INSERT INTO public.loan_type VALUES (3, 'STUDENT', 'Loan to pay education');
INSERT INTO public.loan_type VALUES (4, 'MEDICAL', 'Loan to pay medical bills');
INSERT INTO public.loan_type VALUES (5, 'BUSINESS', 'Loan to fund business expenses');
INSERT INTO public.loan_type VALUES (6, 'PERSONAL', 'Loan for a wide range of personal expenses');
INSERT INTO public.loan_type VALUES (7, 'DEBT_CONSOLIDATION', 'Loan to combine debts from various sources');


--
-- TOC entry 3860 (class 0 OID 16497)
-- Dependencies: 223
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.location VALUES (1, 1, 'Bulevardul Unirii', 24, '040103');
INSERT INTO public.location VALUES (2, 38, 'Via Milanello', 25, '21040');
INSERT INTO public.location VALUES (3, 7, 'Strada Castelului', 100, '500014');
INSERT INTO public.location VALUES (4, 36, 'Via dei Fori Imperiali', 25, '00184');
INSERT INTO public.location VALUES (5, 33, 'Via Toledo', 23, '80134');
INSERT INTO public.location VALUES (6, 33, 'Via Emanuele de Deo', 60, '80132');
INSERT INTO public.location VALUES (7, 9, 'Strada Regele Ferdinand', 100, '400347');
INSERT INTO public.location VALUES (8, 9, 'Strada Ion Creanga', 8, '400000');
INSERT INTO public.location VALUES (9, 54, 'Hollywood Blvd', 6767, '90028');
INSERT INTO public.location VALUES (10, 54, 'Sunset Blvd', 6255, '90028');
INSERT INTO public.location VALUES (11, 58, 'S Dixie Hwy', 1320, '33146');
INSERT INTO public.location VALUES (12, 58, 'Meridian Ave', 418, '33139');
INSERT INTO public.location VALUES (13, 77, 'S Las Vegas Blvd', 3555, '89109');
INSERT INTO public.location VALUES (14, 77, 'W Flamingo Rd', 4321, '89103');
INSERT INTO public.location VALUES (15, 81, 'Bowling Green', 1, '10004');
INSERT INTO public.location VALUES (16, 81, '5th Ave', 175, '10010');
INSERT INTO public.location VALUES (17, 104, 'Whiteladies Rd', 96, 'BS8 2QX');
INSERT INTO public.location VALUES (18, 126, 'Anfield Rd', 10, 'L4 0TH');
INSERT INTO public.location VALUES (19, 126, 'William Brown St, Liverpool', 33, 'L3 8EN');
INSERT INTO public.location VALUES (20, 127, 'Riverside Building', 24, 'SE1 7PB');
INSERT INTO public.location VALUES (21, 127, 'The Mall', 42, 'SW1A 2BJ');
INSERT INTO public.location VALUES (22, 128, 'Sir Matt Busby Way', 16, 'M16 0RA');
INSERT INTO public.location VALUES (23, 128, 'Rowsley St', 13, 'M11 3FF');
INSERT INTO public.location VALUES (24, 185, 'Carrer de Pau Gargallo', 14, '08028');
INSERT INTO public.location VALUES (25, 185, 'Placa Rosa Del Vents', 1, '08039');
INSERT INTO public.location VALUES (26, 189, 'Av. de Concha Espina', 1, '28036');
INSERT INTO public.location VALUES (27, 189, 'C. de Bailén', 4, '28013');
INSERT INTO public.location VALUES (28, 192, 'Av. del Professor López Pinero', 7, '46013');
INSERT INTO public.location VALUES (29, 192, 'Gran Via del Marqués del Túria', 75, '46005');
INSERT INTO public.location VALUES (30, 193, 'Champ de Mars', 5, '75007');
INSERT INTO public.location VALUES (31, 193, 'Av. des Champs-Elysees', 101, '75008');
INSERT INTO public.location VALUES (32, 195, 'Cr Belsunce', 17, '13001');
INSERT INTO public.location VALUES (33, 195, 'Rue de la Charité', 2, '13002');
INSERT INTO public.location VALUES (34, 210, 'Schloss Nymphenburg', 1, '80638');
INSERT INTO public.location VALUES (35, 210, 'Willy-Brandt-Platz', 5, '81829');
INSERT INTO public.location VALUES (36, 221, 'Gewerbemuseumspl', 3, '90403');
INSERT INTO public.location VALUES (37, 221, 'Burg', 17, '90403');
INSERT INTO public.location VALUES (38, 223, 'North Tantau Avenue', 10600, '95014');
INSERT INTO public.location VALUES (39, 224, 'Amphitheatre Pkwy', 1600, '94043');
INSERT INTO public.location VALUES (40, 224, 'La Avenida St', 1045, '94043');
INSERT INTO public.location VALUES (41, 224, 'Moffett Blvd', 1, '94035');
INSERT INTO public.location VALUES (42, 1, 'Strada Speranței 1', 1, '030167');
INSERT INTO public.location VALUES (43, 225, 'Olympic Dr', 1, '2061');
INSERT INTO public.location VALUES (44, 225, 'George St', 455, '2000');


--
-- TOC entry 3873 (class 0 OID 16692)
-- Dependencies: 236
-- Data for Name: sex_type; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--

INSERT INTO public.sex_type VALUES (1, 'M', 'Male');
INSERT INTO public.sex_type VALUES (2, 'F', 'Female');


--
-- TOC entry 3858 (class 0 OID 16443)
-- Dependencies: 221
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: paulmarcelinbejan
--



--
-- TOC entry 3911 (class 0 OID 0)
-- Dependencies: 263
-- Name: id_account_notification_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_account_notification_seq', 1, false);


--
-- TOC entry 3912 (class 0 OID 0)
-- Dependencies: 245
-- Name: id_account_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_account_seq', 1, false);


--
-- TOC entry 3913 (class 0 OID 0)
-- Dependencies: 247
-- Name: id_bank_branch_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_bank_branch_seq', 20, true);


--
-- TOC entry 3914 (class 0 OID 0)
-- Dependencies: 246
-- Name: id_bank_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_bank_seq', 14, true);


--
-- TOC entry 3915 (class 0 OID 0)
-- Dependencies: 240
-- Name: id_city_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_city_seq', 225, true);


--
-- TOC entry 3916 (class 0 OID 0)
-- Dependencies: 241
-- Name: id_continent_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_continent_seq', 31, true);


--
-- TOC entry 3917 (class 0 OID 0)
-- Dependencies: 242
-- Name: id_country_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_country_seq', 208, true);


--
-- TOC entry 3918 (class 0 OID 0)
-- Dependencies: 259
-- Name: id_customer_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_customer_seq', 20, true);


--
-- TOC entry 3919 (class 0 OID 0)
-- Dependencies: 244
-- Name: id_employee_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_employee_seq', 10, true);


--
-- TOC entry 3920 (class 0 OID 0)
-- Dependencies: 248
-- Name: id_interest_rate_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_interest_rate_seq', 35, true);


--
-- TOC entry 3921 (class 0 OID 0)
-- Dependencies: 249
-- Name: id_interest_rate_variable_history_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_interest_rate_variable_history_seq', 21, true);


--
-- TOC entry 3922 (class 0 OID 0)
-- Dependencies: 251
-- Name: id_loan_history_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_loan_history_seq', 1, false);


--
-- TOC entry 3923 (class 0 OID 0)
-- Dependencies: 250
-- Name: id_loan_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_loan_seq', 1, false);


--
-- TOC entry 3924 (class 0 OID 0)
-- Dependencies: 253
-- Name: id_loan_status_history_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_loan_status_history_seq', 1, false);


--
-- TOC entry 3925 (class 0 OID 0)
-- Dependencies: 252
-- Name: id_loan_status_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_loan_status_seq', 1, false);


--
-- TOC entry 3926 (class 0 OID 0)
-- Dependencies: 254
-- Name: id_loan_transaction_history_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_loan_transaction_history_seq', 1, false);


--
-- TOC entry 3927 (class 0 OID 0)
-- Dependencies: 243
-- Name: id_location_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_location_seq', 44, true);


--
-- TOC entry 3928 (class 0 OID 0)
-- Dependencies: 255
-- Name: id_transaction_seq; Type: SEQUENCE SET; Schema: public; Owner: paulmarcelinbejan
--

SELECT pg_catalog.setval('public.id_transaction_seq', 1, false);


--
-- TOC entry 3615 (class 2606 OID 16442)
-- Name: account pk_account; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT pk_account PRIMARY KEY (id_account);


--
-- TOC entry 3637 (class 2606 OID 16590)
-- Name: account_external pk_account_external; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_external
    ADD CONSTRAINT pk_account_external PRIMARY KEY (id_account);


--
-- TOC entry 3635 (class 2606 OID 16583)
-- Name: account_internal pk_account_internal; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal
    ADD CONSTRAINT pk_account_internal PRIMARY KEY (id_account);


--
-- TOC entry 3651 (class 2606 OID 16903)
-- Name: account_internal_type pk_account_internal_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal_type
    ADD CONSTRAINT pk_account_internal_type PRIMARY KEY (id_account_internal_type);


--
-- TOC entry 3663 (class 2606 OID 17538)
-- Name: account_notification pk_account_notification; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_notification
    ADD CONSTRAINT pk_account_notification PRIMARY KEY (id_account_notification);


--
-- TOC entry 3655 (class 2606 OID 17132)
-- Name: account_type pk_account_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_type
    ADD CONSTRAINT pk_account_type PRIMARY KEY (id_account_type);


--
-- TOC entry 3639 (class 2606 OID 16596)
-- Name: bank pk_bank; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.bank
    ADD CONSTRAINT pk_bank PRIMARY KEY (id_bank);


--
-- TOC entry 3609 (class 2606 OID 16616)
-- Name: bank_branch pk_bank_branch; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.bank_branch
    ADD CONSTRAINT pk_bank_branch PRIMARY KEY (id_bank_branch);


--
-- TOC entry 3607 (class 2606 OID 16411)
-- Name: city pk_city; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT pk_city PRIMARY KEY (id_city);


--
-- TOC entry 3603 (class 2606 OID 16397)
-- Name: continent pk_continent; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.continent
    ADD CONSTRAINT pk_continent PRIMARY KEY (id_continent);


--
-- TOC entry 3605 (class 2606 OID 16404)
-- Name: country pk_country; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT pk_country PRIMARY KEY (id_country);


--
-- TOC entry 3659 (class 2606 OID 17186)
-- Name: currency pk_currency; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.currency
    ADD CONSTRAINT pk_currency PRIMARY KEY (id_currency);


--
-- TOC entry 3649 (class 2606 OID 16725)
-- Name: customer pk_customer; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT pk_customer PRIMARY KEY (id_customer);


--
-- TOC entry 3613 (class 2606 OID 16437)
-- Name: customer_individual pk_customer_individual; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_individual
    ADD CONSTRAINT pk_customer_individual PRIMARY KEY (id_customer);


--
-- TOC entry 3629 (class 2606 OID 16544)
-- Name: customer_legal_entity pk_customer_legal_entity; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_legal_entity
    ADD CONSTRAINT pk_customer_legal_entity PRIMARY KEY (id_customer);


--
-- TOC entry 3657 (class 2606 OID 17154)
-- Name: customer_type pk_customer_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_type
    ADD CONSTRAINT pk_customer_type PRIMARY KEY (id_customer_type);


--
-- TOC entry 3661 (class 2606 OID 17547)
-- Name: deposit_account_details pk_deposit_account_details; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.deposit_account_details
    ADD CONSTRAINT pk_deposit_account_details PRIMARY KEY (id_account);


--
-- TOC entry 3611 (class 2606 OID 16430)
-- Name: employee pk_employee; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT pk_employee PRIMARY KEY (id_employee);


--
-- TOC entry 3625 (class 2606 OID 16648)
-- Name: interest_rate pk_interest_rate; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate
    ADD CONSTRAINT pk_interest_rate PRIMARY KEY (id_interest_rate);


--
-- TOC entry 3645 (class 2606 OID 17654)
-- Name: interest_rate_fixed pk_interest_rate_fixed; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_fixed
    ADD CONSTRAINT pk_interest_rate_fixed PRIMARY KEY (id_interest_rate);


--
-- TOC entry 3631 (class 2606 OID 16565)
-- Name: interest_rate_type pk_interest_rate_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_type
    ADD CONSTRAINT pk_interest_rate_type PRIMARY KEY (id_interest_rate_type);


--
-- TOC entry 3643 (class 2606 OID 17682)
-- Name: interest_rate_variable pk_interest_rate_variable; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_variable
    ADD CONSTRAINT pk_interest_rate_variable PRIMARY KEY (id_interest_rate);


--
-- TOC entry 3665 (class 2606 OID 17746)
-- Name: interest_rate_variable_history pk_interest_rate_variable_history; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_variable_history
    ADD CONSTRAINT pk_interest_rate_variable_history PRIMARY KEY (id_interest_rate_variable_history);


--
-- TOC entry 3619 (class 2606 OID 16452)
-- Name: loan pk_loan; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT pk_loan PRIMARY KEY (id_loan);


--
-- TOC entry 3653 (class 2606 OID 17010)
-- Name: loan_history pk_loan_history; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_history
    ADD CONSTRAINT pk_loan_history PRIMARY KEY (id_loan_history);


--
-- TOC entry 3623 (class 2606 OID 16517)
-- Name: loan_status pk_loan_status; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_status
    ADD CONSTRAINT pk_loan_status PRIMARY KEY (id_loan_status);


--
-- TOC entry 3641 (class 2606 OID 16632)
-- Name: loan_status_history pk_loan_status_history; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_status_history
    ADD CONSTRAINT pk_loan_status_history PRIMARY KEY (id_loan_status_history);


--
-- TOC entry 3633 (class 2606 OID 16578)
-- Name: loan_transaction_history pk_loan_transaction_history; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_transaction_history
    ADD CONSTRAINT pk_loan_transaction_history PRIMARY KEY (id_loan_transaction_history);


--
-- TOC entry 3627 (class 2606 OID 16531)
-- Name: loan_type pk_loan_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_type
    ADD CONSTRAINT pk_loan_type PRIMARY KEY (id_loan_type);


--
-- TOC entry 3621 (class 2606 OID 16503)
-- Name: location pk_location; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT pk_location PRIMARY KEY (id_location);


--
-- TOC entry 3647 (class 2606 OID 16698)
-- Name: sex_type pk_sex_type; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.sex_type
    ADD CONSTRAINT pk_sex_type PRIMARY KEY (id_sex_type);


--
-- TOC entry 3617 (class 2606 OID 16447)
-- Name: transaction pk_transaction; Type: CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT pk_transaction PRIMARY KEY (id_transaction);


--
-- TOC entry 3705 (class 2606 OID 17801)
-- Name: deposit_account_details fk4h20xkv5a9ef64qgtpr55au0h; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.deposit_account_details
    ADD CONSTRAINT fk4h20xkv5a9ef64qgtpr55au0h FOREIGN KEY (id_account) REFERENCES public.account_internal(id_account);


--
-- TOC entry 3695 (class 2606 OID 17447)
-- Name: account_external fk_account; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_external
    ADD CONSTRAINT fk_account FOREIGN KEY (id_account) REFERENCES public.account(id_account);


--
-- TOC entry 3691 (class 2606 OID 17452)
-- Name: account_internal fk_account; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal
    ADD CONSTRAINT fk_account FOREIGN KEY (id_account) REFERENCES public.account(id_account);


--
-- TOC entry 3707 (class 2606 OID 17539)
-- Name: account_notification fk_account; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_notification
    ADD CONSTRAINT fk_account FOREIGN KEY (fk_account) REFERENCES public.account(id_account);


--
-- TOC entry 3692 (class 2606 OID 16904)
-- Name: account_internal fk_account_internal_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal
    ADD CONSTRAINT fk_account_internal_type FOREIGN KEY (fk_account_internal_type) REFERENCES public.account_internal_type(id_account_internal_type);


--
-- TOC entry 3679 (class 2606 OID 16820)
-- Name: transaction fk_account_receiver; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk_account_receiver FOREIGN KEY (fk_account_receiver) REFERENCES public.account(id_account);


--
-- TOC entry 3680 (class 2606 OID 16825)
-- Name: transaction fk_account_sender; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk_account_sender FOREIGN KEY (fk_account_sender) REFERENCES public.account(id_account);


--
-- TOC entry 3678 (class 2606 OID 17133)
-- Name: account fk_account_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT fk_account_type FOREIGN KEY (fk_account_type) REFERENCES public.account_type(id_account_type);


--
-- TOC entry 3696 (class 2606 OID 16882)
-- Name: account_external fk_bank; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_external
    ADD CONSTRAINT fk_bank FOREIGN KEY (fk_bank) REFERENCES public.bank(id_bank);


--
-- TOC entry 3668 (class 2606 OID 16909)
-- Name: bank_branch fk_bank; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.bank_branch
    ADD CONSTRAINT fk_bank FOREIGN KEY (fk_bank) REFERENCES public.bank(id_bank);


--
-- TOC entry 3670 (class 2606 OID 17077)
-- Name: employee fk_bank_branch; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_bank_branch FOREIGN KEY (fk_bank_branch) REFERENCES public.bank_branch(id_bank_branch);


--
-- TOC entry 3929 (class 0 OID 0)
-- Dependencies: 3670
-- Name: CONSTRAINT fk_bank_branch ON employee; Type: COMMENT; Schema: public; Owner: paulmarcelinbejan
--

COMMENT ON CONSTRAINT fk_bank_branch ON public.employee IS 'The local bank branch where the employee works';


--
-- TOC entry 3702 (class 2606 OID 17500)
-- Name: loan_history fk_bank_branch; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_history
    ADD CONSTRAINT fk_bank_branch FOREIGN KEY (fk_bank_branch) REFERENCES public.bank_branch(id_bank_branch);


--
-- TOC entry 3684 (class 2606 OID 16989)
-- Name: location fk_city; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fk_city FOREIGN KEY (fk_city) REFERENCES public.city(id_city);


--
-- TOC entry 3666 (class 2606 OID 16924)
-- Name: country fk_continent; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT fk_continent FOREIGN KEY (fk_continent) REFERENCES public.continent(id_continent);


--
-- TOC entry 3667 (class 2606 OID 16919)
-- Name: city fk_country; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT fk_country FOREIGN KEY (fk_country) REFERENCES public.country(id_country);


--
-- TOC entry 3693 (class 2606 OID 17187)
-- Name: account_internal fk_currency; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal
    ADD CONSTRAINT fk_currency FOREIGN KEY (fk_currency) REFERENCES public.currency(id_currency);


--
-- TOC entry 3681 (class 2606 OID 17192)
-- Name: transaction fk_currency; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk_currency FOREIGN KEY (fk_currency) REFERENCES public.currency(id_currency);


--
-- TOC entry 3694 (class 2606 OID 16892)
-- Name: account_internal fk_customer; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.account_internal
    ADD CONSTRAINT fk_customer FOREIGN KEY (fk_customer) REFERENCES public.customer(id_customer);


--
-- TOC entry 3682 (class 2606 OID 17175)
-- Name: loan fk_customer; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT fk_customer FOREIGN KEY (fk_customer) REFERENCES public.customer(id_customer);


--
-- TOC entry 3674 (class 2606 OID 17417)
-- Name: customer_individual fk_customer; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_individual
    ADD CONSTRAINT fk_customer FOREIGN KEY (id_customer) REFERENCES public.customer(id_customer);


--
-- TOC entry 3686 (class 2606 OID 17422)
-- Name: customer_legal_entity fk_customer; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_legal_entity
    ADD CONSTRAINT fk_customer FOREIGN KEY (id_customer) REFERENCES public.customer(id_customer);


--
-- TOC entry 3701 (class 2606 OID 17155)
-- Name: customer fk_customer_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT fk_customer_type FOREIGN KEY (fk_customer_type) REFERENCES public.customer_type(id_customer_type);


--
-- TOC entry 3687 (class 2606 OID 16939)
-- Name: customer_legal_entity fk_headquarters; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_legal_entity
    ADD CONSTRAINT fk_headquarters FOREIGN KEY (fk_headquarters) REFERENCES public.location(id_location);


--
-- TOC entry 3688 (class 2606 OID 16786)
-- Name: loan_transaction_history fk_interest_rate; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_transaction_history
    ADD CONSTRAINT fk_interest_rate FOREIGN KEY (fk_interest_rate) REFERENCES public.interest_rate(id_interest_rate);


--
-- TOC entry 3700 (class 2606 OID 17655)
-- Name: interest_rate_fixed fk_interest_rate; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_fixed
    ADD CONSTRAINT fk_interest_rate FOREIGN KEY (id_interest_rate) REFERENCES public.interest_rate(id_interest_rate);


--
-- TOC entry 3699 (class 2606 OID 17683)
-- Name: interest_rate_variable fk_interest_rate; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_variable
    ADD CONSTRAINT fk_interest_rate FOREIGN KEY (id_interest_rate) REFERENCES public.interest_rate(id_interest_rate);


--
-- TOC entry 3706 (class 2606 OID 17791)
-- Name: deposit_account_details fk_interest_rate_fixed; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.deposit_account_details
    ADD CONSTRAINT fk_interest_rate_fixed FOREIGN KEY (fk_interest_rate_fixed) REFERENCES public.interest_rate_fixed(id_interest_rate);


--
-- TOC entry 3685 (class 2606 OID 17111)
-- Name: interest_rate fk_interest_rate_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate
    ADD CONSTRAINT fk_interest_rate_type FOREIGN KEY (fk_interest_rate_type) REFERENCES public.interest_rate_type(id_interest_rate_type);


--
-- TOC entry 3708 (class 2606 OID 17751)
-- Name: interest_rate_variable_history fk_interest_rate_variable; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.interest_rate_variable_history
    ADD CONSTRAINT fk_interest_rate_variable FOREIGN KEY (fk_interest_rate_variable) REFERENCES public.interest_rate_variable(id_interest_rate);


--
-- TOC entry 3703 (class 2606 OID 17021)
-- Name: loan_history fk_interest_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_history
    ADD CONSTRAINT fk_interest_type FOREIGN KEY (fk_interest_type) REFERENCES public.interest_rate_type(id_interest_rate_type);


--
-- TOC entry 3697 (class 2606 OID 16974)
-- Name: loan_status_history fk_loan; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_status_history
    ADD CONSTRAINT fk_loan FOREIGN KEY (fk_loan) REFERENCES public.loan(id_loan);


--
-- TOC entry 3704 (class 2606 OID 17011)
-- Name: loan_history fk_loan; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_history
    ADD CONSTRAINT fk_loan FOREIGN KEY (fk_loan) REFERENCES public.loan(id_loan);


--
-- TOC entry 3689 (class 2606 OID 17026)
-- Name: loan_transaction_history fk_loan_history; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_transaction_history
    ADD CONSTRAINT fk_loan_history FOREIGN KEY (fk_loan_history) REFERENCES public.loan_history(id_loan_history);


--
-- TOC entry 3698 (class 2606 OID 16781)
-- Name: loan_status_history fk_loan_status; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_status_history
    ADD CONSTRAINT fk_loan_status FOREIGN KEY (fk_loan_status) REFERENCES public.loan_status(id_loan_status);


--
-- TOC entry 3683 (class 2606 OID 17170)
-- Name: loan fk_loan_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan
    ADD CONSTRAINT fk_loan_type FOREIGN KEY (fk_loan_type) REFERENCES public.loan_type(id_loan_type);


--
-- TOC entry 3669 (class 2606 OID 16914)
-- Name: bank_branch fk_location; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.bank_branch
    ADD CONSTRAINT fk_location FOREIGN KEY (fk_location) REFERENCES public.location(id_location);


--
-- TOC entry 3675 (class 2606 OID 16740)
-- Name: customer_individual fk_nationality; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_individual
    ADD CONSTRAINT fk_nationality FOREIGN KEY (fk_nationality) REFERENCES public.country(id_country);


--
-- TOC entry 3671 (class 2606 OID 16944)
-- Name: employee fk_nationality; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_nationality FOREIGN KEY (fk_nationality) REFERENCES public.country(id_country);


--
-- TOC entry 3676 (class 2606 OID 16929)
-- Name: customer_individual fk_residence; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_individual
    ADD CONSTRAINT fk_residence FOREIGN KEY (fk_residence) REFERENCES public.location(id_location);


--
-- TOC entry 3672 (class 2606 OID 16949)
-- Name: employee fk_residence; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_residence FOREIGN KEY (fk_residence) REFERENCES public.location(id_location);


--
-- TOC entry 3677 (class 2606 OID 16934)
-- Name: customer_individual fk_sex_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.customer_individual
    ADD CONSTRAINT fk_sex_type FOREIGN KEY (fk_sex_type) REFERENCES public.sex_type(id_sex_type);


--
-- TOC entry 3673 (class 2606 OID 16954)
-- Name: employee fk_sexy_type; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_sexy_type FOREIGN KEY (fk_sex_type) REFERENCES public.sex_type(id_sex_type);


--
-- TOC entry 3690 (class 2606 OID 16984)
-- Name: loan_transaction_history fk_transaction; Type: FK CONSTRAINT; Schema: public; Owner: paulmarcelinbejan
--

ALTER TABLE ONLY public.loan_transaction_history
    ADD CONSTRAINT fk_transaction FOREIGN KEY (fk_transaction) REFERENCES public.transaction(id_transaction);


-- Completed on 2024-01-22 23:18:36 CET

--
-- PostgreSQL database dump complete
--
