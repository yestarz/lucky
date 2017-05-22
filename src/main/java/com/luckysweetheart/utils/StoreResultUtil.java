package com.luckysweetheart.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by yangxin on 2017/5/22.
 */
public class StoreResultUtil {

    public static ResultInfo getResult(String json){
        ResultInfo resultInfo = new ResultInfo();
        JSONObject jsonObject =  JSON.parseObject(json);
        String code = (String) jsonObject.get("code");
        resultInfo.setResultCode(code);
        String message = (String) jsonObject.get("message");
        resultInfo.setMsg(message);
        // todo
        // data属性：
        // access_url:通过 CDN 访问该文件的资源链接（访问速度更快）；
        // resource_path：该文件在 COS 中的相对路径名，可作为其 ID 标识。 格式 /appid/bucket/filename。推荐业务端存储 resource_path，然后根据业务需求灵活拼接资源 url（通过 CDN 访问 COS 资源的 url 和直接访问 COS 资源的 url 不同）。
        //source_url:	（不通过 CDN）直接访问 COS 的资源链接
        //url:	操作文件的 url 。业务端可以将该 url 作为请求地址来进一步操作文件，对应 API ：文件属性、更新文件、删除文件、移动文件中的请求地址。
        return "0".equalsIgnoreCase(code) ? resultInfo.success() : resultInfo.fail();
    }

}
