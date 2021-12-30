<template>
	<div class="home_page fillcontain">
		<el-row style="height: 100%;">
	  		<el-col :span="4"  style="min-height: 100%; background-color: #324057;">
				<el-menu :default-active="defaultActive" style="min-height: 100%;" theme="dark" router>
					<el-menu-item index="home"><i class="el-icon-menu"></i>今日事项</el-menu-item>
					<el-submenu index="2">
						<template slot="title"><i class="el-icon-document"></i>我的实习</template>
						<el-menu-item index="PracRecom">实习推荐</el-menu-item>
						<el-menu-item index="PracReport">实习报告</el-menu-item>
						<el-menu-item index="myEVAL">我的评价</el-menu-item>
					</el-submenu>
					<el-submenu index="3">
						<template slot="title"><i class="el-icon-plus"></i>个人出勤</template>
						<el-menu-item index="workSTATS">出勤统计</el-menu-item>
						<el-menu-item index="askLeave">请假申请</el-menu-item>
					</el-submenu>
					<el-submenu index="4">
						<template slot="title"><i class="el-icon-star-on"></i>个人信息</template>
						<el-menu-item index="stuInfo">信息修改</el-menu-item>
						<!-- <el-menu-item index="newMember">用户数据</el-menu-item> -->
					</el-submenu>
					<el-menu-item index="logout">退出系统</el-menu-item>

				</el-menu>
			</el-col>
			<el-col :span="20" style="height: 100%;overflow: auto;">
				<keep-alive>
				    <router-view></router-view>
				</keep-alive>
			</el-col>
		</el-row>
  	</div>
</template>

<script>
    export default {
		computed: {
			defaultActive: function(){
				return this.$route.path.replace('/', '');
			}
		},
    }
</script>



 <style lang="less" scoped>
 	@import '../style/mixin';
 	.home_page{

 	}
 </style>
