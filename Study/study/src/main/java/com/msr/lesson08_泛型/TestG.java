package com.msr.lesson08_泛型;


public class TestG {

    public static void main(String[] args) {
        // 泛型 : 解决操作的说句类型不确定的问题;

        ObjectDao objectDao = new ObjectDao();
        //
        // // 存对象
        objectDao.setObj(new Worker());
        // // 获取对象 没有使用泛型 时 需要 转型
        // Object obj = objectDao.getObj();
        //
        // User user = (User) obj;

        //使用泛型
        Dao<User> userDao = new Dao<>();

        userDao.setT(new User());
        //获取对象
        User t = userDao.getT();

        Dao<Worker> workerDao = new Dao<>();

        // workerDao.setT(new Worker());

        Worker t1 = workerDao.getT();

        System.out.println("-----------------------------------------------------");

        workerDao.print(123);
        workerDao.print(true);
        workerDao.print('笨');
        workerDao.print("字符串");
        workerDao.print(new User());
        workerDao.setT(new Worker());



    }
}
