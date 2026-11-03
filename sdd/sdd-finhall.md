# Описание дизайна программного обеспечения

Для FinHall

Версия 0.1

Подготовил(а) Литвинчук Арсений

БГУИР

2026-10-21

## 1. Введение

### 1.1 Назначение документа
Настоящий документ (SDD) описывает архитектуру, структуру базы данных и дизайн программного обеспечения веб-приложения интернет-банкинга FinHall. Документ предназначен для команды разработчиков (backend и frontend) и служит руководством для реализации системы на основе утвержденных требований (SRS).

### 1.2 Область применения
Документ охватывает проектирование серверной части (Spring Boot), клиентской части (React SPA) и схемы базы данных (PostgreSQL). Вне области применения находятся вопросы развертывания инфраструктуры (DevOps) и детальный дизайн сторонних платежных шлюзов.

### 1.3 Определения, акронимы и сокращения
| Term | Definition |
|------|------------|
| SPA | Single Page Application |
| JWT | JSON Web Token |
| REST | Representational State Transfer |
| SDD | Software Design Document |

### 1.4 Ссылки
1. Спецификация требований (SRS): `srs/srs-template.md`
2. Архитектурные решения (ADR): `adr/adr-finhall.md`

## 2. Обзор дизайна

### 2.1 Задачи стейкхолдеров
* **Разработчики:** Нуждаются в четком понимании структуры БД и API.
* **Заказчик:** Заинтересован в том, чтобы дизайн обеспечивал безопасность (JWT, 2FA) и быстрый отклик.

### 2.2 Выбранные точки зрения

#### 2.2.2 Композиция
Система разделена на три основных слоя:
1. **Frontend (React SPA):** Отвечает за UI/UX, графики и формы.
2. **Backend (Spring Boot):** Содержит REST API, бизнес-логику и безопасность.
3. **Database (PostgreSQL):** Хранит данные пользователей, счетов и транзакций.

#### 2.2.3 Логическое представление (Структура кода)
Backend реализует классическую слоистую архитектуру:
* **Controllers:** Принимают HTTP-запросы (AuthController, TransferController).
* **Services:** Содержат бизнес-логику (проверка баланса, лимиты).
* **Repositories:** Интерфейсы Spring Data JPA для работы с БД.
* **Entities:** Java-классы, мапящиеся на таблицы БД.

#### 2.2.7 Информация (Модель данных)
Основные сущности базы данных PostgreSQL:
* **Users:** `id`, `email`, `password_hash`, `role` (CLIENT/ADMIN), `2fa_code`.
* **Accounts:** `id`, `user_id` (FK), `currency` (BYN/USD/EUR), `balance`.
* **Transactions:** `id`, `from_account_id`, `to_account_id`, `amount`, `status`, `created_at`.
* **Limits:** `id`, `user_id`, `daily_limit`, `single_limit`.

#### 2.2.8 Интерфейс
Взаимодействие Frontend и Backend происходит по REST API.
* `POST /api/auth/login` — авторизация (возвращает JWT).
* `GET /api/accounts` — получение списка счетов и баланса.
* `POST /api/transfers` — создание перевода.
* `GET /api/analytics` — получение данных для графиков.

## 3. Проектные представления

- **ID**: 001-API-Design
- **Title**: Проектирование REST API
- **Viewpoint**: Интерфейс
- **Representation**: Все защищенные эндпоинты требуют заголовок `Authorization: Bearer <JWT>`. Данные передаются в формате JSON.
- **More Information**: Ссылка на `REQ-FUNC-001` (аутентификация) и `REQ-FUNC-003` (переводы) из SRS.

### 3.1 Implementation Plan & Iterations (План реализации)
На основе переговоров с Заказчиком был сформирован план разработки. Приоритеты выставлены от 10 (наивысший) до 50 (минимальный). В связи с жесткими дедлайнами и добавлением новой функциональности было принято решение о найме Junior-разработчика для параллельной работы над UI и генерацией отчетов.

**Iteration 1 (Priority 10-20): Core Banking**
* Authentication (2FA) — *Senior*
* View Balance — *Senior*
* Funds Transfer — *Senior*
* Set Limits (Admin) — *Senior*

**Iteration 2 (Priority 30-40): Features & Reporting**
* PDF Statement Export — *Junior* (New requirement from Client)
* Currency Exchange API — *Senior*

**Iteration 3 (Priority 50): Analytics & Release**
* Expense Analytics — *Senior*
* System Testing & Bug Fixing — *Team*

**Team Changes:**
* 1 Senior Developer (Architect)
* 1 Junior Developer (Added after negotiation to speed up UI and PDF tasks under strict code review).

## 4. Решения
В данном разделе продублированы ключевые решения из ADR для удобства чтения.

- **ID**: 001-DB
- **Title**: Использование PostgreSQL
- **Outcome**: Выбрана PostgreSQL из-за строгого соблюдения ACID.
- **More Information**: См. `adr/adr-finhall.md`.

- **ID**: 002-PDF-Generation
- **Title**: Implementation of PDF Statement Export
- **Outcome**: Added new feature requested by the Client during negotiations. Will be implemented using the iText library by the Junior Developer.
- **More Information**: См. ADR-003 в `adr/adr-finhall.md`.

## 5. Приложения
Диаграммы компонентов и схемы БД будут добавлены на этапе детального проектирования.
