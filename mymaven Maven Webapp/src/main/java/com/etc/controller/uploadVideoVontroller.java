package com.etc.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etc.entity.Video;
import com.etc.entity.VideoType;
import com.etc.pojo.PageVideo;
import com.etc.pojo.VideoUpload;
import com.etc.service.AnimationVideoService;
import com.etc.service.impl.AnimationVideoServiceImpl;
import com.etc.tools.PageSupport;

@Controller
public class uploadVideoVontroller {

	@Resource
	private AnimationVideoService av;
	private List<VideoType> listtype;
	private List<Video> listvideo;
/*	private PageSupport ps;
	private PageVideo pv;*/
	
	
	
	/**动漫上传控制器*/
	@RequestMapping(value="/uploadVideo.html",method = RequestMethod.POST)
	private String uploadVideo(@RequestParam("video_name") String video_name,
			@RequestParam("video_introduce") String video_introduce,
			@RequestParam("videotype_idstr") String videotype_idstr,
			HttpServletRequest request,
			@RequestParam(value = "video_image", required = false) MultipartFile video_image,
			@RequestParam(value = "video_files", required = false) MultipartFile[] video_files)
	{
		//多视频上传
		VideoUpload videoupload;
		String idPicPath = null;
		String workPicPath = null;
		boolean flag = true;
		// 定义上传文件目标路径。File.separator可以自适应windows、linux系统的文件路径分隔符。
		String videofolder=System.currentTimeMillis()+"";
		String path = request.getSession().getServletContext()
				.getRealPath("WEB-INF" + File.separator + "jsp" + File.separator + "video" + File.separator + videofolder);
		File video_path = new File(path);
		if ( !video_path.exists()){//若此目录不存在，则创建之
			video_path.mkdir();
	           System.out.println("创建文件夹路径为："+ path);
		}
		for (int i = 0; i < video_files.length; i++) {
			System.out.println(i+"阿瑟东大时代按熟打算打算的按熟:::"+video_files.length);
			MultipartFile video_file = video_files[i];
			// 判断是否有上传视频（非必需）
			if (!video_file.isEmpty()) {

				System.out.println("文件上传路径：" + path);
				String oldFileName = video_file.getOriginalFilename();// 获取原文件名
				System.out.println("上传文件原文件名：" + oldFileName);
				String subfix = FilenameUtils.getExtension(oldFileName);// 获取原文件后缀名
				System.out.println("上传文件后缀名：" + subfix);
				// 获取原文件大小并比较
				long fileSzie = 500000000;
				System.out.println("上传文件大小：" + video_file.getSize());
				if (video_file.getSize() > fileSzie) {// 上传文件小于5000m
					request.setAttribute("uploadFileError", " * 上传视频超过限制大小！");
					flag = false;
				} else if (subfix.equalsIgnoreCase("mp4")) {// 视频格式判断
					// 重命名文件，解决linux中文乱码问题。实际系统可能需要存储原文件名。
					String fileName = (i+1) + ".mp4";// RandomUtis存在于common-lang包中
					System.out.println("新文件名：" + video_file.getName());
					// 根据新文件名和目标路径创建File对象，用于接收用户上传的文件流
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					try {
						video_file.transferTo(targetFile);// 保存文件到服务器
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("uploadFileError", " * 上传视频失败！");
						flag = false;// 上传失败
					}
					// idPicPath = path + File.separator + fileName;//绝对路径

					if (i == 0) {
						idPicPath = fileName;// 工作照片路径
					} else if (i == 1) {
						workPicPath = fileName;// 证件图片路径
					}
				} else {
					request.setAttribute("uploadFileError", "* 上传视频文件格式不正确！");
					flag = false;
				}
			}
			
		}
		System.out.println("图片上传");
		//图片上传
		if (!video_image.isEmpty()) {// 图片有上传
			//文件存储路径
			System.out.println("path:" + path);
			// 读取原文件名
			String oldFileName = video_image.getOriginalFilename();
			System.out.println("原文件名:" + oldFileName);
			// 读取文件扩展名
			String extName = FilenameUtils.getExtension(oldFileName);
			System.out.println("扩展名:" + extName);
			long fileSize = 500000000;// 文件大小5M
			// 读取文件大小
			System.out.println("文件大小:" + video_image.getSize());

			if (video_image.getSize() > fileSize) {// 文件超过限定
				request.setAttribute("uploadFileError", "*上传文件超过5M!");
				return "error";
			} else if (extName.equalsIgnoreCase("jpg") || extName.equalsIgnoreCase("png")
					|| extName.equalsIgnoreCase("jpeg") || extName.equalsIgnoreCase("pneg")) {// 扩展名是否合法
				// 重命名文件
				String fileName = "0." + extName;
				System.out.println("新文件名:" + fileName);
				// 创建文件对象,接收从客户端已经传到服务器的文件流
				File targetFile = new File(path, fileName);

				try {
					video_image.transferTo(targetFile); // 保存文件
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//文件路径
				System.out.println("保存到数据库的文件路径:"+path);
			} else {
				request.setAttribute("uploadFileError", "*上传图片格式不正确!");
				flag=false;
			}
			
		}
		else{
			request.setAttribute("uploadFileError", "*上传图片不能为空!");
			flag=false;
		}
		if(flag)
		//动漫信息上传
		{
			Integer video_userId=1;
			Integer video_hits=0;
			Integer video_isReported=0;
			Integer video_nums=video_files.length;
			Integer videotype_id=Integer.valueOf(videotype_idstr);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String video_time=df.format(new Date());
			videoupload = new VideoUpload(video_name, video_userId, video_introduce, videofolder, video_hits, video_isReported, video_nums, videotype_id, video_time);
			String str = av.AnimationVideoUpload(videoupload);
			request.setAttribute("str", str);
		}
		else{
			//动漫上传失败，删除文件夹
			if(video_path.exists())
			{
				if(video_path.isDirectory()){
					File[] files = video_path.listFiles();
					for(int i =0;i<files.length;i++)
					{
						files[i].delete();
					}
				}
				video_path.delete();
			}
		}
		return "courses/uploadvideo";
	}
}
