package com.aikaimen.pay;

import java.math.BigDecimal;

/**
 * Created by Tom Chen on 2017/6/14.
 */
public class RequestMap {

//    service	接口名称	String	接口名称，固定值。	不可空	mobile.securitypay.pay
//    partner	合作者身份ID	String(16)	签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。	不可空	2088101568358171
//    _input_charset	参数编码字符集	String	商户网站使用的编码格式，固定为UTF-8。	不可空	UTF-8
//    sign_type	签名方式	String	签名类型，目前仅支持RSA。	不可空	RSA
//    sign	签名	String	请参见签名。	不可空	lBBK%2F0w5LOajrMrji7DUgEqNjIhQbidR13GovA5r3TgIbNqv231yC1NksLdw%2Ba3JnfHXoXuet6XNNHtn7VE%2BeCoRO1O%2BR1KugLrQEZMtG5jmJI
//    notify_url	服务器异步通知页面路径	String(200)	支付宝服务器主动通知商户网站里指定的页面http路径。	不可空	http://notify.msp.hk/notify.htm
//    app_id	客户端号	String	标识客户端。	可空	external
//    appenv	客户端来源	String	标识客户端来源。参数值内容约定如下：appenv=”system=客户端平台名^version=业务系统版本”	可空	appenv=”system=android^version=3.0.1.2”
//    out_trade_no	商户网站唯一订单号	String(64)	支付宝合作商户网站唯一订单号。	不可空	0819145412-6177
//    subject	商品名称	String(128)	商品的标题/交易标题/订单标题/订单关键字等。该参数最长为128个汉字。	不可空	测试
//    payment_type	支付类型	String(4)	支付类型。默认值为：1（商品购买）。	不可空	1
//    seller_id	卖家支付宝账号	String(16)	卖家支付宝账号（邮箱或手机号码格式）或其对应的支付宝唯一用户号（以2088开头的纯16位数字）。	不可空	xxx@alipay.com
//    total_fee	总金额	Number	该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。	不可空	0.01
//    body	商品详情	String(512)	对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。	不可空	测试测试
//    goods_type	商品类型	String(1)	具体区分本地交易的商品类型。
//            1：实物交易；
//            0：虚拟交易。
//    默认为1（实物交易）。	可空	1
//    hb_fq_param	花呗分期参数	String	Json格式。
//    hb_fq_num：花呗分期数，比如分3期支付；
//    hb_fq_seller_percent：卖家承担收费比例，比如100代表卖家承担100%。
//    两个参数必须一起传入。
//    具体花呗分期期数和卖家承担收费比例可传入的数值请咨询支付宝。	可空	{“hb_fq_num”:“3”,“hb_fq_seller_percent”:“100”}
//    rn_check	是否发起实名校验	String(1)	T：发起实名校验；
//    F：不发起实名校验。	可空	T
//    it_b_pay	未付款交易的超时时间	String	设置未付款交易的超时时间，一旦超时，该笔交易就会自动被关闭。当用户输入支付密码、点击确认付款后（即创建支付宝交易后）开始计时。取值范围：1m～15d，或者使用绝对时间（示例格式：2014-06-13 16:00:00）。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。该参数数值不接受小数点，如1.5h，可转换为90m。	可空	30m
//    extern_token	授权令牌	String(32)	开放平台返回的包含账户信息的token（授权令牌，商户在一定时间内对支付宝某些服务的访问权限）。通过授权登录后获取的alipay_open_id，作为该参数的value，登录授权账户即会为支付账户。	可空	1b258b84ed2faf3e88b4d979ed9fd4db
//    promo_params	商户优惠活动参数	String(128)	商户与支付宝约定的营销参数，为Key:Value键值对，如需使用，请联系支付宝技术人员。	可空	{"Customer2016":"Y","Goods201606":"Y"}
//    extend_params	业务扩展参数	String	业务扩展参数，详见下面的“业务扩展参数说明”。	可空	{"TRANS_MEMO":"促销"}


    private  String  service ;

    private String  partner;

    private String  _input_charset;

    private  String sign_type;

    private  String  sign ;

    private  String notify_url;

    private String app_id;

    private String out_trade_no;

    private  String subject;

    private  String payment_type;

    private String seller_id;

    private BigDecimal total_fee ;

    private String body;

    private  String goods_type;

    private  String hb_fq_param;

    private String hb_fq_seller_percent;

    private String rn_check;

    private String it_b_pay;

    private String extern_token;

    private  String promo_params;

    private  String extend_params ;


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getHb_fq_param() {
        return hb_fq_param;
    }

    public void setHb_fq_param(String hb_fq_param) {
        this.hb_fq_param = hb_fq_param;
    }

    public String getHb_fq_seller_percent() {
        return hb_fq_seller_percent;
    }

    public void setHb_fq_seller_percent(String hb_fq_seller_percent) {
        this.hb_fq_seller_percent = hb_fq_seller_percent;
    }

    public String getRn_check() {
        return rn_check;
    }

    public void setRn_check(String rn_check) {
        this.rn_check = rn_check;
    }

    public String getIt_b_pay() {
        return it_b_pay;
    }

    public void setIt_b_pay(String it_b_pay) {
        this.it_b_pay = it_b_pay;
    }

    public String getExtern_token() {
        return extern_token;
    }

    public void setExtern_token(String extern_token) {
        this.extern_token = extern_token;
    }

    public String getPromo_params() {
        return promo_params;
    }

    public void setPromo_params(String promo_params) {
        this.promo_params = promo_params;
    }

    public String getExtend_params() {
        return extend_params;
    }

    public void setExtend_params(String extend_params) {
        this.extend_params = extend_params;
    }
}
