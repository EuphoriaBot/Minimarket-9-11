-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2026 at 09:42 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbminimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbdetail_transaksi`
--

CREATE TABLE `tbdetail_transaksi` (
  `id_detail_transaksi` varchar(16) NOT NULL,
  `id_transaksi` varchar(16) NOT NULL,
  `id_produk` varchar(16) NOT NULL,
  `kuantitas` int(8) NOT NULL,
  `subtotal_transaksi` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbdetail_transaksi`
--

INSERT INTO `tbdetail_transaksi` (`id_detail_transaksi`, `id_transaksi`, `id_produk`, `kuantitas`, `subtotal_transaksi`) VALUES
('DT001', 'TR001', 'PR001', 20, 30000.00),
('DT002', 'TR002', 'PR002', 2, 19000.00),
('DT003', 'TR002', 'PR004', 1, 6100.00),
('DT004', 'TR003', 'PR003', 2, 17000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbdetail_transaksi_pembelian`
--

CREATE TABLE `tbdetail_transaksi_pembelian` (
  `id_detail_pembelian` varchar(16) NOT NULL,
  `id_pembelian` varchar(16) NOT NULL,
  `id_produk` varchar(16) NOT NULL,
  `kuantitas_pembelian` int(8) NOT NULL,
  `harga_beli_produk` decimal(15,2) NOT NULL,
  `subtotal_pembelian` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbdetail_transaksi_pembelian`
--

INSERT INTO `tbdetail_transaksi_pembelian` (`id_detail_pembelian`, `id_pembelian`, `id_produk`, `kuantitas_pembelian`, `harga_beli_produk`, `subtotal_pembelian`) VALUES
('DP001', 'PB001', 'PR001', 100, 900.00, 90000.00),
('DP002', 'PB002', 'PR002', 100, 4000.00, 400000.00),
('DP003', 'PB003', 'PR003', 25, 12000.00, 300000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbkaryawan`
--

CREATE TABLE `tbkaryawan` (
  `id_karyawan` varchar(10) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `telepon_karyawan` varchar(16) NOT NULL,
  `jabatan` varchar(32) NOT NULL,
  `gaji_murni` decimal(15,2) NOT NULL,
  `shift` varchar(32) NOT NULL,
  `bonus` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbkaryawan`
--

INSERT INTO `tbkaryawan` (`id_karyawan`, `nama_karyawan`, `telepon_karyawan`, `jabatan`, `gaji_murni`, `shift`, `bonus`) VALUES
('K001', 'King DIMASS', '0804', 'Kasir', 20000.00, 'Pagi', 2000.00),
('K002', 'HiTama', '0820', 'Kasir', 25000.00, 'Malam', 10000.00),
('K003', 'so MUCH', '0813', 'Manager', 7000000.00, '-', 14000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbkategori`
--

CREATE TABLE `tbkategori` (
  `id_kategori` varchar(10) NOT NULL,
  `nama_kategori` varchar(64) NOT NULL,
  `deskripsi_kategori` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbkategori`
--

INSERT INTO `tbkategori` (`id_kategori`, `nama_kategori`, `deskripsi_kategori`) VALUES
('KT001', 'Makanan Berat', 'Makanan Berat'),
('KT002', 'Snek', 'Ular wlee :p'),
('KT003', 'Minuman', 'Minuman cair'),
('KT004', 'Mainan anak', 'Mainan untuk anak anak');

-- --------------------------------------------------------

--
-- Table structure for table `tbpelanggan`
--

CREATE TABLE `tbpelanggan` (
  `id_pelanggan` varchar(10) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `telepon_pelanggan` varchar(16) NOT NULL,
  `poin` int(10) NOT NULL,
  `total_belanja` decimal(15,2) NOT NULL,
  `level_pelanggan` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbpelanggan`
--

INSERT INTO `tbpelanggan` (`id_pelanggan`, `nama_pelanggan`, `telepon_pelanggan`, `poin`, `total_belanja`, `level_pelanggan`) VALUES
('P001', 'Lira', '0801', 120, 7777777.00, 'Gold'),
('P002', 'Richont', '0802', 50, 300000.00, 'Reguler'),
('Ped003', 'Fahri the hero', '0803', 250, 25000.00, 'Reguler');

-- --------------------------------------------------------

--
-- Table structure for table `tbproduk`
--

CREATE TABLE `tbproduk` (
  `id_produk` varchar(16) NOT NULL,
  `nama_produk` varchar(64) NOT NULL,
  `id_kategori` varchar(10) NOT NULL,
  `harga_beli` decimal(15,2) NOT NULL,
  `harga_jual` decimal(15,2) NOT NULL,
  `stok_produk` int(10) NOT NULL,
  `stok_minimum` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbproduk`
--

INSERT INTO `tbproduk` (`id_produk`, `nama_produk`, `id_kategori`, `harga_beli`, `harga_jual`, `stok_produk`, `stok_minimum`) VALUES
('PR001', 'Indomie Bakar', 'KT001', 900.00, 1500.00, 20, 10),
('PR002', 'Chitoto rasa rusa jantan', 'KT002', 200.00, 9500.00, 20, 10),
('PR003', 'Pucari', 'KT003', 3300.00, 8500.00, 80, 10),
('PR004', 'Teh Bulat', 'KT003', 3100.00, 6100.00, 62, 10),
('PR005', 'ColdWheels', 'KT004', 9000.00, 45000.00, 40, 5),
('PR006', 'Dorotis', 'KT002', 2000.00, 6600.00, 30, 10);

-- --------------------------------------------------------

--
-- Table structure for table `tbstock_keluar`
--

CREATE TABLE `tbstock_keluar` (
  `id_stock_keluar` varchar(16) NOT NULL,
  `id_produk` varchar(16) NOT NULL,
  `nama_produk` varchar(64) NOT NULL,
  `id_transaksi` varchar(16) DEFAULT NULL,
  `tanggal_keluar` date NOT NULL,
  `jumlah_keluar` int(10) NOT NULL,
  `keterangan` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbstock_keluar`
--

INSERT INTO `tbstock_keluar` (`id_stock_keluar`, `id_produk`, `nama_produk`, `id_transaksi`, `tanggal_keluar`, `jumlah_keluar`, `keterangan`) VALUES
('SK001', 'PR001', 'Indomie Bakar', 'TR001', '2026-05-14', 20, 'Penjualan pelanggan'),
('SK002', 'PR002', 'Teh Bulat', 'TR002', '2026-05-14', 2, 'Penjualan pelanggan'),
('SK003', 'PR003', 'Pucari', 'TR003', '2026-05-14', 2, 'Penjualan pelanggan'),
('SK004', 'PR004', 'Pucari', 'TR002', '2026-05-14', 1, 'Penjualan pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `tbsupplier`
--

CREATE TABLE `tbsupplier` (
  `id_supplier` varchar(10) NOT NULL,
  `nama_supplier` varchar(50) NOT NULL,
  `telepon_supplier` varchar(16) NOT NULL,
  `nama_perusahaan` varchar(64) NOT NULL,
  `kota_supplier` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbsupplier`
--

INSERT INTO `tbsupplier` (`id_supplier`, `nama_supplier`, `telepon_supplier`, `nama_perusahaan`, `kota_supplier`) VALUES
('SUP001', 'Super Fahri', '08190', 'PT Kayu Loa JAnan', 'Loa Janan'),
('SUP002', 'Patir', '0819682', 'PT Mencari cinta sejati', 'Samarinda'),
('SUP003', 'Dimas', '081787878', 'PT King Dimass', 'Balikpapan');

-- --------------------------------------------------------

--
-- Table structure for table `tbtransaksi`
--

CREATE TABLE `tbtransaksi` (
  `id_transaksi` varchar(16) NOT NULL,
  `waktu_transaksi` datetime NOT NULL,
  `id_kasir` varchar(10) NOT NULL,
  `id_pelanggan` varchar(10) DEFAULT NULL,
  `total_sebelum_diskon` decimal(15,2) NOT NULL,
  `total_diskon` decimal(15,2) NOT NULL,
  `harga_akhir` decimal(15,2) NOT NULL,
  `total_tagihan` decimal(15,2) NOT NULL,
  `uang_diberikan` decimal(15,2) NOT NULL,
  `kembalian` decimal(15,2) NOT NULL,
  `nama_diskon` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbtransaksi`
--

INSERT INTO `tbtransaksi` (`id_transaksi`, `waktu_transaksi`, `id_kasir`, `id_pelanggan`, `total_sebelum_diskon`, `total_diskon`, `harga_akhir`, `total_tagihan`, `uang_diberikan`, `kembalian`, `nama_diskon`) VALUES
('TR001', '2026-05-14 09:00:00', 'K001', 'P001', 30000.00, 3000.00, 27000.00, 27000.00, 100000.00, 73000.00, 'Diskon Gold'),
('TR002', '2026-05-14 10:30:00', 'K002', 'P002', 25100.00, 0.00, 25100.00, 25100.00, 30000.00, 4900.00, 'Tidak Ada'),
('TR003', '2026-05-14 12:00:00', 'K001', 'Ped003', 17000.00, 0.00, 17000.00, 17000.00, 50000.00, 33000.00, 'Tidak Ada');

-- --------------------------------------------------------

--
-- Table structure for table `tbtransaksi_pembelian`
--

CREATE TABLE `tbtransaksi_pembelian` (
  `id_pembelian` varchar(16) NOT NULL,
  `tanggal_pembelian` date NOT NULL,
  `id_supplier` varchar(10) NOT NULL,
  `total_harga_pembelian` decimal(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbtransaksi_pembelian`
--

INSERT INTO `tbtransaksi_pembelian` (`id_pembelian`, `tanggal_pembelian`, `id_supplier`, `total_harga_pembelian`) VALUES
('PB001', '2026-05-10', 'SUP001', 250000.00),
('PB002', '2026-05-11', 'SUP002', 400000.00),
('PB003', '2026-05-12', 'SUP003', 300000.00);

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role_user` varchar(32) NOT NULL,
  `id_karyawan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`id_user`, `username`, `password`, `role_user`, `id_karyawan`) VALUES
('Usr001', 'Dimas', 'Dims1999', 'Kasir', 'K001'),
('Usr002', 'Hitamaa', 'hitam69', 'Kasir', 'K002'),
('Usr003', 'somuch', 'somuch123', 'Manager', 'K003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbdetail_transaksi`
--
ALTER TABLE `tbdetail_transaksi`
  ADD PRIMARY KEY (`id_detail_transaksi`),
  ADD KEY `foreigndetail1` (`id_transaksi`),
  ADD KEY `foreigndetail2` (`id_produk`);

--
-- Indexes for table `tbdetail_transaksi_pembelian`
--
ALTER TABLE `tbdetail_transaksi_pembelian`
  ADD PRIMARY KEY (`id_detail_pembelian`),
  ADD KEY `ddetlpembe1` (`id_pembelian`),
  ADD KEY `ddetlpembe2` (`id_produk`);

--
-- Indexes for table `tbkaryawan`
--
ALTER TABLE `tbkaryawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `tbkategori`
--
ALTER TABLE `tbkategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `tbpelanggan`
--
ALTER TABLE `tbpelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `tbproduk`
--
ALTER TABLE `tbproduk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `prodfor1` (`id_kategori`);

--
-- Indexes for table `tbstock_keluar`
--
ALTER TABLE `tbstock_keluar`
  ADD PRIMARY KEY (`id_stock_keluar`),
  ADD KEY `stockfor1` (`id_produk`),
  ADD KEY `stockfor2` (`id_transaksi`);

--
-- Indexes for table `tbsupplier`
--
ALTER TABLE `tbsupplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `tbtransaksi`
--
ALTER TABLE `tbtransaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `tranfor1` (`id_kasir`),
  ADD KEY `tranfor2` (`id_pelanggan`);

--
-- Indexes for table `tbtransaksi_pembelian`
--
ALTER TABLE `tbtransaksi_pembelian`
  ADD PRIMARY KEY (`id_pembelian`),
  ADD KEY `tranpemfor1` (`id_supplier`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `userfor1` (`id_karyawan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbdetail_transaksi`
--
ALTER TABLE `tbdetail_transaksi`
  ADD CONSTRAINT `foreigndetail1` FOREIGN KEY (`id_transaksi`) REFERENCES `tbtransaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `foreigndetail2` FOREIGN KEY (`id_produk`) REFERENCES `tbproduk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbdetail_transaksi_pembelian`
--
ALTER TABLE `tbdetail_transaksi_pembelian`
  ADD CONSTRAINT `ddetlpembe1` FOREIGN KEY (`id_pembelian`) REFERENCES `tbtransaksi_pembelian` (`id_pembelian`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ddetlpembe2` FOREIGN KEY (`id_produk`) REFERENCES `tbproduk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbproduk`
--
ALTER TABLE `tbproduk`
  ADD CONSTRAINT `prodfor1` FOREIGN KEY (`id_kategori`) REFERENCES `tbkategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbstock_keluar`
--
ALTER TABLE `tbstock_keluar`
  ADD CONSTRAINT `stockfor1` FOREIGN KEY (`id_produk`) REFERENCES `tbproduk` (`id_produk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stockfor2` FOREIGN KEY (`id_transaksi`) REFERENCES `tbtransaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbtransaksi`
--
ALTER TABLE `tbtransaksi`
  ADD CONSTRAINT `tranfor1` FOREIGN KEY (`id_kasir`) REFERENCES `tbkaryawan` (`id_karyawan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tranfor2` FOREIGN KEY (`id_pelanggan`) REFERENCES `tbpelanggan` (`id_pelanggan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbtransaksi_pembelian`
--
ALTER TABLE `tbtransaksi_pembelian`
  ADD CONSTRAINT `tranpemfor1` FOREIGN KEY (`id_supplier`) REFERENCES `tbsupplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD CONSTRAINT `userfor1` FOREIGN KEY (`id_karyawan`) REFERENCES `tbkaryawan` (`id_karyawan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
