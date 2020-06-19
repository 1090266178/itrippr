package com.ZFSDK;

import java.io.FileWriter;
import java.io.IOException;


public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102800772947";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAEO56pOPwjeYWwJKw7lbbaCZ+5kmQAEMXIZrQi4HWTzXThE3mssNhASaVCoICrOq2icQPby1+ZlmBUSmE8IhpL0Ey36QtNeVNW+3psZtUk/v32NAICuME8ihHcdeTZMBpFLVF6wgrTsGuXdwoDIyyEaVygpSJux4cGQUKPt44gJoWF9mDkA/uryGtEwkoo/x1aI6hcmoqBbrrbmGH42YOxqHYPwwWl1ecbJ3HtfqULyzHQ3312nErthgRXKTNUMRrptR81DvBrSvO6I3i8lezAgYHoTe8NjVYIKosZB3EzDKrFUVMQ+xN0E0EAL3Bt9xA8WaAM84C/UFrtlvGn025AgMBAAECggEAGFugEEGmfQ1wMumjvPVIHekcUUyZt0Llf9PLb1jpdAqS0U07x+I+WQfv/68E9V9QMTHY0Zqyy3TKF1eJjxh0yZTMUNHKlzLGD0Wp5aX7RkXzSbu6LZ1sendYg+Y6O3WRRytCIy9F2X7cRb7ibdedNw02K6Z8fAnT+0Ii/ETi3VoLfMlPNspRBPKjfrp1gwJjTPGFNmh5NLAO4O8iNjqRBHG/kwq8stOYCS5YUyuVqpEbri4owE3/1OM+olFKbapaXbny2kacHgrAdZ4et0mcZgJvio/P+1VCanyuHh1hGWZlYMrgWMeI8njF+JHVIWwkXnaTMaBdX5i6sZfie3hjpQKBgQC+lETxhA0+deBgnlYHse9Hu0iQhLKJ8IIPiW+Ork8sMx8viIfh6x/7VUh5zQKY6fOhuohfIm5HA2GWGUslYGUPndsLUTyqfYBcDvhWMkQVSdirGBESpiefhAyU42OmixvwNnSbub5Bek3p2lxxp6/6eqokhH0zzSDYhFWPo9ofewKBgQCsByMQafItL92NdbbcLbJ2BO0eNsGmaITuYFTksIdyVgA1kNVhdzkdNjsh1TN6LwMfHoUL6/2RQhUjhqlrPO3XbbHQhKIYWT/MZQHFL2kyv5t4h8egRGJ3MRH/Fpz1Bagm3q2T3wwchY4AoyAKub7QU2SH3kWF28gH1kIsp6FHWwKBgAIbt8uIL3FScoH/HmqFYGVFwB7BKQx3mai8V3yXlw6hHiYzd3VbWYY5Qkz+pJm2dNiELMAIrHmiovC7JOar81JB58tvQaGNM99Q1xR1B+XIZFo4MPAo4GVWW6FGBrMv9MYqhA24907YIIaGwOEM/thhhQJUaOIq0cMza5LkOCSDAoGALjl0uJJfWrkD5WD+E8fLrl7AgF/iRR7MqWkFJrYwjw6A2+PhEmGA3VKXLQ4m2OwNAK2ovn1ZE1EYcQVcPM6QclStdQROshA5TmjNwvhsYhCObCLAB1aYxsJOvaaL4mL0vg0TwyoqDPfuIkmy8G7c0Qm3d7LIJ6HY7BIskecxNQUCgYBpZYmqLfluk/kHBJkmy3HLTPPQCpVqf7tBzVAQB3NuWjEmE1DH7vu6H8J1IIuKN9BLp1rzZRlupjxea8AAVHN69oAg1NlC3qRM1P8ubTIcwTNhox4+hKhPD3izkHudeQAvyH2bQUaJ2AiCiUnNYv280tujz+7tJjmczXopWnPH5w==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi5DO9nUhCjNn6HrhwArvV4yuW6jDTMtAzVEaJsjXxLNzU+KebCRDSsgfewd/OBvBcsqF1hvYC4+fRlDgmDbmzuv1PBGO/eUso4KwJExdKUv4uVBwIX0lwHUmCWCYqwheEgtgtkHa8sqcqOOaYz+eG8goCdGeeujYxs1IDFcUIR7etvQq5102I64tHRqEA7nMSBOCMKYDz4p3SHiwhnAkqwMGXLtnQ/ZSpsbRWri4unTQ8k92XtBD6p+tcqoQnm0spwauIdMPLgXZ4gd9oNBmErCVVeL67BzUkj8c9U04wvTg4puDxJNqZKkKBPMDONlnUFmEgZgc9Rg+dpaolIzmbwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://laozitianxiadiyi.wezoz.com/itriptrade/trade/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://laozitianxiadiyi.wezoz.com/itriptrade/trade/returnUrl";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

