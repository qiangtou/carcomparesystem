<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="easyui-layout" fit=true>
	<div title="视频区" region="center" border=false>
		<div class="easyui-layout" fit=true>
			<div title="视频列表" region="west" data-options="width:200">
				<div id="video_grid" border=false></div>
			</div>
			<div region="center"></div>
		</div>
	</div>
	<div title="图片区" region="south" data-options="height:250" border=false></div>
</div>
<script type="text/javascript">
$(function(){
	var _grid;
	
	_grid = $('#video_grid').datagrid({
		rownumbers:true,
		pagination:true,
		fit:true,
		columns:[[
			{field:'name',title:'视频名称',width:170}
		]]
	});
	$(_grid.datagrid("getPager")).pagination({
		beforePageText:"",
		afterPageText:"",
		layout:['first','prev','manual','next','last','sep','refresh']
	});
})
</script>