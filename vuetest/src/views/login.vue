<template>
  <div>
    <el-container>
      <el-header>
        <img class="logo" src="https://www.markerhub.com/dist/images/logo/markerhub-logo.png" alt="">
      </el-header>

      <el-main>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username">
              <span slot="prefix">
                <svg-icon icon-class="user" class="color-main"></svg-icon>
              </span>
            </el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password">
            <span slot="prefix">
              <svg-icon icon-class="password" class="color-main"></svg-icon>
            </span>
            <span slot="suffix" @click="showPwd">
              <svg-icon icon-class="eye" class="color-main"></svg-icon>
            </span>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm">登录</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
      return {
        ruleForm: {
          username: 'root',
          password: '123456'
        },
        loading: false,
        pwdType: "password",
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'change' },
            { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
          ]
        }
      };
    },
  methods: {
    showPwd(){
        if (this.pwdType === "password") {
          this.pwdType = "";
        } else {
        this.pwdType = "password";
        }
      },
    submitForm() {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          // let params = { JSON.stringify(params)
          //   username: this.ruleForm.username,
          //   password: this.ruleForm.password
          // }
          // alert('submit!');
          this.loading = true
          // this.$axios.post('http://localhost:8081/login',this,this.ruleForm).then(res => {
          //   console.log(res);
          this.$store.dispatch("Login", this.ruleForm).then(response => {
            this.loading = false;
            let code = response.data.code;
            if (code == 200){
              this.$router.push({path: '/success',
              query: { data: response.data.msg }
              });
            }else {
              this.$router.push({
                path: '/error',
                query: { message: response.data.msg }
              });
            }
            
          }).catch(message => {
            this.loading = false;
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .logo {
    height: 60%;
    margin-top: 10px;
  }
  .demo-ruleForm {
    max-width: 500px;
    margin: 0 auto;
  }
</style>
