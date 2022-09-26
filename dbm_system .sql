-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2021 at 07:27 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbm_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `electricity`
--

CREATE TABLE `electricity` (
  `id` int(50) DEFAULT NULL,
  `Bill_date` date NOT NULL,
  `Units` int(11) NOT NULL,
  `Amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electricity`
--

INSERT INTO `electricity` (`id`, `Bill_date`, `Units`, `Amount`) VALUES
(1, '2021-09-16', 125, 1313),
(1, '2021-09-20', 23, 555),
(2, '2021-09-09', 322, 323232),
(3, '2021-09-02', 3232, 121211),
(NULL, '2000-12-12', 1233, 212323),
(NULL, '2010-12-12', 556, 322),
(NULL, '2009-10-05', 123, 1233),
(NULL, '2021-08-24', 156, 2135),
(1, '2021-08-24', 156, 2135),
(6, '2021-08-01', 56, 3311);

-- --------------------------------------------------------

--
-- Table structure for table `telephone`
--

CREATE TABLE `telephone` (
  `id` int(50) NOT NULL,
  `Bill_Date` date NOT NULL,
  `Amount(Rs.)` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `telephone`
--

INSERT INTO `telephone` (`id`, `Bill_Date`, `Amount(Rs.)`) VALUES
(1, '2021-07-13', 1323),
(6, '2021-07-15', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE `userlogin` (
  `Id` int(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`Id`, `user_name`, `password`) VALUES
(1, 'madushan', '1996'),
(2, 'ranidu', '1997'),
(3, 'test1', '123'),
(4, '1', '123'),
(6, 'jayaz', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `water`
--

CREATE TABLE `water` (
  `id` int(50) NOT NULL,
  `Bill_Date` date NOT NULL,
  `Units` int(11) NOT NULL,
  `Amount(Rs.)` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `water`
--

INSERT INTO `water` (`id`, `Bill_Date`, `Units`, `Amount(Rs.)`) VALUES
(6, '2021-07-21', 253, 2135);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electricity`
--
ALTER TABLE `electricity`
  ADD KEY `Test` (`id`);

--
-- Indexes for table `telephone`
--
ALTER TABLE `telephone`
  ADD KEY `id` (`id`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `water`
--
ALTER TABLE `water`
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `electricity`
--
ALTER TABLE `electricity`
  ADD CONSTRAINT `Test` FOREIGN KEY (`id`) REFERENCES `userlogin` (`Id`);

--
-- Constraints for table `telephone`
--
ALTER TABLE `telephone`
  ADD CONSTRAINT `telephone_ibfk_1` FOREIGN KEY (`id`) REFERENCES `userlogin` (`Id`);

--
-- Constraints for table `water`
--
ALTER TABLE `water`
  ADD CONSTRAINT `water_ibfk_1` FOREIGN KEY (`id`) REFERENCES `userlogin` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
