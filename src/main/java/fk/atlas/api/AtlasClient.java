package fk.atlas.api;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AtlasClient {

    public String BaseUrl;
    public String User;
    public String Pwd;
    public String ApiUrl;
    public String ActionUrl = "/api/atlas/v2/entity";

    /**
     * @param _baseUrl 服务器地址
     * @param _user    用户名
     * @param _pwd     密码
     */
    public AtlasClient(String _baseUrl, String _user, String _pwd) {
        BaseUrl = _baseUrl;
        User = _user;
        Pwd = _pwd;
        ApiUrl = BaseUrl + ActionUrl;
    }

    public static class attributes_rdbms_instance {
        public attributes_field_rdbms_instance attributes;
        public String typeName = "rdbms_instance";
        public String status = "ACTIVE";
    }

    public static class attributes_field_rdbms_instance {
        public String qualifiedName;
        public String name;
        public String rdbms_type;
        public String platform;
        public String hostname;
        public String port;
        public String protocol;
        public String contact_info;
        public String description;
        public String owner;
        public String ownerName;
    }

    public static class entity_rdbms_instance {
        public attributes_rdbms_instance entity;
    }


    public String CreateEntity_rdbms_instance(entity_rdbms_instance _model_rdbms_instance) {
        String result = null;
        String paramJson = JSON.toJSONString(_model_rdbms_instance);
        try {
            result = post(ApiUrl, paramJson);
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }


    public String hello() {
        return "Hello World";
    }

    // 发送请求HTTP-POST请求 url:请求地址; entity:json格式请求参数
    public String post(String url, String entity) {
        String resStr = null;
        try {
            String username = User;// 账户
            String password = Pwd;// 密码
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Authorization", "Basic " + java.util.Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes()));
            StringEntity se = new StringEntity(entity, "UTF-8");
            se.setContentType("application/json");
            httpPost.setEntity(se);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity1 = response.getEntity();
            if (entity1 != null) {
                resStr = EntityUtils.toString(entity1, "UTF-8");
            }
            httpClient.close();
            response.close();
        } catch (Exception e) {
            resStr=e.getMessage();
        }
        return resStr;
    }
}
