CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS collector;


CREATE TABLE collector.user
(
    id                 uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    steam_id           text    NOT NULL UNIQUE,
    simple_rating      integer NOT NULL DEFAULT 1000,
    competitive_rating integer NOT NULL DEFAULT 1000,
    relative_rating    integer NOT NULL DEFAULT 400
);

CREATE TYPE match_type AS ENUM ('COMMON');


CREATE TABLE collector.match
(
    id           uuid PRIMARY KEY    DEFAULT uuid_generate_v4(),
    current_wave integer    NOT NULL DEFAULT 1,
    type         match_type NOT NULL DEFAULT 'COMMON'
);

CREATE TABLE collector.settings
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NOT NULL UNIQUE
);


CREATE TABLE collector.user_settings
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id    uuid NOT NULL REFERENCES collector.user (id),
    setting_id uuid NOT NULL REFERENCES collector.settings (id)
);

CREATE TABLE collector.wave
(
    id           uuid PRIMARY KEY        DEFAULT uuid_generate_v4(),
    round_number integer NOT NULL UNIQUE DEFAULT 1
);

CREATE TABLE collector.npc
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NOT NULL UNIQUE
);

CREATE TABLE collector.npc_pack
(
    id     uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    npc_id uuid    NOT NULL REFERENCES collector.npc (id),
    count  integer NOT NULL DEFAULT 0
);



CREATE TABLE collector.wave_history
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    match_id    uuid NOT NULL REFERENCES collector.match (id),
    npc_pack_id uuid NOT NULL REFERENCES collector.npc_pack (id),
    wave_id     uuid NOT NULL REFERENCES collector.wave (id)
);

CREATE TABLE collector.wave_npc
(
    id               uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    wave_id          uuid    NOT NULL REFERENCES collector.wave (id),
    npc_pack_id      uuid    NOT NULL REFERENCES collector.npc_pack (id),
    possibility_rate integer NOT NULL DEFAULT 100
);


CREATE TABLE collector.npc_ability_set
(
    id     uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    npc_id uuid    NOT NULL REFERENCES collector.npc (id),
    option integer NOT NULL DEFAULT 0
);


CREATE TABLE collector.user_npc_ability_override
(
    id                 uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id            uuid NOT NULL REFERENCES collector.user (id),
    npc_ability_set_id uuid NOT NULL REFERENCES collector.npc_ability_set (id)
);


CREATE TABLE collector.defender
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NOT NULL UNIQUE
);


CREATE TABLE collector.defender_position
(
    id          uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    defender_id uuid    NOT NULL REFERENCES collector.defender (id),
    user_id     uuid    NOT NULL REFERENCES collector.user (id),
    wave_id     uuid    NOT NULL REFERENCES collector.wave (id),
    match_id    uuid    NOT NULL REFERENCES collector.match (id),
    position_x  integer NOT NULL DEFAULT 0,
    position_y  integer NOT NULL DEFAULT 0
);



CREATE TABLE collector.mercenary_npc
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NOT NULL UNIQUE
);


CREATE TABLE collector.mercenary_spell
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text NOT NULL UNIQUE
);

CREATE TABLE collector.user_wave_mercenary_npc
(
    id               uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id          uuid    NOT NULL REFERENCES collector.user (id),
    wave_history_id  uuid    NOT NULL REFERENCES collector.wave_history (id),
    mercenary_npc_id uuid    NOT NULL REFERENCES collector.mercenary_npc (id),
    count            integer NOT NULL DEFAULT 0
);

CREATE TABLE collector.user_wave_mercenary_spell
(
    id               uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id          uuid NOT NULL REFERENCES collector.user (id),
    wave_history_id  uuid NOT NULL REFERENCES collector.wave_history (id),
    mercenary_npc_id uuid NOT NULL REFERENCES collector.mercenary_npc (id)
);

COMMENT ON COLUMN collector.user.simple_rating IS 'Вычисляется каждую игру';
COMMENT ON COLUMN collector.user.competitive_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг"';
COMMENT ON COLUMN collector.user.relative_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг" по особой системе';