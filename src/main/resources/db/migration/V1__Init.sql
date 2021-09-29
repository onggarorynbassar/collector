CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS collector;


CREATE TABLE collector.player
(
    id                 uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    steam_id           text    NOT NULL UNIQUE,
    simple_rating      integer NOT NULL DEFAULT 1000,
    competitive_rating integer NOT NULL DEFAULT 1000,
    relative_rating    integer NOT NULL DEFAULT 400
);


CREATE TABLE collector.match
(
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4()
);

CREATE TABLE collector.player_place
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_id uuid    NOT NULL REFERENCES collector.player (id),
    place     integer NOT NULL
);


CREATE TABLE collector.match_history
(
    id              uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_place_id uuid NOT NULL REFERENCES collector.player_place (id),
    match_id        uuid NOT NULL REFERENCES collector.match (id)
);

COMMENT ON COLUMN collector.player_place.place IS 'FROM 1(BEST) TO 8(LOOSER)';
COMMENT ON COLUMN collector.player.simple_rating IS 'Вычисляется каждую игру';
COMMENT ON COLUMN collector.player.competitive_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг"';
COMMENT ON COLUMN collector.player.relative_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг" по особой системе';