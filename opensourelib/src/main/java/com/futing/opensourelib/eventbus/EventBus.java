package com.futing.opensourelib.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dusuijiang on 2018/10/17.
 */

public class EventBus {

    private static final String TAG = "EventBus";
    Map<Object,List<SubscriberMethod>> cacheMap;
     private Handler mHandler;
     private ExecutorService executorService = Executors.newCachedThreadPool();

    private EventBus(){
        cacheMap = new HashMap();
        mHandler = new Handler(Looper.getMainLooper());

    }

    public static EventBus getDefualt(){
        return EventBusHolder.INSTANCE;
    }

    private static class EventBusHolder{
        private static EventBus INSTANCE = new EventBus();
    }

    public void register(Object obj){
        List<SubscriberMethod> list = cacheMap.get(obj);
        if (list == null){
            list =findSubscribeMethods(obj);
            cacheMap.put(obj,list);
        }
    }

    /**
     * 拿到带有该注解得方法
     * @param obj
     * @return
     */
    private List<SubscriberMethod> findSubscribeMethods(Object obj) {
        Class<?> clazz = obj.getClass();
        Log.e(TAG, "findSubscribeMethods: "+obj.getClass() );
        List<SubscriberMethod> list = new ArrayList<>();

        while (clazz != null){
            String name = clazz.getName();
            //判断类是否系统类
            if (name.startsWith("java.") ||
                    name.startsWith("javax.") ||
                    name.startsWith("android.")){
                break;
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);

                if (subscribe == null){
                    continue;
                }
                Class<?>[] types = method.getParameterTypes();
                if (types.length != 1){
                    throw new RuntimeException("只能有一个参数");
                }

                ThreadMode threadMode = subscribe.threadMode();

                SubscriberMethod subscriberMethod = new SubscriberMethod(types[0],method,threadMode);
                list.add(subscriberMethod);
            }

            //拿到我们得父类
            clazz = clazz.getSuperclass();
        }

        return list;
    }

    public void post(final Object type){
      Set<Object> set = cacheMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            final Object obj = iterator.next();
            List<SubscriberMethod> list = cacheMap.get(obj);

            for (final SubscriberMethod subscriberMethod : list) {
                //判断参数类型是否相等
                if (subscriberMethod.getType().isAssignableFrom(type.getClass())){
//                    invoke(subscriberMethod,obj,type);
//                  切换线程！！！
                    switch (subscriberMethod.getThreadMode()){
                        case MAIN:
                            if (Looper.myLooper() == Looper.getMainLooper()){
                                invoke(subscriberMethod,obj,type);
                            }else {
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(subscriberMethod,obj,type);
                                    }
                                });
                            }
                            break;
                        case BACKGROUND:
                            if (Looper.myLooper() == Looper.getMainLooper()){
                                executorService.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        invoke(subscriberMethod,obj,type);
                                    }
                                });
                            }else {
                                invoke(subscriberMethod,obj,type);
                            }
                            break;
                        case POSTING:
                            invoke(subscriberMethod,obj,type);
                            break;
                    }

                }
            }
        }

    }

    private void invoke(SubscriberMethod subscriberMethod, Object obj, Object type) {
        Method method = subscriberMethod.getMethod();
        try {
            method.invoke(obj,type);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
