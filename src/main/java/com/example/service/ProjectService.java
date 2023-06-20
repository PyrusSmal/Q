package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.ProjectEntityMapper;
import com.example.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;
    //列表
    public List<ProjectEntity>queryProjectList(ProjectEntity projectEntity){
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }
    //新增
    public int addProjectInfo(ProjectEntity projectEntity){
        projectEntity.setId(UUIDUtil.getUUID());
        int projectResult = projectEntityMapper.insert(projectEntity);
        if (projectResult != 0) {
            return 3;
        } else {
            return projectResult;
        }
    }
    //修改
    public int modifyProjectInfo(ProjectEntity projectEntity) {
        int projectChange = projectEntityMapper.modifyProjectInfo(projectEntity);
        return projectChange;
    }
    //删除
    public int deleteProjectById(ProjectEntity projectEntity){
        int projectResult = projectEntityMapper.deleteProjectById(projectEntity);
        return projectResult;
    }

}
