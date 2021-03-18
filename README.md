# String unpacker

Программа распаковывает строки вида число[строка].

Первым аргументом приходит строка, проверяется на валидность и затем распаковывется. Распакованная строка выводиться в консоль.

**Например:**

Аргумент: 3[xyz]4[xy]z

Вывод в консоль: xyzxyzxyzxyxyxyxyz

**Условия валидности:**

* после цифры должна стоять открывающая скобка;
* строка должна состоять из латинских букв, цифр и скобок [];
* количество открывающих скобок должно быть равно количеству закрывающих.