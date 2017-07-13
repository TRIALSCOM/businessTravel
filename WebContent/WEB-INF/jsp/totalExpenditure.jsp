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
            loadChart();
        });
        function loadChart(){
            var chart = document.getElementById('chart');
            var chartData = echarts.init(chart);

            chartData.setOption({

                tooltip:{
                    show:true,
                    trigger:"axis"
                },
                legend:{
                   
                    top:"10px",
                    right:"100px",
                    data:['总花费']
                },
                xAxis:{
                    data:[]
                },
                yAxis:[
                    {
                        type:"value",
                        name:"总花费",
                        min:0,
                        max:60000,
                        interval:6000,
                        axisLabel:{
                            formatter:"{value}元"
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
                                    + '</tr></thead><tbody>';
                                for (var i = 0, l = axisData.length; i < l; i++) {
                                    table += '<tr>'
                                        + '<td>' + axisData[i] + '</td>'
                                        + '<td>' + series[0].data[i] + '</td>'
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
                        name:'总花费',
                        type:'bar',
                        data:[],
                        barWidth:80,
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
                                        {offset: 0, color: '#f6d2f7'},
                                        {offset: 0.7, color: '#f7a5e6'},
                                        {offset: 1, color: '#f64cdc'}
                                    ]
                                )
                            }
                        },
                    },
                ]
            });
            chartData.showLoading();
            function bindData(){
                setTimeout(function(){
                    var text = $("#monthSelect").find("option:selected").text();
                    $.get("goToCostDetailByMOYON?identy=总花费&monthOrYear="+text+"").done(function (data) {
                        chartData.hideLoading();
                        data=eval('(' + data + ')');
                        console.dir(data);
                        // 填入数据
                        chartData.setOption({
                            xAxis: {
                                data: data.categories
                            },
                            series: [{
                                name: '总花费',
                                data: data.cost
                            }]
                        });

                    });
                },700);
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
                        <h2>历年统计</h2>
                    </div>
                    <div id="chart" class="col-md-11 " style="height: 450px"></div>
                    <div class="col-md-11 " style="height: 60px;"><br/></div>


                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>