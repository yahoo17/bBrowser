<template>
    <div>
        <!-- 主要文字 -->
            <li class="main_content">
                <div class="media bottom_cantainer" v-for="topNews in topNews" :key="topNews.path">
                    <a :href="topNews.path">
                    <div class="media-body media-middle text">
                        {{topNews.title}}  
                    </div>
                    </a>
                </div>
                <div class="media-left media-middle day_choice">每日精选</div>
            </li>

            <!-- 大图 -->
            <div class="img_container">
                <a :href="allNews[0].path">
                    <img class="media-object img" :src="allNews[0].image">
                </a>
            </div>

            <div class="media bottom_cantainer" v-for="bottomNews in bottomNews" :key="bottomNews.path">
                <a :href="bottomNews.path">
                <div class="media-body media-middle text1">
                    {{bottomNews.title}}  
                </div>
                <div class="media-right">
                    <img class="media-object" :src="bottomNews.image">
                </div>
                </a>
            </div>
    </div>
</template>
<script>
export default {
    name: "Recommend",
    data () {
    return {
        //获取到的所有新闻
        allNews: [],
        //存储底部新闻数据
        bottomNews: [],
        //存储顶部新闻
        topNews: [],
    }
  },
  created(){
      this.getNews();
  },
  updated(){
    //   this.getNews();
  },
  methods: {
      //获取咨询页面所有新闻
      getNews: function(){
          this.$post('https://api.apiopen.top/getWangYiNews').then((response) => {
            // console.log(response)
            if(response.code===200){
                this.allNews = response.result;
                this.topNews = this.allNews.slice(4,7);
                this.bottomNews=this.allNews.slice(1,4);
            }
            else{
                alert("获取数据失败！")
            }
      })
      }
  }
}
</script>
<style scoped>
li,ul{
    list-style:none;
}
.search {
    margin-top: 2rem;
}
.nav_container{
    -webkit-margin-start: 1rem;
}
.web_nav1{
    display: block;
    padding: 0 2rem;
    padding-bottom: 1rem;
}
.font-nav{
    font-size: 12px;
    color: rgb(177, 170, 170);
}
.main_content{
    width: 90%;
    -webkit-margin-start: 2rem;
}
.day_choice{
    padding-top: 1rem;
    font-weight: 600;
}
.img_container{
    width: 90%;
    margin-left: 2rem;
}
.img{
    width: 100%;
    margin: 0 auto;
}
.bottom_cantainer{
    display: flex;
    width: 90%;
    margin-left: 2rem;
}
.text{
    color:black;
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
}
.text1{
    flex: 7;
}
.cat_img{
    flex:2;
}
.img1{
    width: 100%;
    height: auto;
}
</style>