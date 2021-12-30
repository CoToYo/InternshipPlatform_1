import Vue from 'vue'
import VueRouter from 'vue-router'
//import Login from '@/components/Login'
import home from '@/student/home'

Vue.use(VueRouter)
const Login = r => require.ensure([], () => r(require('@/components/Login.vue')), 'login');
const PracRecom = r => require.ensure([], () => r(require('@/student/PracRecom.vue')), 'PracRecom');
const blank = r => require.ensure([], () => r(require('@/student/blank')), 'home');
const PracReport = r => require.ensure([], () => r(require('@/student/PracReport.vue')), 'PracReport');
const myEVAL = r => require.ensure([], () => r(require('@/student/myEVAL.vue')), 'myEVAL');
const workSTATS = r => require.ensure([], () => r(require('@/student/workSTATS.vue')), 'workSTATS');
const askLeave = r => require.ensure([], () => r(require('@/student/askLeave.vue')), 'askLeave');
const stuInfo = r => require.ensure([], () => r(require('@/student/stuInfo.vue')), 'stuInfo');



const routes = [
{ path: '/', component: Login},
{
	path: '/home', 
	component: home,
	name:'',
	children:[{
		path: '',
		component: blank,  //此处添加事项中要显示的组件
		meta: [],
	},{
		path:'/PracRecom',
		component:PracRecom,
		meta:['我的实习','实习推荐'],
	},{
		path:'/PracReport',
		component:PracReport,
		meta:['我的实习','实习报告'],
	},{
		path:'/myEVAL',
		component:myEVAL,
		meta:['我的实习','我的评价'],
	},{
		path:'/workSTATS',
		component:workSTATS,
		meta:['个人出勤','出勤统计'],
	},{
		path:'/askLeave',
		component:askLeave,
		meta:['个人出勤','请假申请'],
	},
	{
		path:'/stuInfo',
		component:stuInfo,
		meta:['个人信息','信息修改'],
	},
	]
}

 // ,{ path: '/Login', component: Login }
]
 
const router = new VueRouter({
 routes: routes   //注意是routes
})
 
export default router