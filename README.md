# 📊 Finance Management System (AP/AR)

A full-stack finance management application for **Accounts Payable (AP)** and **Accounts Receivable (AR)** workflows.  
Built with **Spring Boot (Java)** for the backend and **React** for the frontend.

This project simulates real enterprise finance systems, featuring **invoice lifecycle management, partial payments, overdue detection, approval workflows, audit logging, dashboards, and more.**

---

## 🚀 Features
- **Invoice Lifecycle Management** (Draft → Approval → Paid → Overdue)
- **Partial Payments** with real-time balance tracking
- **Overdue Detection** and configurable grace periods
- **Approval Thresholds** (multi-role access control)
- **Audit Logs** (track all changes to invoices, vendors, customers)
- **Dashboards** (DSO, DPO, cash flow, invoice aging)
- **Batch Payments** (CSV upload & multi-invoice processing)
- **Notifications** (email + in-app alerts)
- **Multi-Currency Support** with FX conversion
- **Reporting** (export to CSV/PDF)
- **CI/CD** pipeline with automated testing and GitHub Actions
- **Dockerized Deployment** (Heroku/AWS)

---

## 🏗️ Tech Stack
**Backend:** Spring Boot, Maven, Hibernate/JPA, PostgreSQL  
**Frontend:** React, Chart.js, React Hook Form  
**DevOps:** GitHub Actions, Docker, Heroku/AWS  
**Testing:** JUnit 5, Jest + React Testing Library

---

## 📚 Documentation
- [Business Rules](documents/business_rules.md)
- [API Design](documents/api_design.md) _(coming soon)_
- [ER Diagram](documentss/er_diagram.png) _(coming soon)_

---

## ⚡ Getting Started

### 🔧 Prerequisites
- Java 17+
- Node.js 18+
- PostgreSQL 14+
- Maven

### 📥 Installation
```bash
# Clone the repo
git clone

📸 Screenshots (Coming Soon)

Dashboard with invoice aging buckets
Audit log viewer
Multi-currency invoice page

🧪 Tests
# Backend (JUnit 5)
cd backend
./mvnw test

# Frontend (Jest + RTL)
cd frontend
npm test

🌍 Deployment
The project includes Docker support:

# Build and run with Docker
docker-compose up --build


Deployed version available at: Live Demo (coming soon)

👤 Author
Anber Jamshed – Junior Financial Software Engineer
LinkedIn - www.linkedin.com/in/anber-jamshed
