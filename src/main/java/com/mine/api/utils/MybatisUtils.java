package com.mine.api.utils;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//public class MybatisUtils {
//
//    public static SqlSession getSqlSession(){
//        Reader reader = null;
//        try {
//            reader = Resources.getResourceAsReader("mybatisConfig.xml");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
//       return   sessionFactoryBuilder.build(reader).openSession();
//    }
//    public void closeSqlSession(){
//        sqlSession.close();
//    }
//
//}
public class MybatisUtils {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;
    /**
     * 加载位于src/mybatis.xml配置文件
     */
    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 禁止外界通过new方法创建
     */
    private MybatisUtils(){}
    /**
     * 获取SqlSession
     */
    public static SqlSession getSqlSession(){
        //从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
        //如果SqlSession对象为空
        if(sqlSession == null){
            //在SqlSessionFactory非空的情况下，获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //将SqlSession对象与当前线程绑定在一起
            threadLocal.set(sqlSession);
        }
        //返回SqlSession对象
        return sqlSession;
    }
    /**
     * 关闭SqlSession与当前线程分开
     */
    public static void closeSqlSession() {
        //从当前线程中获取SqlSession对象
        SqlSession sqlSession = threadLocal.get();
        //如果SqlSession对象非空
        if (sqlSession != null) {
            //关闭SqlSession对象
            sqlSession.close();
            //分开当前线程与SqlSession对象的关系，目的是让GC尽早回收
            threadLocal.remove();
        }

    }
}