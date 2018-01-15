package net.kingsilk.qh.agency.client;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Map;

public abstract class AbstractApi {

    private Map<String, String> apiUrls;

    public String getApiUrl(String apiName) {
        Assert.isTrue(!StringUtils.isEmpty(apiName), "apiName 不能为空");

        if (apiUrls != null && !StringUtils.isEmpty(apiUrls.get(apiName))) {
            return apiUrls.get(apiName);
        }

        Map<String, String> defaultApiUrls = getDefaultApiUrls();

        String apiUrl = null;

        if (defaultApiUrls != null && !StringUtils.isEmpty(defaultApiUrls.get(apiName))) {
            apiUrl = defaultApiUrls.get(apiName);
        }

        Assert.isTrue(!StringUtils.isEmpty(apiUrl), "`API " + apiName + " 的 url 未正确配置");
        return apiUrl;
    }

    public void setApiUrls(Map<String, String> apiUrls) {
        this.apiUrls = apiUrls;
    }


    public abstract Map<String, String> getDefaultApiUrls();

}
