# Elif_testAutomation
# 🚀 Automation Exercise Test Otomasyon Projesi

Bu proje, [Automation Exercise](https://automationexercise.com) web uygulaması üzerinde Java, Selenium, Cucumber (Gherkin), ve TestNG kullanılarak oluşturulmuş bir test otomasyon projesidir.

## 🧰 Kullanılan Teknolojiler

- Java
- Selenium WebDriver
- Cucumber (Gherkin dili)
- TestNG
- Maven
- Page Object Model (POM) yapısı

## 📁 Proje Yapısı

📁 elif_testAutomation
├── 📁 drivers
│   └── chromedriver.exe
├── 📁 src
│   ├── 📁 main
│   │   └── 📁 java
│   │       ├── 📁 pages
│   │       │   ├── AccountCreationPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── ProductPage.java
│   │       └── 📁 utils
│   │           └── DriverFactory.java
│   └── 📁 test
│       └── 📁 java
│           ├── 📁 base
│           │   └── BaseTest.java
│           ├── 📁 features
│           │   ├── order.feature
│           │   └── signup.feature
│           └── 📁 stepdefs
│               ├── OrderSteps.java
│               └── SignupSteps.java
├── 📄 pom.xml
└── 📄 .gitignore


⚙️ Kurulum

1. Java ve Maven kurulu olduğundan emin olun.
- Java 11+
- Maven 3+

2. Projeyi klonla veya indir:
```bash
git clone https://github.com/kullanici/elif_testAutomation.git
