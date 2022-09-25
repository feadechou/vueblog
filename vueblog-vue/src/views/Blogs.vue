<template>
  <div>
    <Header></Header>
    <div class="block">
      <el-timeline>
        <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs">
          <el-card>
            <h4>
              <router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}">
                {{blog.title}}
              </router-link>
              <!-- 通过BlogDetail将id渲染到router的路径上 -->
            </h4>
            <p>
              {{blog.description}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>

      <el-pagination class="mpage" background layout="prev, pager, next" :current-page=currentPage :page-size=pageSize
        @current-change=page :total="total">
      </el-pagination>
      
    </div>
  </div>
</template>
<script>
import Header from "@/components/Header.vue";
export default {
  name: 'Blogs',
  components: { Header },
  props: [''],
  data() {
    return {
      blogs: {},
      currentPage: 1,
      total: 0,
      pageSize: 5
    };
  },
  watch: {},
  created() {
    this.page(1);
  },
  beforeMount() { },
  mounted() { },
  methods: {
    page(currentPage) {
      this.$axios.get('/blogs?currentPage=' + currentPage).then(res => {
        console.log(res);
        this.blogs = res.data.data.records;
        this.currentPage = res.data.data.current;
        this.total = res.data.data.total;
        this.pageSize = res.data.data.size;
      })

    }
  },
  computed: {}
}
</script>
<style>
.mpage {
  
  text-align: center;
}
</style>