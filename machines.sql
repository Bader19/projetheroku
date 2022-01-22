-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2022 at 08:26 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `machines`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ID`, `Nom`, `Prenom`) VALUES
(2, 'yasmine', 'khaldaoui'),
(3, 'Benhirt', 'Bader');

-- --------------------------------------------------------

--
-- Table structure for table `crenom`
--

CREATE TABLE `crenom` (
  `ID` int(11) NOT NULL,
  `HeureDebut` time NOT NULL,
  `HeureFin` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crenom`
--

INSERT INTO `crenom` (`ID`, `HeureDebut`, `HeureFin`) VALUES
(5, '12:00:00', '13:38:00'),
(10, '23:00:00', '00:00:00'),
(11, '00:00:00', '14:00:00'),
(12, '23:00:00', '00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `machine`
--

CREATE TABLE `machine` (
  `id` int(11) NOT NULL,
  `reference` varchar(20) NOT NULL,
  `dateAchat` date NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `machine`
--

INSERT INTO `machine` (`id`, `reference`, `dateAchat`, `prix`) VALUES
(1, '155A', '2021-12-01', 38000),
(2, '155A', '2021-12-15', 785),
(3, '155A', '2021-12-08', 15),
(4, '155A', '2021-12-09', 455),
(5, '155A', '2021-12-15', 38000);

-- --------------------------------------------------------

--
-- Table structure for table `occupation`
--

CREATE TABLE `occupation` (
  `ID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `IDCrenom` int(11) NOT NULL,
  `IDSalle` int(11) NOT NULL,
  `Idclient` int(11) DEFAULT NULL,
  `Validation` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `occupation`
--

INSERT INTO `occupation` (`ID`, `Date`, `IDCrenom`, `IDSalle`, `Idclient`, `Validation`) VALUES
(134, '2022-06-01', 5, 2, 2, 1),
(135, '2022-06-15', 10, 2, 3, 1),
(136, '2022-01-08', 10, 3, 2, 1),
(137, '2022-05-06', 11, 2, 2, 1),
(138, '2022-01-13', 5, 1, 2, 1),
(139, '2022-03-17', 5, 2, 2, 0),
(140, '2022-04-14', 5, 1, 2, 0),
(141, '2022-05-26', 5, 1, 2, 1),
(142, '2022-06-03', 5, 1, 2, 1),
(143, '2022-07-07', 5, 1, 2, 1),
(144, '2022-08-17', 5, 1, 2, 1),
(145, '2022-09-23', 5, 1, 2, 1),
(146, '2022-10-07', 5, 1, 2, 1),
(147, '2022-11-17', 5, 1, 2, 1),
(148, '2022-12-16', 5, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE `salle` (
  `ID` int(11) NOT NULL,
  `Code` varchar(20) NOT NULL,
  `Capacite` varchar(11) NOT NULL,
  `Type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`ID`, `Code`, `Capacite`, `Type`) VALUES
(1, 'E-2596', '10', 'M'),
(2, 'E-2596', '58', 'aze'),
(3, 'E-2596', '45', 'aze'),
(4, 'Mc-2596', '10', 'M'),
(5, 'aze', '89', 'aze'),
(6, 'E-2596', '10', 'M'),
(7, 'E-2597', '10', 'aze');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Username`, `Password`, `Email`, `Phone`, `Admin`) VALUES
(6, 'Bader15', 'e10adc3949ba59abbe56e057f20f883e', 'Hassan@gmail.com', '0655565116', 1),
(9, 'Yasmine', '4607e782c4d86fd5364d7e4508bb10d9', 'Yasminebenhirt@gmail.com', '0655565116', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `crenom`
--
ALTER TABLE `crenom`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `machine`
--
ALTER TABLE `machine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `occupation`
--
ALTER TABLE `occupation`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `crenom`
--
ALTER TABLE `crenom`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `machine`
--
ALTER TABLE `machine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `occupation`
--
ALTER TABLE `occupation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;

--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
