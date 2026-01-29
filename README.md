[![Java Tests](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml/badge.svg)](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml)

<img width="1906" height="965" alt="image" src="https://github.com/user-attachments/assets/6d0fe510-01a7-4697-95ae-ec742e787596" />
<img width="1729" height="835" alt="image" src="https://github.com/user-attachments/assets/dbe198bd-fc97-4a95-8b6f-b41bf4f8ad20" />

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
