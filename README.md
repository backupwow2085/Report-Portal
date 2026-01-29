[![Java Tests](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml/badge.svg)](https://github.com/backupwow2085/Report-Portal/actions/workflows/main.yml)

<img width="1906" height="965" alt="540213507-6d0fe510-01a7-4697-95ae-ec742e787596" src="https://github.com/user-attachments/assets/eb73ea90-96f8-4414-afee-c5ba92e7e8c0" />
<img width="1729" height="835" alt="540213551-dbe198bd-fc97-4a95-8b6f-b41bf4f8ad20" src="https://github.com/user-attachments/assets/b7c1484b-c415-465a-972c-74d269ad2a30" />


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
