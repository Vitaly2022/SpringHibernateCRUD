CREATE TABLE project
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
    );

    CREATE TABLE position
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
    );

CREATE TABLE developer
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    position_id INTEGER,
    FOREIGN KEY (position_id) REFERENCES position (id)
);

CREATE TABLE developer_project
(
    id SERIAL PRIMARY KEY,
    developer_id INTEGER,
    project_id INTEGER,
    FOREIGN KEY (developer_id) REFERENCES developer (id),
    FOREIGN KEY (project_id) REFERENCES project (id)
);
