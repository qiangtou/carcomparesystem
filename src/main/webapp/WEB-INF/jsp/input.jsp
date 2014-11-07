<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<style>
#input_form td {
	text-align: right;
	width: 100px;
}
</style>
<div class="easyui-layout" fit=true>
<div region="center">

	<form id="input_form" method="post" action="car/add.action">
		<table>
			<tr>
				<td><label>品牌：</label></td>
				<td><input id="brandId" name="brandId" /></td>
				<td><label>系列：</label></td>
				<td><input id="seriesId" name="seriesId" /></td>
			</tr>
			<tr>
				<td><label>车型：</label></td>
				<td><input name="name" class="easyui-textbox" /></td>
				<td><label>价格：</label></td>
				<td><input name="price" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td><label>年份：</label></td>
				<td><input name="year" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td><label>级别：</label></td>
				<td><input class="combo" name="level" /></td>
				<td><label>上市日期：</label></td>
				<td><input class="easyui-textbox" name="data" /></td>
			</tr>
			<tr>
				<td><label>结构：</label></td>
				<td><input class="combo" name="structure" /></td>
				<td><label>座位数：</label></td>
				<td><input class="combo" name="seatNum" /></td>
			</tr>
			<tr>
				<td><label>单侧门数量：</label></td>
				<td><input class="combo" name="sideDoorNum" /></td>
				<td><label>开门方式：</label></td>
				<td><input class="combo" name="openType" /></td>
			</tr>
			<tr>
				<td><label>整备质量：</label></td>
				<td><input class="easyui-textbox" name="weight" /></td>
				<td><label>排量：</label></td>
				<td><input class="easyui-textbox" name="displacement" /></td>
			</tr>
			<tr>
				<td><label>长度：</label></td>
				<td><input class="easyui-textbox" name="length" /></td>
				<td><label>宽度：</label></td>
				<td><input class="easyui-textbox" name="width" /></td>
			</tr>
			<tr>
				<td><label>高度：</label></td>
				<td><input class="easyui-textbox" name="height" /></td>
			</tr>
			<tr>
				<td><label>前轮距：</label></td>
				<td><input class="easyui-textbox" name="trackfront" /></td>
				<td><label>后轮距：</label></td>
				<td><input class="easyui-textbox" name="trackrear" /></td>
			</tr>
			<tr>
				<td><label>轴距：</label></td>
				<td><input class="easyui-textbox" name="wheelbase" /></td>
			</tr>
		</table>
		<a href="#" onclick="$('#input_form').submit();return false;" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
		<a href="#" onclick="$('#input_form').form('reset');return false;" class="easyui-linkbutton" iconCls="icon-redo">重置</a>
	</form>		
</div>
</div>
<script type="text/javascript">
$(function() {
	var _brandArr=${brandData},
		_form,
		_brand,
		_series,
		_data = {
			level:[
				{value:'',text:'请选择...'},
				{value:1,text:'微型车'},
				{value:2,text:'小型车'},
				{value:3,text:'紧凑车'},
				{value:4,text:'中型车'},
				{value:5,text:'中大车'},
				{value:6,text:'豪华车'},
				{value:7,text:'SUV'},
				{value:8,text:'MPV'},
				{value:9,text:'跑车'},
				{value:10,text:'皮卡'},
				{value:11,text:'微面'},
				{value:12,text:'电动车'}
			],
			structure:[
				{value:'',text:'请选择...'},
				{value:1,text:'两厢'},
				{value:2,text:'三厢'},
				{value:3,text:'掀背'},
				{value:4,text:'旅行版'},
				{value:5,text:'硬顶敞篷'},
				{value:6,text:'软顶敞篷'},
				{value:7,text:'硬顶跑车'},
				{value:8,text:'客车'},
				{value:9,text:'货车'}
			],
			seatNum:genArr(100),
			sideDoorNum:genArr(4),
			openType:[
				{value:'',text:'请选择...'},
				{value:1,text:'平开'},
				{value:2,text:'侧滑'},
				{value:3,text:'对开'},
				{value:4,text:'上开'}
			]
		};
		
	$('.combo').each(function(i,o){
		var that = $(o);
		var name = that.attr('name');
		that.combobox({
			panelHeight:'auto',
			panelMaxHeight:200,
			editable:false,
			data:_data[name]
		});
	});
		
	_form = $('#input_form').form();
	
	_brand = $('#brandId').combobox({
		valueField:'id',
		textField:'name',
		panelHeight:'auto',
		panelMaxHeight:200,
		editable:false,
		formatter:function(row) {
			return row.sName + "&nbsp;&nbsp;&nbsp;" + row.name;
		},
		onChange:function(n,o) {
			var seriesArr=n==''?[]:$(this).combobox('getData').filter(function(o){
				return o.id==n;
			})[0].series;
			initSeries(seriesArr);
		}
	});
	_series = $('#seriesId').combobox({
		data:[{id:'',name:'请选择系列...'}],
		valueField:'id',
		textField:'name',
		panelHeight:'auto',
		panelMaxHeight:200,
		editable:false
	});
	initBrand();
	function initBrand(){
		arr=_brandArr;
		arr.unshift({name:'选择品牌',sName:'',id:''});
		_brand.combobox('clear').combobox('loadData',arr);
		initSeries();
	}
	function initSeries(arr){
		arr=arr||[];
		arr.unshift({name:'选择车系',id:''});
		_series.combobox('clear').combobox('loadData',arr);
	}
	function genArr(i){
		var ret=[];
		while(i--)ret[i]={value:i+1,text:i+1};
		ret.unshift({value:'',text:'请选择...'});
		return ret;
	}
})
</script>
