package com.spl.hm;

public class DaoPatternExample {

    private static Dao<User> userDao;

    public static void main(String[] args) {
        userDao = new UserDao();

        final User user1 = userDao.getById(1).get();
        System.out.println("get user 1: " + user1);

        user1.setName("updated." + user1.getName());
        userDao.update(user1);

        System.out.println("All users: ");
        userDao.getAll().forEach(user -> System.out.println(user));
        
        //OUTPUT
        //get user 1: User{id=1, name='Dao user 1', email='dao1@gmail.com'}
        //All users:
        //User{id=1, name='updated.Dao user 1', email='dao1@gmail.com'}
        //User{id=2, name='Dao user 2', email='dao2@gmail.com'}
    }
}
