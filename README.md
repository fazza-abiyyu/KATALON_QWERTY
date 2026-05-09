# KATALON_QWERTY

Automation testing repository for the **QWERTY E-Commerce** platform using Katalon Studio.

This project contains end-to-end testing scenarios covering authentication, cart management, checkout flow, payment simulation, and password reset functionality.

---

# Overview

This repository is part of the QWERTY ecosystem:

- Main Application Repository: [Source Code QWERTY E-Commerce] (https://github.com/fazza-abiyyu/QWERTY-E-Commerce)

- Automation Testing Repository: [Katalon QWERTY E-Commerce] (https://github.com/fazza-abiyyu/KATALON_QWERTY)

- QA Test Case Documentation:
  [Google Sheets Documentation](https://docs.google.com/spreadsheets/d/1VZ4eQ-brBA4YSWC1y6cMlEoiesjL65XsEZ4lJBDL4HI/edit?usp=sharing)

- Live Demo:
  https://qwerty.abiyyu.xyz

---

# Technology Stack

- Katalon Studio
- Groovy
- Selenium WebDriver
- Chrome Driver
- Data Driven Testing
- XPath Selector Strategy
- Self-Healing Object Repository

---

# Testing Scope

## Authentication Testing

### Login Verification
- Login with valid credentials
- Login with invalid credentials
- Login with empty input
- Login with unregistered email
- Login with SQL Injection attempt

### Register Verification
- Register with valid requirements
- Register with blank input
- Register with invalid requirements
- Register with existing email
- Register new user flow

### Reset Password Verification
- Reset password with valid OTP
- Reset password with invalid OTP
- Reset password with invalid email
- Reset password with blank input

---

## Cart Verification

- Add product to cart with login
- Add product without login
- Add product with custom quantity
- Refresh cart page
- Remove item from cart
- Update cart quantity

---

## Checkout & Payment Verification

- Checkout item with login
- Checkout item without login
- Checkout with valid conditional
- Checkout without payment
- Checkout and pay from order details

---

# Integrated Simulator Testing

This project also tests several simulator endpoints available inside the QWERTY platform.

## Email OTP Simulator
Used for:
- OTP verification
- Password reset testing

URL:
```txt
/emailer-simulator
```

## Webhook Payment Simulator
Used for:
- Virtual Account payment simulation
- Order status update testing

URL:
```txt
/webhook-simulator
```

---

# QA Documentation

Real QA test cases are documented in Google Spreadsheet format including:

- Test Scenario
- Test Objective
- Preconditions
- Test Steps
- Expected Result
- Actual Result
- Status
- Postconditions
- Environment

Documentation:
[Google Sheets Documentation](https://docs.google.com/spreadsheets/d/1VZ4eQ-brBA4YSWC1y6cMlEoiesjL65XsEZ4lJBDL4HI/edit?usp=sharing)

---

# Project Structure

```bash
KATALON_QWERTY
├── Profiles
├── Reports
├── Scripts
├── Test Cases
├── Test Suites
├── Object Repository
├── Test Listeners
├── settings
└── KATALON_QWERTY.prj
```

---

# Test Suites

Available automated suites:

- Auth
- Login
- Register
- Cart
- Checkout
- Reset Password
- E2E Testing

---

# Features

- End-to-End Automation Testing
- Modular Test Case Structure
- Reusable Object Repository
- Data Driven Testing
- OTP Simulation Testing
- Payment Webhook Simulation
- Negative Testing
- SQL Injection Validation
- Session Validation
- Dynamic XPath Handling
- Self-Healing Element Detection

---

# Example Test Scenarios

## Login Security Validation

```groovy
WebUI.setText(findTestObject('Login/email_field'), "' OR 1=1; --")
WebUI.setText(findTestObject('Login/password_field'), "test")
WebUI.click(findTestObject('Login/btn_sign_in'))
```

---

## Payment Flow Simulation

```groovy
String vaCode = WebUI.getText(findTestObject('Checkout and payment/text_va_code'))

WebUI.newTab(url + '/webhook-simulator')

WebUI.setText(findTestObject('Webhook/input_va_code'), vaCode)

WebUI.click(findTestObject('Checkout and payment/btn_webhook_pay_bill'))
```

---

# Author

M Faza Abiyyu

- GitHub:
  https://github.com/fazza-abiyyu

- LinkedIn:
  https://linkedin.com/in/fazaabiyyu

---

# Notes

This project was built as part of a personal QA automation portfolio and fullstack testing ecosystem for the QWERTY E-Commerce platform.

The focus of this repository is:
- functional testing
- automation testing
- scenario validation
- simulator-based testing
- real QA documentation workflow

---
