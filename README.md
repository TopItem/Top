# Top
Tutoring software in o2o mode

## Api请求规范

为了严格按照接口进行开发，提高效率，对请求及响应格式进行规范化。

1. get 请求时，采用key/value格式请求，SpringMVC可采用基本类型的变量接收，也可以采用对象接收。
2. Post请求时，可以提交form表单数据（application/x-www-form-urlencoded）和Json数据（Content-Type=application/json），文件等多部件类型（multipart/form-data）三种数据格式，SpringMVC接收Json数据使用@RequestBody注解解析请求的json数据。
3. 响应结果统一信息为：是否成功、操作代码、提示信息及自定义数据。
4. 响应结果统一格式为json
5. Api定义使用SpringMVC来完成，由于此接口后期将作为微服务远程调用使用，在定义接口时有如下限制：
   1. @PathVariable 统一指定参数名称，如：@PathVariable("id") 
   2. @RequestParam统一指定参数名称，如：@RequestParam（"id"）

### Rest

- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建一个资源。
- PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
- PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
- DELETE（DELETE）：从服务器删除资源
- HEAD：获取资源的元数据。
- OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

> - GET /zoos：列出所有动物园
> - POST /zoos：新建一个动物园
> - GET /zoos/ID：获取某个指定动物园的信息
> - PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
> - PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
> - DELETE /zoos/ID：删除某个动物园
> - GET /zoos/ID/animals：列出某个指定动物园的所有动物
> - DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物

**过滤**

> - ?limit=10：指定返回记录的数量
> - ?offset=10：指定返回记录的开始位置。
> - ?page=2&per_page=100：指定第几页，以及每页的记录数。
> - ?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
> - ?animal_type_id=1：指定筛选条件

## 异常处理

1. 在Service方法中的编码顺序是先校验判断，有问题则抛出具体的异常信息，最后执行具体的业务操作，返回成

功信息。

1. 在统一异常处理类中去捕获异常，无需controller捕获异常，向用户返回统一规范的响应信息

例:

```java
public Result add(CmsPage cmsPage){
//校验cmsPage是否为空
if(cmsPage == null){
//抛出异常，非法请求
//...
}
//根据页面名称查询（页面名称已在mongodb创建了唯一索引）
CmsPage cmsPage1 =
cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(),
cmsPage.getSiteId(), cmsPage.getPageWebPath());
//校验页面是否存在，已存在则抛出异常
if(cmsPage1 !=null){
//抛出异常，已存在相同的页面名称
//...
}
cmsPage.setPageId(null);//添加页面主键由spring data 自动生成
CmsPage save = cmsPageRepository.save(cmsPage);
//返回结果
CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS,save);
return cmsPageResult;
}
```

![](https://raw.githubusercontent.com/MyBigDaXin/BlogPic/master/item20190916105928.png)

## 数据库设计

### 基础设计

- 表存储引擎必须使用InnoDB
- 表字符集默认使用utf8，必要时候使用utf8mb4

### 命名规范

- 库名，表名，列名必须用小写，采用下划线分隔
- 库名，表名，列名必须见名知义，长度不要超过32字符
- 表达是与否概念的字段，必须使用 is_xxx的方式命名，数据类型是unsigned tinyint（1表示是， 0表示否）。

### 表设计规范

- 禁止使用外键，如果要保证完整性，应由应用程式实现

### 列设计规范

- 根据业务区分使用tiny int/int/bigint，分别会占用1/4/8字节
- 根据实际的业务情况选择合适的字符存储长度 age tinyint unsigned
- 根据业务区分使用char/varchar

> 1. 字段长度固定，或者`长度近似`的业务场景，适合使用char，能够减少碎片，查询性能高
> 2. 字段长度相差较大，或者`更新较少`的业务场景，适合使用varchar，能够减少空间

- 必须把字段定义为NOT NULL并设默认值
- 根据业务区分使用datetime/timestamp

> 前者占用5个字节，后者占用4个字节，存储年使用YEAR，存储日期使用DATE，存储时间使用datetime

- 使用varchar(20)存储手机号，不要使用整数

> 1. 牵扯到国家代号，可能出现+/-/()等字符，例如+86
> 2. 手机号不会用来做数学运算
> 3. varchar可以模糊查询，例如like ‘138%’

- 使用TINYINT来代替ENUM
- 所有存储相同数据的列名和列类型必须一致（一般作为关联列，如果查询时关联列类型不一致会自动进行数据类型隐式转换，会造成列上的索引失效，导致查询效率降低）
- 小数类型为decimal

### 索引规范

- `唯一`索引使用uniq_[字段名]来命名
- `非唯一`索引使用idx_[字段名]来命名
- 单张表索引数量建议控制在5个以内
- 不建议在频繁更新的字段上建立索引
- 非必要不要进行JOIN查询，如果要进行JOIN查询，被JOIN的字段必须`类型相同`，并`建立索引`
- 理解组合索引`最左前缀原则`，避免重复建设索引，如果建立了(a,b,c)，相当于建立了(a), (a,b), (a,b,c)

> 最左前缀可以是联合索引的`最左N个字段`，也可以是字符串索引的`最左M个字符`

### SQL规范

- 禁止使用select *，只获取必要字段
- insert必须指定字段，禁止使用insert into T values()
- 禁止在where条件列使用函数或者表达式 这样`不会走索引`
- 禁止负向查询以及%开头的模糊查询
- 在删除数据的时候`尽量加limit`，这样不仅可以控制删除数据的条数，让操作更安全，还可以减小加锁的范围

### 更多

https://www.cnblogs.com/huchong/p/10219318.html#_label1

## 编程约束

### 命名风格

#### 接口与抽象类

- 接口类中的方法和属性不要加任何修饰符号（public 也不要加）
- 抽象类命名使用Abstract或Base开头；异常类命名使用Exception结尾；测试类命名以它要测试的类的名称开始，以Test结尾
- 类名使用UpperCamelCase风格，但以下情形例外：DO / BO / DTO / VO / AO / PO / UID等

#### 各层的命名规约

Service/DAO层方法命名规约 

1. 获取单个对象的方法用get做前缀。 
2. 获取多个对象的方法用list做前缀，复数形式结尾如：listObjects。 
3. 获取统计值的方法用count做前缀。
4. 插入的方法用save/insert做前缀。 
5. 删除的方法用remove/delete做前缀。 
6. 修改的方法用update做前缀

### 面向对象

- 所有的POJO类属性必须使用包装数据类型
- 定义DO/DTO/VO等POJO类时，不要设定任何属性默认值


- 序列化类新增属性时，请不要修改serialVersionUID字段
- `构造方法`里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在init方法
- 禁止在 POJO类中，同时存在对应属性 xxx的 isXxx()和 getXxx()
- 在getter/setter方法中，不要增加业务逻辑

### 开发编码

- 类型与中括号紧挨相连来 表示数组 int[] √   int arr[] ×
- Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals

### 异常处理

- Java 类库中定义的可以通过预检查方式规避的RuntimeException异常不应该通过catch 的方式来处理

  如NullPointerException，IndexOutOfBoundsException 对于NullPointerException: if(obj != null)

- 使用JDK8的Optional类来防止NPE问题​

### 注释规范

#### 方法注释

> 对于注释的要求：
>
> 第一、能够准确反应设计思想和代码逻辑 
>
> 第二、能够描述业务含义，使别的程序员能够迅速了解到代码背后的信息



- 类、类属性、类方法的注释必须使用 Javadoc 规范，使用如下方式，不得使用// xxx 方式
  - 类 使用第一个
  - 类方法使用第二个 除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能
  - 类属性 使用第三个

```java
// 1.
/**
 * @author admin
 * @version 1.0.0
 * @Description TODO
 * @createTime ${YEAR}年${MONTH}月${DAY}日
 */
// 2. 
/**
 * @title $title$
 * @description $description$
 * @author admin $param$
 * @updateTime $date$ $TIME$ $return$
 * @throws $throws$
 */
// 3
/**
 *
 */
```

- 方法内的注释使用单行注释，双斜线后面需要加一行空格

```java
// 单行注释例子
```

#### 日志

- 对trace/debug/info级别的日志输出，必须使用条件输出形式或者使用占位符的方式。

```java
if (logger.isDebugEnabled()) {
logger.debug("Processing trade with id: " + id + " and symbol: " + symbol);
}
// 或者
logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
```

