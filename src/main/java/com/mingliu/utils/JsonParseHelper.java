package com.mingliu.utils;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class JsonParseHelper {
    JSONObject jsonObject;
    StringBuilder sb = new StringBuilder();


    //解析json文件
    public JSONObject parse(String jsonFileName) {
        File file = new File(jsonFileName);
        String content;

        try {
            content = FileUtils.readFileToString(file, "UTF-8");
            jsonObject = new JSONObject(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

    //设置package
    public void setPackage(String packageName) {
        sb.append(packageName);
    }

    //导入库文件
    public void setImport() {
        sb.append("import com.mingliu.base.BasePage;");
        sb.append("import io.appium.java_client.pagefactory.AndroidFindBy;");
        sb.append("import org.openqa.selenium.WebElement;");
        sb.append("\n");
    }

    //设置类名
    public void setClassName(String className) {
        sb.append("public class " + className + " extends BasePage {");
        sb.append("\n");

    }

    //构造类成员变量,适用于Android
    public void parseVarAnd(JSONObject jsonObject) {
        Set<String> strings = jsonObject.keySet();
        for (String s : strings) {
            String by = jsonObject.getJSONObject(s).getString("by");
            String value = jsonObject.getJSONObject(s).getString("value");
            String comment = jsonObject.getJSONObject(s).getString("comment");
            sb.append("//" + comment);
            sb.append("\n");
            sb.append("@AndroidFindBy(" + by + "=" + "\"" + value + "\")");
            sb.append("\n");
            sb.append("public WebElement " + s + ";");
            sb.append("\n");
        }
    }

    //构造结束，添加"}"
    public void end() {
        sb.append("}");

    }

    //解析类名
    public String getGenerateName(String jsonFileName) {
        String[] split = jsonFileName.split("/");
        return jsonFileName.split("/")[split.length - 1].split("\\.")[0];
    }

    //根据json文件构造类
    public String generateClass(String jsonFileName) {
        JSONObject jsonObject = parse(jsonFileName);
        setImport();
        setClassName(getGenerateName(jsonFileName));
        parseVarAnd(jsonObject);
        end();
        return sb.toString();
    }

//    public static void main(String[] args) {
////        JSONObject object = new JsonParseHelper().parse("/Users/mingliu/course/jike/appiumLearn/src/main/resources/pages/Example.json");
////        Set<String> strings = object.keySet();
////        StringBuilder sb=new StringBuilder();
////        for (String s : strings) {
//////            System.out.println("key:"+s);
//////            System.out.println("value:"+object.get(s));
////            String by=object.getJSONObject(s).getString("by");
////            String value=object.getJSONObject(s).getString("value");
////            sb.append("@AndroidFindBy("+by+"="+"\""+value+"\")");
////            sb.append("\n");
////            sb.append("public WebElement "+s+";");
////            System.out.println(sb.toString());
////        }
//        String jsonFileName="/Users/mingliu/course/jike/appiumLearn/src/main/resources/pages/Example.json";
//        System.out.println(new JsonParseHelper().generateClass(jsonFileName));
//
//    }


}
