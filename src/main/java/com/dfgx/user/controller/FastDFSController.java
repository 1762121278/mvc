package com.dfgx.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@Api("文件上传和下载")
@RequestMapping("/fast")
@Slf4j
public class FastDFSController {

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public StringBuilder upload() throws IOException, MyException {
        // 1、初始化全局配置。加载一个配置文件。
        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(filePath);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        //本地文件上传
        String[] jpgs = storageClient1.upload_file("F:/pic/aa.jpg", "jpg", null);
        //获取到路径后，直接拼接成新的url
        //http://192.168.188.146/group1/M00/00/01/wKi8kmAvXMiAN-ScAAQn7UfzFho420.jpg 直接按照获得的地址，在浏览器中进行查看
        StringBuilder fileName = new StringBuilder();
        fileName.append(jpgs[0]).append("/").append(jpgs[1]);
        log.info("文件名为{}",fileName);
        return fileName;
    }


    /**
     * 从FastDFS下载文件
     *
     * @param groupName      文件在FastDFS中的组名
     * @param remoteFilename 文件在FastDFS中的名称
     */
    @ApiOperation("文件下载")
    @PostMapping("/download")
    public void download( String groupName, String remoteFilename) throws IOException, MyException {
       //文件下载的操作是根据文件上传的路径进行下载
        // 1、初始化全局配置。加载一个配置文件。
        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(filePath);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        //三个参数，原始文件名，现文件名，
        byte[] bytes = new byte[0];
        try {
            bytes = storageClient.download_file(groupName, remoteFilename);
        } catch (MyException e) {
            e.printStackTrace();
            log.info("文件不存在");
        }
        //使用输出流保存文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:/pic/cc.jpg"));
        fileOutputStream.write(bytes);
        log.info("下载完成");
    }

    @ApiOperation("文件删除")
    @PostMapping("/delete")
    public void delete( String groupName, String remoteFilename) throws IOException, MyException {
        //文件下载的操作是根据文件上传的路径进行下载
        // 1、初始化全局配置。加载一个配置文件。
        String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
        ClientGlobal.init(filePath);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient1 = new StorageClient1(trackerServer,null);
        int i = storageClient1.delete_file(groupName, remoteFilename);
        log.info("文件删除完成{}",i);
    }

    /**
     * @description:
      1、 public boolean exists() ：此File表示的文件或目录是否实际存在。
      2、 public boolean isDirectory() ：此File表示的是否为目录。
      3、public boolean isFile() ：此File表示的是否为文件
     * @Param: [args]
     * @Return: void
     */
    //采用递归的方式遍历文件夹下所有文件
    @ApiOperation("读取文件夹")
    @GetMapping("/getDictionary")
     public void getDictionary(String[] args) {
         File file=new File("D:\\java专属IO测试");
         getAllFile(file);
     }
     //获取该文件夹下所有的文件及文件夹目录
    public void getAllFile(File file){
        //1、判断传入的是否是目录
        if(!file.isDirectory()){
            //不是目录直接退出
            return;
        }
        //已经确保了传入的file是目录
        File[] files = file.listFiles();
        //遍历files
        for (File f: files) {
            //如果该目录下文件还是个文件夹就再进行递归遍历其子目录
            if(f.isDirectory()){
                //递归
                getAllFile(f);
            }else {
                //如果该目录下文件是个文件，则打印对应的名字
                System.out.println(f.getName());
            }
        }
    }

    @ApiOperation("以流的方式复制文件")
    @PostMapping("/copyFile")
    public void copyFile() throws IOException {
        File file = new File("C:\\Users\\Today\\Music\\文武贝 - 告白气球.mp3");
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream("F:\\pic\\文武贝 - 告白气球.mp3");
        int len = 1024;
        byte[] b = new byte[len];
        while((len = in.read(b)) != -1){
            System.out.println(len);
            out.write(b,0,len);
        }
        in.close();
        out.flush();
        out.close();
        log.info("文件复制完成");
    }
}
