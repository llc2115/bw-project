package com.mz.service.impl;

import com.mz.config.Constants;
import com.mz.service.IGitService;
import com.mz.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * github api 实现
 * Created by Administrator on 2022/6/30.
 */
@Slf4j
@Service("iGitHubServiceImpl")
public class IGitHubServiceImpl implements IGitService {


    @Value("${accessTokenGitHub}")
    private String accessTokenGitHub;

    /**
     * oauth2 restTemplate
     */
    @Autowired
    RestTemplate gitHubRestTemplate;

    /**
     * 获取某个项目的某个仓库信息
     * @param map request param
     * @return response
     */
    @Override
    public ResponseEntity getRepoByProject(Map map) {

        //azureRestTemplate
        ResponseEntity<String> res = gitHubRestTemplate.getForEntity(Constants.GITHUB_REPO_INFO_API,String.class);
        log.info(res.getStatusCode().toString());
        log.info(res.getBody());
        return null;
    }

    /**
     *
     * @param map request param
     * @return
     */
    @Override
    public RestResponse getBranchByProject(Map map) {
        return null;
    }

    /**
     *
     * @param map request param
     * @return
     */
    @Override
    public RestResponse getCommitById(Map map) {
        return null;
    }

    @Override
    public RestResponse GenerateTag(Map map) {
        return null;
    }
}
