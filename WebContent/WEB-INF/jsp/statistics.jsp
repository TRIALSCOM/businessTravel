
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/sorie.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
    <script>
        $(document).ready(function(){
            var chart = document.getElementById('chart');
            var chartData = echarts.init(chart);

            chartData.setOption({

                tooltip:{
                    show:true,
                    trigger:"axis"
                },
                legend:{
                    top:"30px",
                    data:['行程数','积分']
                },
                xAxis:{
                    data:[]
                },
                yAxis:[
                    {
                        type:"value",
                        name:"行程数",
                        min:0,
                        max:15,
                        interval:3,
                        axisLabel:{
                            formatter:"{value}次"
                        }
                    },
                    {
                        type:"value",
                        name:"积分",
                        min:0,
                        max:250,
                        interval:50,
                        axisLabel:{
                            formatter:"{value}分"
                        }
                    },

                ],
                dataZoom: [{
                    type: 'inside',
                    start: 0,
                    end: 100
                }, {
                    start: 0,
                    end: 100,
                    handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                    handleSize: '80%',
                    handleStyle: {
                        color: '#fff',
                        shadowBlur: 3,
                        shadowColor: 'rgba(0, 0, 0, 0.6)',
                        shadowOffsetX: 2,
                        shadowOffsetY: 2
                    }
                }],
                toolbox:{
                    show:true,
                    feature:{
                        saveAsImage:{
                            show:true
                        },
                        dataView:{
                            show:true,
                            readOnly:true,
                            optionToContent: function(opt) {
                                var axisData = opt.xAxis[0].data;
                                var series = opt.series;
                                var table = '<div class="col-md-12"><table class = "table table-striped TSTable table-hover "><thead><tr>'
                                    + '<th>姓名</th>'
                                    + '<th>' + series[0].name + '</th>'
                                    + '<th>' + series[1].name + '</th>'
                                    + '</tr></thead><tbody>';
                                for (var i = 0, l = axisData.length; i < l; i++) {
                                    table += '<tr>'
                                        + '<td>' + axisData[i] + '</td>'
                                        + '<td>' + series[0].data[i] + '</td>'
                                        + '<td>' + series[1].data[i] + '</td>'
                                        + '</tr>';
                                }
                                table += '</tbody></table></div>';
                                return table;
                            }
                        },
                        magicType:{
                            type:["line","bar"]
                        }
                    }
                },
                series:[
                    {
                        name:'行程数',
                        type:'bar',
                        data:[],
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#bcf6db'},
                                        {offset: 0.5, color: '#8cecf0'},
                                        {offset: 1, color: '#7e91f0'}
                                    ]
                                )
                            },
                            emphasis: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#eef79c'},
                                        {offset: 0.7, color: '#f7e06c'},
                                        {offset: 1, color: '#f6be31'}
                                    ]
                                )
                            }
                        }

                    },
                    {
                        name:'积分',
                        type:'bar',
                        yAxisIndex:1,
                        data:[],
                        itemStyle: {
                            normal: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#c1f68b'},
                                        {offset: 0.5, color: '#a8f083'},
                                        {offset: 1, color: '#53f05a'}
                                    ]
                                )
                            },
                            emphasis: {
                                color: new echarts.graphic.LinearGradient(
                                    0, 0, 0, 1,
                                    [
                                        {offset: 0, color: '#eef79c'},
                                        {offset: 0.7, color: '#f7e06c'},
                                        {offset: 1, color: '#f6be31'}
                                    ]
                                )
                            }
                        }

                    }
                ]
            });
            chartData.showLoading();
            function bindData(){
                setTimeout(function(){
                    $.get('goToStatistics').done(function (data) {
                        chartData.hideLoading();
                       // data=JSON.parse(data);
                       data=eval('(' + data + ')');
                        console.dir(data);
                        // 填入数据
                        chartData.setOption({
                            xAxis: {
                                data: data.categories
                            },
                            series: [{
                                name: '行程数',
                                data: data.cishu
                            },
                                {
                                    name: '积分',
                                    data: data.jifen
                                }]
                        });

                    });
                },700)
            }
            bindData();

            function eConsole(param)
            {
                console.dir(param);
            }

            chartData.on("click",eConsole);
            chartSolo();
        });


        function chartSolo(){

            var chart = document.getElementById('chartSolo');
            var chartData = echarts.init(chart);

            chartData.setOption({
                tooltip:{
                    show:true,
                    trigger:"item",
                    formatter:"{a} <br/>{b}:{c} ({d}%)"
                },
                legend:{
                    orient:"vertical",
                    data:[]
                },

                toolbox:{
                    show:true,
                    feature:{
                        saveAsImage:{
                            show:true
                        }
                    }
                },
                series:[
                    {
                        name:'访问来源',
                        type:'pie',
                        radius:"55%",
                        center:["50%","60%"],
                        data:[]
                    }
                ]
            });
            chartData.showLoading();
            function bindData(){
                setTimeout(function(){
                    $.get('goToStatisticsPie').done(function (data) {
                        chartData.hideLoading();
                        console.dir(data);
                        // 填入数据
                         data=eval('(' + data + ')');
                        chartData.setOption({
                            series: [{
                                data:(function(){
                                    var res = [];
                                    if(data == null){
                                        return null;
                                    }
                                    var vLen = data.value.length;
                                    var nLen =  data.name.length;
                                    while (vLen--, nLen--) {
                                        if( data.name[nLen] != null &&  data.name[nLen] != "" &&
                                            data.value[vLen] != null && data.value[vLen] != "") {
                                            res.push({
                                                name: nLen >= 0 ? data.name[nLen] : "",
                                                value: vLen >= 0 ? data.value[vLen] : ""
                                            });
                                        }
                                    }
                                    return res;
                                })()
                            }],

                            legend: [{
                                data:data.name
                            }]
                        });

                    });
                },700)
            }
            bindData();
            function eConsole(param)
            {
                console.dir(param);
            }
            chartData.on("click",eConsole);
        }

    </script>
    <style type="text/css">
    /*#chart{*/
        /*position: relative;*/
        /*top: 50%;*/
        /*left: 50%;*/
        /*-webkit-transform: translate(-50%, -50%);*/
        /*-moz-transform: translate(-50%, -50%);*/
        /*-ms-transform: translate(-50%, -50%);*/
        /*-o-transform: translate(-50%, -50%);*/
        /*transform: translate(-50%, -50%);*/
    /*}*/
    </style>
        </head>
<body>
<div class="container TSContainerPosition">
    <div class="row">

        <div class="col-md-12 col-xs-12 col-lg-12  TSBoxPosition">
            <div class="fh5co-form animate-box TSBox">
                <div class="row">
                    <div class="col-md-12">
                        <h2>统计</h2>
                    </div>
                    <div id="chart" class="col-md-11 " style="height: 450px"></div>
                    <div class="col-md-11 " style="height: 60px;"><br/></div>
                    <div id="chartSolo" class="col-md-11" style="height: 400px;"></div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>