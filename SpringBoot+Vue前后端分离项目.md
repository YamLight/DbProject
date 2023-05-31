# 前端准备

1. 表单内容
   src/views/index.vue

   ![image-20230526172836150](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230526172836150.png)

2. 下拉表单
   src/layout/components/Navbar.vue
   ![image-20230526173308478](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230526173308478.png)

3. 路由管理
   ![image-20230526175101251](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230526175101251.png)

4. 标签导航栏
   ![image-20230527174611373](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230527174611373.png)

   ![image-20230527174552893](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230527174552893.png)

   ![image-20230527174651223](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230527174651223.png)

   ![image-20230527174717175](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230527174717175.png)

   ![image-20230527174807359](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230527174807359.png)

   ```vue
   <template>
     <div :class="classObj" class="app-wrapper">
       <div v-if="device==='mobile'&&sidebar.opened" class="drawer-bg" @click="handleClickOutside" />
       <sidebar class="sidebar-container" />
       <div class="main-container">
         <div :class="{'fixed-header':fixedHeader}">
           <navbar />
           <tags-view/>
         </div>
         <app-main />
       </div>
     </div>
   </template>
   
   <script>
   import { Navbar, Sidebar, AppMain, TagsView} from './components'
   import ResizeMixin from './mixin/ResizeHandler'
   
   export default {
     name: 'Layout',
     components: {
       Navbar,
       Sidebar,
       AppMain,
       TagsView
     },
   ```

   ```vue
   export { default as TagsView } from './TagsView'
   ```

   5. 前后端对接
      ![image-20230530161043385](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530161043385.png)
      ![image-20230530161110564](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530161110564.png)
      ![image-20230530161136284](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530161136284.png)
   6. 用户管理页面布局
      ![image-20230530185146495](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530185146495.png)
      ![image-20230530190718301](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530190718301.png)
      ![image-20230530190735031](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530190735031.png
   7. 用户查询
      ![image-20230530202316573](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530202316573.png)
      ![image-20230530202621411](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530202621411.png)
      用钩子函数，在每次加载的时候查询
      ![image-20230530202700905](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230530202700905.png)
   8. 数据验证
      ![image-20230531100113092](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230531100113092.png)
   
      ```vue
      export default {
        data() {
          var checkEmail = (rule, value, callback) => {
            var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/
            if (!reg.test(value)){
              return callback(new Error('邮箱格式错误'));
            }
            callback();
          }
          return {
            formLabelWidth: "130px",
            userForm: {},
            dialogFormVisible: false,
            title: "",
            total: 0,
            searchModel: {
              pageNo: 1,
              pageSize: 10,
            },
            userList: [],
            rules:{
              username: [
                  { required: true, message: '请输入用户名', trigger: 'blur' },
                  { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
                ],
              phone: [
                  { required: true, message: '请输入手机号码', trigger: 'blur' },
                  { min: 11, max: 11, message: '手机号格式错误', trigger: 'blur' }
                ],  
              password: [
                  { required: true, message: '请输入登录初始密码', trigger: 'blur' },
                  { min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur' }
                ],  
              email: [
                  { required: true, message: '请输入电子邮件', trigger: 'blur' },
                  { validator: checkEmail, trigger: 'blur'}
                ],  
            }, 
          };
        },
      ```

            9. 修改用户数据
               ![image-20230531110027360](C:\Users\北师大在逃学子\AppData\Roaming\Typora\typora-user-images\image-20230531110027360.png)