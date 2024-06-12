-- public.task определение

-- Drop table

-- DROP TABLE task;

-- Updated 12.06.2024 (used to be 04.06.2024)

CREATE TABLE task (
                      id bigserial NOT NULL,
                      "date" date NOT NULL,
                      description text NULL,
                      done bool DEFAULT false NOT NULL,
                      user_id int8 NULL,
                      CONSTRAINT task_pkey PRIMARY KEY (id)
);
CREATE INDEX task_date_idx ON public.task USING btree (date);
CREATE INDEX task_done_idx ON public.task USING btree (done);


-- public.task внешние включи

ALTER TABLE public.task ADD CONSTRAINT task_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);