# week06作业

## 作业要求
创建自定义异常类
1. InvalidAgeException：用于表示年龄无效的异常，实现为 checked Exception。
2. InvalidNameException：用于表示姓名无效的异常，实现为 unchecked Exception。
实现用户注册类 UserRegistration
1. 方法 validateAge(int age)：
  - 验证用户年龄是否符合要求。
  - 若年龄小于 18，则抛出 InvalidAgeException。
2. 方法 validateName(String name)：
  - 验证用户姓名是否符合要求。
  - 若姓名为空或长度小于 3，则抛出 InvalidNameException。
3. 方法 registerUser(String name, int age)：
  - 调用 validateAge 和 validateName 验证用户信息。
  - 如果验证通过，打印注册成功信息。
  - 如果验证失败，捕获并打印异常信息。
模拟多层调用链
- 在主方法中创建一个服务层方法 startRegistration(String name, int age)：
  - 调用 UserRegistration.registerUser(name, age) 实现用户注册。
  - 让 registerUser 抛出的异常沿调用链传播至 main。
  
## 测试要求
使用以下三组测试数据，验证程序的正确性：
1. 正常注册：
  - 输入合法的姓名和年龄，验证程序输出成功信息。
2. 姓名无效：
  - 输入空字符串或过短的姓名，触发 InvalidNameException。
3. 年龄无效：
  - 输入小于 18 的年龄，触发 InvalidAgeException。

## 扩展任务（选做）
1. 更复杂的调用链：
  - 增加更深层次的验证方法，并将异常沿调用链逐级传播。
2. 日志记录：
  - 使用 java.util.logging 将异常信息记录到日志文件中，而非直接打印到控制台。
3. 异常转译：
  - 在捕获到异常后，将其包装为自定义的更高层异常（如 ApplicationException）并重新抛出。

## 完成目标
1. 掌握自定义异常类的定义与使用。
2. 理解 Exception 和 RuntimeException 的应用场景和区别。
3. 熟练使用异常的多层传播和捕获。
4. 熟悉日志记录和异常转译的应用。

## 提交内容：
1. 代码截图：展示完成的所有类和方法实现。
2. 运行结果截图：展示所有测试用例的输出结果，确保程序逻辑正确且异常处理完善。