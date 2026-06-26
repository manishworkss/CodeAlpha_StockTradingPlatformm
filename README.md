# 🚀 Stock Trading Platform (CodeAlpha Internship - Task 2)

A dual-interface quantitative trading simulation featuring both a **pure Java CLI Application** and an **Institutional-Grade AI Web Terminal**.

Built by **Manish Kumar** for the CodeAlpha Internship Program.

---

## 🌟 Highlights & Features

### 1. 🌐 StockPulse Institutional Pro (Web Simulation Terminal)
Located in `index.html`, this single-file modern frontend simulator brings the domain logic to life:
- 📈 **Real-Time Interactive SVG Charts**: Live streaming tick data & area charts for major equities (`AAPL`, `NVDA`, `TSLA`, `AMZN`, `MSFT`, `BTC`).
- 🤖 **DeepMind Autonomous AI Copilot**: Quantitative bot assistant scanning RSI and momentum indicators to auto-trade in real-time.
- 📊 **Level 2 Market Depth**: Simulated real-time order book with streaming bids and asks.
- 📰 **Breaking News Events**: Macroeconomic sentiment headlines dynamically impacting market valuations.
- 🔊 **Web Audio Synthesizer**: Acoustic audio feedback on BUY/SELL order executions.
- ⌨️ **Trader Hotkeys**: Instant order switching (`B` for Buy, `S` for Sell).

### 2. ☕ Core Java Console Engine
Located in `StockTradingPlatform/`, demonstrating core Java backend engineering:
- **Object-Oriented Programming**: Clean domain encapsulation (`Stock`, `Portfolio`, `Transaction`, `User`).
- **HashMap Data Structures**: Constant-time lookup and aggregation of asset holdings.
- **File I/O & Serialization**: Persistent binary storage of portfolio states (`portfolio.ser`).

---

## ▶️ How to Run

### 🌐 Launch Web Simulator
Simply double-click `index.html` to open it in any web browser, or serve it locally:
```bash
python3 -m http.server 8080
# Open http://localhost:8080 in Chrome
```

### ☕ Run Java Console App
1. Navigate to the backend directory:
   ```bash
   cd StockTradingPlatform
   ```
2. Compile the Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java TradingPlatform
   ```

---

## 🛠️ Tech Stack
- **Web Terminal**: HTML5 | Modern Vanilla CSS3 (Glassmorphism, Dark UI) | JavaScript (ES6+, Web Audio API, Live SVG)
- **Core Engine**: Java JDK 11+ | OOP | Java Serialization | File I/O | Collections (HashMap)

---
*Developed by **Manish Kumar** | CodeAlpha Internship Task 2*
