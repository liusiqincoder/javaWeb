#   Schema高级

## 元素替换  substitutionGroup

条件：全局元素，相同元素

## 抽象元素和抽象类型

abstract="true"指定抽象元素

xsi:type="...."指定抽象类型的派生类

##  限制替换元素和限制派生元素

final="#all | extension | restriction | extension&restriction"

## schema复用

```
包含文件和被包含文件属于同一命名空间
<xs:include schemaLocation="..."/>
<xs:redefine schemaLocation="..."/>
包含文件和被包含文件不属于同一命名空间
<xs:import schemaLocation="..." namespace="...."/>
```

## 空元素表示

> minOccurs="0" 空元素
>
> nillable="true"