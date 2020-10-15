package com.neo.utils;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.neo.exception.FileNotExistException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * create by xiaocai on 2020/10/15 10:58
 **/
public class DownLoadAndUpdate {
    private static String awsAccessKeyId="awsAccessKeyId";
    private static String awsSecretAccessKey="awsSecretAccessKey";
    private static String protocal="protocal";
    private static String zone="zone";
    private static String bucket="bucket";
    private static String endpoint="endpoint";
    private static String backUpS3Dir="backUpS3Dir";

    public static void main(String[] args) {
        String channel = "wzry";
        String ftpDir = "./project/ftpdir/"+channel;
        String localDir = "D:/test";
        backup(ftpDir,localDir,channel);

    }

    public static void backup(String ftpDir,String localDir,String channel){
        downloadFileToLocal(ftpDir, localDir);
        uploadS3(localDir,channel);
    }

    /**
     * 上传本地所有目录文件到S3服务器，不支持递归
     * @param localDir
     * @param channel
     */
    public static void uploadS3(String localDir,String channel){
        AmazonS3 s3Client = initS3Client();
        File file = new File(localDir+"/"+channel);
        File[] files = file.listFiles();
        for (File fileInfo:files) {
            String s3File = backUpS3Dir+"/"+fileInfo.getName();
            s3Client.putObject(new PutObjectRequest(bucket, s3File, fileInfo));
            fileInfo.delete();
        }
    }

    /**
     * 下载ftp指定目录文件到本地，并删除ftp文件
     * @param ftpDir
     * @param localDir
     * @return
     */
    public static boolean downloadFileToLocal(String ftpDir,String localDir){
        FTPClient ftp = new FTPClient();
        FileOutputStream outputStream = null;
        try {
            ftp.connect("hostname", 100);
            ftp.login("username", "password");
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();
            ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                throw new RuntimeException("FTP服务器拒绝连接");
            }
            if (!ftp.changeWorkingDirectory(ftpDir)) {
                throw new FileNotExistException(ftpDir + "can not find");
            }
            FTPFile[] ftpFiles = ftp.listFiles();
            //创建本地目录
            String channelDir = ftpDir.substring(ftpDir.lastIndexOf("/"));
            for (FTPFile ftpFile:ftpFiles
                 ) {
                //创建目录
                File localFileDir = new File(localDir + channelDir);
                if (!localFileDir.exists()){
                    localFileDir.mkdir();
                }
                File file = new File(localDir + channelDir + "/" + ftpFile.getName());
                outputStream = new FileOutputStream(file);
                ftp.retrieveFile(ftpFile.getName(),outputStream);
                boolean b = ftp.deleteFile(file.getName());
            }
            ftp.logout();
            outputStream.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static AmazonS3 initS3Client(){
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setSignerOverride("AWSS3V4SignerType");
        if ("http".equals(protocal)) clientConfig.setProtocol(Protocol.HTTP);
        if ("https".equals(protocal)) clientConfig.setProtocol(Protocol.HTTPS);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(clientConfig)
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                endpoint,
                                zone))
                .withPayloadSigningEnabled(true)
                .build();
        return s3Client;
    }
}
