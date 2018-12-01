/*
 * TcmFilesBase.java
 * CopyRight(C) 2015-2016 山东数迅信息技术有限公司 
 * All rights reserved.
 * ----------------------------------
 * At 2018-03-24 18:05:15  Created by
 */
package Yest;


import java.math.BigDecimal;
import java.util.Date;

public class TcmFilesBase  {
    public TcmFilesBase(Long fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    /**
     *
     * tcm_files_base.file_id (文件ID) 
     */
    private Long fileId;
    /**
     *
     * tcm_files_base.file_name (文件名称) 
     */
    private String fileName;
    /**
     *
     * tcm_files_base.file_type (文件类型) 
     */
    private String fileType;
    /**
     *
     * tcm_files_base.file_size (文件大小) 
     */
    private BigDecimal fileSize;
    /**
     *
     * tcm_files_base.crt_user (创建人) 
     */
    private String crtUser;
    /**
     *
     * tcm_files_base.crt_time (创建时间) 
     */
    private Date crtTime;
    /**
     *
     * tcm_files_base.save_path (保存路径) 
     */
    private String savePath;

    /**
     * 返回列  tcm_files_base.file_id
     *
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 设置列  tcm_files_base.file_id
     *
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 返回列  tcm_files_base.file_name
     *
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置列  tcm_files_base.file_name
     *
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 返回列  tcm_files_base.file_type
     *
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置列  tcm_files_base.file_type
     *
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 返回列  tcm_files_base.file_size
     *
     */
    public BigDecimal getFileSize() {
        return fileSize;
    }

    /**
     * 设置列  tcm_files_base.file_size
     *
     */
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 返回列  tcm_files_base.crt_user
     *
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * 设置列  tcm_files_base.crt_user
     *
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser == null ? null : crtUser.trim();
    }

    /**
     * 返回列  tcm_files_base.crt_time
     *
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置列  tcm_files_base.crt_time
     *
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 返回列  tcm_files_base.save_path
     *
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * 设置列  tcm_files_base.save_path
     *
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath == null ? null : savePath.trim();
    }

    @Override
    public String toString() {
        return "TcmFilesBase{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                ", crtUser='" + crtUser + '\'' +
                ", crtTime=" + crtTime +
                ", savePath='" + savePath + '\'' +
                '}';
    }

}