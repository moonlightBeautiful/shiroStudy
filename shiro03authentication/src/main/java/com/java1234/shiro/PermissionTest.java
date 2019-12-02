
    public static void permitted() {
        Subject subject = null;
        try {

        } catch (PropertyVetoException e) {
            System.out.println("*权限验证失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    /**
     * void
     * checkPermission(string)：检查是否有这个权限，没有则直接跑出异常   void
     * checkPermissions(string...)：如果不能同时全部有这些权限，则直接跑出异常   void
     */
    public static void checkPermitted() {
        Subject subject = null;
        try {
            subject = ShiroUtil.login("java1234", "123456");
            subject.checkPermission("all");
            subject.checkPermissions("zouxuesheng1", "zouxuesheng", "zouxuesheng");
        } catch (PropertyVetoException e) {
            System.out.println("*权限检查失败！*");
            e.printStackTrace();
        } finally {
            subject.logout();
        }
    }

    public static void main(String[] args) {
        permitted();
        checkPermitted();
    }
}
