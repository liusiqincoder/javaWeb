[菜鸟教程](http://www.runoob.com/xml/xml-attributes.html)

[TOC]



## XML简介

* XML 指可扩展标记语言（e**X**tensible **M**arkup **L**anguage）。
* XML 被设计用来传输和存储数据。

`实例`

```XML

<?xml version="1.0" encoding="UTF-8"?>
<note>
  <to>Tove</to>
  <from>Jani</from>
  <heading>Reminder</heading>
  <body>Don't forget me this weekend!</body>
</note>

```



##   用途

* 分离Html的数据
* 简化数据共享
* 简化数据传输
* 简化平台变更
* 创建新的互联网语言



##  树结构

每个XML文档都有一个根元素，每个元素都可以有子元素



![image](http://www.runoob.com/wp-content/uploads/2013/09/nodetree.gif)

这样通过操作这棵树和这些对象就可以完成对 XML 文档的操作,为处理文档的所有方面提供了一个完美的概念性框架 

![DOM树](http://www.runoob.com/wp-content/uploads/2018/03/991342_1.jpg)

##  语法规则

1. ```xml
   声明
   <?xml version="1.0" encoding="utf-8"?>
   ```

2. 每个元素都得有关闭标签

3. 大小写敏感

4. 正确嵌套

5. 属性值必须加引号

6. 标签内特殊字符（<和&）需要转义

​    (没有空格)

|  & lt;  |  <   |   less than    |
| :-----: | :--: | :------------: |
|  & gt;  |  >   |  greater than  |
| & amp;  |  &   |   ampersand    |
| & apos; |  '   |   apostrophe   |
| & quot; |  "   | quotation mark |

8. 空格保留
9. 回车符（CR）和换行符（LF） 

## XML元素

* 命名规则
  * 名称可以包含字母、数字以及其他的字符
  * 名称不能以数字或者标点符号开始
  * 名称不能以字母 xml（或者 XML、Xml 等等）开始
  * 名称不能包含空格

> 避免使用 '`-`','`.`', '`:`',尽量使用'`_`'
>
> 实用的经验，即使用数据库的命名规则来命名 XML 文档中的元素 

* 可以添加XML无法识别元素，但正常数据不会受影响



## XML属性

`属性通常提供不属于数据组成部分的信息 `

同样，属性也需要加双引号

> 在 HTML 中，属性用起来很便利，但是在 XML 中，您应该尽量避免使用属性 

弊端

- 属性不能包含多个值（元素可以）
- 属性不能包含树结构（元素可以）
- 属性不容易扩展（为未来的变化）

> 理念是：元数据（有关数据的数据）应当存储为属性，而数据本身应当存储为元素 

##  DTD

定义 XML 文档的结构 

```xml-dtd
<!DOCTYPE note
[
<!ELEMENT note (to,from,heading,body)>
<!ELEMENT to (#PCDATA)>
<!ELEMENT from (#PCDATA)>
<!ELEMENT heading (#PCDATA)>
<!ELEMENT body (#PCDATA)>
]>
```

## XML验证

XML 文档中的错误会终止您的 XML 应用程序

所以必须验证才能用，浏览器可以查看和验证错误

##  使用XSLT显示XML

* XSLT 是首选的 XML 样式表语言。
* XSLT（eXtensible Stylesheet Language Transformations）远比 CSS 更加完善。
* XSLT 是在浏览器显示 XML 文件之前，先把它转换为 HTML
* 在使用 XSLT 来转换 XML 时，不同的浏览器可能会产生不同结果。为了减少这种问题，可以在服务器上进行 XSLT 转换。 

