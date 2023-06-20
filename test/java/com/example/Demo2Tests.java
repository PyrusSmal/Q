package com.example;

import com.example.common.utils.UUIDUtil;
import com.example.dao.ProjectEntityMapper;
import com.example.dao.UserEntityMapper;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.log4j.Logger;

public class Demo2Tests {

    Logger log = Logger.getLogger(Demo2Tests.class);

    @Test
    public void queryProjectList() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        ProjectEntity projectEntity = new ProjectEntity();
        List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
        if(CollectionUtils.isEmpty(list)){
        }else{
            System.out.println(list);
            log.info(">>queryProjectList项目列表查询测试成功");
        }
    }
    @Test
    public void insert() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUIDUtil.getUUID());
        projectEntity.setProjectName("LS");
        projectEntity.setProjectContent("123");

        List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
        if(CollectionUtils.isEmpty(list)){
        }else{
            System.out.println(list);
            log.info(">>queryProjectList项目新增测试成功");
        }
    }
    @Test
    public void deleteProjectById() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUIDUtil.getUUID());
        projectEntity.setProjectName("LS");
        projectEntity.setProjectContent("123");
        projectEntityMapper.insert(projectEntity);
        int i = projectEntityMapper.deleteProjectById(projectEntity);
        if(i==0){
            // 记录error级别的信息
            log.info("a");
        }else{
            System.out.println(i);
            // 记录info级别的信息
            log.info(">>delete项目删除测试成功");
        }
    }
    @Test
    public void modifyProjectInfo() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUIDUtil.getUUID());
        projectEntity.setProjectName("LS");
        projectEntity.setProjectContent("123");
        projectEntityMapper.insert(projectEntity);
        int i = projectEntityMapper.modifyProjectInfo(projectEntity);
        if(i==0){
        }else{
            log.info(">>modifyProject项目修改测试成功");
        }
    }
}
