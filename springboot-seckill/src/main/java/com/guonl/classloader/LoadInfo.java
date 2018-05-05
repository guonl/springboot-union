package com.guonl.classloader;

/**
 * Created by guonl
 * Date 2018/5/5 下午4:35
 * Description: 封装加载类的信息
 */
public class LoadInfo {

    // 自定义的类加载
    private MyClassLoder myClassLoder;

    // 记录加载的时间
    private long loadTime;

    private BaseManager baseManager;

    public LoadInfo(MyClassLoder myClassLoder, long loadTime) {
        this.myClassLoder = myClassLoder;
        this.loadTime = loadTime;
    }

    public MyClassLoder getMyClassLoder() {
        return myClassLoder;
    }

    public void setMyClassLoder(MyClassLoder myClassLoder) {
        this.myClassLoder = myClassLoder;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
