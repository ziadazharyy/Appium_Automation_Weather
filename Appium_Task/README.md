# 🌤️ Android Weather App Test Automation Framework

This project provides an automated test suite for the **Weather Android Mobile App**, focusing on validating functionality and UI of the **Home Screen**. The framework uses **Appium**, **TestNG**, and **Java** to run UI-based automated tests directly on a mobile emulator or real device.

---

## 📦 Features

- ✅ Change temperature unit from °C to °F with validation
- 🕒 Switch time format from 24h to 12h and verify UI updates
- 🌧️ Assert rain probability and humidity icons are shown for the next 6 hours
- 📲 Built with **Appium** for Android automation
- 📊 Generates test execution reports

---

## 📘 Solution Overview

This test automation framework includes:

- **Java 18**
- **TestNG** for test orchestration
- **Appium** for Android UI automation
- **ExtentReports** for HTML-based test reports
- **Maven** for dependency and project management

---

## ⚙️ Setup Instructions

## Clone the Repository

```bash
git clone https://github.com/ziadazharyy/Appium_Automation_Weather.git
cd weather-app-automation


## 🚀 How to Execute Tests

You can execute the automated tests in multiple ways:

### ✅ Run All Tests

```bash
mvn test
