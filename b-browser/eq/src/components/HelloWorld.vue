<template>
 <div>
        <div class="search">
            <div class="col-lg-6">
                <div class="input-group">
                <input type="text" class="form-control" placeholder="请输入网址" v-model="searchtext">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" @click="search(searchtext)">Go!</button>
                </span>
                </div><!-- /input-group -->
            </div> 
        </div>
        <div class="nav_container">
                <ul class="nav nav-pills web_nav .nav-justified">
                    <li role="presentation"><a href="http://www.people.com.cn/" class="font-nav">人民网</a></li>
                    <li role="presentation"><a href="http://www.xinhuanet.com/" class="font-nav">新华网</a></li>
                    <li role="presentation"><a href="https://www.cctv.com/" class="font-nav">央视网</a></li>
                    <li role="presentation"><a href="http://www.china.com.cn/" class="font-nav">中国网</a></li>
                    <li role="presentation"><a href="https://news.gmw.cn/" class="font-nav">光明网</a></li>
                </ul>
                <ul class="nav nav-pills .nav-justified">
                    <li role="presentation" class="web_nav1" @click="pbutton0()">推荐</li>
                    <li role="presentation" class="web_nav1" @click="pbutton1()">影视</li>
                    <li role="presentation" class="web_nav1" @click="pbutton2()">娱乐</li>
                    <li role="presentation" class="web_nav1" @click="pbutton3()">疫情</li>
                    <!-- <li role="presentation"><a href="#" class="font-nav1">618</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    </a></li> -->
                </ul>
        </div>

            <div class="comp">
                <!-- 动态组件部分 -->
            <keep-alive>
                <component :is="pageNum"/>
            </keep-alive>
            </div>

    </div>
</template>

<script>
import 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import Recommend from '../components/Recommend.vue'
import Video from '../components/Video'
import Outbreaks from '../components/Outbreaks'
import Entertainment from '../components/Entertainment'
export default {
  name: 'HelloWorld',
  data(){
      return{
          isActive: 0,
          //搜索内容
          searchtext: '',
      }
  },
  components: {
      Recommend,
      Video,
      Outbreaks,
      Entertainment
  },
  computed: {
      pageNum(){
          switch(this.isActive){
              case 0:
                  return "Recommend"
                  break;
              case 1:
                  return "Video"
                  break;
              case 2:
                  return "Entertainment"
                  break;
              case 3:
                  return "Outbreaks"
                  break;
              default:
                  return "Outbreaks"
          }
      }
  },
  methods: {
      pbutton0: function(){
          this.isActive = 0;
        //   console.log("切换组件！")
      },
      pbutton1: function(){
          this.isActive = 1;
        //   console.log("切换组件！")
      },
      pbutton2: function(){
          this.isActive = 2;
        //   console.log("切换组件！")
      },
      pbutton3: function(){
          this.isActive = 3;
        //   console.log("切换组件！")
      },
      search: function(text){
          console.log("搜索"+text);
          window.location.href = 'https://'+text;
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
    padding: 1rem 2rem;
}
.web_nav1:hover{
    cursor: pointer;
    background-color: rgb(94, 97, 136);
    color: white;
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
.comp {
    width: 100%;
}
a {
    text-decoration: none;   
}
</style>
