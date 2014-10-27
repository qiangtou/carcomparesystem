<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<script src='/js/lib/avalon.js'></script>
<script src='/js/lib/jquery.min.js'></script>
<div ms-controller='carquery'>
	<select ms-duplex='brandId'><option ms-repeat='brands' ms-value="{{el.id}}">{{el.sName}} {{el.name}}</option></select>
	<select ms-duplex='seriesId'><option ms-repeat='series' ms-value="{{el.id}}">{{el.name}}</option></select>
	<select ms-duplex='carTypeId'><option ms-repeat='carTypes' ms-value="{{el.id}}">{{el.year}} {{el.name}}</option></select>
</div>
<div>
	<form id='qq' action="/car/query.action" method="post">
		级别
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
		<select name='structure'>
			<option value="0">选择结构</option>
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
		<select name=seatNum>
			<option value="0">座位数</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
			<option value="29">29</option>
			<option value="30">30</option>
			<option value="31">31</option>
			<option value="32">32</option>
			<option value="33">33</option>
			<option value="34">34</option>
			<option value="35">35</option>
			<option value="36">36</option>
			<option value="37">37</option>
			<option value="38">38</option>
			<option value="39">39</option>
			<option value="40">40</option>
			<option value="41">41</option>
			<option value="42">42</option>
			<option value="43">43</option>
			<option value="44">44</option>
			<option value="45">45</option>
			<option value="46">46</option>
			<option value="47">47</option>
			<option value="48">48</option>
			<option value="49">49</option>
			<option value="50">50</option>
			<option value="51">51</option>
			<option value="52">52</option>
			<option value="53">53</option>
			<option value="54">54</option>
			<option value="55">55</option>
			<option value="56">56</option>
			<option value="57">57</option>
			<option value="58">58</option>
			<option value="59">59</option>
			<option value="60">60</option>
			<option value="61">61</option>
			<option value="62">62</option>
			<option value="63">63</option>
			<option value="64">64</option>
			<option value="65">65</option>
			<option value="66">66</option>
			<option value="67">67</option>
			<option value="68">68</option>
			<option value="69">69</option>
			<option value="70">70</option>
			<option value="71">71</option>
			<option value="72">72</option>
			<option value="73">73</option>
			<option value="74">74</option>
			<option value="75">75</option>
			<option value="76">76</option>
			<option value="77">77</option>
			<option value="78">78</option>
			<option value="79">79</option>
			<option value="80">80</option>
			<option value="81">81</option>
			<option value="82">82</option>
			<option value="83">83</option>
			<option value="84">84</option>
			<option value="85">85</option>
			<option value="86">86</option>
			<option value="87">87</option>
			<option value="88">88</option>
			<option value="89">89</option>
			<option value="90">90</option>
			<option value="91">91</option>
			<option value="92">92</option>
			<option value="93">93</option>
			<option value="94">94</option>
			<option value="95">95</option>
			<option value="96">96</option>
			<option value="97">97</option>
			<option value="98">98</option>
			<option value="99">99</option>
			<option value="100">100</option>
			</select >
			<select name='sideDoorNum'>
				<option value="0">单侧门数量</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
			<select name="openType">
				<option value="0">开门方式</option>
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
	<script>
		(function($,avalon){
			var brandArr=${brandData},
			carquery=avalon.define('carquery',function(vm){
				vm.brands=[];vm.brandId=0;
				vm.series=[];vm.seriesId=0;
				vm.carTypes=[];vm.carType=0;

				vm.$init=function(){
					arr=brandArr;
					arr.unshift({name:'选择品牌',id:0});
					carquery.brands=arr;
					carquery.brandId=0;
					carquery.$seriesInit();
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
			var form=$('#qq').submit(function(){
				$.ajax({
					url:form.attr('action'),
					type:'post',
					data:form.serialize(),
					success:$.noop
				});
				return false;
			});
		})(jQuery,avalon);
	</script>
