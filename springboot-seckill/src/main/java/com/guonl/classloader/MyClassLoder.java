package com.guonl.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by guonl
 * Date 2018/5/5 下午4:04
 * Description: 自定义一个类加载器
 */
public class MyClassLoder extends ClassLoader{

    // 指定加载类的路径
    private String classPath;

    public MyClassLoder(String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return super.defineClass(name,data,0,data.length);
    }

    /**
     * 加载class文件中的内容
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            name = name.replace(".","//");
            FileInputStream inputStream = new FileInputStream(new File(classPath + name + ".class"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int b = 0;
            while((b = inputStream.read()) != -1){
                outputStream.write(b);
            }
            inputStream.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
