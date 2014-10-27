<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<script src='/js/lib/avalon.js'></script>
<script src='/js/lib/jquery.min.js'></script>
<div ms-controller='carquery'>
	<div>
		<select ms-duplex='brandId'><option ms-repeat='brands' ms-value="{{el.id}}">{{el.sName}} {{el.name}}</option></select>
		<select ms-duplex='seriesId'><option ms-repeat='series' ms-value="{{el.id}}">{{el.name}}</option></select>
		<select ms-duplex='carTypeId'><option ms-repeat='carTypes' ms-value="{{el.id}}">{{el.year}} {{el.name}}</option></select>
	</div>
	<div>
		<form id='qq' action="/car/query.action" method="post">
			级别:
			<label ><input type="checkbox" name="level" value="1">微型车</label>
			<label ><input type="checkbox" name="level" value="2">小型车</label>
			<label ><input type="checkbox" name="level" value="3">紧凑型车</label>
			<label ><input type="checkbox" name="level" value="4">中型车</label>
			<label ><input type="checkbox" name="level" value="5">中大型车</label>
			<label ><input type="checkbox" name="level" value="6">豪华车</label>
			<label ><input type="checkbox" name="level" value="7">SUV</label>
			<label ><input type="checkbox" name="level" value="8">MPV</label>
			<label ><input type="checkbox" name="level" value="9">跑车</label>
			<label ><input type="checkbox" name="level" value="10">皮卡</label>
			<label ><input type="checkbox" name="level" value="11">微面</label>
			<label ><input type="checkbox" name="level" value="12">电动车</label>
			<br>
			结构:<select name='structure'>
				<option value="0">请选择.</option>
				<option value="1">两厢</option>
				<option value="2">三厢</option>
				<option value="3">掀背</option>
				<option value="4">旅行版</option>
				<option value="5">硬顶敞篷车</option>
				<option value="6">软顶敞篷车</option>
				<option value="7">硬顶跑车</option>
				<option value="8">客车</option>
				<option value="9">货车</option>
			</select>
			座位数:<select name=seatNum>
				<option value="0">请选择.</option>
				<option ms-value="{{el.val}}" ms-repeat='seatNumbers'>{{el.name}}</option>
			</select >
			单侧门数量:<select name='sideDoorNum'>
				<option value="0">请选择.</option>
				<option ms-value="{{el.val}}" ms-repeat='sideDoorNumbers'>{{el.name}}</option>
			</select>
			开门方式:<select name="openType">
				<option value="0">请选择.</option>
				<option value="1">平开</option>
				<option value="2">侧滑</option>
				<option value="3">对开</option>
				<option value="4">上开</option>
			</select>
			<div>
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</div>
<div ms-controller="carTypeContent">
	<table>
	<thead>
		<tr>
			<td>品牌</td>
			<td>车系</td>
			<td>结构</td>
			<td>级别</td>
			<td>座位数</td>
			<td>款型</td>
		</tr>
	</thead>
		<tr ms-repeat='cars'>
			<td></td>
			<td></td>
			<td></td>
			<td>{{el.level}}</td>
			<td>{{el.seatNum}}</td>
			<td>{{el.year}} {{el.name}}</td>
		</tr>
	</table>
</div>
<script>
(function($,avalon){
 var brandArr=${brandData},
 carquery=avalon.define('carquery',function(vm){
	 vm.brands=[];vm.brandId=0;
	 vm.series=[];vm.seriesId=0;
	 vm.carTypes=[];vm.carType=0;

	 vm.seatNumbers=[];
	 vm.sideDoorNumbers=[];

	 vm.$init=function(){
	 arr=brandArr;
	 arr.unshift({name:'选择品牌',id:0});
	 carquery.brands=arr;
	 carquery.brandId=0;
	 carquery.$seriesInit();
	 carquery.seatNumbers=genArr(100);
	 carquery.sideDoorNumbers=genArr(4);
	 }
	 vm.$seriesInit=function(arr){
	 arr=arr||[];
	 arr.unshift({name:'选择车系',id:0});
	 carquery.series=arr;
	 carquery.seriesId=0;
	 carquery.$carTypeInit();
	 }
	 vm.$carTypeInit=function(arr){
	 arr=arr||[];
	 arr.unshift({name:'选择车型',id:0});
	 carquery.carTypes=arr;
	 carquery.carTypeId=0;
	 }
 });
function genArr(i){
	var ret=[];
	while(i--)ret[i]={val:i+1,name:i+1};
	return ret;
}

carquery.$watch('brandId',function(id){
		var series=id==0?[]:brandArr.filter(function(o){
			return o.id==id;
			})[0].series;
		carquery.$seriesInit(series);
		});

carquery.$watch('seriesId',function(id){
		if(id==0){
		carquery.$carTypeInit();
		return;
		}
		$.ajax({
url:'/car/findType.action',
data:{seriesId:id},
success:carquery.$carTypeInit
});
		});
carquery.$init();
var content=avalon.define('carTypeContent',function(vm){
		vm.cars=[];

		});
var form=$('#qq').submit(function(){
		$.ajax({
url:form.attr('action'),
type:'post',
data:form.serialize(),
success:function(p){
content.cars=p.rows;
}
});
		return false;
		});
})(jQuery,avalon);
</script>
