

## Schema

[TOC]



- DTD的替代品，比 DTD 更加强大 ,常用

```scheme
<xs:element name="note">

<xs:complexType>
<xs:sequence>
<xs:element name="to" type="xs:string"/>
<xs:element name="from" type="xs:string"/>
<xs:element name="heading" type="xs:string"/>
<xs:element name="body" type="xs:string"/>
</xs:sequence>
</xs:complexType>

</xs:element>
```

- 定义部分
  - 定义可出现在文档中的元素
  - 定义可出现在文档中的属性
  - 定义哪个元素是子元素
  - 定义子元素的次序
  - 定义子元素的数目
  - 定义元素是否为空，或者是否可包含文本
  - 定义元素和属性的数据类型
  - 定义元素和属性的默认值以及固定值
- 推荐Schema理由
  - XML Schema 可针对未来的需求进行扩展
  - XML Schema 更完善，功能更强大
  - XML Schema 基于 XML 编写
  - XML Schema 支持数据类型
  - XML Schema 支持命名空间
- DTD  和  Schema

```xml-dtd
DTD

<!ELEMENT note (to, from, heading, body)>
<!ELEMENT to (#PCDATA)>
<!ELEMENT from (#PCDATA)>
<!ELEMENT heading (#PCDATA)>
<!ELEMENT body (#PCDATA)> 

Schema

<?xml version="1.0"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
targetNamespace="http://www.w3schools.com"
xmlns="http://www.w3schools.com"
elementFormDefault="qualified">

<xs:element name="note">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="to" type="xs:string"/>
      <xs:element name="from" type="xs:string"/>
      <xs:element name="heading" type="xs:string"/>
      <xs:element name="body" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>

</xs:schema> 
```



##  元素

>  指定命名空间
>
>  xsi:targetNamespace="http://www.runoob.com" 
>
>  不指定
>
>  xsi:noNamespaceSchemaLocation="......"

```
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
        <--指定元素使用时必须用命名空间限定-->
           elementFormDefault="qualified"
attributeFormDefault="unqualified" targetNamespace="/233/233">
```



> xmlns:xs="http://www.w3.org/2001/XMLSchema" 

显示元素和数据类型来自那个命名空间



> xmlns="http://www.runoob.com" 

指出默认命名空间

## 元素组

```
<xs:group name="...">
包含多个元素及其约束
</xs:group>

引用
<xs:group ef="元素组名称"/>
```

## 属性

> 只有xs:complexType才有属性
>
> name,type,default,fixed,ref,use

## 注释

> <!--注释-->
>
> <annotation>
>
> <documentation>
>
> <appinfo>
>
> </annotation>

## XML文档应用Schema



```scheme
<--默认命名空间-->
<note xmlns="http://www.runoob.com"
<--可用的实例命名空间-->
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
<--需要与Schema的targetnamespace一致-->
xsi:schemaLocation="http://www.runoob.com note.xsd">

eg
指定标签的命名空间
xmlns:s="233"
```



## 简易元素

简易元素指那些仅包含文本的元素。它不会包含任何其他的元素或属性。 

> <xs:element name="xxx" type="yyy"/> 

* 常用的数据类型

  * xs:string
  * xs:decimal
  * xs:integer
  * xs:boolean
  * xs:date
  * xs:time

* 可以使用default="default"指定默认值，fixed="fixed"指定固定值

  

  

  ## XSD属性  

  > //定义属性
  >
  > <xs:attribute name="xxx" type="yyy"/> 

* 同样有默认值和固定值选项

* use="required"指定为必需属性

* 可以使用facet 为内容添加限制

## XSD限定/Facets

对于内容的限定

* 对于值的限定

```xml
 <xs:element name="age">
  <xs:simpleType>
    <xs:restriction base="xs:integer">
      <xs:minInclusive value="0"/>
      <xs:maxInclusive value="120"/>
    </xs:restriction>
  </xs:simpleType>
</xs:element>

```



* 对一组值的限定

```xml
<xs:element name="car">
  <xs:simpleType>
    <xs:restriction base="xs:string">
      <xs:enumeration value="Audi"/>
      <xs:enumeration value="Golf"/>
      <xs:enumeration value="BMW"/>
    </xs:restriction>
  </xs:simpleType>
</xs:element> 
```



* 模式约束

```xml
<xs:element name="letter">
  <xs:simpleType>
    <xs:restriction base="xs:string">
      <xs:pattern value="[a-z]"/>
    </xs:restriction>
  </xs:simpleType>
</xs:element> 

可以换为
大写字母 A - Z 其中的三个
<xs:pattern value="[A-Z][A-Z][A-Z]"/>

大写或小写字母 a - z 其中的三个
 <xs:pattern value="[a-zA-Z][a-zA-Z][a-zA-Z]"/>

字母 x, y 或 z 中的一个
<xs:pattern value="[xyz]"/>



```



* 对于空白符的限定
  <xs:whiteSpace value="preserve"/>
  可选  
  1. "replace"，这意味着 XML 处理器将移除所有空白字符（换行、回车、空格以及制表符）
  2. "collapse"，这意味着 XML 处理器将移除所有空白字符（换行、回车、空格以及制表符会被替换为空格，开头和结尾的空格会被移除，而多个连续的空格会被缩减为一个单一的空格
* 对一系列值的其他限定

> a - z 中零个或多个字母     
>
> <xs:pattern value="([a-z])*"/>
>
> "sToP"将会通过这种模式的验证，但是 "Stop"、"STOP" 或者 "stop" 无法通过验证 
>
> ​    <xs:pattern value="([a-z][A-Z])+"/>  
>
> 可接受的值是 male 或者 female 
>
> <xs:pattern value="male|female"/> 

* 长度的限定

> ​    <xs:length value="8"/> 



| 限定           | 描述                                                      |
| -------------- | --------------------------------------------------------- |
| enumeration    | 定义可接受值的一个列表                                    |
| fractionDigits | 定义所允许的最大的小数位数。必须大于等于0。               |
| length         | 定义所允许的字符或者列表项目的精确数目。必须大于或等于0。 |
| maxExclusive   | 定义数值的上限。所允许的值必须小于此值。                  |
| maxInclusive   | 定义数值的上限。所允许的值必须小于或等于此值。            |
| maxLength      | 定义所允许的字符或者列表项目的最大数目。必须大于或等于0。 |
| minExclusive   | 定义数值的下限。所允许的值必需大于此值。                  |
| minInclusive   | 定义数值的下限。所允许的值必需大于或等于此值。            |
| minLength      | 定义所允许的字符或者列表项目的最小数目。必须大于或等于0。 |
| pattern        | 定义可接受的字符的精确序列。                              |
| totalDigits    | 定义所允许的阿拉伯数字的精确位数。必须大于0。             |
| whiteSpace     | 定义空白字符（换行、回车、空格以及制表符）的处理方式。    |

##  复合元素

* 四种复合元素
  * 空元素
  * 包含其他元素的元素
  * 仅包含文本的元素
  * 包含元素和文本的元素
* 例子

```
<description>
It happened on <date lang="norwegian">03.03.99</date> ....
</description> 
```

* 定义

```
<xs:element name="employee">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element> 
```



```
<xs:element name="employee" type="personinfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
  </xs:sequence>
</xs:complexType> 
```



在已有的复合元素之上以某个复合元素为基础，然后添加一些元素 

```
<xs:element name="employee" type="fullpersoninfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
  </xs:sequence>
</xs:complexType>

<xs:complexType name="fullpersoninfo">
  <xs:complexContent>
    <xs:extension base="personinfo">
      <xs:sequence>
        <xs:element name="address" type="xs:string"/>
        <xs:element name="city" type="xs:string"/>
        <xs:element name="country" type="xs:string"/>
      </xs:sequence>
    </xs:extension>
  </xs:complexContent>
</xs:complexType> 
```

仅含文本

```
<xs:element name="shoesize" type="shoetype"/>

<xs:complexType name="shoetype">
  <xs:simpleContent>
    <xs:extension base="xs:integer">
      <xs:attribute name="country" type="xs:string" />
    </xs:extension>
  </xs:simpleContent>
</xs:complexType> 
```



##  XSD混合内容

```
<xs:element name="letter">
  <xs:complexType mixed="true">
    <xs:sequence>
      <xs:element name="name" type="xs:string"/>
      <xs:element name="orderid" type="xs:positiveInteger"/>
      <xs:element name="shipdate" type="xs:date"/>
    </xs:sequence>
  </xs:complexType>
</xs:element> 
```

> **注意：** 为了使字符数据可以出现在 "letter" 的子元素之间，mixed 属性必须被设置为 "true" 



##  XSD 指示器

> 通过指示器，我们可以控制在文档中使用元素的方式

* Order 指示器：

  > 定义元素的顺序 

  - All    

    ```
    规定子元素可以按照任意顺序出现，且每个子元素必须只出现一次
    <xs:element name="person">
      <xs:complexType>
        <xs:all>
          <xs:element name="firstname" type="xs:string"/>
          <xs:element name="lastname" type="xs:string"/>
        </xs:all>
      </xs:complexType>
    </xs:element> 
    ```

    

  - Choice

    ```
    可出现某个子元素或者可出现另外一个子元素（非此即彼）
    <xs:element name="person">
      <xs:complexType>
        <xs:choice>
          <xs:element name="employee" type="employee"/>
          <xs:element name="member" type="member"/>
        </xs:choice>
      </xs:complexType>
    </xs:element> 
    ```

    

  - Sequence

    ```
    子元素必须按照特定的顺序出现
    <xs:element name="person">
       <xs:complexType>
        <xs:sequence>
          <xs:element name="firstname" type="xs:string"/>
          <xs:element name="lastname" type="xs:string"/>
        </xs:sequence>
      </xs:complexType>
    </xs:element> 
    ```

    

  ------

* Occurrence 指示器：

  > 定义某个元素出现的频率 

  * maxOccurs

    ```
    某个元素可出现的最大次数
    出现次数不受限制，请使用 maxOccurs="unbounded" 这个声明
    <xs:element name="person">
      <xs:complexType>
        <xs:sequence>
          <xs:element name="full_name" type="xs:string"/>
          <xs:element name="child_name" type="xs:string" maxOccurs="10"/>
        </xs:sequence>
      </xs:complexType>
    </xs:element> 
    ```

    

  * minOccurs

    > 某个元素能够出现的最小次数 

* Group 指示器：

  > 定义相关的数批元素

  * Group name

    ```
    定义了必须按照精确的顺序出现的一组元素
    
    <xs:group name="persongroup">
      <xs:sequence>
        <xs:element name="firstname" type="xs:string"/>
        <xs:element name="lastname" type="xs:string"/>
        <xs:element name="birthday" type="xs:date"/>
      </xs:sequence>
    </xs:group>
    
    <xs:element name="person" type="personinfo"/>
    
    <xs:complexType name="personinfo">
      <xs:sequence>
        <xs:group ref="persongroup"/>
        <xs:element name="country" type="xs:string"/>
      </xs:sequence>
    </xs:complexType> 
    ```

    

  * attributeGroup name

    ```
    
    <xs:attributeGroup name="personattrgroup">
      <xs:attribute name="firstname" type="xs:string"/>
      <xs:attribute name="lastname" type="xs:string"/>
      <xs:attribute name="birthday" type="xs:date"/>
    </xs:attributeGroup>
    
    <xs:element name="person">
      <xs:complexType>
        <xs:attributeGroup ref="personattrgroup"/>
      </xs:complexType>
    </xs:element> 
    ```

    

## XSD <any> 元素

<any> 元素使我们有能力通过未被 schema 规定的元素来拓展 XML 文档！ 

```
<xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
      <xs:any minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>
</xs:element> 
```

##  XSD <anyAttribute> 元素

<anyAttribute> 元素使我们有能力通过未被 schema 规定的属性来扩展 XML 文档！ 



##  XSD 元素替换(Element Substitution)

* 元素替换

  <xs:element name="name" type="xs:string"/>
 <xs:element name="navn" substitutionGroup="name"/> 

在上面的例子中，"name" 元素是主元素，而 "navn" 元素可替代 "name" 元素。

* 阻止元素替换

> <xs:element name="name" type="xs:string" block="substitution"/> 

* 全局元素

指 "schema" 元素的直接子元素！本地元素（Local elements）指嵌套在其他元素中的元素。 

substitutionGroup 中的所有元素（主元素和可替换元素）必须被声明为全局元素，否则就无法工作 



#  XSD 字符串 数据类型

* <xs:element name="customer" type="xs:string"/> 
* <xs:element name="customer"type="xs:normalizedString"/> 

>  会使用空格替换所有的制表符 

* <xs:element name="customer" type="xs:token"/> 

>  XML 解析器会移除制表符 

| 名称             | 描述                                                         |
| ---------------- | ------------------------------------------------------------ |
| ENTITIES         |                                                              |
| ENTITY           |                                                              |
| ID               | 在 XML 中提交 ID 属性的字符串 (仅与 schema 属性一同使用)     |
| IDREF            | 在 XML 中提交 IDREF 属性的字符串(仅与 schema 属性一同使用)   |
| IDREFS language  | 包含合法的语言 id 的字符串                                   |
| Name             | 包含合法 XML 名称的字符串                                    |
| NCName           |                                                              |
| NMTOKEN          | 在 XML 中提交 NMTOKEN 属性的字符串 (仅与 schema 属性一同使用) |
| NMTOKENS         |                                                              |
| normalizedString | 不包含换行符、回车或制表符的字符串                           |
| QName            |                                                              |
| string           | 字符串                                                       |
| token            | 不包含换行符、回车或制表符、开头或结尾空格或者多个连续空格的字符串 |

* 限定
  * enumeration
  * length
  * maxLength
  * minLength
  * pattern (NMTOKENS、IDREFS 以及 ENTITIES 无法使用此约束)
  * whiteSpace

##  内置基本数据类型

> 字符串
>
> string ,  QName
>
> 数值
>
> decimal   float   double   hexBinary
>
> boolean
>
> anyURI

##  内置扩展数据类型

> NMTOKEN   NMTOKENS    ID   IDREF   ENTITY   ENTITYS
>
> normalizedString  



##  XSD 日期和时间数据类型

> <xs:element name="start" type="xs:date"/> 
>
> <start>2002-09-24</start> 
>
> <xs:element name="start" type="xs:time"/> 
>
> <start>09:30:10.5</start> 

* 时区

```
1. 在日期时间后加一个 "Z" 
<startdate>2002-05-30T09:30:10Z</startdate>
2. 在时间后添加一个正的或负时间的方法，来规定以世界调整时间为准的偏移量
<startdate>2002-05-30T09:30:10-06:00</startdate>

或者

<startdate>2002-05-30T09:30:10+06:00</startdate> 
```

* 时间间隔

  时间间隔使用下面的格式来规定："PnYnMnDTnHnMnS" 

```

    P 表示周期(必需)
    nY 表示年数
    nM 表示月数
    nD 表示天数
    T 表示时间部分的起始 （如果您打算规定小时、分钟和秒，则此选项为必需）
    nH 表示小时数
    nM 表示分钟数
    nS 表示秒数

```



```
<xs:element name="period" type="xs:duration"/> 

<period>P5Y2M10D</period> 

<period>-P10D</period> 
```



| 名称       | 描述                                  |
| ---------- | ------------------------------------- |
| date       | 定义一个日期值                        |
| dateTime   | 定义一个日期和时间值                  |
| duration   | 定义一个时间间隔                      |
| gDay       | 定义日期的一个部分 - 天 (DD)          |
| gMonth     | 定义日期的一个部分 - 月 (MM)          |
| gMonthDay  | 定义日期的一个部分 - 月和天 (MM-DD)   |
| gYear      | 定义日期的一个部分 - 年 (YYYY)        |
| gYearMonth | 定义日期的一个部分 - 年和月 (YYYY-MM) |
| time       | 定义一个时间值                        |

* 限定
  * enumeration
  * maxExclusive
  * maxInclusive
  * minExclusive
  * minInclusive
  * pattern
  * whiteSpace

##  XSD  数值数据类型

| 名字               | 秒数                               |
| ------------------ | ---------------------------------- |
| byte               | 有正负的 8 位整数                  |
| decimal            | 十进制数                           |
| int                | 有正负的 32 位整数                 |
| integer            | 整数值                             |
| long               | 有正负的 64 位整数                 |
| negativeInteger    | 仅包含负值的整数 ( .., -2, -1.)    |
| nonNegativeInteger | 仅包含非负值的整数 (0, 1, 2, ..)   |
| nonPositiveInteger | 仅包含非正值的整数 (.., -2, -1, 0) |
| positiveInteger    | 仅包含正值的整数 (1, 2, ..)        |
| short              | 有正负的 16 位整数                 |
| unsignedLong       | 无正负的 64 位整数                 |
| unsignedInt        | 无正负的 32 位整数                 |
| unsignedShort      | 无正负的 16 位整数                 |
| unsignedByte       | 无正负的 8 位整数                  |

限定

- enumeration
- fractionDigits
- maxExclusive
- maxInclusive
- minExclusive
- minInclusive
- pattern
- totalDigits
- whiteSpace

##  其他数据类型

<xs:attribute name="disabled" type="xs:boolean"/> 

<xs:element name="blobsrc" type="xs:hexBinary"/> 

<xs:attribute name="src" type="xs:anyURI"/> 

##  自定义数据类型

```
<xs:simpleType>
限制  <xs:restriction>
列表   <xs:list>
联合   <xs:union>
<xs:complexType>
顺序   <xs:sequence>
选择   <xs:choice>
无序   <xs:all>
简单内容   <xs:simpleContent> 限制   扩展
复杂内容   <xs:complexContent> 限制   扩展
```

