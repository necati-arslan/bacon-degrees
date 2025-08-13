DROP TABLE IF EXISTS name_basics;
CREATE TABLE IF NOT EXISTS name_basics (
    nconst VARCHAR(255) PRIMARY KEY,
    primaryName VARCHAR(255),
    birthYear INT,
    deathYear INT,
    primaryProfession VARCHAR(255),
    knownForTitles VARCHAR(1024)
);

CREATE TABLE IF NOT EXISTS title_basics (
    tconst VARCHAR(255) PRIMARY KEY,
    titleType VARCHAR(50),
    primaryTitle VARCHAR(255),
    originalTitle VARCHAR(255),
    isAdult BOOLEAN,
    startYear INT,
    endYear INT,
    runtimeMinutes INT,
    genres VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS title_principals (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tconst VARCHAR(20),
    ordering INT,
    nconst VARCHAR(20),
    category VARCHAR(100),
    job VARCHAR(255),
    characters VARCHAR(1000)
);
