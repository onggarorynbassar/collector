INSERT INTO collector.settings (id, name)
VALUES ('56e54d8f-4785-4180-80fb-1605af213805', 'graphics'),
       ('6028d819-8422-4200-b46b-1016fb5a3126', 'audio'),
       ('754f85a2-5240-4641-a01b-9190a1168745', 'ambient'),
       ('3684eed4-0c77-4a33-9f86-a790fa67f39d', 'skin'),
       ('97076565-2a86-4b4e-9b1e-d4179aac2982', 'hud');
INSERT INTO collector."user" (id, steam_id)
VALUES ('58138920-28f7-4fb6-a63c-459852978e0f', 'testUser');

INSERT INTO collector.user_settings (user_id, setting_id, value)
VALUES ('58138920-28f7-4fb6-a63c-459852978e0f', '56e54d8f-4785-4180-80fb-1605af213805', 6),
       ('58138920-28f7-4fb6-a63c-459852978e0f', '6028d819-8422-4200-b46b-1016fb5a3126', 22),
       ('58138920-28f7-4fb6-a63c-459852978e0f', '754f85a2-5240-4641-a01b-9190a1168745', 75),
       ('58138920-28f7-4fb6-a63c-459852978e0f', '3684eed4-0c77-4a33-9f86-a790fa67f39d', 31),
       ('58138920-28f7-4fb6-a63c-459852978e0f', '97076565-2a86-4b4e-9b1e-d4179aac2982', 88);

INSERT INTO collector.npc (id, name)
VALUES ('78ccedc2-8d3b-4605-8455-9e636db96910', 'dummy'),
       ('74b73595-8400-46ac-98d7-af829b4a1664', 'dummy2'),
       ('e756784c-b08f-4882-bad3-1a7012280423', 'dummy3');

INSERT INTO collector.npc_ability_set (id, npc_id, option)
VALUES ('805fcced-eca2-450e-a93e-14aa6c8bfdb8', '78ccedc2-8d3b-4605-8455-9e636db96910', 1),
       ('716249b0-85f7-4823-baaa-4cdc14f8a1a1', '78ccedc2-8d3b-4605-8455-9e636db96910', 2),
       ('6aa53b53-655a-4fa2-a90e-b70e82d1a1a9', '78ccedc2-8d3b-4605-8455-9e636db96910', 3),
       ('5b54d899-aca8-4223-8a93-36381bb39422', '74b73595-8400-46ac-98d7-af829b4a1664', 1),
       ('6a4d7a67-fd4c-4f73-91c9-a569a18fdaac', '74b73595-8400-46ac-98d7-af829b4a1664', 2),
       ('3c515583-3d93-4cb2-a53d-9a9f21f8d61c', 'e756784c-b08f-4882-bad3-1a7012280423', 1),
       ('fc920d4a-7234-4634-be1c-2fd5aaac66f5', 'e756784c-b08f-4882-bad3-1a7012280423', 2);

INSERT INTO collector.user_npc_ability_override(id, user_id, npc_ability_set_id)
VALUES ('4cdc6f14-5ec4-4e62-a8e2-be0ea5b82bd4', '58138920-28f7-4fb6-a63c-459852978e0f',
        '716249b0-85f7-4823-baaa-4cdc14f8a1a1'),
       ('9e0f5ff1-5045-439a-99e8-ed488827f56d', '58138920-28f7-4fb6-a63c-459852978e0f',
        '3c515583-3d93-4cb2-a53d-9a9f21f8d61c');