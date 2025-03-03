# 题目：Java 和 Scala 混合编程任务

## 任务描述

在本任务中，创建一个包含 Java 和 Scala 混合编程的简单项目。通过创建四个 Java 和 Scala 类，展示如何在 Java 中调用 Scala 方法，以及如何从 Scala 中调用 Java 方法。并在任务中观察编译后的字节码文件，分析混合编程的实现方式和细节。

## 项目要求

1. 创建 Java 类：

- HelloFromJava（Java 类）：调用 HelloScala 的方法，输出 "Hello from Java!" 和 "Hello from Scala!"。
- HelloJava（Java 类）：包含一个静态方法 sayHelloFromJava()，输出 "Hello from Java!"。

2. 创建 Scala 类：

- HelloFromScala（Scala 类）：调用 HelloJava 的方法，输出 "Hello from Scala!" 和 "Hello from Java!"。
- HelloScala（Scala 类）：包含一个方法 sayHelloFromScala()，输出 "Hello from Scala!"。

3. 输出要求：

- 从 Java 入口调用 Scala：通过 Java 类 HelloFromJava 调用 Scala 类 HelloScala，程序输出：
Hello from Java!
Hello from Scala!
- 从 Scala 入口调用 Java：通过 Scala 类 HelloFromScala 调用 Java 类 HelloJava，程序输出：
Hello from Scala!
Hello from Java!

4. 编译和字节码分析：

- 在编译项目后，使用 IDE 自带的反编译工具，查看生成的字节码文件。
- 观察和记录以下内容：
  - Java 类和 Scala 类的字节码文件的生成情况。
  - Java 和 Scala 在字节码层面的差异。

5. 提交要求：

- 源代码：提交项目的完整源代码（Java 和 Scala 类）。
- 运行截图：提交项目运行的截图以确认正确性。
- 研究文档：提交一份简短的文档，内容包括：
  - 对编译后字节码文件的分析。
  - Java 和 Scala 混合编程的实现方式。对两者混合编程的理解，特别是在 JVM 层面的实现。
  - 对观察到的现象的分析和解释说明。
