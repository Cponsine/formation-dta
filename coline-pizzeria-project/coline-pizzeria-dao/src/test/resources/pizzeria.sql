-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 05 Janvier 2017 à 17:15
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeria`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `clientID` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `adresse_rue` text NOT NULL,
  `adresse_numero` int(11) DEFAULT NULL,
  `adresse_ville` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`clientID`, `nom`, `prenom`, `telephone`, `adresse_rue`, `adresse_numero`, `adresse_ville`) VALUES
(2, 'O''Connell', 'Paddy', '035317852', 'Lower Abbey Street -D1', 6, 'Dublin'),
(3, 'McGowan', 'Shane', '035319712', 'Kildare Street -D2', 36, 'Dublin'),
(4, 'Ni Conghaile', 'Mary', '035318763', 'main street', 252, 'Clifden'),
(5, 'Cooper', 'Colm', '035321715', 'Patrick street', 12, 'Dingle'),
(6, 'McFarlane', 'Grant', '00447815632', 'Andrew street', 81, 'Edinburgh'),
(7, 'O''Shea', 'William', '035311812', 'Bridget street', 108, 'Navan'),
(8, 'Murphy', 'Oisin', '035312755', 'Church street', 144, 'Bray'),
(9, 'Doyle', 'Brittany', '035317429', 'French street', 162, 'Kinsale'),
(10, 'Connell', 'Helen', '035314592', 'castle street', 135, 'Limerick'),
(11, 'O''Leary', 'Michael', '035394283', 'Dublin road', 32, 'Swords'),
(12, 'Flynn', 'Liam', '035355294', 'Rory Gallagher street', 8, 'Slane'),
(13, 'Hunt', 'Séamus', '035318752', 'Parnell square west- D1', 365, 'Dublin'),
(14, 'Jones', 'Bridget', '0044541929', 'Park avenue', 85, 'London'),
(15, 'O''Donnell', 'Patrick', '035378456', 'Merrion square -D2', 819, 'Dublin'),
(18, 'Lepoulpe', 'Paul', '0256987163', 'Rue de la mer', 66, 'Prinquiau');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `commandeID` int(11) NOT NULL,
  `numero` varchar(12) NOT NULL,
  `clientID` int(11) NOT NULL,
  `datec` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`commandeID`, `numero`, `clientID`, `datec`) VALUES
(1, '201612070642', 4, '2016-12-07'),
(2, '201612079416', 4, '2016-12-07'),
(3, '201612060094', 1, '2016-12-06'),
(4, '201612121622', 2, '2016-12-12'),
(5, '201612110904', 3, '2016-12-11'),
(6, '201612184508', 4, '2016-12-18'),
(7, '201612200813', 5, '2016-12-20'),
(8, '201612048052', 1, '2016-12-04'),
(9, '201611270502', 2, '2016-11-27'),
(10, '201609174896', 9, '2016-09-17'),
(11, '12', 3, '2016-12-15');

-- --------------------------------------------------------

--
-- Structure de la table `commandepizza`
--

CREATE TABLE `commandepizza` (
  `commandeID` int(11) NOT NULL,
  `pizzaID` int(11) NOT NULL,
  `quantite` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `commandepizza`
--

INSERT INTO `commandepizza` (`commandeID`, `pizzaID`, `quantite`) VALUES
(1, 6, 2),
(1, 9, 1),
(2, 9, 4),
(3, 6, 5),
(7, 9, 2),
(8, 6, 4),
(1, 2, 8),
(2, 2, 5),
(4, 2, 1),
(10, 9, 1),
(5, 6, 1),
(4, 4, 1),
(10, 4, 2),
(6, 3, 1),
(9, 1, 1),
(9, 6, 2),
(5, 5, 2),
(3, 4, 1),
(6, 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `livreur`
--

CREATE TABLE `livreur` (
  `LivreurID` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `telephone` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `livreur`
--

INSERT INTO `livreur` (`LivreurID`, `nom`, `prenom`, `telephone`) VALUES
(1, 'Duff', 'John', 614852713),
(2, 'Tazy', 'Alex', 624829421),
(3, 'Ruanna', 'Marie', 684582818),
(4, 'Lescalope', 'Dédé', 617539428);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `mapizzeria`
--
CREATE TABLE `mapizzeria` (
);

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

CREATE TABLE `pizza` (
  `PizzaID` int(11) NOT NULL,
  `code` varchar(3) NOT NULL,
  `Libelle` varchar(15) NOT NULL,
  `prix` decimal(10,2) NOT NULL,
  `categorie` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pizza`
--

INSERT INTO `pizza` (`PizzaID`, `code`, `Libelle`, `prix`, `categorie`) VALUES
(6, 'REI', 'Reine', '9.50', 'SANS_VIANDE'),
(7, 'MAR', 'Margherita', '11.90', 'VIANDE'),
(8, 'IND', 'Indienne', '13.90', 'VIANDE'),
(9, 'ORI', 'Orientale', '10.90', 'VIANDE'),
(10, 'FRM', '5 fromages', '144.00', 'SANS_VIANDE'),
(11, 'CAN', 'Cannibale', '12.50', 'VIANDE'),
(13, 'BZH', 'Bretonne', '11.50', 'POISSON'),
(14, 'TIN', 'Tino', '125.00', 'POISSON'),
(15, 'AME', 'Américaine', '12.90', 'VIANDE'),
(16, 'PEP', 'Peperoni', '12.50', 'VIANDE'),
(17, 'GUI', 'Guillaume', '21.00', 'VIANDE'),
(19, 'JUL', 'Julien', '10.00', 'SANS_VIANDE'),
(20, 'GER', 'Gerbouille', '15.00', 'VIANDE'),
(22, 'LOL', 'Lolilol', '10.30', 'Poisson'),
(24, 'SAU', 'Sausage Party', '6.00', 'VIANDE'),
(25, 'SCA', 'SensationCalien', '11.20', 'SANS_VIANDE'),
(26, 'PIP', 'Piperade', '9.00', 'SANS_VIANDE'),
(27, 'SUD', 'Sudiste', '8.75', 'POISSON'),
(28, 'GRA', 'Gratouille', '8.95', 'POISSON');

-- --------------------------------------------------------

--
-- Structure de la vue `mapizzeria`
--
DROP TABLE IF EXISTS `mapizzeria`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mapizzeria`  AS  select `commande`.`date` AS `date`,`client`.`nom` AS `nom`,`commande`.`commandeID` AS `commandeID`,`commandepizza`.`quantite` AS `quantite`,`pizza`.`Libelle` AS `Libelle`,`pizza`.`prix` AS `prix` from (((`client` join `commande`) join `commandepizza`) join `pizza`) where ((`commande`.`clientID` = `client`.`clientID`) and (`commande`.`commandeID` = `commandepizza`.`commandeID`) and (`commandepizza`.`pizzaID` = `pizza`.`PizzaID`)) ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`clientID`),
  ADD KEY `adresse_ville` (`adresse_ville`) USING BTREE;

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`commandeID`),
  ADD KEY `clientID` (`clientID`);

--
-- Index pour la table `commandepizza`
--
ALTER TABLE `commandepizza`
  ADD KEY `commandeID` (`commandeID`),
  ADD KEY `pizzaID` (`pizzaID`);

--
-- Index pour la table `livreur`
--
ALTER TABLE `livreur`
  ADD PRIMARY KEY (`LivreurID`);

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`PizzaID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `clientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `commandeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `livreur`
--
ALTER TABLE `livreur`
  MODIFY `LivreurID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `PizzaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
