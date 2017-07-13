//菜单JS
var menuFunc = function(role) {
       var defaultData = [
          {
            text: '出差',
            tags: ['0'],
            nodes:[
              {
                text: '出差计划',
                tags: ['0']
              },
              {
                text: '出差记录',
                tags: ['0']
              }
            ]
          }
        ];

      var bossData = [
        {
            text: '员工管理',
            tags: ['0'],
            nodes:[
              {
                text: '用户管理',
                tags: ['0']
              },

              {
                text: '新用户管理',
                tags: ['0']
              }
            ]
        }
       
      ];

         var commonStatisticsData = [
        {
            text: '统计',
            tags: ['0'],
             nodes:[
              {
                text: '行程积分统计',
                tags: ['0']
              }
            ]
        }
      ];

        var BossStatisticsNodes = [
             {
                text: '月统计',
                tags: ['0']
              },

              {
                text: '年统计',
                tags: ['0']
              },
              {
                text: '历来统计',
                tags: ['0']
              }
        ];
      
      
      var auditData = [
          {
            text: '审核',
            tags: ['0'],
            nodes:[
              {
                text: '待审核',
                tags: ['0']
              },

              {
                text: '已审核',
                tags: ['0']
              }
            ]
          }
      ];
     var companyManageData = [
        {
            text: '公司管理',
            tags: ['0'],
             nodes:[
              {
                text: '部门管理',
                tags: ['0']
              }
            ]
        }
      ];
      if(role == "总经理" || role == "系统管理员"){
        defaultData.push.apply(defaultData,bossData);
        defaultData.push.apply(defaultData, companyManageData);
      }

      if(role == "总经理" || role == "系统管理员" || role == "部门经理"){
        defaultData.push.apply(defaultData,auditData);
      }
      
     if(role == "总经理" || role == "部门经理"){
        commonStatisticsData[0].nodes.push.apply(commonStatisticsData[0].nodes, BossStatisticsNodes);
      }
      defaultData.push.apply(defaultData,commonStatisticsData);
       var urlMap = {};
       urlMap['出差计划'] = "business.html";
       urlMap['出差记录'] = "goToTravelRecord";
       urlMap['用户管理'] = "userAdminManage";
       urlMap['新用户管理'] = "goToNewUserManage";
       urlMap['待审核'] = "goToPendingaudit";
       urlMap['已审核'] = "goToAdults";
     // urlMap['统计'] = "statistics";
       urlMap['月统计'] = "monthlyExpenditure";
       urlMap['年统计'] = "annualExpenditure";
       urlMap['历来统计'] = "totalExpenditure";
       urlMap['行程积分统计'] = "statistics";
      
        urlMap['部门管理'] = "goToAddDept";
    
       
        $('#treeview1').treeview({
          data: defaultData,
          selectedBackColor:'#34CCCC',
          expandIcon: 'glyphicon glyphicon-chevron-right',
          collapseIcon: 'glyphicon glyphicon-chevron-down',
          levels: 1,
          onNodeSelected: function(event, node) {
              if(node.nodes != null){
                var select_node = $('#treeview1').treeview('getSelected');
                if(select_node[0].state.expanded){
                  $('#treeview1').treeview('collapseNode',select_node);
                  select_node[0].state.selected=false;
                }
                else{
                  $('#treeview1').treeview('expandNode',select_node);
                  select_node[0].state.selected=false;
                }
              }
              if(urlMap[node.text] != null)
                $("#mainFrame").attr("src", urlMap[node.text]);
            }
        }); 


}
//菜单JS结束