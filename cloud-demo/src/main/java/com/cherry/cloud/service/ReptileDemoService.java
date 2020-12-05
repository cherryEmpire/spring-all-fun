package com.cherry.cloud.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Cherry
 * @Date: 2020/12/6
 * @Desc: JsoupDemoService
 */
@Service
public class ReptileDemoService {

    private static final Logger logger = LoggerFactory.getLogger(ReptileDemoService.class);

    /**
     * jsoup方式 获取虎扑新闻列表页
     *
     * @param url
     * @return
     */
    public List<String> jsoupList(String url) {
        try {
            List<String> result = new ArrayList<>();
            Document document = Jsoup.connect(url).get();
            // 使用 css选择器 提取列表新闻 a 标签
            // <a href="https://voice.hupu.com/nba/2484553.html" target="_blank">霍华德：夏休期内曾节食30天，这考验了我的身心</a>
            Elements elements = document.select("div.news-list > ul > li > div.list-hd > h4 > a");
            for (Element element : elements) {
                // 获取详情页链接
                String d_url = element.attr("href");
                // 获取标题
                String title = element.ownText();

                result.add("详情页链接：" + d_url + " ,详情页标题：" + title);

            }
            return result;
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * httpClient 获取虎扑新闻列表页
     *
     * @param url
     */
    public List<String> httpClientList(String url) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity, "utf-8");

                if (body != null) {
                    /*
                     * 替换掉换行符、制表符、回车符，去掉这些符号，正则表示写起来更简单一些
                     * 只有空格符号和其他正常字体
                     */
                    Pattern p = Pattern.compile("\t|\r|\n");
                    Matcher m = p.matcher(body);
                    body = m.replaceAll("");
                    /*
                     * 提取列表页的正则表达式
                     * 去除换行符之后的 li
                     * <div class="list-hd">                                    <h4>                                        <a href="https://voice.hupu.com/nba/2485167.html"  target="_blank">与球迷亲切互动！凯尔特人官方晒球队开放训练日照片</a>                                    </h4>                                </div>
                     */
                    Pattern pattern = Pattern.compile("<div class=\"list-hd\">\\s* <h4>\\s* <a href=\"(.*?)\"\\s* target=\"_blank\">(.*?)</a>\\s* </h4>\\s* </div>");

                    Matcher matcher = pattern.matcher(body);
                    List<String> result = new ArrayList<>();
                    // 匹配出所有符合正则表达式的数据
                    while (matcher.find()) {
                        // 提取出链接和标题
                        result.add("详情页链接：" + matcher.group(1) + " ,详情页标题：" + matcher.group(2));
                    }
                    return result;
                } else {
                    logger.error("处理失败！！！获取正文内容为空");
                }
            } else {
                logger.error("处理失败！！！返回状态码：" + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
