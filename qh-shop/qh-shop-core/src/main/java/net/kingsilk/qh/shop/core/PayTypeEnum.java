package net.kingsilk.qh.shop.core;

/**
 * Created by lit on 17/8/23.
 */
public enum PayTypeEnum {

    ALIPAY("ALIPAY", "支付宝"),
    WX("WX", "微信支付");

    PayTypeEnum(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    PayTypeEnum(String code) {
        this(code, null);
    }

    public String getCode() {
        return code;
    }

    public String getDesp() {
        return desp;
    }

    private final String code;
    private final String desp;
}
