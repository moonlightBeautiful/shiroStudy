# shiroStudy
权限简介：
    也就是访问控制，即在应用中控制谁能访问哪些资源。
1.权限认证核心三要素:
    权限、角色、用户
        权限：操作资源的权利，比如访问某个页面，以及对某个模块的资源的增删改查。
        角色：权限的集合，一个角色可以包含多种权限。
        用户：在shiro中，代表访问系统的用户，即subject。
2.授权：
    3中授权方式：这里对编程式授权进行了编码，其他授权方式目前了解就好
    权限相关的方法
        hasRole、hasRoles、hasAllRoles、checkRole、checkRoles
        isPermitted、isPermittedAll、checkPermission、checkPermissions
    1.编程式授权：在代码中判断用户是否有角色或者权限 role、permission相关的方法
        1.基于角色的访问控制：hasRole、hasRoles、hasAllRoles、checkRole、checkRoles
        2.基于权限的访问控制:isPermitted、isPermittedAll、checkPermission、checkPermissions
    2.注解式授权：需要java5+
        1.@RequiresAuthentication   要求当前 Subject 已经在当前的 session 中被验证通过才能被访问或调用。
        2.@RequiresGuest    要求当前的 Subject 是一个"guest"，也就是说，他们必须是在之前的 session 中没有被验证或被记住才
                            能被访问或调用
        3.@RequiresPermissions("account:create")    要求当前的 Subject 被允许一个或多个权限，以便执行注解的方法。
        4.@RequiresRoles("administrator")   要求当前的 Subject 拥有所有指定的角色。如果他们没有，则该方法将不会被执行，而 且 AuthorizationException 异常将会被抛出。
        5.@RequiresUser 注解需要当前的 Subject 是一个应用程序用户才能被注解的类/实例/方法访问或调用。一个“应
                        用程序用户”被定义为一个拥有已知身份，或在当前 session 中由于通过验证被确认，或者在之前 session 中的'RememberMe'
                        服务被记住
    3.jsp标签授权：
        jsp需要引入：
            <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
        标签 <shiro:标签> 满足才会输出 </shiro:标签>
            Guest 标签：用户没有身份验证时显示相应信息，即游客访问信息；
            User 标签：用户已经身份验证/记住我登录后显示相应的信息；
            Authenticated 标签：用户已经身份验证通过，即 Subject.login 登录成功，不是记住我登录的。
            notAuthenticated 标签：用户没有身份验证通过，即没有调用 Subject.login 进行登录，包括记住我自动登录
            的也属于未进行身份验证。
            principal 标签 显示用户身份信息，默认调用 Subject.getPrincipal()获取，即 Primary Principal。
            hasRole 标签 如果当前 Subject 有角色将显示 body 体内容。
            lacksRole 标签 如果当前 Subject 没有角色将显示 body 体内容。
            hasAnyRoles 标签 如果当前 Subject 有任意一个角色（或的关系）将显示 body 体内容。
            hasPermission 标签 如果当前 Subject 有权限将显示 body 体内容。
            lacksPermission 标签 如果当前 Subject 没有权限将显示 body 体内容。        
3.授权流程图
    授权流程：
        subject.isP../hasR。通俗的讲，就是在securityManager中调用authorizer从realm查看用户有哪些角色和权限。
4.权限定义，资源:权限:[实例]
    权限控制：一般就用这个
        单个权限
            user:query
        单个资源多个权限 
            user:query 
            user:add 
            或者多值 
            user:query,add
        单个资源所有权限 
            user:query,add,update,delete  
            或者
            user:*
        所有资源某个权限 
            *:view
    更加精细，实例级别的权限控制：
        单个实例的单个权限，lp7200和epsoncolor是实例
            printer:query:lp7200 
            printer:print:epsoncolor
        所有实例的单个权限 
            printer:print:*
        所有实例的所有权限 
            printer:*:*
        单个实例的所有权限 
            printer:*:lp7200
        单个实例的多个权限 
            printer:query,print:lp7200
           
