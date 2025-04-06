# week07作业

"集合的强大在于抽象，用户只需关注‘做什么’，而不必担心‘如何做’。"
- 体现了 Java 集合框架对接口和实现分离的设计哲学。

---
假设某学校需要开发一个更复杂的学生管理系统，涉及多种数据操作与统计功能，包括学生成绩管理、去重、排序、查找和分组分析。请实现如下需求。
## 要求：
1. 定义实体类 `Student`：
  - 包括以下字段：
    - `id` (int 类型)：学生的唯一标识。
    - `name` (String 类型)：学生姓名。
    - `score` (double 类型)：学生成绩。
    - `major` (String 类型)：学生的专业（如 "Computer Science", "Mathematics", "Physics"）。
  - 必须重写 `hashCode` 和 `equals` 方法，确保以 `id` 判断对象的唯一性。
  - 重写 `toString` 方法，方便打印对象信息。
2. 程序逻辑：
  - 初始数据（硬编码）：
```java
ID=1, Name=Alice, Score=85.0, Major=Computer Science
ID=2, Name=Bob, Score=45.0, Major=Mathematics
ID=3, Name=Charlie, Score=78.5, Major=Physics
ID=4, Name=David, Score=59.0, Major=Computer Science
ID=5, Name=Eve, Score=93.0, Major=Mathematics
ID=6, Name=Frank, Score=70.0, Major=Physics
ID=2, Name=Duplicate Bob, Score=45.0, Major=Mathematics
ID=7, Name=Grace, Score=88.5, Major=Computer Science
```

  - 根据以上数据完成以下操作：
    1. 存储与打印： 使用 List 存储学生信息并打印初始数据。
    2. 去重筛选： 根据 id 去重，将成绩大于或等于 60 的学生存储到一个 HashSet，打印及格学生信息。
    3. 分组统计： 使用 HashMap 将学生按 major（专业）分组，打印每个专业的学生列表。
    4. 平均成绩计算： 计算并打印每个专业的学生平均成绩。
    5. 排序：
      - 按 score 降序排序 List 中的学生。
      - 如果成绩相同，则按 name 字母顺序升序。
      - 打印排序结果。
    6. 查找与更新：
      - 使用 HashMap 实现根据学生 id 查找学生信息的功能。如果找到，则更新其成绩为 95 分。
      - 如果未找到，则提示用户该学生不存在。
    7. 全局统计：
      - 打印最高成绩的学生信息。
      - 统计及格学生的总数和不及格学生的总数。

---
## 输出要求：
1. 初始数据： 打印所有学生的信息。
2. 及格学生信息： 打印去重后及格学生的列表。
3. 分组信息： 打印每个专业的学生及其平均成绩。
4. 排序结果： 打印按成绩降序排列后的学生信息。
5. 查找与更新结果： 打印查找到的学生信息或提示未找到。
6. 全局统计： 打印最高成绩学生信息，以及及格与不及格学生的数量。

---
## 难点说明：
- 去重逻辑： 需要正确使用 hashCode 和 equals 方法避免重复数据。
- 分组与统计： 利用 HashMap 按专业分组，同时计算平均成绩。
- 多重排序： 需要结合 Comparator 实现多重排序逻辑。
- 数据更新： 在 HashMap 中操作对象，实现更新功能。

---
## 完成程序的目标：
1. 掌握 Java 集合（List、HashSet、HashMap）的高级应用。
2. 理解如何通过多条件 Comparator 实现排序。
3. 熟练掌握分组统计和数据处理逻辑。
4. 模拟真实数据管理场景中的操作，如筛选、分组、排序和更新。

---
## 提交内容：
1. 代码截图：展示完成的所有类和方法实现。
2. 运行结果截图：展示所有测试用例的输出结果，确保程序逻辑正确且异常处理完善。

---
输出示例：
```shell
Initial List of Students:
Student{id=1, name='Alice', score=85.0, major='Computer Science'}
Student{id=2, name='Bob', score=45.0, major='Mathematics'}
Student{id=3, name='Charlie', score=78.5, major='Physics'}
Student{id=4, name='David', score=59.0, major='Computer Science'}
Student{id=5, name='Eve', score=93.0, major='Mathematics'}
Student{id=6, name='Frank', score=70.0, major='Physics'}
Student{id=2, name='Duplicate Bob', score=45.0, major='Mathematics'}
Student{id=7, name='Grace', score=88.5, major='Computer Science'}

Passed Students (After Removing Duplicates):
Student{id=1, name='Alice', score=85.0, major='Computer Science'}
Student{id=3, name='Charlie', score=78.5, major='Physics'}
Student{id=5, name='Eve', score=93.0, major='Mathematics'}
Student{id=6, name='Frank', score=70.0, major='Physics'}
Student{id=7, name='Grace', score=88.5, major='Computer Science'}

Students Grouped by Major:
Major: Computer Science
Student{id=1, name='Alice', score=85.0, major='Computer Science'}
Student{id=4, name='David', score=59.0, major='Computer Science'}
Student{id=7, name='Grace', score=88.5, major='Computer Science'}
...

Average Score by Major:
Major: Computer Science, Average Score: 77.33333333333333
...

Students Sorted by Score (Descending):
Student{id=5, name='Eve', score=93.0, major='Mathematics'}
...

Global Statistics:
Highest Scoring Student: Student{id=5, name='Eve', score=93.0, major='Mathematics'}
Number of Passed Students: 5
Number of Failed Students: 3
```