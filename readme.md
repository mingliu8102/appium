# Tools
    1. IDE - IDEA
    2. Appium
    3. Build and dependency Management tool - Maven
    4. Testing Framework - TestNG
    5. Design pattern - Page Object Model
    6. Reporting Framework - Allure

# 文件结构
   - /main
     - /java/com/mingliu/:
       - actions: 封装各个页面的操作
         - FindPageAction: 封装 网易云发现页面的操作
         - LoginAction: 封装 网易云登陆界面的常见操作
         - SearchPageAction: 封装 网易云歌曲搜索界面的操作
       - base: 
         - BaseAction: 封装常见页面的基础操作：click,sendKeys
         - BasePage: PageFactory初始化
         - BaseTest: Test开始前driver初始化、Test结束后driver quit
       - listeners:
         - TestResultListener: 拦截器，实现本地截图，截图添加到Allure
       - manager：
         - DriverManager：driver 管理
       - page： 封装不同页面内的元素
       - utils：工具类
         - JsonParseHelper:解析json文件
         - ClassGenerator:解析json文件，生成Page类
     - /resources/pages：json格式文件，描述各个页面常见元素定位方式

# 使用说明
  + 执行测试用例：
     ` mvn clean test ` 
  + 查看Allure报告：
     ` allure serve allure-results`  
    + 说明：Allure报告数据存放在/allure-results下
## Allure报告：
![](/Users/mingliu/Desktop/截屏2022-10-08 下午8.25.30.png)



# To do:
 1. 测试前，需要先手动开启appium server  
     解决方案：添加appium server 开启check；未开启则开启appium server
