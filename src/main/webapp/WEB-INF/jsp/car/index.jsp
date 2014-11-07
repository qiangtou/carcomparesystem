<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<script src='/js/lib/avalon.js'></script>
<style>
	.cartype table {
	border-collapse: separate;
	border-spacing: 0 5px;
	width:80%;
	}

	.cartype thead th {
	background-color: gray;
	color: white;
	}

	.cartype tbody td {
	background-color: #EEEEEE;
	}

	.cartype tr td:first-child,
	.cartype tr th:first-child {
	border-top-left-radius: 6px;
	border-bottom-left-radius: 6px;
	}

	.cartype tr td:last-child,
	.cartype tr th:last-child {
	border-top-right-radius: 6px;
	border-bottom-right-radius: 6px;
	}
</style>
<div class='cartype easyui-layout' fit=true >
	<div data-options="region:'north',title:'车型查询',height:210" >
		<div ms-controller='carquery'>
			<div>
				<select ms-duplex='brandId'><option ms-repeat='brands' ms-value="{{el.id}}">{{el.sName}} {{el.name}}</option></select>
				<select ms-duplex='seriesId'><option ms-repeat='series' ms-value="{{el.id}}">{{el.name}}</option></select>
				<select ms-duplex='carTypeId'><option ms-repeat='carTypes' ms-value="{{el.id}}">{{el.year}} {{el.name}}</option></select>
				<form id='qq' action="/car/query.action" method="post">
					级别:
					<label ms-repeat='levels' ><input type="checkbox" name="level" ms-value="{{$key}}">{{$val}}</label>
					<div>
						结构:<select name='structure'>
							<option value="0">.</option>
							<option ms-repeat='structures' ms-value="{{$key}}">{{$val}}</option>
						</select>
						座位数:
						<select name=seatNum>
							<option value="0">.</option>
							<option ms-value="{{el}}" ms-repeat='seatNumbers'>{{el}}</option>
						</select>
						单侧门数量:<select name='sideDoorNum'>
							<option value="0">.</option>
							<option ms-value="{{el}}" ms-repeat='sideDoorNumbers'>{{el}}</option>
						</select>
						开门方式:<select name="openType">
							<option value="0">.</option>
							<option ms-repeat='openTypes' ms-value="{{$key}}">{{$val}}</option>
						</select>
					</div>
					<div>
						车头:
						前大灯:<select name="headLight"><option value=""></option></select>
						前雾灯:<select name="frontFogLight"><option value=""></option></select>
						散热格栅:<select name="grille"><option value=""></option></select>
						前保险杠:<select name="bumper"><option value=""></option></select>
						车外后视镜:<select name="mirror"><option value=""></option></select>
					</div>
					<div>
						车侧:
						侧面顶端线:<select name="sideTopLine"><option value=""></option></select>
						腰线数量:<select name="waistLineNum">
							<option value="0"></option>
							<option value="1">1</option>
							<option value="2">2</option>
						</select>
						上腰线位置:<select name="upWaistLinePos">
							<option value="0"></option>
							<option value="1">把手上方</option>
							<option value="2">穿过把手</option>
							<option value="3">把手下方</option>
						</select>
						上腰线线型:<select name="upWaistLineType">
							<option value="0"></option>
							<option value="1">不明显</option>
							<option value="2">前低后高</option>
							<option value="3">前高后低</option>
							<option value="4">中间凸起</option>
							<option value="5">中间凹陷</option>
							<option value="6">平行</option>
						</select>
						上腰线造型:<select name="upWaistLineModel">
							<option value="0"></option>
							<option value="1">不明显</option>
							<option value="2">凹槽</option>
							<option value="3">棱线</option>
							<option value="4">凹凸线</option>

						</select>
						下腰线造型:<select name="downWaistLineModel">
							<option value="0"></option>
							<option value="1">凹槽</option>
							<option value="2">棱线</option>
							<option value="3">凸条</option>
							<option value="4">凹凸线</option>
						</select>
						<br>
						底部流线造型:
						<select name="bottomLineModel">
							<option value="0"></option>
							<option value="1">不明显</option>
							<option value="2">凹槽</option>
							<option value="3">棱线</option>
							<option value="4">凸条</option>
							<option value="5">凹凸线</option>
						</select>
						底部流线位置:
						<select name="bottomLinePos">
							<option value="0"></option>
							<option value="1">车门</option>
							<option value="2">底盘</option>
						</select>
						前门大窗:
						<select name="frontDoorBigWin">
							<option value="0"></option>
						</select>
						前门小窗:
						<select name="frontDoorSmallWin">
							<option value="0"></option>
						</select>
						后门大窗:
						<select name="backDoorBigWin">
							<option value="0"></option>
						</select>
						后门小窗:
						<select name="backDoorSmallWin">
							<option value="0"></option>
						</select>
						后座小窗:
						<select name="backSeatSmallWin">
							<option value="0"></option>
						</select>
					</div>
					<div>
						车尾:
						后尾灯:<select name="rearLight">
							<option value="0"></option>
						</select>
						后保险杠:<select name="rearBumper">
							<option value="0"></option>
						</select>
						高位刹车灯:<select name="highMountStopLamp">
							<option value="0"></option>
						</select>
					</div>
					<div>
						颜色: <select name="color">
							<option value="0"></option>
							<option value="1">黑</option>
						</select>
						方位:
						<select name="position">
							<option value="0"></option>
							<option value="1">车头</option>
							<option value="2">车尾</option>
							<option value="3">车侧</option>
							<option value="4">车顶</option>
						</select>
					</div>
				</form>
			</div>
			<div>
				<input type="button" class="easyui-linkbutton" value="查询" ms-click='submit(1)'>
			</div>
		</div>
	</div>

	<div data-options="region:'center',title:'车型列表'" >
		<div ms-controller="carTypeContent">
			<div ms-visible='showTable'>
				<table>
					<thead>
						<tr>
							<th>品牌</th><th>车系</th><th>结构</th><th>级别</th><th>座位数</th><th>款型</th>
						</tr>
					</thead>
					<tr ms-repeat='cars' ms-click="showPic(el)">
						<td>{{el.brandName}}</td>
						<td>{{el.seriesName}}</td>
						<td>{{el.structure}}</td>
						<td>{{el.level}}</td>
						<td>{{el.seatNum}}</td>
						<td>{{el.year}} {{el.name}}</td>
					</tr>
				</table>
				<div ms-visible='cars.length'>
					<a href="#" ms-visible='page!=1' ms-click='goPage("first")'>首页</a>
					<a href="#" ms-visible='page>1' ms-click='goPage("prev")'>上一页</a>
					{{page}} 
					<a href="#" ms-visible='page<last' ms-click='goPage("next")'>下一页</a>
					<a href="#" ms-visible='page!=last' ms-click='goPage("last")'>尾页({{last}})</a>
				</div>
			</div>
			<div ms-visible='!showTable' >
				<table>
					<tr>
						<td>品牌:{{car.brandName}}</td><td>上市日期:{{car.date}}</td>
					</tr>
					<tr>
						<td>系列:{{car.seriesName}}</td><td>排量:{{car.displacement}}</td>
					</tr>
					<tr>
						<td>车型:{{car.year}} {{car.name}}</td><td>长度(mm):{{car.long}}</td>
					</tr>
					<tr>
						<td>轿车级别:{{car.level}}</td><td>宽度(mm):{{car.width}}</td>
					</tr>
					<tr>
						<td>座位数:{{car.seatNum}}</td><td>高度(mm):{{car.height}}</td>
					</tr>
					<tr>
						<td>单侧门数量:{{car.sideDoorNum}}</td><td>轴距(mm):{{car.wheelbase}}</td>
					</tr>
					<tr>
						<td>开门方式:{{car.openType}}</td><td>前轮距(mm):{{car.trackfront}}</td>
					</tr>
					<tr>
						<td>单侧车门数:{{car.sideDoorNum}}</td><td>后轮距(mm):{{car.trackrear}}</td>
					</tr>
					<tr>
						<td>价格:{{car.price}}元</td><td>整备质量(kg):{{car.weight}}</td>
					</tr>
				</table>
				<div>
					<a href="#" ms-click='goCar(car,-1)'>上一款</a>
					<a href="#" ms-click='goCar(car,+1)'>下一款</a>
					<a href="#" ms-click='returnTable'>返回列表</a>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'south',title:'图片',height:270" >
		<div ms-controller="picture">
			<div>
				<a href="#" ms-repeat='pics' ms-click='display(el)'>{{el.color}} </a>
			</div>
			<img ms-src="{{url}}" ms-visible='url!=""' width='400px' height='300px'>
		</div>
	</div>
</div>
<script>
	(function($,avalon){
		var brandArr=${brandData},
		carquery=avalon.define('carquery',function(vm){
			vm.brands=[];vm.brandId=0;
			vm.series=[];vm.seriesId=0;
			vm.carTypes=[];vm.carTypeId=0;

			vm.seatNumbers=[];
			vm.sideDoorNumbers=[];

			vm.levels={
				1:'微型车',
				2:'小型车',
				3:'紧凑型',
				4:'中型车',
				5:'中大型',
				6:'豪华车',
				7:'SUV',
				8:'MPV',
				9:'跑车',
				10:'皮卡',
				11:'微面',
				12:'电动车'
			};
			vm.openTypes={
				1:'平开',
				2:'侧滑',
				3:'对开',
				4:'上开'
			};
			vm.structures={
				1:'两厢',
				2:'三厢',
				3:'掀背',
				4:'旅行版',
				5:'硬顶敞篷',
				6:'软顶敞篷',
				7:'硬顶跑车',
				8:'客车',
				9:'货车',
			};

			//提交查询,传入一个页数参数,指定跳到哪页
			vm.submit=function(page){
				var page=content.page=page||1,
				form=$('#qq'),data=form.serialize()+'&page='+page+'&size='+content.size;
				'brandId,seriesId,carTypeId'.split(',').forEach(function(key){
					data+='&'+key+'='+carquery[key];
				});
				$.ajax({
					url:form.attr('action'),
					type:'post',
					data:data,
					success: content.$normalizeData
				});
			}

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

		//生成数组,数字下拉列表用
		function genArr(i){
			var ret=[];
			while(i--)ret[i]=i+1;
			return ret;
		}

		//监听品牌的变化
		carquery.$watch('brandId',function(id){
			var series=id==0?[]:brandArr.filter(function(o){
				return o.id==id;
			})[0].series;
			carquery.$seriesInit(series);
		});

		//监听车系的变化
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
		//全局初始化
		carquery.$init();
		var content=avalon.define('carTypeContent',function(vm){
			vm.page=1;
			vm.size=10;
			vm.last=0;
			vm.cars=[];
			vm.url='';
			vm.showTable=true;
			vm.car={}
			//黑、白、银、灰、红、绿、蓝、黄、褐
			vm.$colors={
				1:'黑',
				2:'白',
				3:'银',
				4:'灰',
				5:'红',
				6:'绿',
				7:'蓝',
				8:'黄',
				9:'褐'
			};

			//显示车型图片,当点击表格的行时会调用
			vm.showPic=function(el){
				vm.showTable=false;
				vm.car=el;
				$.ajax({
					url:'/car/showPic.action',
					data:{carTypeId:el.id},
					success:function(data){
						data.forEach(function(o){
							o.color=vm.$colors[o.color]
						});
						pic.pics=data;
						pic.display(data[0]);
					}
				});
			}

			//详情页面中返回表格视图
			vm.returnTable=function(){
				vm.showTable=true;
			};

			//详情页面中上一款,下一款导航
			vm.goCar=function(c,step){
				var index=0;
				vm.cars.forEach(function(o,i){
					if(o.id==c.id)index=i+step;
				});
				if(index>=0 && index<vm.cars.length) vm.showPic(vm.cars[index])
			}


			//表格下面的翻页
			vm.goPage=function(page){
				if(page=='first'){
					vm.page=1
					}else if(page=='prev'){
					vm.page--;
					}else if(page=='next'){
					vm.page++;
					}else if(page=='last'){
					vm.page=vm.last;
				}
				carquery.submit(vm.page);
			}

			//数据标准化,格式化
			vm.$normalizeData=function(p){
				content.showTable=true;
				var list=p.rows;
				content.last=Math.ceil(p.total/content.size);
				list.forEach(function(o){
					o.structure=carquery.structures[o.structure];
					o.level=carquery.levels[o.level];
					o.openType=carquery.openTypes[o.openType];
					var ext=o.extendProperty?$.parseJSON(o.extendProperty):{};
					$.extend(o,ext);
				});
				vm.cars=list;
			};
		});
		var pic=avalon.define("picture",function(vm){
			vm.url="";
			vm.pics=[];
			//加载图片url
			vm.display=function(o){
				vm.url=o&&o.picUrl||"";
			}
		});
	})(jQuery,avalon);
</script>
