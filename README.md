# Алгоритмы биоинформатики 

### Лаболаторная 1

<details>
<summary>Посмотреть задания</summary>

![image](https://github.com/user-attachments/assets/7a6a0258-6e0b-4ed9-9c45-ed916f0d954a)
![image](https://github.com/user-attachments/assets/b527d0d2-31ea-4e33-a42f-445e3c953298)
![image](https://github.com/user-attachments/assets/f295711a-4015-44bb-809f-f7a5da67b6e5)
![image](https://github.com/user-attachments/assets/69e31b2d-07e7-48b9-b9f9-980f57825006)
![image](https://github.com/user-attachments/assets/8173b415-d1e0-46fc-bbcc-06f0ed3c5467)

</details>

[Посмотреть решение](https://github.com/NIOHOMY/Bioinformatic_Algorithms_8_semester/tree/lab1)

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19410477/_.01_._62_.pdf)

### Лаболаторная 2

Задание 1. <br/>
1. В базе данных GenBank найти нуклеотидные последовательности в соответствии с вариантом. 
Привести каждую последовательность и определить число пар оснований каждой последовательности. 
2. Описать какие последовательности вы нашли, за что они отвечают и каким организмам принадлежат.
3. Построить точечную матрицу сходства между двумя последовательностями в формате FASTA. Сделать
вывод о сходстве или несходстве последовательностей.

Задание 2. <br/>
Пользуясь базой данных Nucleotide сайта NCBI для любого выбранной последовательности ДНК организма <br/>
из варианта записать: <br/>
1. Длину последовательности ДНК.
2. Исходный организм, название гена / имя белка.
3. Записать домен, царство, тип, класс, отряд, семейство, род и вид.
4. Авторы последовательности.
5. Дата размещения.
6. Найти и приложить фото исходного организма.

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19410461/_.02_._62_.pdf)

### Лаболаторная 3

Задание 1. <br/>

*Входные данные:* Две произвольные строки, содержащие буквы одного алфавита. <br/>
*Выходные данные:* Редакционное расстояние d(S1,S2), используя алгоритм Вагнера-Фишера. <br/>

В качестве сравниваемых последовательностей взять последовательности S1 и S2 из <br/>
Лабораторной работы 2. <br/>

*Пример входных данных:* S1 = PLEASANTLY S2 = MEANLY <br/>
*Пример выходных данных:* 5 <br/>

Задание 2.  <br/>
Выполнить задание 1, уменьшив потребление памяти до O(min{m,n}). В качестве <br/>
сравниваемых последовательностей взять последовательности из S1 и S2 Лабораторной работы <br/>
2. <br/>
Выписалть время, которое потребовалось для выполнения программы в Задании 1 и в Задании 2 <br/>
для сравнения последовательностей S1 и S2 из Лабораторной работы 2. <br/>


[Посмотреть решение](https://github.com/NIOHOMY/Bioinformatic_Algorithms_8_semester/tree/lab3)

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19410472/_.03_._62_.pdf)

### Лаболаторная 4

Задание 1. <br/>

Найти наилучшее глобальное выравнивание между двумя строками нуклеотидных <br/>
последовательностей при заданной матрицы весов. Файлы для примера брать в соот- <br/>
ветствии с вариантом из Лабораторной работы 2 из базы данных GenBank. <br/>

*Входные данные.* Строки V и W и матрица весов. <br/>
*Выходные данные.* Глобальное выравнивание между V и W вес которого (опре- <br/>
деленный по матрице весов) является максимальным среди всех возможных выравни- <br/>
ваний V и W . <br/>

Задание 2. <br/>

Найти наилучшее локальное выравнивание между двумя строками нуклеотидных <br/>
или аминокислотных последовательностей. Файлы для примера брать в соответствии <br/>
с вариантом из Лабораторной работы 2 из базы данных GenBank. <br/>

*Входные данные.* Две строки V и W и матрица весов. <br/>
*Выходные данные.* Локальное выравнивание, определяемое подстроками строк <br/>
V и W , глобальное выравнивание которых определенное матрицей весов, является <br/>
наилучшим среди всех глобальных выравниваний всех подстрок V и W . <br/>

[Посмотреть решение](https://github.com/NIOHOMY/Bioinformatic_Algorithms_8_semester/tree/lab4)

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19410474/_.04_._62_.pdf)

### Лаболаторная 5

Задание 1.  <br/>
Написать программу поиска консенсусной последовательности. <br/>
Проиллюстрировать на примере из своего варианта. Вывести матрицу Motifs и матрицу Count(Motifs). <br/>

Задание 2.  <br/>
Используя сайт [https://weblogo.berkeley.edu/logo.cgi](https://weblogo.berkeley.edu/logo.cgi) построить логотип последо- <br/>
вательностей матрицы Motifs на примере из своего варианта. <br/>

[Посмотреть решение](https://github.com/NIOHOMY/Bioinformatic_Algorithms_8_semester/tree/lab5)

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19493526/_.05_._62_.pdf)

### Лаболаторная 6

Задание 1. <br/>
В базе данных GenBank найти нуклеотидные последовательности в формате <br/>
Fasta в соответствии с вариантом. <br/>

Задание 2. <br/>
Написать программу поиска наиболее часто встречающегося k-мера в строке,  <br/>
k каждый раз вводится любое, меньшее длины строки. Тестовую последовательность для <br/>
примера брать из Задания 1. Вывести наиболее часто встречающуюся строку длины 7. <br/>

[Посмотреть решение](https://github.com/NIOHOMY/Bioinformatic_Algorithms_8_semester/tree/lab6)

[Скачать отчёт с заданиями и решением (pdf)](https://github.com/user-attachments/files/19493530/_.06_._62_.pdf)

