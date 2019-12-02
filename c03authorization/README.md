# shiroStudy
关于shiro的学习     
    授权：
        1.权限认证核心要素
            简介：
                也就是访问控制，即在应用中控制谁能访问哪些资源。
            核心三要素：
                权限、角色和用户、资源。
            权限：操作资源的权利，比如访问某个页面，以及对某个模块的资源的增删改查。
            角色：权限的集合，一个角色可以包含多种权限。
            用户：在shiro中，代表访问系统的用户，即subject。
        2.授权：这里对编程式授权进行了编码，其他授权方式目前了解就好
            1.编程式授权：在代码中判断是否有角色或者权限
                1.基于角色的访问控制
                2.基于权限的访问控制
            2.注解式授权：需要java5+
                1.@RequiresAuthentication
                2.@RequiresGuest
                3.@RequiresPermissions("account:create")
                4.@RequiresRoles("administrator")
                5.@RequiresUser
            3.jsp标签授权：
        3.授权流程图
            授权：subject.isP../hasR，通俗的讲，就是在securityManager中调用authorizer从realm查看用户有哪些角色和权限。
        4.对权限的深入了解
            权限控制：一般就用这个
                单个权限 query
                单个资源多个权限 user:query user:add 多值 user:query,add
                单个资源所有权限 user:query,add,update,delete user:*
                所有资源某个权限 *:view
            实例级别的权限控制
                单个实例的单个权限 printer:query:lp7200 printer:print:epsoncolor
                所有实例的单个权限 printer:print:*
                所有实例的所有权限 printer:*:*
                单个实例的所有权限 printer:*:lp7200
                单个实例的多个权限 printer:query,print:lp7200
           
