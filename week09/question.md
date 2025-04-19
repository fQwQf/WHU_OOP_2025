# week09作业

## 任务一：实现一个泛型容器类 `MyBox<T>`

目标： 理解并掌握泛型类的定义与使用。  

任务内容：
1. 定义一个泛型类 `MyBox<T>`，用于存储任意类型的对象。
2. 实现以下方法：
  - `void set(T item)`：设置内容；
  - `T get()`：获取内容；
  - `String toString()`：返回该对象的字符串形式；
3. 创建测试类 TestMyBox，分别使用 `MyBox<String>`、`MyBox<Integer>`、`MyBox<Double>` 进行测试。
4. 为 `MyBox` 添加一个比较方法 `boolean equals(MyBox<?> other)`，比较两个 `MyBox` 中的内容是否相同。

要求： 理解 `<?>` 的意义和使用场景。

## 任务二：设计一个使用泛型接口和方法的集合处理器

目标： 熟悉泛型接口、泛型方法和通配符的高级用法。  
任务内容：
1. 定义一个泛型接口 `Processor<T>`，包含方法：  
`void process(T item)`;
2. 实现该接口的两个类：
  - `StringPrinter`：输出字符串；
  - `NumberSummer`：将数字相加并显示总和。
3. 定义一个工具类 `ProcessorUtil`，其中包含一个泛型方法：  
`public static <T> void apply(List<? extends T> list, Processor<T> processor)`
- 遍历列表，依次调用 `processor.process(item)`。
4. 编写测试类 `TestProcessor`，验证 `apply` 方法的功能。
  - 使用 `StringPrinter` 处理 `List<String>`；
  - 使用 `NumberSummer` 处理 `List<Integer>`。

拓展内容：
- 尝试使用 `<? super T>` 编写一个 `collect(List<? super T> dest, List<T> src)` 方法，将源列表复制到目标列表。

## 提交内容：
1. 代码截图：展示完成的所有类和方法实现。
2. 运行结果截图：展示所有测试用例的输出结果，确保程序逻辑正确且异常处理完善。