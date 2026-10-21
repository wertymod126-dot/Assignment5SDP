# Strategy Pattern — CS2 Economy Buy System

## Overview
This repository contains a Java implementation of the **Strategy Behavioral Design Pattern** applied to a Counter-Strike 2 (CS2) team economy management system. 

In CS2, player purchasing behavior changes dynamically each round based on available funds and team economy tactics. This project models those dynamic execution modes (`Full Buy`, `Force Buy`, and `Eco Round`) without using conditional branching inside the player context class.

---

## Technical Requirements Fulfillment

The project adheres to the four core components of the Strategy Design Pattern:

1. **Strategy Interface (`BuyStrategy`)**: Declares standard execution methods (`executeBuy()`, `getRequiredMoney()`) implemented by all interchangeable buy behaviors.
2. **Concrete Strategies**:
   * `FullBuyStrategy`: Handles purchases for high-tier equipment ($4,200).
   * `ForceBuyStrategy`: Handles purchases for mid-tier weapons and partial armor ($2,000).
   * `EcoBuyStrategy`: Handles eco-round behavior where funds are preserved ($0).
3. **Context (`CS2Player`)**: Maintains a reference to a `BuyStrategy`, delegates transaction validation and execution to it, and supports changing strategies at runtime via `setBuyStrategy()`.
4. **Client (`Main`)**: Configures and injects specific concrete strategies into the `CS2Player` context based on match conditions.

---

## Clean Code Justifications (Assignment #5)

As required by Assignment #5 (referencing *Clean Code*, Ch. 10), the following five Clean Code principles were applied:

### 1. Elimination of Branching Logic in Favor of Polymorphism
* **Justification**: Traditional implementations rely on conditional logic (e.g., `if (mode == "FULL") ... else if ...`). In this codebase, `CS2Player.buyEquipment()` contains zero `if/else` or `switch` statements checking strategy types. The context polymorphically invokes `buyStrategy.getRequiredMoney()` and `buyStrategy.executeBuy()`, allowing behavior switching purely through composition.

### 2. Single Responsibility Principle (SRP)
* **Justification**: Responsibilities are strictly segregated across classes:
  * `CS2Player` is solely responsible for player state (nickname, balance) and financial balance checks.
  * Each concrete strategy (`FullBuyStrategy`, `ForceBuyStrategy`, `EcoBuyStrategy`) is solely responsible for encapsulating the execution output and cost of its specific purchasing algorithm.

### 3. Context Algorithm-Agnosticism & Open/Closed Principle (OCP)
* **Justification**: `CS2Player` depends strictly on the `BuyStrategy` interface abstraction and has zero references to concrete classes (`FullBuyStrategy`, etc.). New purchase behaviors (such as `HeroBuyStrategy` or `DropWeaponStrategy`) can be added by creating a new class implementing `BuyStrategy` without modifying a single line of code in `CS2Player` or existing strategies.

### 4. Meaningful, Intention-Revealing Names
* **Justification**: Identifiers across the codebase clearly reflect the CS2 domain rather than generic technical terms. Classes like `ForceBuyStrategy` and methods like `getRequiredMoney()` communicate their exact purpose without requiring inline code comments.

### 5. Encapsulation and Data Hiding
* **Justification**: Algorithm constants (such as `REQUIRED_MONEY`) are declared `private static final` inside their respective concrete strategy classes. External classes cannot modify internal algorithm parameters, preventing unintended side effects.

---

## Project Structure

```text
src/
├── BuyStrategy.java         // Strategy Interface
├── FullBuyStrategy.java     // Concrete Strategy 1
├── ForceBuyStrategy.java    // Concrete Strategy 2
├── EcoBuyStrategy.java      // Concrete Strategy 3
├── CS2Player.java           // Context
└── Main.java                // Client Application
```

---

## How to Compile & Run

1. Clone the repository:
   ```bash
   git clone <your-github-repo-url>
   cd <repo-folder>
   ```

2. Compile all Java files:
   ```bash
   javac *.java
   ```

3. Run the application:
   ```bash
   java Main
   ```
