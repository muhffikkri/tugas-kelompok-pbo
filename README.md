## Anggota Kelompok :    
1. Nayla Husna - 24060124140158
2. Khanza Qaila - 24060124120011
3. Muhammad Akmal Fazli Riyadi - 24060124130123
4. Muhammad Fahri - 24060124120037
5. Muhammad Fikri - 24060124130069


# Sistem Informasi Pemesanan Tiket Kereta Api

Dokumen ini menjelaskan alur sistem secara menyeluruh berdasarkan implementasi kode saat ini, termasuk detail setiap kelas, atribut, method, jenis kelas, relasi antarkelas, konsep OOP, struktur folder, dan cara menjalankan program.

## Gambaran Umum Alur Sistem

Sistem mensimulasikan proses pemesanan tiket kereta dari awal sampai pembayaran, sekaligus menampilkan skenario sukses dan skenario error.

Alur utama:

1. Sistem menyiapkan data master stasiun, kereta, dan jadwal perjalanan.
2. Pengguna mencari jadwal sesuai asal, tujuan, dan tanggal.
3. Pengguna memilih kursi pada jadwal.
4. Sistem membuat tiket yang berisi data penumpang, jadwal, nomor kursi, dan payment record.
5. Sistem memproses pembayaran digital dan menyinkronkan status transaksi.
6. Sistem menampilkan detail tiket lengkap.
7. Sistem juga menguji exception untuk input tidak valid dan konflik bisnis.

## Konsep OOP yang Digunakan

1. Encapsulation

- Data disimpan sebagai atribut private.
- Akses data melalui getter dan setter dengan validasi.
- Beberapa koleksi/array dikembalikan sebagai salinan untuk mencegah perubahan langsung dari luar objek.

2. Inheritance

- Person diwarisi oleh Passenger.
- Train diwarisi oleh EconomyTrain dan ExecutiveTrain.

3. Polymorphism

- Overriding: hitungTarif dan printInfo pada kelas turunan.
- Overloading: pencarian jadwal pada ScheduleService dengan beberapa variasi parameter.

4. Abstraction

- Abstract class: Person dan Train.
- Interface: PrintableInfo dan PaymentMethod.

## Jenis Kelas dan Relasi Inti

Ringkasan relasi:

- Inheritance: Passenger -> Person, EconomyTrain -> Train, ExecutiveTrain -> Train.
- Implementasi interface: hampir seluruh kelas domain mengimplementasikan PrintableInfo untuk output konsol.
- Agregasi: Schedule menggunakan Train dan Stasion.
- Komposisi: Ticket memiliki PaymentRecord sebagai bagian integral tiket.
- Asosiasi: Ticket terhubung ke Passenger dan Schedule, DigitalPayment terhubung ke PaymentRecord.
- Service layer: ScheduleService mengelola daftar Schedule.

## Detail Kelas

### Entry Point

#### RailwayApp

- Package: default package (src)
- Jenis kelas: kelas aplikasi (entry point)
- Atribut: tidak ada atribut instance
- Method:

1. main(String[] args)
2. scenarioBerhasil()
3. scenarioInvalidNIK()
4. scenarioScheduleConflict()
5. scenarioSeatAlreadyBooked()
6. scenarioSeatUnavailable()
7. scenarioInvalidBooking()
8. bookSeatOrThrowAlreadyBooked(Schedule schedule, int seatIndex)

- Relasi:

1. Menggunakan model: Stasion, Train, EconomyTrain, Schedule, Passenger, Ticket.
2. Menggunakan service: ScheduleService, DigitalPayment.
3. Menangani custom exception dari package exception.

### Package model

#### Person

- Jenis kelas: abstract class
- Implements: PrintableInfo
- Atribut:

1. nama: String
2. nik: String
3. noTelp: String

- Method:

1. Person()
2. Person(String nama, String nik, String noTelp)
3. getNamaLengkap()
4. setNamaLengkap(String nama)
5. getNik()
6. setNik(String nik)
7. getNoTelp()
8. setNoTelp(String noTelp)
9. printInfo() abstract

- Relasi:

1. Superclass dari Passenger.

#### Passenger

- Jenis kelas: concrete class
- Extends: Person
- Atribut:

1. passengerId: String
2. email: String
3. tickets: List<Ticket>

- Method:

1. Passenger()
2. Passenger(String namaLengkap, String nik, String noTelp, String email, String passengerId)
3. getPassengerId()
4. setPassengerId(String passengerId)
5. getEmail()
6. setEmail(String email)
7. getTickets()
8. setTickets(List<Ticket> tickets)
9. bookTickets(Schedule s)
10. cancelTicket(String ticketId)
11. parseSeatIndex(String seatNumber) private
12. printInfo()

- Relasi:

1. Mewarisi Person.
2. Berasosiasi dengan Ticket (satu penumpang dapat memiliki banyak tiket).
3. Berinteraksi dengan Schedule saat pembatalan tiket untuk melepas kursi.

#### Train

- Jenis kelas: abstract class
- Implements: PrintableInfo
- Atribut:

1. idTrain: String
2. namaTrain: String
3. kapasitas: int
4. discountRate: double
5. tarifDasar: double

- Method:

1. Train()
2. Train(String idTrain, String namaTrain, int kapasitas, double discountRate)
3. getIdTrain()
4. setIdTrain(String idTrain)
5. getNamaTrain()
6. setNamaTrain(String namaTrain)
7. getKapasitas()
8. setKapasitas(int kapasitas)
9. getDiscountRate()
10. setDiscountRate(double discountRate)
11. getTarifDasar()
12. setTarifDasar(double tarifDasar)
13. hitungTarif() abstract
14. printInfo()

- Relasi:

1. Superclass dari EconomyTrain dan ExecutiveTrain.
2. Digunakan oleh Schedule sebagai objek agregasi.

#### EconomyTrain

- Jenis kelas: concrete class
- Extends: Train
- Atribut:

1. luggageLimit: int

- Method:

1. EconomyTrain()
2. EconomyTrain(String idTrain, String namaTrain, int kapasitas, int luggageLimit, double discountRate)
3. getLuggageLimit()
4. setLuggageLimit(int luggageLimit)
5. hitungTarif() override
6. printInfo() override

- Relasi:

1. Turunan Train untuk kereta kelas ekonomi.

#### ExecutiveTrain

- Jenis kelas: concrete class
- Extends: Train
- Atribut:

1. fasilitas: String
2. surchargeRate: double

- Method:

1. ExecutiveTrain()
2. ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas)
3. ExecutiveTrain(String idTrain, String namaTrain, int kapasitas, double discountRate, String fasilitas, double surchargeRate)
4. getFasilitas()
5. setFasilitas(String fasilitas)
6. getSurchargeRate()
7. setSurchargeRate(double surchargeRate)
8. hitungTarif() override
9. printInfo() override

- Relasi:

1. Turunan Train untuk kereta kelas eksekutif.

#### Stasion

- Jenis kelas: concrete class
- Implements: PrintableInfo
- Atribut:

1. idStasion: String
2. namaStasion: String
3. kota: String

- Method:

1. Stasion()
2. Stasion(String idStasion, String namaStasion, String kota)
3. getIdStasion()
4. setIdStasion(String idStasion)
5. getNamaStasion()
6. setNamaStasion(String namaStasion)
7. getKota()
8. setKota(String kota)
9. printInfo()

- Relasi:

1. Digunakan oleh Schedule sebagai stasiun asal dan tujuan (agregasi).

#### Schedule

- Jenis kelas: concrete class
- Implements: PrintableInfo
- Atribut:

1. scheduleId: String
2. train: Train
3. departureStasion: Stasion
4. arrivalStasion: Stasion
5. departureTime: LocalDateTime
6. arrivalTime: LocalDateTime
7. seats: boolean[]

- Method:

1. Schedule()
2. Schedule(String scheduleId, Train train, Stasion departureStasion, Stasion arrivalStasion, LocalDateTime departureTime, LocalDateTime arrivalTime)
3. getScheduleId()
4. setScheduleId(String scheduleId)
5. getTrain()
6. setTrain(Train train)
7. getDepartureStasion()
8. setDepartureStasion(Stasion departureStasion)
9. getArrivalStasion()
10. setArrivalStasion(Stasion arrivalStasion)
11. getDepartureTime()
12. setDepartureTime(LocalDateTime departureTime)
13. getArrivalTime()
14. setArrivalTime(LocalDateTime arrivalTime)
15. getDuration()
16. getSeats()
17. setSeats(boolean[] seats)
18. getAvailableSeat()
19. getBookedSeat()
20. bookSeat(int seatIndex)
21. bookFirstAvailableSeat()
22. releaseSeat(int seatIndex)
23. printInfo()

- Relasi:

1. Agregasi ke Train.
2. Agregasi ke Stasion (asal dan tujuan).
3. Berasosiasi dengan Ticket untuk proses booking.

#### PaymentRecord

- Jenis kelas: concrete class
- Implements: PrintableInfo
- Atribut:

1. waktu: LocalDateTime
2. status: String
3. jumlah: double

- Method:

1. PaymentRecord()
2. PaymentRecord(LocalDateTime waktu, String status, double jumlah)
3. getWaktu()
4. setWaktu(LocalDateTime waktu)
5. getStatus()
6. setStatus(String status)
7. getJumlah()
8. setJumlah(double jumlah)
9. syncPayment(String newStatus, double amount)
10. printInfo()

- Relasi:

1. Dikomposisikan oleh Ticket.
2. Digunakan oleh DigitalPayment untuk sinkronisasi status pembayaran.

#### Ticket

- Jenis kelas: concrete class
- Implements: PrintableInfo
- Atribut:

1. ticketId: String
2. seatNumber: String
3. schedule: Schedule
4. passenger: Passenger
5. paymentRecord: PaymentRecord

- Method:

1. Ticket()
2. Ticket(String ticketId, String seatNumber, Schedule schedule, Passenger passenger)
3. getTicketId()
4. setTicketId(String ticketId)
5. getSeatNumber()
6. setSeatNumber(String seatNumber)
7. getSchedule()
8. setSchedule(Schedule schedule)
9. getPassenger()
10. setPassenger(Passenger passenger)
11. getPaymentRecord()
12. setPaymentRecord(PaymentRecord paymentRecord)
13. generateTicket()
14. printInfo()

- Relasi:

1. Asosiasi ke Passenger.
2. Asosiasi ke Schedule.
3. Komposisi ke PaymentRecord.

### Package service

#### PrintableInfo

- Jenis kelas: interface
- Method:

1. printInfo()

- Relasi:

1. Diimplementasikan oleh kelas domain yang memiliki output informasi ke konsol.

#### PaymentMethod

- Jenis kelas: interface
- Method:

1. processPayment(double amount)

- Relasi:

1. Diimplementasikan oleh DigitalPayment.

#### DigitalPayment

- Jenis kelas: concrete class
- Implements: PaymentMethod
- Atribut:

1. namaProvider: String
2. record: PaymentRecord

- Method:

1. DigitalPayment()
2. DigitalPayment(String namaProvider, PaymentRecord record)
3. getNamaProvider()
4. setNamaProvider(String namaProvider)
5. getRecord()
6. setRecord(PaymentRecord record)
7. processPayment(double amount)

- Relasi:

1. Implementasi PaymentMethod.
2. Berasosiasi dengan PaymentRecord untuk update status pembayaran.

#### ScheduleService

- Jenis kelas: service class
- Atribut:

1. masterJadwal: List<Schedule>

- Method:

1. ScheduleService()
2. addSchedule(Schedule s)
3. cariJadwalById(String idSchedule)
4. cariJadwal(String kotaAsal, String kotaTujuan)
5. cariJadwal(String kotaAsal, String kotaTujuan, LocalDate tanggalBerangkat)
6. searchSchedule(String tujuan)
7. searchSchedule(String asal, String tujuan)
8. searchSchedule(String asal, String tujuan, LocalDate tanggalBerangkat)
9. getMasterJadwal()

- Relasi:

1. Mengelola kumpulan Schedule.
2. Menerapkan overloading untuk fitur pencarian jadwal.

### Package exception

#### InvalidBookingException

- Jenis kelas: custom checked exception
- Extends: Exception
- Method:

1. InvalidBookingException()
2. InvalidBookingException(String message)

- Relasi:

1. Digunakan saat data tiket tidak valid.

#### InvalidNIKException

- Jenis kelas: custom checked exception
- Extends: Exception
- Method:

1. InvalidNIKException()
2. InvalidNIKException(String message)

- Relasi:

1. Digunakan pada validasi NIK di Person dan Passenger.

#### ScheduleConflictException

- Jenis kelas: custom checked exception
- Extends: Exception
- Method:

1. ScheduleConflictException()
2. ScheduleConflictException(String message)

- Relasi:

1. Digunakan oleh ScheduleService saat terjadi tabrakan jadwal kereta yang sama.

#### SeatAlreadyBookedException

- Jenis kelas: custom checked exception
- Extends: Exception
- Method:

1. SeatAlreadyBookedException()
2. SeatAlreadyBookedException(String message)

- Relasi:

1. Digunakan untuk mengabstraksikan kondisi kursi yang sudah dipesan pada level aplikasi.

#### SeatUnavailableException

- Jenis kelas: custom checked exception
- Extends: Exception
- Method:

1. SeatUnavailableException()
2. SeatUnavailableException(String message)

- Relasi:

1. Dilempar oleh Schedule saat kursi tidak tersedia atau sudah habis.

## Struktur Folder Proyek

```text
tugas-kelompok-pbo/
|-- README.md
`-- pemesanan_tiket_kereta/
    |-- README.md
    |-- bin/
    `-- src/
        |-- RailwayApp.java
        |-- model/
        |   |-- EconomyTrain.java
        |   |-- ExecutiveTrain.java
        |   |-- Passenger.java
        |   |-- PaymentRecord.java
        |   |-- Person.java
        |   |-- Schedule.java
        |   |-- Stasion.java
        |   |-- Ticket.java
        |   `-- Train.java
        |-- service/
        |   |-- DigitalPayment.java
        |   |-- PaymentMethod.java
        |   |-- PrintableInfo.java
        |   `-- ScheduleService.java
        `-- exception/
            |-- InvalidBookingException.java
            |-- InvalidNIKException.java
            |-- ScheduleConflictException.java
            |-- SeatAlreadyBookedException.java
            `-- SeatUnavailableException.java
```

## Cara Kompilasi dan Menjalankan (Output ke bin)

Jalankan dari folder pemesanan_tiket_kereta.

1. Masuk ke folder project Java:

```bash
cd pemesanan_tiket_kereta
```

2. Kompilasi semua source ke folder bin:

```bash
javac -d bin src/RailwayApp.java src/service/*.java src/model/*.java src/exception/*.java
```

3. Jalankan aplikasi dari classpath bin:

```bash
java -cp bin RailwayApp
```

Catatan:

- Gunakan output ke bin agar folder src tetap bersih dari file .class.
- Jika diperlukan, hapus artefak lama .class di src sebelum build ulang.
