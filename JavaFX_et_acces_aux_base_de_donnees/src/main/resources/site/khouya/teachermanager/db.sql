create database if not exists javafxdb;

use javafxdb;
CREATE TABLE `departements` (
                                `id` INT(10) NOT NULL AUTO_INCREMENT,
                                `nom` VARCHAR(25) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                                PRIMARY KEY (`id`) USING BTREE,
                                UNIQUE INDEX `nom` (`nom`) USING BTREE
)
    COLLATE='utf8mb4_0900_ai_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=39
;

CREATE TABLE `professeurs` (
                               `id` INT(10) NOT NULL AUTO_INCREMENT,
                               `nom` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `prenom` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `cin` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `adresse` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `email` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `telephone` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
                               `date_recrutement` DATE NOT NULL,
                               `departement_id` INT(10) NULL DEFAULT NULL,
                               PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE INDEX `email` (`email`) USING BTREE,
                               UNIQUE INDEX `telephone` (`telephone`) USING BTREE,
                               INDEX `professeurs_ibfk_1` (`departement_id`) USING BTREE,
                               CONSTRAINT `professeurs_ibfk_1` FOREIGN KEY (`departement_id`) REFERENCES `departements` (`id`) ON UPDATE NO ACTION ON DELETE SET NULL
)
    COLLATE='utf8mb4_0900_ai_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=39
;
INSERT INTO departements (id, nom) VALUES (1,'Mathematics');
INSERT INTO departements (id, nom) VALUES (2,'Computer Science');
INSERT INTO departements (id, nom) VALUES (3,'Physics');
INSERT INTO departements (id, nom) VALUES (4,'Chemistry');
INSERT INTO departements (id, nom) VALUES (5,'Biology');
INSERT INTO departements (id, nom) VALUES (6,'History');
INSERT INTO departements (id, nom) VALUES (7,'Literature');
INSERT INTO departements (id, nom) VALUES (8,'Philosophy');
INSERT INTO departements (id, nom) VALUES (9,'Economics');
INSERT INTO departements (id, nom) VALUES (10,'Sociology');

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Smith', 'John', 'CIN1234567', '123 Main St, City', 'john.smith@example.com', '0612345678', '2015-09-01', 1);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Doe', 'Jane', 'CIN2345678', '456 Elm St, City', 'jane.doe@example.com', '0612345679', '2016-02-15', 2);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Brown', 'James', 'CIN3456789', '789 Oak St, City', 'james.brown@example.com', '0612345680', '2017-07-12', 3);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Johnson', 'Emily', 'CIN4567890', '321 Pine St, City', 'emily.johnson@example.com', '0612345681', '2018-01-20', 4);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Williams', 'Michael', 'CIN5678901', '654 Maple St, City', 'michael.williams@example.com', '0612345682', '2019-03-30', 5);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Taylor', 'Sophia', 'CIN6789012', '987 Birch St, City', 'sophia.taylor@example.com', '0612345683', '2020-06-18', 6);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Anderson', 'David', 'CIN7890123', '159 Walnut St, City', 'david.anderson@example.com', '0612345684', '2021-08-05', 7);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Lee', 'Olivia', 'CIN8901234', '753 Cedar St, City', 'olivia.lee@example.com', '0612345685', '2022-04-22', 8);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Martinez', 'Daniel', 'CIN9012345', '951 Aspen St, City', 'daniel.martinez@example.com', '0612345686', '2013-12-15', 9);

INSERT INTO professeurs (nom, prenom, cin, adresse, email, telephone, date_recrutement, departement_id)
VALUES ('Clark', 'Emma', 'CIN0123456', '357 Spruce St, City', 'emma.clark@example.com', '0612345687', '2014-11-25', 10);
