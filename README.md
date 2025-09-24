# IFG Katalon Submission

## Isi Project
1. **RESTful API**
   - `TC01_POST_CreateUser` : POST https://reqres.in/api/users (Data-driven dari `users.csv`)
   - `TC02_GET_UserList` : GET https://reqres.in/api/users?page=2

2. **Kafka Consumer**
   - `TC_KAFKA_ExternalConsumer` : consume pesan dari topic `qa-events` menggunakan `kcat`.

## Catatan
- Dataset: `Data Files/users.csv`
- Kafka: pastikan `kcat` terinstall, broker default `host.docker.internal:9092`.
- Hasil bisa langsung di-push ke GitHub/GitLab (jangan private).

## Run
1. Buka project di Katalon.
2. Jalankan `Test Suites/TS_Submission`.
