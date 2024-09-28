package com.futing.opensourelib.eventbus;


/**
 * Created by dusuijiang on 2018/10/17.
 */

public class EventBusTest {


    public void aaa() {
        EventBus.getDefualt().register(this);

        EventBus.getDefualt().post("111111111111");
        EventBus.getDefualt().post(new User("都岁江"));

    }

    static class User {
        public String name;

        public User(String name) {
            this.name = name;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ccc(String s) {
        System.out.println(s);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void bbb(User user) {
        System.out.println(user.name);
    }

}
