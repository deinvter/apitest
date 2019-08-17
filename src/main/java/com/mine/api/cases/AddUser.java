package com.mine.api.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mine.api.entity.AddUserCases;
import com.mine.api.entity.User;
import com.mine.api.mapper.AddUserCasesMapper;
import com.mine.api.mapper.UserMapper;
import com.mine.api.utils.Json;
import com.mine.api.utils.MybatisUtils;
import com.mine.api.utils.PropertiesUtils;
import com.mine.api.utils.RequestUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class AddUser {
    String url;
    @BeforeClass
    public void before(){
        url=PropertiesUtils.getValue("test.url")+PropertiesUtils.getValue("addUser.uri");
    }

    @Test(groups = "addUserTrue",description = "成功添加用户")
    public void test1(){
        //获取测试数据
        User userCase=getUserFromCase(1L);
        String userJson= JSONObject.toJSON(userCase).toString();
        //获取预期结果
        String expiredCode =String.valueOf(getExpired(1L));
        //连接接口
        CloseableHttpResponse response= RequestUtils.post(url,userJson);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //比较预期结果和实际结果
        String name = userCase.getName();
        Object user = getUserFromUser(name);
        Assert.assertNotNull(user);

    }
    @Test(groups = "addUserFalse",description = "用户姓名为空时不能添加用户")
    public void test2(){
        //获取测试数据
        User userCase=getUserFromCase(2L);
        String userJson= JSONObject.toJSON(userCase).toString();
        //获取预期结果
        String expiredCode =String.valueOf(getExpired(2L));
        //连接接口
        CloseableHttpResponse response= RequestUtils.post(url,userJson);

        //比较预期结果和实际结果
        try {
            String res= EntityUtils.toString(response.getEntity());
            JSONObject jsonObject=  (JSONObject)JSONObject.parse(res);
            String trueCode= String.valueOf(jsonObject.get("code"));
            Assert.assertEquals(trueCode,expiredCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test(groups = "addUserFalse",description = "用户密码为空时不能添加用户")
    public void test3(){
        //获取测试数据
        User userCase=getUserFromCase(3L);
        String userJson= JSONObject.toJSON(userCase).toString();
        //获取预期结果
        String expiredCode =String.valueOf(getExpired(3L));
        //连接接口
        CloseableHttpResponse response= RequestUtils.post(url,userJson);
        //比较预期结果和实际结果
        try {
            String res= EntityUtils.toString(response.getEntity());
            JSONObject jsonObject=  (JSONObject)JSONObject.parse(res);
            String trueCode= String.valueOf(jsonObject.get("code"));
            Assert.assertEquals(trueCode,expiredCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @AfterTest
    public void after(){
        MybatisUtils.closeSqlSession();
    }

    public User getUserFromCase(long id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddUserCasesMapper addUserCasesMapper=  sqlSession.getMapper(AddUserCasesMapper.class);
        AddUserCases ad = addUserCasesMapper.selectById(id);
        String name = ad.getName();
        String password = ad.getPassword();
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }
    public User getUserFromUser(String name){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper=  sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByName(name);
        return user;
    }
    public int getExpired(long id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AddUserCasesMapper addUserCasesMapper=  sqlSession.getMapper(AddUserCasesMapper.class);
        AddUserCases ad = addUserCasesMapper.selectById(id);
        int code= ad.getExpried();
        return code;
    }
}
