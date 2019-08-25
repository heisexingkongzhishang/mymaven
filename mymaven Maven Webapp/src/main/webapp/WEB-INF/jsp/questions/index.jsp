<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Lei Shi">
<meta http-equiv="Cache-Control" content="o-transform">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="csrf-token"
	content="1483780974##87f89328c5616669f00302a263fe9061bb852818">

<title>讨论区</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta
	content="实验楼课程分为基础课和项目课，内容涵盖了Linux、Python、Java、C语言、Ruby、Android、IOS开发、大数据、信息安全等IT技术领域。"
	name="description">
<meta content="实验楼课程,IT培训课程,IT实训课程,IT在线课程,all" name="keywords">

<meta content="实验楼,琛石科技" name="author">

<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/font-awesome//4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/highlight.js/9.8.0/monokai-sublime.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/libs/katex/0.6.0/katex.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/libs/videojs/5.11.7/video-js.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/dest/styles.css?=2016121272249">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/layui/css/layui.css"
	media="all">
<script src="${pageContext.request.contextPath}/static/layui/layui.js"
	charset="utf-8"></script>

<style>
@font-face {
	font-family: "lantingxihei";
	src: url("../fonts/FZLTCXHJW.TTF");
}

/* modal 模态框*/
#invite-user .modal-body {
	overflow: hidden;
}

#invite-user .modal-body .form-label {
	margin-bottom: 16px;
	font-size: 14px;
}

#invite-user .modal-body .form-invite {
	width: 80%;
	padding: 6px 12px;
	background-color: #eeeeee;
	border: 1px solid #cccccc;
	border-radius: 5px;
	float: left;
	margin-right: 10px;
}

#invite-user .modal-body .msg-modal-style {
	background-color: #7dd383;
	margin-top: 10px;
	padding: 6px 0;
	text-align: center;
	width: 100%;
}

#invite-user .modal-body .modal-flash {
	position: absolute;
	top: 53px;
	right: 74px;
	z-index: 999;
}
/* end modal */
.en-footer {
	padding: 30px;
	text-align: center;
	font-size: 14px;
}
</style>

<%--      <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>  --%>
    
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor1/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor1/lang/zh-cn/zh-cn.js"></script>
    
    <script>
        var ueditor = UE.getEditor('addContent',{
        toolbars: [
            [
                'undo', //撤销
                'bold', //加粗
                'underline', //下划线
                'preview', //预览
                'horizontal', //分隔线
                'inserttitle', //插入标题
                'cleardoc', //清空文档
                'fontfamily', //字体
                'fontsize', //字号
                'paragraph', //段落格式
                'simpleupload', //单图上传
                'insertimage', //多图上传
                'attachment', //附件
                'music', //音乐
                'inserttable', //插入表格
                'emotion', //表情
                'insertvideo', //视频
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对
                'justifyjustify', //两端对齐
                'forecolor', //字体颜色
                'fullscreen', //全屏
                'edittip ', //编辑提示
                'template', //模板
            ]
        ]
    });
    </script>



</head>

<body>

	<nav class="navbar navbar-default navbar-fixed-top header">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#header-navbar-collapse"
				aria-expanded="false">
				<span class="sr-only">实验楼</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.html"> <img
				src="../img/logo_03.png">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="header-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown active"><a href="javascript:void(0);"
					class="dropdown-toggle" data-toggle="dropdown"> 课程 <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a class="active" href="../courses/index.html">全部课程</a></li>
						<li><a class="" href="../courses/index.html?status=preview">即将上线</a></li>
						<li><a class="" href="../developer/index.html">开发者</a></li>
					</ul></li>
				<li class=""><a href="../paths/index.html">路径</a></li>
				<li class=""><a href="../questions/index.html">讨论区</a></li>
				<li class=" bootcamp new-nav logo-1111"><a
					href="../bootcamp/index.html">训练营</a></li>
				<li class=" new-nav logo-1111"><a href="../vip/index.html">会员</a>

				</li>

			</ul>


			<div name="titleUserInfo" class="navbar-right btns">
				<a class="btn btn-default navbar-btn sign-in" data-sign="signin"
					href="#sign-modal" data-toggle="modal">登录</a> <a
					class="btn btn-default navbar-btn sign-up" data-sign="signup"
					href="#sign-modal" data-toggle="modal">注册</a>
			</div>


			<form class="navbar-form navbar-right" action="../search"
				method="get" role="search">
				<div class="form-group">
					<input type="text" class="form-control" name="search"
						autocomplete="off" placeholder="搜索 课程/问答">
				</div>
			</form>
		</div>
	</div>
	</nav>



	<div class="container layout layout-margin-top">


		<div class="row">
			<div class="col-md-9 layout-body">

				<div class="content">

					<ul name="questionTitle" class="nav nav-tabs question-types"
						role="tablist">

					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active">

							<ul name="topics" class="row question-items">

							</ul>




							<nav class="pagination-container">
							<ul name="pages" class="pagination">

							</ul>
							</nav>
							
							<!-- 富文本编辑器 -->
							<div>
                        		<div class="">
                        			<form action="">
                            			<input type="text" id="topicsTitle" min="5" max="100" class="form-control" placeholder="标题" ></br>
                            			<span>类型</span>
    									<select style="margin-bottom:10px" id="topicsType">
    										<option value="资源共享">资源共享</option>	
    										<option value="交流讨论">交流讨论</option>
    										<option value="易物交易">易物交易</option>
    										<option value="社团招募">社团招募</option>
    										<option value="站内公告">站内公告</option>
    									</select>
                            			<script id="addContent"  type="text/plain"></script>
                            			 <div class="layui-form-item">
                                			<button class="layui-btn" id="addPostBtn" type="button">立即发布</button>
                            			</div>
                            		</form>
                        		</div>
							</div>
							


						</div>
					</div>
				</div>

			</div>
			<div class="col-md-3 layout-side">



				<a class="btn side-btn" href="#askquestion" data-toggle="modal"
					data-sign="signin">我要发帖</a>



				<div class="panel panel-default panel-userinfo">
					<div class="panel-body body-userinfo">
						<div class="media userinfo-header">
							<div class="media-left">
								<div class="user-avatar">

									<a class="avatar" href="#sign-modal" data-toggle="modal"
										data-sign="signin"> <img class="circle"
										src="../img/logo-grey.png">
									</a>

								</div>
							</div>
							<div class="media-body">

								<span class="media-heading username">欢迎来到实验楼</span>
								<p class="vip-remain">做实验，学编程</p>

							</div>
						</div>

						<div class="row userinfo-data">

							<hr>
							<div class="btn-group-lr">
								<a href="#sign-modal" type="button"
									class="btn btn-success col-md-5 col-xs-6 login-btn"
									data-toggle="modal" data-sign="signin">登录</a> <a
									href="#sign-modal" type="button"
									class="btn btn-success col-md-5 col-xs-6 col-md-offset-1 register-btn"
									data-toggle="modal" data-sign="signup">注册</a>
							</div>

						</div>


					</div>
				</div>


				<div class="sidebox">

					<div class="sidebox-header">
						<h4 class="sidebox-title">热门帖子</h4>
					</div>
					<div name="topFive"
						class="sidebox-body course-content side-list-body"></div>

				</div>

				<div class="side-image side-qrcode">
					<img src="../img/ShiyanlouQRCode.png">
					<div class="side-image-text">关注公众号，手机看教程</div>
				</div>

				<div class="sidebox side-list">
					<div class="sidebox-header">
						<h4 class="sidebox-title">常见问题</h4>
					</div>
					<div class="sidebox-body side-list-body">
						<a href="/questions/80" target="_blank">实验操作很卡怎么办？</a> <a
							href="/questions/91" target="_blank">为什么连不上实验桌面？</a> <a
							href="/questions/360" target="_blank">"我的代码库"如何用？</a> <a
							href="/questions/92" target="_blank">实验楼环境默认用户及密码？</a> <a
							href="/questions/235" target="_blank">环境中是否可以联网？</a>
					</div>
					<div class="sidebox-footer">
						<div class="pull-right">
							<a href="/questions/?tag=%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98"
								target="_blank">查看全部</a>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>


	<div class="modal fade" id="invite-user" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">邀请好友，双方都可获赠实验豆！</h4>
				</div>
				<div class="modal-body">

					<p>
					<h4>
						<a href="#sign-modal" data-toggle="modal" data-sign="signin">登录</a>后邀请好友注册，您和好友将分别获赠3个实验豆！
					</h4>
					</p>

					<div id="msg-modal"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="flash-message" tabindex="-1" role="dialog">
		<div class="modal-dialog" rolw="document"></div>
	</div>
	<div class="modal fade" id="modal-message" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">注意</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary confirm"
						data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="sign-modal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<button type="button" class="close-modal" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="modal-body">
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#signin-form"
							aria-controls="signin-form" role="tab" data-toggle="tab">登录</a></li>
						<li role="presentation"><a href="#signup-form"
							aria-controls="signup-form" role="tab" data-toggle="tab">注册</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="signin-form">
							<form action="/login" method="post">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-envelope" style="margin:0;"></i>
										</div>
										<input type="" name="user_phone1" class="form-control"
											placeholder="请输入手机号">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-lock" style="margin:0;"></i>
										</div>
										<input type="password" name="user_password1"
											class="form-control" placeholder="请输入密码">
									</div>
								</div>
								<div class="form-inline verify-code-item" style="display:none;">
									<div class="form-group">
										<div class="input-group">
											<input type="text" name="captcha_v" class="form-control"
												placeholder="请输入验证码">
										</div>
									</div>
									<img class="verify-code" src=""
										source="https://www.shiyanlou.com/captcha.gif">
								</div>
								<div class="form-group remember-login">
									<input name="remember" type="checkbox" value="y">
									下次自动登录 <a class="pull-right"
										href="../reset_password/index.html">忘记密码？</a>
								</div>
								<div class="form-group">
									<input class="btn btn-primary" name="submit" type="submit"
										value="进入实验楼" onclick="login()">
								</div>
								<div class="form-group widget-signin">
									<span>快速登录</span> <a href="/auth/qq?next="><i
										class="fa fa-qq"></i></a> <a href="/auth/weibo?next="><i
										class="fa fa-weibo"></i></a> <a href="/auth/weixin?next="><i
										class="fa fa-weixin"></i></a> <a href="/auth/github?next="><i
										class="fa fa-github"></i></a> <a href="/auth/renren?next="><i
										class="fa fa-renren"></i></a>
								</div>
								<div class="form-group error-msg">
									<!-- <div class="alert alert-danger" role="alert"></div> -->
								</div>
							</form>
						</div>
						<div role="tabpanel" class="tab-pane" id="signup-form">
							<form action="/register" method="post">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-envelope" style="margin:0;"></i>
										</div>
										<input type="email" name="email" class="form-control"
											placeholder="请输入邮箱">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-lock" style="margin:0;"></i>
										</div>
										<input type="password" name="password" class="form-control"
											placeholder="请输入密码">
									</div>
								</div>
								<div class="form-inline">
									<div class="form-group">
										<div class="input-group">
											<input type="text" name="captcha_v" class="form-control"
												placeholder="请输入验证码">
										</div>
									</div>
									<img class="verify-code" src=""
										source="https://www.shiyanlou.com/captcha.gif">
								</div>
								<div class="form-group">
									<input class="btn btn-primary" name="submit" type="submit"
										value="注册">
								</div>
								<div class="form-group agree-privacy">
									注册表示您已经同意我们的<a href="../privacy/index.html" target="_blank">隐私条款</a>
								</div>
								<div class="form-group widget-signup">
									<span>快速注册</span> <a href="/auth/qq?next="><i
										class="fa fa-qq"></i></a> <a href="/auth/weibo?next="><i
										class="fa fa-weibo"></i></a> <a href="/auth/weixin?next="><i
										class="fa fa-weixin"></i></a> <a href="/auth/github?next="><i
										class="fa fa-github"></i></a> <a href="/auth/renren?next="><i
										class="fa fa-renren"></i></a>
								</div>
								<div class="form-group error-msg">
									<div class="alert alert-danger" role="alert"></div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- <div id="base-data"
        
        
            data-flash="false"
            
        
        
        data-is-login=false
        
        data-is-jwt=true
        data-socket-url="wss://comet.shiyanlou.com"
        data-msg-user=""
        data-msg-system=""
    ></div> -->

	<script
		src="${pageContext.request.contextPath}/app/dest/lib/lib.js?=2016121272249"></script>
	<script
		src="${pageContext.request.contextPath}/static/jquery/2.2.4/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/ace/1.2.5/ace.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/aliyun/aliyun-oss-sdk-4.3.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/highlight.js/9.8.0/highlight.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/jspdf/1.2.61/jspdf.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/plupload/2.1.9/js/plupload.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/zeroclipboard/2.2.0/ZeroClipboard.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/videojs/video.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-tour/0.11.0/js/bootstrap-tour.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-table/1.11.0/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-table/1.11.0/locale/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-table/1.11.0/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/static/ravenjs/3.7.0/raven.min.js"></script>



	<script>
		Raven.config('https://bc3878b7ed0a4468a65390bd79e6e73f@sentry.shiyanlou.com/5', {
			release : '3.12.13'
		}).install();
	</script>


	<!-- <div id="jinja-data"
    
    data-question-form="/questions/meta"
    data-is-authenticated="false"
    data-login-url="/login?next=%2Fquestions%2F"
    data-qiniu-token-url="/api/qiniu/token"
    data-userid=""
    ></div> -->

	<script
		src="${pageContext.request.contextPath}/app/dest/question/index.js?=2016121272249"></script>

	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4 clearfix footer-col">
					<img src="../img/logo_03.png">
					<div class="footer-slogan">动手做实验，轻松学编程</div>
					<div class="col-xs-2">
						<div class="social-item footer-weixin-item">
							<i class="fa fa-weixin"></i>
							<div class="footer-weixin">
								<img src="../img/footer-weixin.png">
							</div>
						</div>
					</div>
					<div class="col-xs-2">
						<div class="social-item footer-qq-item">
							<i class="fa fa-qq"></i>
						</div>
					</div>
					<div class="col-xs-2">
						<div class="social-item footer-weibo-item">
							<a href="http://weibo.com/shiyanlou2013" target="_blank"> <i
								class="fa fa-weibo"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-2 footer-col">
					<div class="col-title">公司</div>
					<a href="../aboutus/index.html" target="_blank">关于我们</a><br> <a
						href="../contact/index.html" target="_blank">联系我们</a><br> <a
						href="http://www.simplecloud.cn/jobs.html" target="_blank">加入我们</a><br>
					<a href="https://blog.shiyanlou.com" target="_blank">技术博客</a><br>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-2 footer-col">
					<div class="col-title">合作</div>
					<a href="../contribute/index.html" target="_blank">我要投稿</a><br>
					<a href="../labs/index.html" target="_blank">教师合作</a><br> <a
						href="../edu/index.html" target="_blank">高校合作</a><br> <a
						href="../friends/index.html" target="_blank">友情链接</a>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-2 footer-col">
					<div class="col-title">服务</div>
					<a href="../bootcamp/index.html" target="_blank">实战训练营</a><br>
					<a href="../vip/index.html" target="_blank">会员服务</a><br> <a
						href="../courses/reports/index.html" target="_blank">实验报告</a><br>
					<a
						href="../questions/index.html?tag=%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98"
						target="_blank">常见问题</a><br> <a href="../privacy/index.html"
						target="_blank">隐私条款</a>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-2 footer-col">
					<div class="col-title">学习路径</div>
					<a href="../paths/python/index.html" target="_blank">Python学习路径</a><br>
					<a href="../paths/linuxdev/index.html" target="_blank">Linux学习路径</a><br>
					<a href="../paths/bigdata/index.html" target="_blank">大数据学习路径</a><br>
					<a href="../paths/java/index.html" target="_blank">Java学习路径</a><br>
					<a href="../paths/php/index.html" target="_blank">PHP学习路径</a><br>
					<a href="../paths/index.html" , target="_blank">全部</a>
				</div>
			</div>
		</div>
		<div class="text-center copyright">
			<span>Copyright @2013-2016 实验楼在线教育</span> <span class="ver-line">
				| </span> <a href="http://www.miibeian.gov.cn/" target="_blank">蜀ICP备13019762号</a>
			<script type="text/javascript">
				var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
				document.write(unescape("%3Cspan id='cnzz_stat_icon_5902315'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "v1.cnzz.com/stat.php%3Fid%3D5902315' type='text/javascript'%3E%3C/script%3E"));
			</script>
			<script>
				var _hmt = _hmt || [];
				(function() {
					var hm = document.createElement("script");
					hm.src = "//hm.baidu.com/hm.js?6eb47a3aeda6ea31fa53985fdfdc78e8";
					var s = document.getElementsByTagName("script")[0];
					s.parentNode.insertBefore(hm, s);
				})();
			</script>
			<script>
				(function(i, s, o, g, r, a, m) {
					i['GoogleAnalyticsObject'] = r;i[r] = i[r] || function() {
						(i[r].q = i[r].q || []).push(arguments)
					}, i[r].l = 1 * new Date();a = s.createElement(o),
					m = s.getElementsByTagName(o)[0];
					a.async = 1;
					a.src = g;m.parentNode.insertBefore(a, m)
				})(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
				ga('create', 'UA-89338452-1', 'auto');
				ga('send', 'pageview');
			</script>
		</div>
	</div>


	<script>
	
	
	
	
	
		var nowPage = 1; //记录当前页码
		var nowTopicTypeId = ""; //记录当前帖子类型的ID
		var nowMaxPageSize = "";
	
		$(document).ready(function() {
	
			$.getJSON("questions/queryAllTopicType", function(data) {
				var str = "<li role='presentation' class='active'>" +
					"<a href='javascript:queryTopicsPriv(" + '""' + ",1);' aria-controls='all' role='tab' toggle='tab'>全部</a>" +
					"</li>";
				for (var i = 0; i < data.length; i++) {
					str += "<li role='presentation' >" +
						"<a name='" + data[i].topicType_id + "' href='javascript:queryTopicsPriv(" + data[i].topicType_id + ", 1);' aria-controls='course' role='tab' toggle='tab'>" + data[i].topicType_name + "</a>" +
						"</li>";
				}
				$("ul[name='questionTitle']").html(str);
			});
	
			queryTopicsByPage(1);
			queryTopFive("");
	
			$.get("questions/isLogined", null, function(data) {
				var str = "";
				if (data == '1') {
					str += "<div class='user-avatar '><a class='avatar' href='../user/13/study.html' target='_blank'>" +
						"<img src='https://dn-simplecloud.shiyanlou.com/gravataradmin.png?imageView2/1/w/100/h/100'>" +
						"</a></div>";
					$("div[name='titleUserInfo']").html(str);
				}
			});
			
			
	 $('#addPostBtn').click(function () {
        var topicsTitle = $("#topicsTitle").val();
        var topicsType = $("#topicsType").val();
        var topicsContent = ueditor.getContent();
        var BbsPost = {
            topicsTitle: topicsTitle,
            topicsType: topicsType,
            topicsContent: topicsContent
        };
        if(topicsTitle.length==0||topicsType.length==0||topicsContent.length==0)
        {
            alert("请输入完整的帖子信息！");
        }
        else {
            $.post("questions/addTopics", BbsPost,function(data){
            	if (data=="1") {
            		alert("发布成功");
                	window.location.reload();
                }else {
                	alert("发布出错");
                }
            });
        }
    });
			
			
			
			
	
		});
	
		function queryTopicsPriv(condition, choosedPage) {
			nowTopicTypeId = condition;
			queryTopicsByPage(choosedPage);
			queryTopFive(condition)
		}
	
		function queryTopicsByTypeId(condition, choosedPage) {
			$.getJSON("questions/queryTopicsByTypeId", {
				topicsType_id : condition,
				nowPage : choosedPage
			}, function(data) {
	
				var str = "";
				for (var i = 0; i < data.length; i++) {
	
					str += "<li class='question-item'>" +
						"<div class='col-md-10'>" +
						"<div class='col-sm-2 question-item-author'>" +
						"<div class='user-avatar '>" +
						"<a class='avatar' href='../user/13/study.html' target='_blank'>" +
						"<img src='https://dn-simplecloud.shiyanlou.com/gravataradmin.png?imageView2/1/w/100/h/100'>" +
						"</a>" +
						"</div>" +
						"</div>" +
						"<div class='col-sm-10'>" +
						"<h4><a class='question-item-title' href='show.html' target='_blank'> " + data[i].topics.topics_title + "</a></h4>" +
						"<div class='question-item-summary'>" +
						"<div class='user-username '>" +
						"<a class='avatar' href='#' target='_blank'>" + data[i].topics.topics_user.user_name + "</a>" +
						"</div>";
	
					if (data[i].reply_lastTime != null && data[i].reply_lastTime != '') {
						str += "<span class='question-item-date'>" + data[i].reply_lastTime + "</span>最后回复 ";
					}
					str += "<span class='question-item-date'>" +
						"<div class='user-username '>";
	
					if (data[i].reply_lastUser != null && data[i].reply_lastUser != '') {
						str += "<a class='username' href='/user/256544' target='_blank'>" + data[i].reply_lastUser.user_name + "</a>";
					}
	
					str += "</div>" +
						"</span>" +
						"</div>" +
						"</div>" +
						"</div>" +
						"<div class='col-md-2 question-item-rank'>" +
						"<div class='question-item-answered'>" +
						"<div>" + data[i].topics.topics_replys + "</div>" +
						"<div>回复&nbsp;</div>" +
						"</div>" +
						"<div class='question-item-views'>" +
						"<div>" + data[i].topics.topics_hits + "</div>" +
						"<div>查看</div>" +
						"</div>" +
						"</div>" +
						"</li>";
	
				}
	
				$("ul[name='topics']").html(str);
	
			});
	
		}
	
	
	
		function queryTopicsByPage(choosedPage) {
			queryTopicsByTypeId(nowTopicTypeId, choosedPage);
	
			nowPage = choosedPage;
	
			$.get("questions/getMaxPage", {
				topicsType_id : nowTopicTypeId
			}, function(data) {
	
				nowMaxPageSize = data;
				lastPage = nowPage - 1;
				nextPage = nowPage + 1;
	
				var str = "";
	
				if (nowPage == 1) {
					str += "<li class='disabled'>" +
						"<a  >" +
						"<span aria-hidden='true'>上一页</span>" +
						"</a>" +
						"</li>";
				} else {
					str += "<li class=''>" +
						"<a href='javascript:queryTopicsByPage(" + lastPage + ")' >" +
						"<span aria-hidden='true'>上一页</span>" +
						"</a>" +
						"</li>";
				}
	
				var i = 1;
				if (nowPage <= 5) {
					i = 1;
				} else {
					if (nowMaxPageSize - nowPage <= 4) {
						i = nowMaxPageSize - 8;
					} else {
						i = nowPage - 4;
					}
				}
	
				for (var j = 0; i <= nowMaxPageSize && j < 9; i++, j++) {
	
					if (nowPage - i == 0) {
						str += "<li class='active'>" +
							"<a href='javascript:queryTopicsByPage(" + i + ")'>" + i + "</a>" +
							"</li>";
					} else {
						str += "<li class=''>" +
							"<a href='javascript:queryTopicsByPage(" + i + ")'>" + i + "</a>" +
							"</li>";
					}
				}
	
				if (nowPage - nowMaxPageSize == 0) {
					str += "<li class='disabled'>" +
						"<a  >" +
						"<span aria-hidden='true'>下一页</span>" +
						"</a>" +
						"</li>";
				} else {
					str += "<li class=''>" +
						"<a  href='javascript:queryTopicsByPage(" + nextPage + ")'>" +
						"<span aria-hidden='true'>下一页</span>" +
						"</a>" +
						"</li>";
				}
	
				$("ul[name='pages']").html(str);
			});
	
		}
	
	
		function queryTopFive(condition) {
			$.getJSON("question/getTopFive", {
				topicsType_id : condition
			}, function(data) {
	
				var str = "";
	
				for (var i = 0; i < data.length; i++) {
					str += " <a href='#'><img style='width:25px;height:25px' src='${pageContext.request.contextPath}/img/1471513769430.png'>" + data[i].topics_title + "</a>";
				}
	
				$("div[name='topFive']").html(str);
			});
	
		}
	
		function login() {
			var phone = $("input[name='user_phone1']").val();
			var password = $("input[name='user_password1']").val();
	
			$.get("questions/login.html", {
				user_phone : phone,
				user_password : password
			}, function(data) {
				var str = "";
				if (data == '1') {
					alert("登陆成功");
					str += "<div class='user-avatar '><a class='avatar' href='../user/13/study.html' target='_blank'>" +
						"<img src='https://dn-simplecloud.shiyanlou.com/gravataradmin.png?imageView2/1/w/100/h/100'>" +
						"</a></div>";
					$("div[name='titleUserInfo']").html(str);
					/* $("#sign-modal").css('display','none'); */
	
				} else {
					alert("登陆失败");
				}
			});
	
		}
	</script>

	
</body>
</html>
