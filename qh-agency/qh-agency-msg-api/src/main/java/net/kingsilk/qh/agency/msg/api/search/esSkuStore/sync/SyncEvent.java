package net.kingsilk.qh.agency.msg.api.search.esSkuStore.sync;

import java.io.Serializable;

/**
 * 通知同步 指定微信公众号 下用户信息。
 *
 * 加锁路径为： ${prefix}/${className}/${wxMpAppId}
 */
public class SyncEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 微信公众号 APP ID。
     */
    private String skuStoreId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSkuStoreId() {
        return skuStoreId;
    }

    public void setSkuStoreId(String skuStoreId) {
        this.skuStoreId = skuStoreId;
    }
}
