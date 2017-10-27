<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图片水印制作</title>
<meta name="keyword" content="图片水印制作">
<meta name="description" content="图片水印制作">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="author" content="图片水印制作">
<link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css?2024" rel="stylesheet" type="text/css" />
<!--[if lte IE 6]>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-ie6.css?2024" />
<![endif]-->
<!--[if lte IE 7]>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/ie.css?2024" />
<![endif]-->
<link href="${pageContext.request.contextPath}/static/site.css?2024" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
	function checkFile() {
		var filename = document.getElementById("srcfile").value;
		if(filename == null || filename == "") {
			alert("请上传图片文件！");
			return false;
		} else {
			var mime = filename.toLowerCase().substr(filename.lastIndexOf("."));
			if (mime != ".jpg" && mime != ".gif" && mime != ".jpeg" && mime != ".png" && mime != ".bmp") {
				alert("请选择图片格式的文件上传！");
				return false;
			} else {
				var imageSize = (document.getElementById("srcfile").files[0].size/(1024*1024)).toFixed(2);
				if(imageSize>1.00) {
					alert("上传图片大小不能超过1M，当前文件大小为："+imageSize+"M");
					return false;
				}
			}
		}
		return true;
	}
</script>
</head>
<body>
	<form class="form-horizontal" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/servlet/handleServlet">
		<fieldset>
			<div id="legend" class="">
				<legend class="leipiplugins-orgvalue">图片文字水印制作</legend>
			</div>
			<div class="control-group">
				<label class="control-label leipiplugins-orgname">水印文字</label>
				<div class="controls">
					<input type="text" name="imagetext" value="版权所有 转载必究">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label leipiplugins-orgname">选择源图片&nbsp;</label>
				<div>
					<input type="file" name="srcfile" id="srcfile" title="选择源图片,上传图片大小不能超过1M" 
						accept="image/gif,image/jpeg,image/jpg,image/png,image/bmp">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="submit" value="提交制作..." onclick="return checkFile();"/>
				</div>
			</div>
		</fieldset>
	</form>

</body>
</html>