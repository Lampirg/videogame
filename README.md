# videogame

[Тестовое задание](https://docs.google.com/document/d/1lfpe1JDCuGMQ3cFyn5oNk2PqRO94z6IqCq6yoTaUsYo/edit) для школы разработки Heads x Hands.

## Контакты

Telegram: [@Lampirg](https://t.me/Lampirg)

Почта: svcode01@gmail.com

## Текст задания

Спроектируйте и реализуйте классы для одной видеоигры. Реализацию опубликуйте в открытом репозитории на github. В readme репозитория оставьте свое имя пользователя в Telegram для связи.
Условия:
1) В игре есть Существа. К ним относятся Игрок и Монстры.
2) У Существа есть параметры Атака и Защита. Это целые числа от 1 до 30.
3) У Существа есть Здоровье. Это натуральное число от 0 до N. Если Здоровье становится равным 0, то Существо умирает. Игрок может себя исцелить до 4-х раз на 30% от максимального Здоровья.
4) У Существа есть параметр Урон. Это диапазон натуральных чисел M - N. Например, 1-6.
5) Одно Существо может ударить другое по такому алгоритму:
- Рассчитываем Модификатор атаки. Он равен разности Атаки атакующего и Защиты защищающегося плюс 1
- Успех определяется броском N кубиков с цифрами от 1 до 6, где N - это Модификатор атаки. Всегда бросается хотя бы один кубик.
- Удар считается успешным, если хотя бы на одном из кубиков выпадает 5 или 6
- Если удар успешен, то берется произвольное значение из параметра Урон атакующего и вычитается из Здоровья защищающегося.

Все сущности должны быть написаны и спроектированы в ООП стиле. Объекты обязательно должны реагировать на некорректные аргументы методов.
В вашей программе обязательно должны получиться классы сущностей Игрок и Монстр. Наличие дополнительных классов по вашему желанию.

Результатом должно стать приложение с реализацией классов и примером их использования.

## Выполнение

Результат работы классов представлен в классе [Main.java](src/main/java/dev/lampirg/Main.java) и в тестовом классе [TestPlayer.java](src/test/java/TestPlayer.java)