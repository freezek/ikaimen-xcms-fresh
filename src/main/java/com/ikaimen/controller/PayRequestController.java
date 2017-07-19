package com.ikaimen.controller;

import com.ikaimen.pay.RequestMap;
import com.ikaimen.pay.util.AlipayCore;
import com.ikaimen.utils.model.JsonResult;
import com.ikaimen.utils.model.ResponseData;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Tom Chen on 2017/6/13.
 */

@Controller
@RequestMapping("/app/alipay")
public class PayRequestController {

    private static final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCtFW1vG4jnzN3BqBObEpqWZYPaS1u9QppGvS2i1iax4L8a2RD7UymK6VQ1HzN/aQ3ZuW0v12VOHdOkGlOcXD5ViwMeC4z41yzDbL+Mv3aqRxOw9xlHx0cqzc8BS1Cwv408NTDaPQ31NwtLCk03B5J1RHaOiTl+PqZ+CM1UMbSVPZmd7U/EiRRpoehMsbkEQn+PnCQYpDgMNWIkVbfvZI18irfUZghz7z6+0KfJN1IveWW7Yg71KGF+DigHOxtQpD3OgpGxoYCSBa4ppxt49zeU6slirJgpxa6B84iQTfJ3nkie1rlwvPmK1RI2SNuvdOCHpU4v0GJq02eopUmb8yrfAgMBAAECggEANS6VToNuYJMRPFTRmV9xAm80wVlQWeniD4RHRnZ4s0U0UyKJVj/qTtV820m4ABkeeVzBUOblKMh/ZDf2ot+xA4XQMmYoLbmn9nAutyeJZa6rPT/fk6+GjX9pcKNcqsJgujQ5y4ThCgycurTynssD1GZx6z/8226Sp706ofkX3JbsYVBV1MsB28u5NcwjjGo6owu2FNnkpQbJJVFwukhT+DEwTiAclaFfWhIBTZKIU1rhN59tzo6imJovB/m6kzZMlMF1ZmrO3inU/ulz6JUOZ4DLECjnHFA1jjmDlLmmVIFdfo+3Ek3ZQJSR9PC8tvFi8s8ndNvK2bBNutCxtFfNaQKBgQDco/lxplKh8yvBZ7yCGg9AYui5o5eWCd3gY/Y8iQrpUonEYImFWSaFyD7OpWWhAQTGTZEPigjRJurjhK3xY1FNTMFz0C6cUGFMBLpx5LaQ9ONFQYJSiU8qfl/A1C6sOzh7fyjnIWUcNJ9J+jRZUa7dM9OoKx+QzK8fmMoZ49fE1QKBgQDI0mGDxAQ/jM2uJzaRNSiKthW8ZcTMbuRWnX52e8IMm1Zc3TVAgUNwxgo8GkYXxrCr2xaiNSA8VJXUD+wPBvrxfCxCWwhQzLZohEQAn77W5tM4gEIXsTorTDfOAxHs0vKpDuHvujWB2WJcCpEzsKxSUq+p24Kpc5byWZXx/Boa4wKBgD9dI/TchByYXjeD2CIw47Jk9VrivVTMbpjTfFK0NJr/JitsYfIWwTZoZIkp/L65MSrV+dPRm2idWZWPc/i/wgiGA4SEA+7GMrsHHJg6y6djfKVWA9w6LK8SbeNNzD2QIE9vHEsMTyJDhn9TSJdiGurRyHYiNEV8UsqrMVcwFLYlAoGAcj3MH4tI52YQM7w2/JADCjXfU5eJRsrmtqdNo9VvZICRtq5YduOSG/ttIxfHPAtZwcoWrBwQxIFR4ptULJBJ/UooW28x4dUzB24GyVwW0mXpTsEX2CaH8s2fCWERt2mhha7jtN53RfEGVVnllEQzI3nKWJR5VjBddGymMky6BQUCgYA7fmDmkgvm4yUc7Uqp9xSgqET4zg34D8swbimVV0yL5mBgqw2Veed/Z+5SieO79IXlLw07EBQ5LSUreRx85w3udXVvI3DV02o8Q17TxRscgK2sDTqR3GYc45PdCre6SUsnAv23vSvwW3OpNGneeGdCzk0582nn01UC9isxU9B4bQ==";

    private static final  String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB" ;


    private  JsonResult jsonResult;

    private ResponseData responseData;

    @RequestMapping("/getParam")
    @ResponseBody
    public JsonResult getPayParam(){

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2017030105979917", APP_PRIVATE_KEY, "json", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2");
//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo("20170511155449421");
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("https://openapi.alipay.com/gateway.do");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。

            jsonResult = new JsonResult();
            responseData = new ResponseData();
            responseData.setCont(response.getBody());

            jsonResult.setCode(1);
            jsonResult.setMsg("获取支付宝请求参数成功！");
            jsonResult.setResponse(responseData);

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return  jsonResult;
    }

    @RequestMapping("/getOldParam")
    @ResponseBody
    public void getPayParam(RequestMap requestMap) {
        Map map = new HashMap<>();
        map.put("partner", "2088801555885173");
        map.put("seller_id", "server@zedaotea.com");
        map.put("out_trade_no", "0819145412-6177");
        map.put("subject", "测试");
        map.put("body", "测试测试");
        map.put("total_fee", "0.01");
        map.put("notify_url", "http://notify.msp.hk/notify.htm");
        map.put("service", "mobile.securitypay.pay");
        map.put("payment_type", "1");
        map.put("_input_charset", "utf-8");
        map.put("it_b_pay", "30m");
        map.put("sign_type", "RSA");
        //  map.put("sign","");

        AlipayCore alipayCore = new AlipayCore();


    }

}
