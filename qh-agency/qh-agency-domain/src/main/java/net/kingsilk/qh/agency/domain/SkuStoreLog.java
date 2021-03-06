package net.kingsilk.qh.agency.domain;

import net.kingsilk.qh.agency.core.SkuStoreChangeEnum;

/**
 * SKU库存变更记录表
 */
public class SkuStoreLog extends Base {
    private String brandAppId;


    private String partnerId;

    /**
     * 库存记录ID
     */
    private String skuStoreId;

    /**
     * 变更的数量（正：增加；负：减少）
     */
    private int num;

    /**
     * 库存变更的原因
     * ps:例如
     *      进货、退货、卖出等
     */
    private SkuStoreChangeEnum storeChangeEnum;

    public SkuStoreLog() {
    }

    public SkuStoreLog(String brandAppId, String partnerId, String skuStoreId, int num, SkuStoreChangeEnum storeChangeEnum) {
        this.brandAppId = brandAppId;
        this.partnerId = partnerId;
        this.skuStoreId = skuStoreId;
        this.num = num;
        this.storeChangeEnum = storeChangeEnum;
    }

    public String getBrandAppId() {
        return brandAppId;
    }

    public void setBrandAppId(String brandAppId) {
        this.brandAppId = brandAppId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getSkuStoreId() {
        return skuStoreId;
    }

    public void setSkuStoreId(String skuStoreId) {
        this.skuStoreId = skuStoreId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public SkuStoreChangeEnum getStoreChangeEnum() {
        return storeChangeEnum;
    }

    public void setStoreChangeEnum(SkuStoreChangeEnum storeChangeEnum) {
        this.storeChangeEnum = storeChangeEnum;
    }
}
