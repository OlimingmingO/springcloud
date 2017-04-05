package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**配置中心3/3
 * 使用RefreshScope来使得依赖配置的有状态的bean在配置变更的时候能够动态更新
 */
@RefreshScope
@RestController
public class ConfigCenterCtr {

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
}
