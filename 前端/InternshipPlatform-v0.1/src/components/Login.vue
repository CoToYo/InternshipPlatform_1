<template>
  <div class="login-wrap">
	  
    <el-form class="login-container">		<!-- /*登录框*/ -->
      <h1 class="title">欢迎登录实习管理系统</h1>
		
		<el-form :model="ruleForm" :rules="rules" :ref="ruleForm">
		  <el-form-item label="用户名" prop="account">				
			<el-input type="number" v-model="ruleForm.account" placeholder="请输入学号" 
						autocomplete="off" >
			</el-input>
		  </el-form-item>
		  <el-form-item label="密码" prop="password">
			<el-input type="password" v-model="ruleForm.password" @keyup.enter.native="dosubmit()"
					placeholder="请输入密码" autocomplete="off">
			</el-input>
		  </el-form-item>
			
		  <el-form-item>			<!--登录键-->
			<el-button type="primary" style="width: 100%;" @click="submit()">登录</el-button>
		  </el-form-item>
		</el-form>
    </el-form>
  </div>
</template>
 
<script>
	import axios from 'axios'
	import qs from 'qs'


  export default {
    name: 'Login',
    data() {
      return {
		  ruleForm:{  //初始化
			account: '',
			password: ''
		  },
		  rules:{     //校验
			  account:[
				  { required:true, message:'请输入用户名', trigger:'blur' },
				  { min:3, max:11 , message:'长度在3-11个字符', trigger:'blur' }
			  ],
			  password:[
				  {required:true, message:'请输入密码', trigger:'blur'}
			  ]
		  }
      }
    },
    methods: {
      dosubmit() {
        let {account,password} = {
          account: this.account,
          password: this.password
        };
		// var url = "http://localhost:8080/";
		this.$http({
			method:'post',
			url:'',			//用户密码接受URL
			data:{user:account,password:password}
		}).then(res=>{
			console.log(res);
			let{code,msg} = res.data;
			if(code == 200){      //后端返回一个数
				this.$router.push('/home'); //登录正确跳转主界面
			}else{
				alert(msg);
			}
		})},
		/*
		axios.get(url, { //数据保存到json对象的params属性
			params:params
		}).then(function(response) {
		    console.log(response);
		}).catch(function(error) {
		    console.log(error);
		});
		
		var str=qs.stringify(params);
		axios.post('http://172.20.10.09:8080',str        //数据直接保存到json对象
		).then(function(response) {
			console.log(response);
		}).catch(function(error) {
		    console.log(error);
		}); */ 
		submit(){
			axios.post('http://172.20.10.9:8080/InternshipPlatform_1/attendance', {
				firstName: 'Fred',
				//lastName: 'Flintstone'
			  })
			  .then(function (response) {
				console.log(response);
			  })
			  .catch(function (error) {
				console.log(error);
			  });
		}
		


      }
    }
  
</script>

<!--去除el-input中的箭头-->
<style lang="css" scoped>
  /deep/.login-container input::-webkit-outer-spin-button,
  /deep/.login-container input::-webkit-inner-spin-button {
    -webkit-appearance: none!important;
  }
  /deep/.login-container input[type="number"]{
    -moz-appearance: textfield;
  }
</style>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .login-wrap {
    box-sizing: border-box;
    width: 100%;
    height: 100%;
    padding-top: 10%;
    /* background-color: #112346; */
    background-repeat: no-repeat;
    background-position: center right;
    background-size: 100%;
  }
 
  .login-container {
    border-radius: 10px;
    margin: 0px auto;
    width: 350px;
    padding: 30px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    text-align: left;
    box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);

  }
 
  .title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
</style>


