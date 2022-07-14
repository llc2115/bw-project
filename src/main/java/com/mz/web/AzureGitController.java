package com.mz.web;

import com.mz.service.IGitService;
import com.mz.utils.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2022/6/29.
 */
@RestController
@RequestMapping("/azure/git")
public class AzureGitController {


    @Resource(name="iAzureGitServiceImpl")
    private IGitService iAzureGitServiceImpl;
    @Resource(name="iGitHubServiceImpl")
    private IGitService iGitHubServiceImpl;

    @GetMapping(value = "/hello", name = "Hello World")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        iAzureGitServiceImpl.getRepoByProject(null);
        iGitHubServiceImpl.getRepoByProject(null);
        return String.format("Hello %s! ", name == null ? "World" : name);
    }



    @ApiOperation(value = "获取某个项目的某个仓库信息")
    @GetMapping(value = "/getRepoByProject/{org}")
    public RestResponse getRepoByProject(@PathVariable(value = "org") String org) {


        return null;

    }



}
