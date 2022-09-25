<template>
  <div>
    <Header></Header>
    <div class="mblog">
      <h2>{{blog.title}}</h2>
      <el-button type="primary" icon="el-icon-edit">
        <router-link :to="{name: 'BlogEdit',param:{blogId:blog.id}}">
          编辑
        </router-link>
      </el-button>
      <el-divider></el-divider>
      <div class="markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>
<script>
import Header from '@/components/Header.vue';
import "github-markdown-css"
export default {
  name: '',
  components: { Header },
  props: [''],
  data() {
    return {
      blog: {
        id: "",
        title: "",
        content: ""
      },
      ownblog: false
    };
  },
  watch: {},
  created() {
    const blogId = this.$route.params.blogId
    console.log(blogId)
    const _this = this
    this.$axios.get('/blog/' + blogId).then(res => {
      const blog = res.data.data
      _this.blog.id = blog.id
      _this.blog.title = blog.title;

      var MardownIt = require("markdown-it")
      var md = new MardownIt()
      var result = md.render(blog.content)
      _this.blog.content = result;

      _this.ownblog = (blog.userId === _this.$store.getters.getUser.id)//编辑按钮的权限
    })
  },
  beforeMount() { },
  mounted() { },
  methods: {},
  computed: {}
}
</script>
<style scoped>
.mblog {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 100%;
  min-height: 700px;
  /* 左右 */
  padding: 20px 10px;
}
</style>