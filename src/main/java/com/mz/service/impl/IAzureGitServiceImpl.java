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
 * Created by Administrator on 2022/6/29.
 */
@Slf4j
@Service("iAzureGitServiceImpl")
public class IAzureGitServiceImpl implements IGitService {



    /**
     * basicAuth restTemplate
     */
    @Autowired
    RestTemplate azureRestTemplate;



    /**
     * 获取某个项目的某个仓库信息
     * @param map request param
     * @return response
     */
    @Override
    public ResponseEntity getRepoByProject(Map map) {

        //azureRestTemplate
        ResponseEntity<String> res = azureRestTemplate.getForEntity(Constants.AZURE_REPO_INFO_API,String.class);
        log.info(res.getStatusCode().toString());
        log.info(res.getBody());

        return null;
    }

    @Override
    public RestResponse getBranchByProject(Map map) {
        return null;
    }

    @Override
    public RestResponse getCommitById(Map map) {
        return null;
    }

    @Override
    public RestResponse GenerateTag(Map map) {
        return null;
    }
}
