CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA IF NOT EXISTS collector;


CREATE TABLE collector.player
(
    id              uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    steam_id        text    NOT NULL DEFAULT '',
    simple_mmr      integer NOT NULL DEFAULT 1000,
    competitive_mmr integer NOT NULL DEFAULT 1000,
    relative_mmr    integer NOT NULL DEFAULT 1000
);


CREATE TABLE collector.match
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_id uuid NOT NULL REFERENCES collector.player (id)
);


CREATE TABLE collector.match_history
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_id uuid    NOT NULL REFERENCES collector.player (id),
    match_id  uuid    NOT NULL REFERENCES collector.player (id),
    place     integer NOT NULL DEFAULT 1
);

COMMENT ON COLUMN collector.match_history.place IS 'FROM 1(BEST) TO 8(LOOSER)';


