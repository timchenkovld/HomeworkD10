INSERT INTO client (name)
VALUES
('Vladyslav'),
('Oleksandr'),
('Dmytro'),
('Anna'),
('Olga'),
('Volodymyr'),
('Olena'),
('Roman'),
('Oleh'),
('Alina');

INSERT INTO planet (id, name)
VALUES
('EARTH', 'Earth'),
('MARS23', 'Mars23'),
('VENUS11', 'Venus11'),
('JUPITER', 'Jupiter'),
('URANUS45', 'Uranus45');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES
(CURRENT_TIMESTAMP, 1, 'EARTH', 'MARS23'),
(CURRENT_TIMESTAMP, 2, 'VENUS11', 'MARS23'),
(CURRENT_TIMESTAMP, 3, 'VENUS11', 'JUPITER'),
(CURRENT_TIMESTAMP, 4, 'EARTH', 'URANUS45'),
(CURRENT_TIMESTAMP, 5, 'URANUS45', 'EARTH'),
(CURRENT_TIMESTAMP, 6, 'JUPITER', 'URANUS45'),
(CURRENT_TIMESTAMP, 7, 'JUPITER', 'EARTH'),
(CURRENT_TIMESTAMP, 8, 'MARS23', 'EARTH'),
(CURRENT_TIMESTAMP, 9, 'URANUS45', 'VENUS11'),
(CURRENT_TIMESTAMP, 10, 'MARS23', 'EARTH');