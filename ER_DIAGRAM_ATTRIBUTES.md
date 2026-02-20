# BookMyShow - ER Diagram Entity Attributes

## BaseModel (Parent Class - Abstract)
**All entities inherit from this class:**
| Attribute | Type | Notes |
|-----------|------|-------|
| id | int | Primary Key (Auto-generated) |
| createdAt | LocalDateTime | Auto-populated on creation |
| updatedAt | LocalDateTime | Auto-populated on update |
| seatNumber | String | Optional |

---

## User
**Entity Name:** BMS_USER
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| username | String | - | - | |
| email | String | - | - | |
| password | String | - | - | |
| tickets | List<Ticket> | OneToMany | 1:N | user_id (FK) |

---

## City
**Entity Name:** City
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| cityName | String | - | - | |
| theatres | List<Theatre> | OneToMany | 1:N | city_id (FK) |

---

## Theatre
**Entity Name:** Theatre
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| theatreName | String | - | - | |
| address | String | - | - | |
| auditoriums | List<Auditorium> | OneToMany | 1:N | Mapped by "theatre" |

**Foreign Keys:**
- city_id (from City.theatres)

---

## Auditorium
**Entity Name:** Auditorium
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| auditoriumName | String | - | - | |
| seats | List<Seat> | OneToMany | 1:N | auditorium_id (FK) |
| features | List<Feature> | ElementCollection | - | Enum: IMAX, DOLBY, 3D, etc. |
| theatre | Theatre | ManyToOne | N:1 | Theatre FK |

---

## Seat
**Entity Name:** Seat
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| row | int | - | - | |
| column | int | - | - | |
| seatType | SeatType | Enum | - | REGULAR, PREMIUM, RECLINER |

**Foreign Keys:**
- auditorium_id (from Auditorium.seats)

---

## Movie
**Entity Name:** Movie
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| movieName | String | - | - | |
| genre | String | - | - | |
| durationInMinutes | int | - | - | |
| features | List<Feature> | ElementCollection | - | Enum: IMAX, DOLBY, 3D, etc. |

---

## Show
**Entity Name:** Show
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| startTime | LocalDateTime | - | - | |
| endTime | LocalDateTime | - | - | |
| movie | Movie | ManyToOne | N:1 | Movie FK |
| auditorium | Auditorium | ManyToOne | N:1 | Auditorium FK |
| showSeats | List<ShowSeat> | OneToMany | 1:N | show_id (FK) |
| features | List<Feature> | ElementCollection | - | Enum: IMAX, DOLBY, 3D, etc. |

---

## ShowSeat
**Entity Name:** ShowSeat
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| seat | Seat | ManyToOne | N:1 | Seat FK |
| show | Show | ManyToOne | N:1 | Show FK |
| price | int | - | - | |
| showSeatStatus | ShowSeatStatus | Enum | - | AVAILABLE, BOOKED, BLOCKED |

---

## Ticket
**Entity Name:** Ticket
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| show | Show | ManyToOne | N:1 | Show FK |
| user | User | ManyToOne | N:1 | User FK |
| showSeat | List<ShowSeat> | OneToMany | 1:N | ticket_id (FK) |
| payment | Payment | OneToOne | 1:1 | Payment FK |
| theatre | Theatre | ManyToOne | N:1 | Theatre FK |
| ticketStatus | TicketStatus | Enum | - | ACTIVE, CANCELLED, USED |

---

## Payment
**Entity Name:** Payment
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| totalAmount | int | - | - | |
| paymentStatus | PaymentStatus | Enum | - | PENDING, COMPLETED, FAILED |
| transactions | List<Transaction> | OneToMany | 1:N | payment_id (FK) |

**Foreign Keys:**
- ticket_id (from Ticket.payment - OneToOne)

---

## Transaction
**Entity Name:** Transaction
**Extends:** BaseModel

| Attribute | Type | Relationship | Cardinality | Notes |
|-----------|------|--------------|-------------|-------|
| refrenceId | String | - | - | Payment gateway reference |
| TransactionAmount | int | - | - | |
| paymentType | PaymentType | Enum | - | CREDIT_CARD, DEBIT_CARD, UPI, WALLET |
| transactionPaymentStatus | TransactionPaymentStatus | Enum | - | SUCCESS, FAILED, PENDING |

**Foreign Keys:**
- payment_id (from Payment.transactions)

---

## Enum Constants

### SeatType
- REGULAR
- PREMIUM
- RECLINER

### ShowSeatStatus
- AVAILABLE
- BOOKED
- BLOCKED

### TicketStatus
- ACTIVE
- CANCELLED
- USED

### PaymentStatus
- PENDING
- COMPLETED
- FAILED

### PaymentType
- CREDIT_CARD
- DEBIT_CARD
- UPI
- WALLET

### TransactionPaymentStatus
- SUCCESS
- FAILED
- PENDING

### Feature
- IMAX
- DOLBY
- 3D
(etc.)

---

## Relationships Summary

```
City (1) ──────────────── (N) Theatre
                              │
                              ├── (1) ─────────── (N) Auditorium
                              │                      │
                              │                      ├── (1) ───────── (N) Seat
                              │                      │
                              │                      └── (1) ───────── (N) Show
                              │                                        │
                              └── (1) ──────────────────────────────── (N) Ticket
                                                                        │
                                                                        ├── (1) ── (N) User (via ManyToOne)
                                                                        │
                                                                        ├── (1) ── (1) Payment
                                                                        │           │
                                                                        │           └── (1) ── (N) Transaction
                                                                        │
                                                                        └── (1) ── (N) ShowSeat
                                                                                      │
                                                                                      ├── (N) ── (1) Seat
                                                                                      │
                                                                                      └── (N) ── (1) Show
                                                                                                  │
                                                                                                  ├── (N) ── (1) Movie
                                                                                                  │
                                                                                                  └── (N) ── (1) Auditorium
```

---

## Key Cardinalities

| Relationship | Cardinality | Description |
|--------------|-------------|-------------|
| City ↔ Theatre | 1:N | One city has many theatres |
| Theatre ↔ Auditorium | 1:N | One theatre has many auditoriums |
| Auditorium ↔ Seat | 1:N | One auditorium has many seats |
| Auditorium ↔ Show | 1:N | One auditorium hosts many shows |
| Movie ↔ Show | 1:N | One movie can have many shows |
| Show ↔ ShowSeat | 1:N | One show has many show seats |
| Seat ↔ ShowSeat | 1:N | One seat appears in many shows |
| Show ↔ Ticket | 1:N | One show can have many tickets |
| User ↔ Ticket | 1:N | One user can have many tickets |
| Theatre ↔ Ticket | 1:N | One theatre can have many tickets |
| Ticket ↔ ShowSeat | 1:N | One ticket has many show seats |
| Ticket ↔ Payment | 1:1 | One ticket has one payment |
| Payment ↔ Transaction | 1:N | One payment can have many transactions |

