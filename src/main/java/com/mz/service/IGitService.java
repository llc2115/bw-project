package com.mz.service;

import com.mz.utils.RestResponse;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * Created by Administrator on 2022/6/29.
 */
public interface IGitService {

    /**
     * 获取某个项目的某个仓库信息
     * @param map request param
     * @return response
     */
    ResponseEntity getRepoByProject(Map map);

    /**
     * 获取某个仓库的某个分支信息
     * @param map request param
     * @return response
     */
    RestResponse getBranchByProject(Map map);

    /**
     * 获取某个项目的某个仓库的某个commit 信息
     * @param map request param
     * @return response
     */
    RestResponse getCommitById(Map map);

    /**
     * 生成Tag
     * @param map
     * @return
     */
    RestResponse GenerateTag(Map map);

}
