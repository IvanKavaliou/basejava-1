
# Четвертое занятие

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) [Разбор домашнего задания](https://drive.google.com/open?id=0B_4NpoQW1xfpQXVMb2xjRXJPdUU)
**Коммиты:**
 - [`lesson04 HW03`](https://github.com/JavaWebinar/basejava/tree/afc0cc5111434375f9da00e225ed7cbb15bbd4b7/src/ru/javawebinar/basejava/storage)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Работа со строками](https://drive.google.com/open?id=0B_4NpoQW1xfpSWVLYk51M2JpRnM)
**Коммиты:**
 - [`Lesson04 String`](https://github.com/JavaWebinar/basejava/blob/7f5a5d70a63fbeea40539397b1c4b2cfb3bd272f/src/ru/javawebinar/basejava/MainString.java)

**Ресурсы:**
- [Строки в Java](https://urvanov.ru/2016/04/20/java-8-строки/)
- [Кодировка в Java](https://web.archive.org/web/20210515175050/http://www.skipy.ru/technics/encodings.html)
- [Ошибки при использовании строк](https://web.archive.org/web/20170608030853/http://www.skipy.ru/technics/strings.html)
- [Обработка строк в Java](https://habrahabr.ru/post/260767/)
- [Руководство по String pool в Java](https://topjava.ru/blog/rukovodstvo-po-string-pool-v-java)
- **Дополнительно:**
  - [StringBuilder vs StringBuffer](https://stackoverflow.com/questions/355089/difference-between-stringbuilder-and-stringbuffer?rq=1)
  - [String vs StringBuffer vs StringBuilder](https://www.journaldev.com/538/string-vs-stringbuffer-vs-stringbuilder)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Исключения](https://drive.google.com/open?id=0B_4NpoQW1xfpQ1BaQjc3Y3N1MTQ)
**Коммиты:**
 - [`Lesson04 Exceptions`](https://github.com/JavaWebinar/basejava/tree/da03245d2fdafa86d1f02ea242c072ca52e19f26/src/ru/javawebinar/basejava)

**Ресурсы:**
  - [Обработка ошибок. Исключения](https://youtu.be/rjjyV7YGndc)
  - [Исключения (Exceptions)](http://proglang.su/java/exceptions)
  - [Статья про исключения](http://developer.alexanderklimov.ru/android/java/exception.php)
  - Про исключения также можно почитать в книге Джошуа Блоха - ["Java. Эффективное программирование"](https://www.ozon.ru/context/detail/id/21724143/)
  - [Руководство по конструкторам](https://topjava.ru/blog/rukovodstvo-po-konstruktoram-v-java)
  - [Ключевые слова: this, super](http://info.javarush.ru/grishin/2015/03/31/Разница-между-ключевыми-словами-this-и-super-в-Java.html)
  - **Дополнительно:**
    - [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
    - [Checked vs unchecked exception explanation](https://stackoverflow.com/questions/6115896/java-checked-vs-unchecked-exception-explanation)

![image](https://cloud.githubusercontent.com/assets/18701152/15581283/4c2f5348-2374-11e6-8fd2-e4de02d2c389.png)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Reflection. Аннотации. Модульное тестирование](https://drive.google.com/open?id=0B_4NpoQW1xfpT0dGZWlJbnN3bU0)
**Коммиты:**
 - [`Lesson04 Reflection and JUnit`](https://github.com/JavaWebinar/basejava/tree/c77bb7c73022fa411262c1da56953f3ef3ca3cc7)
 
**Ресурсы:**
 - [Руководство по аннотациям в Java](https://topjava.ru/blog/rukovodstvo-po-annotatsiyam-v-java-i-mekhanizmu-ikh-raboty)
 - [Reflection для начинающих](https://youtu.be/XJQuBXWADZg) (youtube)
 - [Руководство по Java Reflection API](http://javadevblog.com/polnoe-rukovodstvo-po-java-reflection-api-refleksiya-na-primerah.html)
 - [Java Reflection Example Tutorial](https://www.journaldev.com/1789/java-reflection-example-tutorial)
 - [Отличие JUnit4 от JUnit5](https://topjava.ru/blog/migratsiya-s-junit4-na-junit5)
 - **Дополнительно:**
   - [The Reflection API](https://docs.oracle.com/javase/tutorial/reflect/)
   - [What is reflection and why is it useful?](https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful)
> В нашем проекте Reflection используют JUnit и будут использовать библиотеки работы с XML и JSON
 - [Фреймворк для модульного тестирования JUnit](http://junit.org/) 
 - [Тестирование с помощью JUnit (Test Case)](http://web.archive.org/web/20190829153452/http://www.javenue.info/post/19)
 - [Тестирование кода Java с помощью фреймворка JUnit](https://www.youtube.com/watch?v=z9jEVLCF5_w) (youtube)
 - Использование Assert.fail() при тестировании: [1](https://www.baeldung.com/junit-fail), [2](https://stackoverflow.com/questions/3869954/whats-the-actual-use-of-fail-in-junit-test-case)

## Домашнее задание HW4
- Реализуйте тестовые классы: `AbstractArrayStorageTest`, `ArrayStorageTest` и `SortedArrayStorageTest`
- Необходимо написать тесты для всех public-методов, которые проверяли бы как их штатную работу, так и все выкидываемые ими икспешены
- В `MainReflection` вызовите у Resume, через отражение, метод `toString`. Выведите результат на консоль

## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW4
- используйте в `AbstractArrayStorageTest` конструктор для инициализации поля `Storage storage`, а в его наследниках добавьте конструкторы, которые будут вызывать `super()` с нужным хранилищем
- `SortedArrayStorageTest` должен создавать экземпляр `SortedArrayStorage`, а `ArrayStorageTest` экземпляр `ArrayStorage`
- тестировать правильность сортировки не надо
- во всех тестах проверяйте `Resume` целиком. Проверки только uuid недостаточно
- иерархия наследования тестовых классов должна совпадать с иерархией тестируемых
- логика реализации теста на переполнение массива (`StorageException`):
  - заполняем массив, но не вызываем у него переполнение
  - если при заполнении вылетит исключение, то тест должен провалиться (используйте Assert.fail())
  - в fail() выводите сообщение о том, что переполнение произошло раньше времени
  - тест считается успешно пройденным, когда переполнение происходит при попытке добавить в полностью заполненный массив еще одно резюме
- если при запуске тестового класса возникает ошибка `Test class should have exactly one public zero-argument constructor`, то нажмите два раза Shift и напишите Edit Configurations. В открывшейся вкладке Run/Debug Configurations, удалите в левой панели все запускаемые с JUnit классы
