# OnlineShopApp

## Описание на проекта

**OnlineShopApp** е Android приложение за онлайн пазаруване на смарт часовници, разработено с **Kotlin**, **Firebase** и **SQLite**.  
Приложението позволява на потребителите да разглеждат продукти, да виждат подробна информация за тях, да ги добавят в любими и да ги споделят чрез Android Share Intent.

---

## Основни функционалности

- Firebase Realtime Database интеграция
- Зареждане на продукти, категории и банери
- Детайлен екран за всеки продукт
- Favorites система със SQLite база данни
- Пълен CRUD (Create, Read, Update, Delete)
- Share Intent за споделяне на продукти
- RecyclerView списъци
- Glide зареждане на изображения
- Модерен Material Design интерфейс
- Локално съхранение на данни след рестарт

---

## Как работи приложението

Приложението зарежда продукти, категории и банери от **Firebase Realtime Database**.  
Началният екран визуализира всички налични смарт часовници в grid layout чрез RecyclerView.

При избор на продукт се отваря **DetailActivity**, където потребителят може да:
- разгледа изображения на продукта
- види цена, описание и рейтинг
- добави продукта в Favorites
- сподели продукта чрез Android Share Intent

Favorites системата използва **SQLite локална база данни**, в която продуктите се записват локално. Данните остават налични дори след затваряне или рестартиране на приложението.

Във Favorites екрана потребителят може да:
- преглежда добавените продукти
- редактира цена
- изтрива продукти

Приложението използва разделение между UI слой, data слой и database helper класове, което улеснява поддръжката и разширяването на проекта.

---

## Архитектура

Приложението използва layered architecture:

```text
UI Layer
│
├── Activities
├── Adapters
│
Data Layer
│
├── Firebase Realtime Database
├── SQLite Database
│
Domain Layer
│
├── Models
├── Database Helper


Потребителски поток
Splash Screen
   ↓
Main Screen
   ↓
Detail Screen
   ↓
Add to Favorites / Share Product
   ↓
Favorites Screen


CRUD функционалност

Favorites модулът поддържа пълен CRUD:

Операция	Описание
Create	    Добавяне на продукт в Favorites
Read	    Зареждане на всички любими продукти
Update	    Редактиране на цена
Delete	    Изтриване на продукт

Данните се запазват след рестарт на приложението.

Допълнителна функционалност
- Firebase Realtime Database - Приложението използва Firebase за: зареждане на продукти; категории и банери

Share Intent - Потребителят може да споделя продукт към други приложения.

Пример: Check this product: Apple Watch Series 10 - $442.95

Използвани технологии
Технология	                     Версия	              Предназначение
Kotlin	                          2.0.21	           Основен език
Firebase Realtime Database	      22.0.1	       Облачна база данни
SQLite	                        Android SDK       	Локална база данни
RecyclerView	                   1.4.0	         Списъци с продукти
Glide	                           4.16.0	      Зареждане на изображения
ViewBinding                      AndroidX	              UI binding
Material Design	                   1.13.0	            UI компоненти

Структура на проекта
app/
├── activity/
├── adapter/
├── data/
├── domain/
├── viewmodel/
├── res/

Инсталация и стартиране
1. Клониране на проекта
git clone https://github.com/ayshe-izetova/MobileApps2026-2301681012.git

2. Отваряне в Android Studio
Отворете проекта чрез Android Studio.

3. Gradle Sync
Изчакайте Gradle synchronization.

4. Стартиране
Приложението може да се стартира на:

Android Emulator
Реално Android устройство

APK
APK файлът се намира в:
/apk/app-release.apk

GitHub Repository
https://github.com/ayshe-izetova/MobileApps2026-2301681012

Автор
Ayshe Izetova
Android Mobile Applications Project
2026