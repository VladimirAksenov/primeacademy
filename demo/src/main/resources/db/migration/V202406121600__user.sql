-- public.users определение

-- Drop table

-- DROP TABLE users;

CREATE TABLE users (
                       id bigserial NOT NULL,
                       login varchar(255) NOT NULL,
                       "password" varchar(255) NOT NULL,
                       CONSTRAINT users_pkey PRIMARY KEY (id)
);