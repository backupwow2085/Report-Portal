[![Java Tests](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml/badge.svg)](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml)

## Локальный запуск тестов и Allure

1. Запустить приложение:
```powershell
java -jar artifacts/app-replan-delivery.jar
```

2. Запустить тесты:
```powershell
.\gradlew.bat test -Dselenide.headless=true
```

3. Открыть Allure-отчет:
- через встроенный сервер:
```powershell
.\gradlew.bat allureServe
```
- либо сгенерировать статический отчет и открыть файл:
```powershell
.\gradlew.bat allureReport
```
`build/reports/allure-report/index.html`
