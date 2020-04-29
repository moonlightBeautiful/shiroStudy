# shiroStudy
shiro特性
    1.自带加密和解密
        base64（可逆）、md5（不可逆，撒盐）
        应用在数据库中，就是密码存加密后的字符串
    2.web支持：
        集成web讲过
        配置文件web.xml和log4j、shiro配置文件
    3.缓存支持：
        realm、session缓存的支持，自己研究
    4.并发支持：
         视频没说，用到再学       
    5.测试支持
        没啥卵用，自己研究
    6.run as 支持
        借助第三张表，自己研究
    7.remember me：
        底层是把一些信息存到cookie里面，也就是浏览器本地，用的话从cookie中取出来。
        建议自己封装。
        开启记住功能，默认关闭
            token.setRememberMe(true)
        查询是否是记住：
            subject.isRemembered()
        默认cookie时间是一周，
            
           
