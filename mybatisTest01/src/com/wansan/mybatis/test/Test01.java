package com.wansan.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wansan.mybatis.dao.UseDao;
import com.wansan.mybatis.vo.Article;
import com.wansan.mybatis.vo.User;

public class Test01 {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
//    public static void main(String[] args) {
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//        User user = (User) session.selectOne("test01.findById", 1);
//        System.out.println(user);
//        } finally {
//        session.close();
//        }
//    }
//    public static void main(String[] args) {
//    	List<User> list1=new ArrayList();
//		SqlSession session=sqlSessionFactory.openSession();
//		UseDao usedao=session.getMapper(UseDao.class);
//		User use=new User();
//		use=usedao.findById(1);
//		list1= usedao.findByIdMsg("kanglu");
//		System.out.println(list1);
//		session.close();
//		System.out.println(use);
//	}
    //添加
//    public static void main(String[] args) {
//		UseDao usedao=sqlSession.getMapper(UseDao.class);
//		SqlSession sqlSession=sqlSessionFactory.openSession();
//		User user1=new User();
//		user1.setUserAddress("ewq");
//		user1.setUserAge("21");
//		user1.setUserName("xijin21");
//		usedao.add(user1);
//		sqlSession.commit();
//		sqlSession.close();
//	}
    //修改
//    public static void main(String[] args) {
//		SqlSession sqlSession=sqlSessionFactory.openSession();
//		UseDao userDao=sqlSession.getMapper(UseDao.class);
//		User user2=new User();
//		user2=userDao.findById(2);
//		user2.setUserAddress("2121");
//		userDao.update(user2);
//		sqlSession.commit();
//		sqlSession.close();
//	}
    //删除
//    public static void main(String[] args) {
//		SqlSession sqlSession=sqlSessionFactory.openSession();
//		UseDao userDao=sqlSession.getMapper(UseDao.class);
//		userDao.delete(1);
//		sqlSession.commit();
//		sqlSession.close();
//	}
    //多表查询
    public static void main(String[] args) {
    	SqlSession sqlSession=sqlSessionFactory.openSession();
    	UseDao userDao=sqlSession.getMapper(UseDao.class);
    	List<Article> list1=new ArrayList();
    	list1=userDao.getUserArticles(1);
         for(Article a:list1){
    	   System.out.println(a.getUser().getUserAddress());
       }
    	
	}
}