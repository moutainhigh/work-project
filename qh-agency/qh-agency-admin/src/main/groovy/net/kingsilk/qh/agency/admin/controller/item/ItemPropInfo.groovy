package net.kingsilk.qh.agency.admin.controller.item;

import net.kingsilk.qh.agency.core.ItemPropTypeEnum;

/**
 * Created by tpx on 17-3-18.
 */
public class ItemPropInfo {

    public static class PropInfo {

        private String id;

        /**
         * 属性类型
         */
        private ItemPropTypeEnum type;

        /**
         * 名称。
         * <p>
         * 给顾客查看时，使用该名字。比如: "蚕丝净重"
         */
        private String name;

        /**
         * 助记名。
         * <p>
         * 因为不同商品可能有类似商品属性，为方便操作人员区分，该名称可以很长，仅在管理后台显示，不在会员前端展示。
         * <p>
         * 比如："钱皇-万福娘娘-蚕丝净重"。
         * <p>
         * mnemonic name
         */
        private String memName;

        /**
         * 单位。仅当 type 字段 为 ItemPropTypeEnum.INT 时有意义。
         */
        private String unit;

        /**
         * 自定义代码
         */
        private String code;

        /**
         * 备注
         */
        private String memo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public ItemPropTypeEnum getType() {
            return type;
        }

        public void setType(ItemPropTypeEnum type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMemName() {
            return memName;
        }

        public void setMemName(String memName) {
            this.memName = memName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }

    public static class PropValue {

        private String id;
        /**
         * 属性值。
         * <p>
         * 比如: "粉色"、"180*200"、"XL"、"16.0"
         */
        private String name;

        /**
         * 自定义代码
         */
        private String code;

        /**
         * 颜色。CSS十六进制颜色值。比如（9999FF）
         */
        private String color;

        /**
         * 图片网址（https格式）
         */
        private String img;

        /**
         * 备注
         */
        private String memo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }
}
