<template>
  <div>
    <el-container>      
      <el-main>
        <el-header>
        <img class="mlogo" src="https://cdn.staticaly.com/gh/feadechou/img-bed@main/avataaars.6ooctx7djqw0.webp" alt="">
      </el-header>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>

</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      ruleForm: {
        username: "markerhub",
        password: "111111"
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 15, message: "长度在 3 到 15 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // alert("submit!");
          const _this = this;//全局地址
          //login:http://localhost:8081/login 后端地址
          this.$axios.post('/login',this.ruleForm).then(res => {
            
            console.log(res.headers);
            console.log(res);
            const jwt = res.headers['authorization'];
            const userInfo = res.data.data;
            console.log(userInfo);

            //把数据共享出去
            _this.$store.commit("SET_TOKEN",jwt);
            _this.$store.commit("SET_USERINFO",userInfo);

            //获取
            console.log(_this.$store.getters.getUser);

            _this.$router.push("/blogs")
          })

        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>
<style scope>
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body>.el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.demo-ruleForm {
  max-width: 500px;
  margin: 0 auto;
}

.mlogo {
    height: 60%;
    margin-top: 10px;
  }
</style>