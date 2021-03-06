package com.luckysweetheart.dto;

/**
 * Created by yangxin on 2017/5/22.
 */
public class StoreDataDTO {

    /**
     * 通过 CDN 访问该文件的资源链接（访问速度更快）；
     */
    private String accessUrl;

    /**
     * 该文件在 COS 中的相对路径名，可作为其 ID 标识。 格式 /appid/bucket/filename。推荐业务端存储 resource_path，
     * 然后根据业务需求灵活拼接资源 url（通过 CDN 访问 COS 资源的 url 和直接访问 COS 资源的 url 不同）。
     */
    private String resourcePath;

    /**
     * （不通过 CDN）直接访问 COS 的资源链接，img的src属性可以直接访问到
     */
    private String sourceUrl;

    /**
     * 操作文件的 url 。业务端可以将该 url 作为请求地址来进一步操作文件，对应 API ：文件属性、更新文件、删除文件、移动文件中的请求地址。
     */
    private String url;

    /**
     * 本次请求id
     */
    private String requestId;

    private String vId ;

    private String cosPath;

    private String fileName;

    private String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCosPath() {
        return cosPath;
    }

    public void setCosPath(String cosPath) {
        this.cosPath = cosPath;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "StoreDataVO{" +
                "accessUrl='" + accessUrl + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
