CREATE TABLE collector.player_place
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_id uuid    NOT NULL REFERENCES collector.player (id),
    place     integer NOT NULL
);

ALTER TABLE collector.match_history
    DROP COLUMN place;

ALTER TABLE collector.match_history
    DROP COLUMN player_id;

ALTER TABLE collector.match_history
    ADD COLUMN player_place_id uuid NOT NULL DEFAULT uuid_generate_v4() REFERENCES collector.player_place (id);