# Sistem Informasi Pemesanan Tiket Kereta Api

> Proyek kuliah **Pemrograman Berorientasi Objek (PBO)** untuk mensimulasikan proses manajemen dan pemesanan tiket kereta api.

## Deskripsi Singkat

Aplikasi ini dirancang untuk mensimulasikan sistem pemesanan tiket kereta api dengan menerapkan prinsip dasar OOP:

- **Encapsulation**: data penting (misalnya identitas penumpang, detail tiket, pembayaran) dibungkus dalam kelas dengan kontrol akses yang jelas.
- **Inheritance**: pewarisan perilaku dan atribut dari kelas induk ke kelas turunan untuk menghindari duplikasi kode.
- **Polymorphism**: fleksibilitas perilaku melalui overriding dan overloading sesuai konteks kebutuhan sistem.
- **Abstraction**: penyederhanaan proses bisnis melalui abstract class dan interface.

## Anggota Kelompok

| No  | Nama Mahasiswa     | Peran                          | Tanggung Jawab Utama                                                                |
| --- | ------------------ | ------------------------------ | ----------------------------------------------------------------------------------- |
| 1   | [Nama Mahasiswa 1] | System Designer                | Mendesain arsitektur kelas, diagram relasi, dan alur sistem keseluruhan.            |
| 2   | [Nama Mahasiswa 2] | Core Developer                 | Mengembangkan struktur kelas inti (Person, Train, Ticket, Station, Schedule).       |
| 3   | [Nama Mahasiswa 3] | Business Logic Developer       | Mengimplementasikan logika pemesanan, validasi data, dan perhitungan harga tiket.   |
| 4   | [Nama Mahasiswa 4] | Specialist Exception/Interface | Menangani custom exception, assertion, serta implementasi interface pembayaran.     |
| 5   | [Nama Mahasiswa 5] | Integration/QA                 | Integrasi modul, pengujian end-to-end, dokumentasi bug, dan verifikasi hasil akhir. |

## Spesifikasi Teknis (Kriteria Tugas)

Proyek ini memenuhi kriteria berikut:

1. **Minimal 8 kelas** dalam implementasi sistem.
2. **Relasi kelas mencakup Asosiasi, Agregasi, dan Komposisi.**
3. **Inheritance**:
   - `Person` -> `Passenger`
   - `Train` -> `Executive`, `Economy`
4. **Abstract Class & Interface**:
   - Abstract class: `Person`, `Train`
   - Interface: `PaymentMethod`
5. **Polymorphism**:
   - Overriding: metode perhitungan harga tiket.
   - Overloading: metode pencarian jadwal.
6. **Error Handling**:
   - Custom exception: `InvalidNIKException`, `SeatUnavailableException`
   - Validasi menggunakan Java `assert`.

### Penekanan Relasi Kelas

> **Catatan penting untuk penilaian dosen:** Implementasi relasi kelas telah dirancang eksplisit agar mudah diverifikasi pada kode dan diagram kelas.

| Jenis Relasi  | Implementasi                     | Keterangan                                                                          |
| ------------- | -------------------------------- | ----------------------------------------------------------------------------------- |
| **Asosiasi**  | `Passenger` <-> `Schedule`       | Penumpang memilih jadwal perjalanan.                                                |
| **Agregasi**  | `Schedule` -> `Train`, `Station` | Jadwal menggunakan objek kereta dan stasiun yang tetap dapat berdiri sendiri.       |
| **Komposisi** | `Ticket` -> `PaymentRecord`      | Riwayat pembayaran menjadi bagian integral tiket dan lifecycle-nya mengikuti tiket. |

## Struktur Folder

```text
project-root/
|-- src/
|   |-- RailwayApp.java
|   |-- model/
|   |-- service/
|   `-- exception/
|-- classes/
`-- docs/
```

## Cara Menjalankan

> Jalankan perintah berikut dari root project.

1. Kompilasi source code:

```bash
javac -d classes src\\*.java
```

2. Jalankan aplikasi:

```bash
java -cp classes RailwayApp
```

## Kontak / Deadline

- **Mata Kuliah**: Pemrograman Berorientasi Objek (PBO)
- **Proyek**: Sistem Informasi Kereta Api
- **Deadline Pengumpulan**: **1 April 2026**

> Pastikan seluruh anggota melakukan final check terhadap fitur, exception handling, dan kesesuaian kriteria sebelum pengumpulan.
