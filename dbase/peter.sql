-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2018 at 02:01 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `peter`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `loc` varchar(100) NOT NULL,
  `val` longtext NOT NULL,
  `author` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`loc`, `val`, `author`) VALUES
('0-0', 'A', 'alan'),
('0-1', '4', 'alan'),
('0-10', 'kl', 'alan'),
('0-11', 'kl', 'alan'),
('0-12', 'k', 'alan'),
('0-13', 'lk', 'alan'),
('0-14', 'lk', 'alan'),
('0-15', 'l', 'alan'),
('0-16', 'kl', 'alan'),
('0-17', 'k', 'alan'),
('0-18', 'lk', 'alan'),
('0-19', 'l', 'alan'),
('0-2', '3', 'alan'),
('0-3', '1.0', 'alan'),
('0-4', 'kl', 'alan'),
('0-5', 'k', 'alan'),
('0-6', 'null', 'alan'),
('0-7', 'kl', 'alan'),
('0-8', 'kl', 'alan'),
('0-9', 'kl', 'alan'),
('1-0', '2', 'alan'),
('1-1', ' ', ''),
('1-10', 'kl', 'alan'),
('1-11', 'k', 'alan'),
('1-12', 'lk', 'alan'),
('1-13', 'l', 'alan'),
('1-14', 'kl', 'alan'),
('1-15', 'kl', 'alan'),
('1-16', 'k', 'alan'),
('1-17', 'lk', 'alan'),
('1-18', 'lk', 'alan'),
('1-19', 'lk', 'alan'),
('1-2', 'b', 'alan'),
('1-3', 'lk', 'alan'),
('1-4', 'l', 'alan'),
('1-5', 'lk', 'alan'),
('1-6', 'null', 'alan'),
('1-7', 'lk', 'alan'),
('1-8', 'lk', 'alan'),
('1-9', 'l', 'alan'),
('10-0', 'kl', 'alan'),
('10-1', 'kl', 'alan'),
('10-10', 'lol', 'alan'),
('10-11', 'null', 'alan'),
('10-12', 'null', 'alan'),
('10-13', 'coba', 'alan'),
('10-14', 'null', 'alan'),
('10-15', 'null', 'alan'),
('10-16', 'null', 'alan'),
('10-17', 'null', 'alan'),
('10-18', 'null', 'alan'),
('10-19', 'null', 'alan'),
('10-2', 'lala', 'alan'),
('10-3', 'lk', 'alan'),
('10-4', 'kl', 'alan'),
('10-5', 'lk', 'alan'),
('10-6', 'null', 'alan'),
('10-7', 'null', 'alan'),
('10-8', 'null', 'alan'),
('10-9', 'null', 'alan'),
('11-0', 'kl', 'alan'),
('11-1', 'k', 'alan'),
('11-10', 'null', 'alan'),
('11-11', 'null', 'alan'),
('11-12', 'null', 'alan'),
('11-13', 'null', 'alan'),
('11-14', 'null', 'alan'),
('11-15', 'null', 'alan'),
('11-16', 'null', 'alan'),
('11-17', 'null', 'alan'),
('11-18', 'null', 'alan'),
('11-19', 'null', 'alan'),
('11-2', 'kl', 'alan'),
('11-3', 'lkl', 'alan'),
('11-4', 'k', 'alan'),
('11-5', 'null', 'alan'),
('11-6', 'null', 'alan'),
('11-7', 'null', 'alan'),
('11-8', 'null', 'alan'),
('11-9', 'null', 'alan'),
('12-0', 'k', 'alan'),
('12-1', 'lk', 'alan'),
('12-10', 'null', 'alan'),
('12-11', 'null', 'alan'),
('12-12', 'null', 'alan'),
('12-13', 'null', 'alan'),
('12-14', 'null', 'alan'),
('12-15', 'null', 'alan'),
('12-16', 'null', 'alan'),
('12-17', 'null', 'alan'),
('12-18', 'null', 'alan'),
('12-19', 'null', 'alan'),
('12-2', 'k', 'alan'),
('12-3', 'k', 'alan'),
('12-4', 'lk', 'alan'),
('12-5', 'null', 'alan'),
('12-6', 'null', 'alan'),
('12-7', 'a', 'alan'),
('12-8', 'null', 'alan'),
('12-9', 'lol', 'alan'),
('13-0', 'lk', 'alan'),
('13-1', 'l', 'alan'),
('13-10', 'coba', 'alan'),
('13-11', 'null', 'alan'),
('13-12', 'null', 'alan'),
('13-13', 'null', 'alan'),
('13-14', 'null', 'alan'),
('13-15', 'null', 'alan'),
('13-16', 'null', 'alan'),
('13-17', 'null', 'alan'),
('13-18', 'null', 'alan'),
('13-19', 'null', 'alan'),
('13-2', 'lk', 'alan'),
('13-3', 'lk', 'alan'),
('13-4', 'l', 'alan'),
('13-5', 'null', 'alan'),
('13-6', 'null', 'alan'),
('13-7', 'null', 'alan'),
('13-8', 'null', 'alan'),
('13-9', 'null', 'alan'),
('14-0', 'lk', 'alan'),
('14-1', 'kl', 'alan'),
('14-10', '11', 'alan'),
('14-11', 'null', 'alan'),
('14-12', 'null', 'alan'),
('14-13', 'null', 'alan'),
('14-14', 'null', 'alan'),
('14-15', '1', 'alan'),
('14-16', 'null', 'alan'),
('14-17', 'null', 'alan'),
('14-18', 'null', 'alan'),
('14-19', 'null', 'alan'),
('14-2', 'l', 'alan'),
('14-3', 'l', 'alan'),
('14-4', 'k', 'alan'),
('14-5', 'null', 'alan'),
('14-6', 'null', 'alan'),
('14-7', 'null', 'alan'),
('14-8', 'null', 'alan'),
('14-9', 'null', 'alan'),
('15-0', 'l', 'alan'),
('15-1', 'kl', 'alan'),
('15-10', 'null', 'alan'),
('15-11', 'null', 'alan'),
('15-12', 'null', 'alan'),
('15-13', 'null', 'alan'),
('15-14', '1', 'alan'),
('15-15', 'coba', 'alan'),
('15-16', 'null', 'alan'),
('15-17', 'null', 'alan'),
('15-18', 'null', 'alan'),
('15-19', 'null', 'alan'),
('15-2', 'klk', 'alan'),
('15-3', 'kl', 'alan'),
('15-4', 'lk', 'alan'),
('15-5', 'null', 'alan'),
('15-6', 'null', 'alan'),
('15-7', 'null', 'alan'),
('15-8', 'null', 'alan'),
('15-9', '12', 'alan'),
('16-0', 'kl', 'alan'),
('16-1', 'k', 'alan'),
('16-10', 'null', 'alan'),
('16-11', 'null', 'alan'),
('16-12', 'null', 'alan'),
('16-13', 'null', 'alan'),
('16-14', 'null', 'alan'),
('16-15', 'null', 'alan'),
('16-16', 'null', 'alan'),
('16-17', 'null', 'alan'),
('16-18', 'null', 'alan'),
('16-19', 'null', 'alan'),
('16-2', 'l', 'alan'),
('16-3', 'k', 'alan'),
('16-4', 'l', 'alan'),
('16-5', 'null', 'alan'),
('16-6', 'null', 'alan'),
('16-7', 'null', 'alan'),
('16-8', 'null', 'alan'),
('16-9', 'null', 'alan'),
('17-0', 'k', 'alan'),
('17-1', 'lk', 'alan'),
('17-10', 'null', 'alan'),
('17-11', 'null', 'alan'),
('17-12', 'null', 'alan'),
('17-13', 'null', 'alan'),
('17-14', 'null', 'alan'),
('17-15', 'null', 'alan'),
('17-16', 'null', 'alan'),
('17-17', 'null', 'alan'),
('17-18', 'null', 'alan'),
('17-19', 'null', 'alan'),
('17-2', 'k', 'alan'),
('17-3', 'lk', 'alan'),
('17-4', 'kl', 'alan'),
('17-5', 'null', 'alan'),
('17-6', 'null', 'alan'),
('17-7', 'null', 'alan'),
('17-8', 'null', 'alan'),
('17-9', 'null', 'alan'),
('18-0', 'lk', 'alan'),
('18-1', 'lk', 'alan'),
('18-10', 'null', 'alan'),
('18-11', 'null', 'alan'),
('18-12', 'null', 'alan'),
('18-13', 'null', 'alan'),
('18-14', 'null', 'alan'),
('18-15', 'null', 'alan'),
('18-16', 'null', 'alan'),
('18-17', 'null', 'alan'),
('18-18', 'null', 'alan'),
('18-19', 'null', 'alan'),
('18-2', 'lk', 'alan'),
('18-3', 'l', 'alan'),
('18-4', 'k', 'alan'),
('18-5', 'null', 'alan'),
('18-6', 'null', 'alan'),
('18-7', 'null', 'alan'),
('18-8', 'null', 'alan'),
('18-9', 'null', 'alan'),
('19-0', 'l', 'alan'),
('19-1', 'lk', 'alan'),
('19-10', 'null', 'alan'),
('19-11', 'null', 'alan'),
('19-12', 'null', 'alan'),
('19-13', 'null', 'alan'),
('19-14', 'null', 'alan'),
('19-15', 'null', 'alan'),
('19-16', 'null', 'alan'),
('19-17', 'null', 'alan'),
('19-18', 'null', 'alan'),
('19-19', 'null', 'alan'),
('19-2', 'lk', 'alan'),
('19-3', 'kl', 'alan'),
('19-4', 'lkl', 'alan'),
('19-5', 'null', 'alan'),
('19-6', 'null', 'alan'),
('19-7', 'null', 'alan'),
('19-8', 'null', 'alan'),
('19-9', 'null', 'alan'),
('2-0', '3', 'alan'),
('2-1', 'b', 'alan'),
('2-10', 'lala', 'alan'),
('2-11', 'kl', 'alan'),
('2-12', 'k', 'alan'),
('2-13', 'lk', 'alan'),
('2-14', 'l', 'alan'),
('2-15', 'klk', 'alan'),
('2-16', 'l', 'alan'),
('2-17', 'k', 'alan'),
('2-18', 'lk', 'alan'),
('2-19', 'lk', 'alan'),
('2-2', '3', 'alan'),
('2-3', ' ', 'alan'),
('2-4', 'lk', 'alan'),
('2-5', 'hahaha', 'alan'),
('2-6', 'wakka', 'alan'),
('2-7', 'kl', 'alan'),
('2-8', 'k', 'alan'),
('2-9', 'lk', 'alan'),
('3-0', '1.0', 'alan'),
('3-1', 'lk', 'alan'),
('3-10', 'lk', 'alan'),
('3-11', 'lkl', 'alan'),
('3-12', 'k', 'alan'),
('3-13', 'lk', 'alan'),
('3-14', 'l', 'alan'),
('3-15', 'kl', 'alan'),
('3-16', 'k', 'alan'),
('3-17', 'lk', 'alan'),
('3-18', 'l', 'alan'),
('3-19', 'kl', 'alan'),
('3-2', ' ', 'alan'),
('3-3', ' ', 'alan'),
('3-4', 'l', 'alan'),
('3-5', 'kl', 'alan'),
('3-6', 'null', 'alan'),
('3-7', 'lk', 'alan'),
('3-8', 'l', 'alan'),
('3-9', 'k', 'alan'),
('4-0', 'kl', 'alan'),
('4-1', 'l', 'alan'),
('4-10', 'kl', 'alan'),
('4-11', 'k', 'alan'),
('4-12', 'lk', 'alan'),
('4-13', 'l', 'alan'),
('4-14', 'k', 'alan'),
('4-15', 'lk', 'alan'),
('4-16', 'l', 'alan'),
('4-17', 'kl', 'alan'),
('4-18', 'k', 'alan'),
('4-19', 'lkl', 'alan'),
('4-2', 'lk', 'alan'),
('4-3', 'l', 'alan'),
('4-4', 'lk', 'alan'),
('4-5', 'k', 'alan'),
('4-6', 'null', 'alan'),
('4-7', 'k', 'alan'),
('4-8', 'lk', 'alan'),
('4-9', 'l', 'alan'),
('5-0', 'k', 'alan'),
('5-1', 'lk', 'alan'),
('5-10', 'lk', 'alan'),
('5-11', 'null', 'alan'),
('5-12', 'null', 'alan'),
('5-13', 'null', 'alan'),
('5-14', 'null', 'alan'),
('5-15', 'null', 'alan'),
('5-16', 'null', 'alan'),
('5-17', 'null', 'alan'),
('5-18', 'null', 'alan'),
('5-19', 'null', 'alan'),
('5-2', 'hahaha', 'alan'),
('5-3', 'kl', 'alan'),
('5-4', 'k', 'alan'),
('5-5', 'lk', 'alan'),
('5-6', 'l', 'alan'),
('5-7', 'l', 'alan'),
('5-8', 'k', 'alan'),
('5-9', 'lk', 'alan'),
('6-0', 'null', 'alan'),
('6-1', 'null', 'alan'),
('6-10', 'null', 'alan'),
('6-11', 'null', 'alan'),
('6-12', 'null', 'alan'),
('6-13', 'null', 'alan'),
('6-14', 'null', 'alan'),
('6-15', 'null', 'alan'),
('6-16', 'null', 'alan'),
('6-17', 'null', 'alan'),
('6-18', 'null', 'alan'),
('6-19', 'null', 'alan'),
('6-2', 'wakka', 'alan'),
('6-3', 'null', 'alan'),
('6-4', 'null', 'alan'),
('6-5', 'l', 'alan'),
('6-6', 'null', 'alan'),
('6-7', 'null', 'alan'),
('6-8', 'null', 'alan'),
('6-9', 'coba', 'alan'),
('7-0', 'kl', 'alan'),
('7-1', 'lk', 'alan'),
('7-10', 'null', 'alan'),
('7-11', 'null', 'alan'),
('7-12', 'a', 'alan'),
('7-13', 'null', 'alan'),
('7-14', 'null', 'alan'),
('7-15', 'null', 'alan'),
('7-16', 'null', 'alan'),
('7-17', 'null', 'alan'),
('7-18', 'null', 'alan'),
('7-19', 'null', 'alan'),
('7-2', 'kl', 'alan'),
('7-3', 'lk', 'alan'),
('7-4', 'k', 'alan'),
('7-5', 'l', 'alan'),
('7-6', 'null', 'alan'),
('7-7', 'null', 'alan'),
('7-8', 'null', 'alan'),
('7-9', 'as', 'alan'),
('8-0', 'kl', 'alan'),
('8-1', 'lk', 'alan'),
('8-10', 'null', 'alan'),
('8-11', 'null', 'alan'),
('8-12', 'null', 'alan'),
('8-13', 'null', 'alan'),
('8-14', 'null', 'alan'),
('8-15', 'null', 'alan'),
('8-16', 'null', 'alan'),
('8-17', 'null', 'alan'),
('8-18', 'null', 'alan'),
('8-19', 'null', 'alan'),
('8-2', 'k', 'alan'),
('8-3', 'l', 'alan'),
('8-4', 'lk', 'alan'),
('8-5', 'k', 'alan'),
('8-6', 'null', 'alan'),
('8-7', 'null', 'alan'),
('8-8', 'null', 'alan'),
('8-9', 'null', 'alan'),
('9-0', 'kl', 'alan'),
('9-1', 'l', 'alan'),
('9-10', 'null', 'alan'),
('9-11', 'null', 'alan'),
('9-12', 'lol', 'alan'),
('9-13', 'null', 'alan'),
('9-14', 'null', 'alan'),
('9-15', '12', 'alan'),
('9-16', 'null', 'alan'),
('9-17', 'null', 'alan'),
('9-18', 'null', 'alan'),
('9-19', 'null', 'alan'),
('9-2', 'lk', 'alan'),
('9-3', 'k', 'alan'),
('9-4', 'l', 'alan'),
('9-5', 'lk', 'alan'),
('9-6', 'coba', 'alan'),
('9-7', 'as', 'alan'),
('9-8', 'null', 'alan'),
('9-9', 'null', 'alan');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(20) NOT NULL,
  `location` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`time`, `author`, `location`) VALUES
('2018-05-29 18:09:18', 'user', '0-0'),
('2018-05-29 18:09:19', 'user', '11-1'),
('2018-05-29 18:09:20', 'user', '10-3'),
('2018-05-29 18:09:21', 'user', '12-5'),
('2018-05-29 18:09:22', 'user', '11-7'),
('2018-05-29 18:09:23', 'user', '12-9'),
('2018-05-29 18:09:24', 'user', '14-11'),
('2018-05-29 18:09:25', 'user', '15-13'),
('2018-05-29 18:09:26', 'user', '17-15'),
('2018-05-29 18:09:27', 'user', '19-17'),
('2018-05-29 18:11:16', 'user', '3-0'),
('2018-05-29 18:11:17', 'user', '12-1'),
('2018-05-29 18:11:18', 'user', '15-3'),
('2018-05-29 18:11:19', 'user', '16-5'),
('2018-05-29 18:11:20', 'user', '19-7'),
('2018-05-29 18:11:21', 'user', '2-10'),
('2018-05-29 18:11:22', 'user', '5-12'),
('2018-05-29 18:11:23', 'user', '6-14'),
('2018-05-29 18:11:24', 'user', '9-16'),
('2018-05-29 18:11:25', 'user', '11-18'),
('2018-05-29 18:13:01', 'user', '0-0'),
('2018-05-29 18:13:02', 'user', '13-0'),
('2018-05-29 18:13:03', 'user', '13-2'),
('2018-05-29 18:13:04', 'user', '14-4'),
('2018-05-29 18:13:05', 'user', '15-6'),
('2018-05-29 18:13:06', 'user', '16-8'),
('2018-05-29 18:13:07', 'user', '18-10'),
('2018-05-29 18:13:08', 'user', '0-13'),
('2018-05-29 18:13:09', 'user', '2-15'),
('2018-05-29 18:13:10', 'user', '3-17'),
('2018-05-29 18:13:11', 'user', '6-19'),
('2018-05-29 18:13:27', 'alan', '0-0'),
('2018-05-29 18:13:41', 'alan', '0-1'),
('2018-05-29 18:14:35', 'user', '3-0'),
('2018-05-29 18:14:36', 'user', '18-1'),
('2018-05-29 18:14:37', 'user', '19-3'),
('2018-05-29 18:14:38', 'user', '0-6'),
('2018-05-29 18:14:39', 'user', '2-8'),
('2018-05-29 18:14:40', 'user', '3-10'),
('2018-05-29 18:14:41', 'user', '6-12'),
('2018-05-29 18:14:42', 'user', '7-14'),
('2018-05-29 18:14:43', 'user', '10-16'),
('2018-05-29 18:14:44', 'user', '11-18'),
('2018-05-29 18:15:08', 'user', '0-0'),
('2018-05-29 18:15:09', 'user', '1-0'),
('2018-05-29 18:15:10', 'user', '2-2'),
('2018-05-29 18:15:11', 'user', '4-4'),
('2018-05-29 18:15:12', 'user', '7-6'),
('2018-05-29 18:15:13', 'user', '9-8'),
('2018-05-29 18:15:14', 'user', '11-10'),
('2018-05-29 18:15:15', 'user', '10-3'),
('2018-05-29 18:15:16', 'user', '16-14'),
('2018-05-29 18:15:17', 'user', '19-16'),
('2018-05-29 18:15:18', 'user', '2-19'),
('2018-05-29 18:15:19', 'user', '3-12'),
('2018-05-29 18:15:20', 'user', '9-14'),
('2018-05-29 18:15:21', 'user', '11-16'),
('2018-05-29 18:15:22', 'user', '12-18'),
('2018-05-29 18:16:23', 'user', '3-0'),
('2018-05-29 18:16:24', 'user', '5-0'),
('2018-05-29 18:16:25', 'user', '8-2'),
('2018-05-29 18:16:26', 'user', '7-4'),
('2018-05-29 18:16:27', 'user', '8-6'),
('2018-05-29 18:16:28', 'user', '12-8'),
('2018-05-29 18:16:29', 'user', '16-10'),
('2018-05-29 18:16:30', 'user', '18-12'),
('2018-05-29 18:16:31', 'user', '16-14'),
('2018-05-29 18:16:32', 'user', '16-16'),
('2018-05-29 18:16:33', 'user', '0-19'),
('2018-05-29 18:16:51', 'alan', '0-0'),
('2018-05-29 18:16:52', 'alan', '3-1'),
('2018-05-29 18:16:53', 'alan', '6-3'),
('2018-05-29 18:16:54', 'alan', '11-5'),
('2018-05-29 18:16:55', 'alan', '17-7'),
('2018-05-29 18:16:56', 'alan', '1-10'),
('2018-05-29 18:16:57', 'alan', '6-12'),
('2018-05-29 18:16:58', 'user', '4-5'),
('2018-05-29 18:16:59', 'alan', '16-16'),
('2018-05-29 18:17:00', 'user', '15-9'),
('2018-05-29 18:17:01', 'user', '18-11'),
('2018-05-29 18:17:02', 'user', '2-14'),
('2018-05-29 18:17:03', 'user', '5-16'),
('2018-05-29 18:17:04', 'user', '8-18'),
('2018-05-29 18:17:18', 'alan', '0-0'),
('2018-05-29 18:17:23', 'a', '0-0'),
('2018-05-29 18:17:27', 'alan', '0-1');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('a', 'lol'),
('alan', 'budi'),
('will', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`loc`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`time`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
