ALTER TABLE ONLY collector.player
    ALTER COLUMN simple_mmr SET DEFAULT 0;
ALTER TABLE ONLY collector.player
    ALTER COLUMN competitive_mmr SET DEFAULT 0;
ALTER TABLE ONLY collector.player
    ALTER COLUMN relative_mmr SET DEFAULT 0;

ALTER TABLE collector.player
    RENAME COLUMN simple_mmr TO simple_rating;
ALTER TABLE collector.player
    RENAME COLUMN competitive_mmr TO competitive_rating;
ALTER TABLE collector.player
    RENAME COLUMN relative_mmr TO relative_rating;

COMMENT ON COLUMN collector.player.simple_rating IS 'Вычисляется каждую игру';
COMMENT ON COLUMN collector.player.competitive_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг"';
COMMENT ON COLUMN collector.player.relative_rating IS 'Вычисляется если игрок выбрал пункт "играть за рейтинг" по особой системе';
