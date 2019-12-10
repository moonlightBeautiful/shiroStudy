# shiroStudy
shiro特性
    1.自带加密和解密
        base64、md5（不可逆）
        应用在数据库中，就是密码存加密后的字符串
    2.web支持：集成web讲过
    3.缓存支持：realm、session的支持，自己研究
    4.并发支持：
    5.测试支持
    6.run as 支持
    7.remember me：把一些信息存到cookie里面，也就是浏览器本地，用的话从cookie中取出来
        token.setRememberMe(true)
        subject.isRemembered() 返回是否记住me
        默认cookie时间是一周，
            
           
