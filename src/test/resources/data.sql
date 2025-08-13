DELETE FROM title_principals;
DELETE FROM title_basics;
DELETE FROM name_basics;

-- name_basics
INSERT INTO name_basics (nconst, primaryName, birthYear, deathYear, primaryProfession, knownForTitles) VALUES
('nm0000001', 'Kevin Bacon', 1958, NULL, 'actor', 'tt0000001,tt0000005'),
('nm0000002', 'Tom Hanks', 1956, NULL, 'actor', 'tt0000002,tt0000005'),
('nm0000003', 'Leonardo DiCaprio', 1974, NULL, 'actor', 'tt0000003'),
('nm0000004', 'Morgan Freeman', 1937, NULL, 'actor', 'tt0000004'),
('nm0000005', 'Scarlett Johansson', 1984, NULL, 'actress', 'tt0000006'),
('nm0000006', 'Brad Pitt', 1963, NULL, 'actor', 'tt0000007'),
('nm0000007', 'Natalie Portman', 1981, NULL, 'actress', 'tt0000008'),
('nm0000008', 'Samuel L. Jackson', 1948, NULL, 'actor', 'tt0000009'),
('nm0000009', 'Robert Downey Jr.', 1965, NULL, 'actor', 'tt0000010'),
('nm0000010', 'Emma Stone', 1988, NULL, 'actress', 'tt0000011'),
('nm0000011', 'Ryan Gosling', 1980, NULL, 'actor', 'tt0000011'),
('nm0000012', 'Anne Hathaway', 1982, NULL, 'actress', 'tt0000012'),
('nm0000013', 'Matt Damon', 1970, NULL, 'actor', 'tt0000013'),
('nm0000014', 'Christian Bale', 1974, NULL, 'actor', 'tt0000014'),
('nm0000015', 'Amy Adams', 1974, NULL, 'actress', 'tt0000015'),
('nm0000016', 'Tom Hardy', 1977, NULL, 'actor', 'tt0000016'),
('nm0000017', 'Hugh Jackman', 1968, NULL, 'actor', 'tt0000017'),
('nm0000018', 'Chris Evans', 1981, NULL, 'actor', 'tt0000018'),
('nm0000019', 'Jennifer Lawrence', 1990, NULL, 'actress', 'tt0000019'),
('nm0000020', 'Denzel Washington', 1954, NULL, 'actor', 'tt0000020');

-- title_basics
INSERT INTO title_basics (tconst, titleType, primaryTitle, originalTitle, isAdult, startYear, endYear, runtimeMinutes, genres) VALUES
('tt0000001', 'movie', 'Film A', 'Film A', false, 1990, NULL, 120, 'Drama'),
('tt0000002', 'movie', 'Film B', 'Film B', false, 1995, NULL, 110, 'Comedy'),
('tt0000003', 'movie', 'Film C', 'Film C', false, 2000, NULL, 130, 'Thriller'),
('tt0000004', 'movie', 'Film D', 'Film D', false, 2001, NULL, 140, 'Action'),
('tt0000005', 'movie', 'Film E', 'Film E', false, 1996, NULL, 125, 'Drama'),
('tt0000006', 'movie', 'Film F', 'Film F', false, 2003, NULL, 115, 'Romance'),
('tt0000007', 'movie', 'Film G', 'Film G', false, 1999, NULL, 105, 'Sci-Fi'),
('tt0000008', 'movie', 'Film H', 'Film H', false, 2010, NULL, 100, 'Drama'),
('tt0000009', 'movie', 'Film I', 'Film I', false, 2005, NULL, 95, 'Comedy'),
('tt0000010', 'movie', 'Film J', 'Film J', false, 2015, NULL, 90, 'Action'),
('tt0000011', 'movie', 'Film K', 'Film K', false, 2016, NULL, 130, 'Musical'),
('tt0000012', 'movie', 'Film L', 'Film L', false, 2012, NULL, 125, 'Drama'),
('tt0000013', 'movie', 'Film M', 'Film M', false, 2006, NULL, 135, 'Action'),
('tt0000014', 'movie', 'Film N', 'Film N', false, 2011, NULL, 140, 'Crime'),
('tt0000015', 'movie', 'Film O', 'Film O', false, 2013, NULL, 118, 'Biography'),
('tt0000016', 'movie', 'Film P', 'Film P', false, 2014, NULL, 112, 'Sci-Fi'),
('tt0000017', 'movie', 'Film Q', 'Film Q', false, 2017, NULL, 108, 'Drama'),
('tt0000018', 'movie', 'Film R', 'Film R', false, 2018, NULL, 110, 'Adventure'),
('tt0000019', 'movie', 'Film S', 'Film S', false, 2019, NULL, 102, 'Fantasy'),
('tt0000020', 'movie', 'Film T', 'Film T', false, 2020, NULL, 120, 'History');

-- title_principals
INSERT INTO title_principals (tconst, ordering, nconst, category, job, characters) VALUES
('tt0000001', 1, 'nm0000001', 'actor', NULL, '[A]'),
('tt0000001', 2, 'nm0000002', 'actor', NULL, '[B]'),
('tt0000002', 1, 'nm0000002', 'actor', NULL, '[B]'),
('tt0000002', 2, 'nm0000003', 'actor', NULL, '[C]'),
('tt0000003', 1, 'nm0000003', 'actor', NULL, '[C]'),
('tt0000003', 2, 'nm0000004', 'actor', NULL, '[D]'),
('tt0000004', 1, 'nm0000004', 'actor', NULL, '[D]'),
('tt0000004', 2, 'nm0000005', 'actress', NULL, '[E]'),
('tt0000005', 1, 'nm0000001', 'actor', NULL, '[A]'),
('tt0000005', 2, 'nm0000006', 'actor', NULL, '[F]'),
('tt0000006', 1, 'nm0000005', 'actress', NULL, '[E]'),
('tt0000006', 2, 'nm0000007', 'actress', NULL, '[G]'),
('tt0000007', 1, 'nm0000006', 'actor', NULL, '[F]'),
('tt0000007', 2, 'nm0000008', 'actor', NULL, '[H]'),
('tt0000008', 1, 'nm0000007', 'actress', NULL, '[G]'),
('tt0000008', 2, 'nm0000009', 'actor', NULL, '[I]'),
('tt0000009', 1, 'nm0000008', 'actor', NULL, '[H]'),
('tt0000009', 2, 'nm0000010', 'actress', NULL, '[J]'),
('tt0000010', 1, 'nm0000009', 'actor', NULL, '[I]'),
('tt0000010', 2, 'nm0000011', 'actor', NULL, '[K]');
