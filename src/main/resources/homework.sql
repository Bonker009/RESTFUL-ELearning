CREATE TABLE instructors
(
    instructor_id   SERIAL PRIMARY KEY,
    instructor_name VARCHAR(50) NOT NULL,
    email           VARCHAR(100)
);
CREATE TABLE courses
(
    course_id     SERIAL PRIMARY KEY,
    course_name   VARCHAR(50)  NOT NULL,
    description   VARCHAR(250) NOT NULL,
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES instructors (instructor_id) ON DELETE CASCADE
);
CREATE TABLE students
(
    student_id   SERIAL PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    email        VARCHAR(100),
    phone_number VARCHAR(15)
);
CREATE TABLE student_course
(
    id         SERIAL PRIMARY KEY,
    student_id INT,
    course_id  INT,
    FOREIGN KEY (student_id) REFERENCES students (student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses (course_id) ON DELETE CASCADE,
    UNIQUE (student_id, course_id)
);

INSERT INTO instructors (instructor_name, email)
VALUES ('John Doe', 'john.doe@example.com'),
       ('Jane Smith', 'jane.smith@example.com');

INSERT INTO courses (course_name, description, instructor_id)
VALUES ('Mathematics', 'Introduction to mathematics', 1),
       ('English', 'Introduction to English language', 2),
       ('Physics', 'Introduction to physics', 1);


INSERT INTO students (student_name, email, phone_number)
VALUES ('Alice Johnson', 'alice.johnson@example.com', '123-456-7890'),
       ('Bob Smith', 'bob.smith@example.com', '987-654-3210'),
       ('Charlie Brown', 'charlie.brown@example.com', '555-123-4567');

INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 1),
       (3, 3);

