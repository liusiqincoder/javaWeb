*2018.9.3  入门知识*

脚本元素  注释功能
<ul>jsp+JavaBean模式
<li>jsp出来页面
<li>JavaBean处理数据
 </ul>
 
jsp+JavaBean+Servlet模式

#  JSP语法

##  1. <ul>JSP页面：
     <li>静态部分（css和html）
     <li>动态部分    
                   注释<!--注释--> 或<%--注释--%>
                   
                   指令<%@-----%>
                      page指令 语法<%@ page 属性名1="属性值" 属性名2="属性值" .....%>
                           page指令属性有language，extends,import,pageEncoding,contentType,session,
                           buffer,autoFlush,isErrorPage,errorPage,isThreadSafe,isELIgnored,include
                           
                   脚本<%java代码%>
                   
                   表达式<%=java表达式%>
                   
                   声明<%!声明一个Java类或者方法%>
                   
                   动作<jsp:动作名>开始，</jsp:动作名>结束
                       
                       <jsp:useBean>html代码和Java代码相分离，创建一个javaBean实例
                           语法：<jsp:useBean id="name" scope="page|request|session|application"
                                    class="page.class" beanName="beanName"/>(创建类为page.class的名为name的类实例)
                                    
                       <jsp：setProperty name="beanName" property="propertyName" value="value">
                             为name实例的propertyName赋值value(同样有<jsp：getProperty....>)
                             </ul>
<b>响应模式  客户端发送HTTP请求，服务器发送HTTP响应</b>

##   2. <ul>jsp内置对象（9个）   
        <li>request 接受客户端发送来的请求信息（只包含HTTP报文的头部数据）
        
                        表单提交方式：post（携带数据,数据量大，安全性高）和get（相反)
                        主要方法：getParameter(),getParameter(String name),setAttribute(Key,value)....
         <li>response 向客户端发送数据
                        主要方法：encodeRedirectURL(String URL),encodeURL(url).....
                                 sendRedirect(String Location)使用之前不能有信息输出
                                 
                                 
                        <b>两个页面不属于同一个request,URL地址栏会改变,forward相反
                                      
                        <b>PrintWriter输出总是提前于内置的out对象
                        
                        设置字符编码优先级：setCharacterEncoding,setContentType,默认ISO-8859-1
                        
          <li>out对象  JspWriter类的实例  
                         方法：println(),clear(),flush(),clearBuffer(),getBufferSize()...
                         
                         
           <li>session  客户端与服务器的一次会话，是时间概念，指用户使用浏览的这段时间
                             HttpSession类的实例
                          方法：getCreationTime(),getId()....
                          <ul>生命周期：<li>1.会话中打开的超链接都属于同一个会话
                                   <li>2.只要当前会话没有关闭，重新打开浏览器窗口访问统一资源项目时属于同一次会话
                                   <li>3.将本次会话的所有界面关闭，再访问才属于不同会话
                                   （旧会话还存在服务器，等到超时）
               <ul>销毁：<li>1.调用session.invalidate()
                <li>2.session过期
                <li>3.服务器重启</ul>
            <li>application  （servletContext实例）实现用户间的数据共享，可存放全局变量。开始于服务器启动，终止与服务器关闭
                          方法：setAttribute(name,value),getServerInfo()
                          
             <li>page 保存当前页面信息
                    
             <li>pageContext 可以访问本页面的所有对象
                          方法：getOut(),getPage()...setAttribute(name,attribute),include(url),forward(url)
                          
             <li>config servlet初始化时jsp向他传递信息的一个对象，包括servlet初始化需要的信息和服务器信息
                          方法：个体Servlet Context(),getInitParameter(name),....
                          
              <li>Exception 页面运行异常时产生，必须把isErrorPage设置为true,才能应用
                    
                          方法：getMessage(),toString()...
                             setHeader(name,value),可以设置响应头(Refresh,刷新间隔)

<li>Cookie 由服务器写到客户端的小文件或字符串

      方法:Cookie(name,value),getName(),getMaxAge(int)
      服务器设置Cookie到客户端response.addCookie(Cookie)
      </ul>
      
##  3. URL重写    浏览器不支持或用户禁用Cookie,客户发送的请求将不包含Cookie中的sessionID
          此时，客户程序将会在URL尾部添加额外数据标志当前会话

Header (request方法)包含请求的附加信息和客户端信息 Enumeration request.getHeaderName() 

##  4. JavaBean技术    *提高代码的重用性*

    <li>不可视JavaBean：值JavaBean（封装表单数据）和工具Javabean(封装业务逻辑)
    <li>可视Javabean
       
       
       规范：1.实现可序列化接口  2.公共无参构造方法  3.类的声明是非final类
       使用<jsp:useBean>创建JavaBean  语法：
             <jsp:useBean id="beanName" class="classPath" sope="page|Request|Session|Application"/>
 
##  5. <ul>EL表达式   

语法格式：${expression}
       在jsp网页中必须以"/${"开头，或"${'${'}"
       
<ul>特点：
<li>（1）EL语法简单，方便
<li>（2）EL可以与JSTL结合使用，也可以和JavaScript语句结合使用。
<li>（3）EL可以自动转换类型。
<li>（4）EL既可以访问一般的变量，也可以访问JavaBean中的属性和嵌套属性、集合对象。
<li>（5）EL中可以执行算术运算、逻辑运算、关系运算和条件运算等。
<li>（6）EL中可以获得命名空间（PageContext对象，他是页面中所有其他内置对象的最大范围的集成对象，通过它可以访问其他内置对象）。
<li>（7）EL中在进行除法运算时，如果除数是0，则返回无穷大Infinity，而不返回错误。
<li>（8）EL中可以访问JSP的作用域（request、session、application以及page）
<li>（9）扩展函数可以与Java类的静态方法进行映射。
</ul>
    <b> 禁用EL
    
        1.使用'\'  即\$｛expression}   
        2.使用page  ,<%@ page isELIgnored="true">
        3.在web.xml配置<el-ignored>
        
<b>变量存取范围</b>  page(默认) request  session  application
        eg.  ${pageScope.usenme｝
 <b>访问数据</b>  
  
           1.${user[user-name]}
           2.访问数组    ${arrUser[0]}
           3.list集合读取 ${sessionScope.citys[0]}
           3.map集合读取  ${applicationScope.citys[0]}
           
<b>算术、关系、逻辑运算符，条件运算符   同java</b>
  
  empty运算符 判断对象或变量是否为空  ${not empty session.username}    
  
  隐含对象  pgeContext,param,header,cookie,pageScope
  
  (2108.9.15)
  ##  6.Servlet  *独立于平台和协议的特性，动态生成web页面*
        继承自HttpServlet（覆盖goGet和doPost方法）
        
 <ul> 功能；
 <li>(1) 创建并返回一个包含基于客户请求性质的动态内容的完整的 HTML 页面。
 <li>(2) 创建可嵌入到现有 HTML 页面中的一部分 HTML 页面（ HTML 片段）。
       <li>(3) 与其它服务器资源（包括数据库和基于 Java 的应用程序）进行通信。
       <li>(4) 用多个客户机处理连接，接收多个客户机的输入，并将结果广播到多个客户机上。
          例如， Servlet 可以是多参与者的游戏服务器。
       <li>(5) 当允许在单连接方式下传送数据的情况下，在浏览器上打开服务器至 applet 的新连接，
           并将该连接保持在打开状态。当允许客户机和服务器简单、高效地执行会话的情况下， a
           pplet 也可以启动客户浏览器和服务器之间的连接。可以通过定制协议或标准（如 IIOP ）进行通信。
       <li>(6) 对特殊的处理采用 MIME 类型过滤数据，例如图像转换和服务器端包括（ SSI ）。
       <li>(7) 将定制的处理提供给所有服务器的标准例行程序。例如， Servlet 可以修改如何认证用户。</ul>
       
  <b>生命周期<b>；加载，实例化，初始化(init())，处理客户请求(service())，卸载(destroy())
  
       初始化 init()
         以下情况Tomcat自动装入Servlet：已设置servlet的自动装入选项;客户的首次请求。（创建一个servlet实例并调用init）
       处理请求 service()
         对于客户机的请求，服务器会创建请求和相应对象
       终止 destroy()
    
    可继承以下接口
    
  javax.servlet.Servlet接口
  javax.servlet.GenericServlet接口
       与Http无关的Servlet，只需实现service（）即可实现
  javax.servlet.HttpServletRequest接口
       获取客户端的http请求
  javax.servlet.HttpServletResponse接口
       向客户端发送请求
  javax.servlet.HttpServlet接口
       通常继承此类开发servlet，只需实现doGet()和dopost（）方法
       
（2018.9.17）
##  7. 配置Servlet
   <li>在类上注解 格式为：@WebServlet("/URL")
   <li>配置web.xml
   
向客户输出信息

   PrintWriter out=response.getWriter();
   
Servlet生成HTML

   response.setContentType("text/html;charset=UTF-8")
   
接受客户提交参数

   request.getParameter(name);
   
获取内置对象  

     由HttpServletRequest获取session和application
     
  eg.  request.getSession();
       ServletContext context=getServletContext();
       
##  8. <b>实现include和forward动作需要使用RequestDispatcher对象</b>

  RequestDispatcher dispatcher=request.getRequestDispatcher("URL")//URL相对网站根路径则用/URL
  或者使用
     ServletContext sc=getServletContext();
     RequestDispatcher dispatcher=sc.getRequestDispatcher("URL")
     
  RequestDispatcher定义了forward(request,response)和include(request,response)
  
  <b>WEB-INF是一个安全目录，放在里面的JSP页面通过URl访问无效，但可以通过Requestdispatcher的forward访问
  
##  9. Servlet过滤器 
           服务器与客户端请求与响应的中间层组件，在实际项目开发中Servlet过滤器主要用于
             对浏览器的请求进行过滤处理，将过滤后的请求再转给下一个资源
             
     <ul>配置filter：
     <li>1.在web.xml映射为URL或者在java类中注释
     
                        语法：@WebFilter(dispatcherTypes=(DispatcherType.REQUEST,DispatcherType.FOEWARD,
                       DispatcherType.INCLUDE,DispatcherType.ERROR),urlPatterns={"/*"})
                <li>2.编写web.xml,在<filter></filter>（可多个）用<filter-name>和<filter-class>指定filter
    为filter设置url可以用<filter-mapping>的<filter-name>和<url-pattern>
    dispatcher可以指定过滤器的请求类型
    </ul>
 * Filter接口  init,doFilter,destroy *
  
  ##  10. 常用标签JSTL
<li>用taglib指令将JSTL库导入JSP<%@ taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core %>
    <li>输出标签 
          <c:out value="表达式" [escapeXML="true|false"] default="默认值" />
             escapeXML允许标签自动转义<,>,&之类的XML类型字符
    <li>迭代标签   c:forEach和c:forTokens
    
       c:forEach  items  制定遍历对象   var每次遍历时的变量名  
                  begin  遍历开始时的索引值     end。。。结束。。   step遍历步长
                  <c:forEach items="${test}" var="test" />
                  需要将request.setAttribute将items遍历的对象添加到页面中
                  
    <li>条件标签 c:if,c:choose,c:when,c:otherwise
    
        <c:if test="条件" />
        c:choose与c:when和c:otherwise标签一起使用，作用和switch-case-default差不多
        c:when和c:if差不多，有test,只要有一个c:when为true则执行后跳出c:choose
        c:otherwise当所有的c:when都为false才执行
        
     <li>变量操作符
     
         <c:set var="attributeName" value="someValue" [scope="varScope"] />
           或<c:set value="someValue" [scope="varScope"]>someValue</c:set>
           
         *对于对象  <c:set target="beanName" property="propertyName" [scope="varScope"]>someValue</c:set>*
         *如果c:set标签里的值为null,则相当把变量或对象的某个属性置为null*
             <c:remove var="attributeName" />
      <li>URL相关标签
      
         c:import  作用和include，jsp:include差不多，但后两者不能导入html全部页面，却不能导入其他服务器的html文件
                                                   但c:import能
               属性：url,context指明应用的上下文，var保存导入内容
                    scope指定变量的作用域，charEncoding导入资源使用的编码
         c:url   tomcat从Cookie读取SessionID或从url读取，c:url可以对url进行编码
            <c:url value="URL" [var="varName"] [scope="varScope"] [context="context"] />
            或 <c:url value.. [var...] [scope...] [context....] > [<c:param />] </c:url>
            
         c:param标签   为c:import,c:url和c:redirect提供参数
          <c:param name="paramName" value="paramValue" />
         c:redirect标签  <c:redirect url="URL" [context="context"]>  [<c:param />] </c:redirect>
  <li>自定义标签  需要定义以下3个组件：
  
      1.标签处理类  继承SimpleTagSupport
           必须有无参构造器，执行代码放在doTag里
      2.TLD文件  标签库描述文件
           向服务器标识这个类，并将其与特定的XML标记名称相关联。通过一个XML格式的TLD文件完成（放在WEB-INF目录下）
      3.使用标签库的JSP文件
    标签处理类   可以为自定义标签设置属性，在类内部的属性
                在tld里用attribute标记（name,required,[rtexprvalue]）,required为true但页面未设置该标签属性，页面翻译会出错
                标签体，想要使用标签体，需要在doTag里获取JspFragment实例调用  getJspBody().invoke(null)
