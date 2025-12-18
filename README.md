# 📦 Payment Service

A **payment integration service** that handles secure payment processing using **Paymob**.  
Designed to be simple, secure, and easily extendable for other payment providers.

---

## 🚀 Features

- Centralized payment processing logic
- Paymob payment gateway integration
- Environment variables configuration using `.env`
- Ready-to-use `.env.example` template
- Clean and scalable project structure

---

## 🧱 Project Structure

```text
├── .env.example         # Environment variables template
├── .gitignore           # Git ignored files
├── pom.xml              # Maven configuration
├── src/                 # Application source code
├── mvnw / mvnw.cmd      # Maven wrapper
└── README.md
```

---

## ⚙️ Setup

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Yusuf-Hussien/payment-service.git
cd payment-service
```

### 2️⃣ Create environment file

```bash
cp .env.example .env
```

### 3️⃣ Configure environment variables

Edit `.env` and add your credentials:

```env
PAYMOB_API_KEY=your_api_key_here
PAYMOB_SECRET_KEY=your_secret_key_here
PAYMOB_PUBLIC_KEY=your_public_key_here
HMAC_KEY=your_hmac_key_here
```

⚠️ **Never commit `.env`** — it contains sensitive data.

---

## 📌 Environment Variables Template

`.env.example`
```env
# Paymob Configuration
PAYMOB_API_KEY=
PAYMOB_SECRET_KEY=
PAYMOB_PUBLIC_KEY=

# Security
HMAC_KEY=
```

---

## ▶️ Running the Application

Using Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw clean install
mvnw spring-boot:run
```

---

## 🛠 Extending the Service

- Add support for other payment providers
- Implement webhook handling
- Improve security & validation
- Add unit and integration tests

---

## 🤝 Contributing

1. Fork the repository
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Push to your fork
5. Open a Pull Request

---

## 📄 License

This project is open-source.  

---

## 👤 Author

**Yusuf Hussien**  
Software Engineer | Spring Boot | .Net
