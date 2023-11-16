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
(CURRENT_TIMESTAMP, 1, 1, 2),
(CURRENT_TIMESTAMP, 2, 1, 3),
(CURRENT_TIMESTAMP, 3, 2, 4),
(CURRENT_TIMESTAMP, 4, 4, 5),
(CURRENT_TIMESTAMP, 5, 2, 1),
(CURRENT_TIMESTAMP, 6, 3, 5),
(CURRENT_TIMESTAMP, 7, 4, 2),
(CURRENT_TIMESTAMP, 8, 5, 3),
(CURRENT_TIMESTAMP, 9, 5, 1),
(CURRENT_TIMESTAMP, 10, 4, 1);