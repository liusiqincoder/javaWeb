## 运行时数据区域

![image](https://github.com/liusiqincoder/javaWeb/blob/master/jvm/picture/运行时数据区.png)

*  `程序计数器`  每个线程都有一个，负责分支，循环，跳转，异常恢复，线程恢复  
*  `虚拟机栈`   （栈内存和堆内存）用于存储局部变量表，操作数栈，动态链接，方法出口等  
*  `本地方法栈`   和虚拟机栈差不多，只是为本地方法服务，同样会抛出StackOverflowError和OutOfMemoryError异常  
*  `堆`  线程共享的一块内存区域，对象实例和数组在堆上分配  
*  `方法区`  （也可以叫做永久代）也是线程共享区域，存储虚拟机加载的类信息，常量，静态变量，JIT编译后的代码  
           可以通过参数`-XX:MaxpermSize`指定大小   
*  `运行时常量池`  （方法区的一部分）存放编译器生成的各种字面量和符号引用  
*  `直接内存`  堆外内存，不是虚拟机运行时数据区的一部分  

##  对象的创建  
new  
1. 检查指令的参数能否定位到常量池中的一个类的符号引用，并检查类信息  
2. 堆上分配内存  
  *  CAS配上失败重试  
  *  本地线程分配缓冲（TLAB） 通过`-XX:+/-UseTLAB`设定
  
##  对象的内存布局  
对象头+实例数据+对齐填充  

对象头   运行时数据+类型指针（指向类元的指针）  

##  对象的访问定位  
* 句柄访问（稳定地地址，常用）  

![image](https://github.com/liusiqincoder/javaWeb/blob/master/jvm/picture/句柄访问.png)  

*  直接指针访问（速度快）  


![image](https://github.com/liusiqincoder/javaWeb/blob/master/jvm/picture/直接指针访问.png) 

##  堆内存问题地思路  
用内存映像分析工具确定问题类型  
* 内存泄露  
进一步查看对象到GC Roots的引用链  
* 内存溢出  
调大虚拟机参数-Xmx和-Xms （物理内存允许）  

##  虚拟机栈和本地方法溢出  
* 栈深度溢出  StackOverflowError  -Xss  
* 堆内存溢出  OuOfMemoryError   

##  本机直接内存溢出  
可通过-XX:MaxDirectMemorySize指定  默认与堆最大内存一样  
