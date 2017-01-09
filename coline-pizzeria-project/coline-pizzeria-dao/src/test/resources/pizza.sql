-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 05 Janvier 2017 à 16:31
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.24



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeria`
--

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
);

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
(15, 'AME', 'Americaine', '12.90', 'VIANDE'),
(16, 'PEP', 'Peperoni', '12.50', 'VIANDE'),
(17, 'GUI', 'Guillaume', '21.00', 'VIANDE'),
(19, 'JUL', 'Julien', '10.00', 'SANS_VIANDE'),
(20, 'GER', 'Gerbouille', '15.00', 'VIANDE'),
(22, 'LOL', 'Lolilol', '10.30', 'POISSON'),
(24, 'SAU', 'Sausage Party', '6.00', 'VIANDE'),
(25, 'SCA', 'SessionCaliente', '11.20', 'SANS_VIANDE'),
(26, 'PIP', 'Piperade', '9.00', 'SANS_VIANDE'),
(27, 'SUD', 'Sudiste', '8.75', 'POISSON'),
(28, 'GRA', 'Gratouille', '8.95', 'POISSON');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`PizzaID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `PizzaID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
