<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" fit=true>
	<div title="视频区" region="center">
	</div>
	<div title="图片区" region="south" split=true data-options="height:270,tools:[{
					iconCls:'icon-add',
					handler:function(){
						if(video.id == null) {
							$.messager.alert('提示!','请先选择视频！');
							return;
						}
						pic.dialog.dialog('open');
					}
				},{
					iconCls:'icon-remove',
					handler:function(){
						var g = $('#video_pic').data('galleria');
						var index = g.getIndex();
						g.splice(index,1);
						setTimeout(function() {
							if(g.getDataLength() == 0) {
								g.destroy();
								return;
							}
					   		g.show(index-1);
					   	},200);
					}
				}]">
		<div id="video_pic" class="easyui-panel" data-options="fit:true" border=false></div>
	</div>
</div>
<div id="upload">
	<form id="upload_form" enctype="multipart/form-data" method="post">
		<input type="file" name="file" multiple/><br/>
		<div id="progressbar" class="easyui-progressbar" data-options="value:0" style="width:250px;"></div>
	</form>
</div>
<script type="text/javascript">
$(function(){
	var _pic = {},
		_video = {id:1},
		_form,
		_dialog,
		_progressbar,
		_interValId;
	
	window.pic = _pic;
	window.video = _video;
	
	_pic.galleria = $('#video_pic');
	
	_progressbar = $('#progressbar');
	
	_form = $('#upload_form').form({
		url:'pic/add.action',
		onLoadError:function(){
    		_progressbar.hide();
    		clearTimeout(_interValId);
    	},
		onSubmit:function(p) {
			p.id = _video.id;
			if($(this).form("validate")) {
				if(_progressbar){
			    	_progressbar.show().progressbar({value:0});
			    	_interValId=setInterval(function(){
			    	    $.ajax({url:"/progress.action",type:"post",dataType:"json",success:function(progress){
			    		    _progressbar.progressbar({value:progress});
			    		    if(progress==100){
			    		    	clearTimeout(_interValId);
			    		    }
			    	    }})
			    	},100);
			    }
				return true;
			}
			$.messager.alert("提示!","请检查表单是否存在错误信息！");
			return false;
		},
		success:function(data){
			_form.form('reset');
			if(_progressbar){
				  _progressbar.hide();
			      clearTimeout(_interValId);
			}
			if(data == "fail") {
				$.messager.alert("提示!","文件为空！");
			} else if (data == "typeError") {
				$.messager.alert("提示!","文件类型不正确！");
			} else {
				var p = eval('('+data+')');
		        $.messager.show({
					title:'消息',
					msg:'上传成功！',
					timeout:2000
				});
				addPic(p);
			}
			_dialog.dialog('close');
		}
	});
	
	_dialog = _pic.dialog = $('#upload').dialog({
		title:'上传加图',
		closed:true,
		modal:true,
		onBeforeOpen:function() {
			_form.form('reset');
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function() {
				$('#upload_form').submit();
			}
		}]
	});
	
	function addPic(p) {
		var t = _pic.galleria;
		var g = t.data('galleria');
		var params = {
		   		thumb:p.url,
		   		image:p.url,
			    big: p.url,
			    title: p.name,
		   	}
		if(g) {
			g.push(params);
		   	setTimeout(g.show.bind(g,g.getDataLength()),200);
		} else {
			t.galleria({
				lightbox:true,
				dataSource:[params]
			});
		}
	}
})
</script>