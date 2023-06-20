package com.example.dao;

import com.example.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {
    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);
    int insert(ProjectEntity projectEntity);
    int deleteProjectById(ProjectEntity projectEntity);
    int modifyProjectInfo(ProjectEntity projectEntity);

}
