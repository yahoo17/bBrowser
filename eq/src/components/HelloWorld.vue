<template>
 <div>
        <div class="search">
            <div class="col-lg-6">
                <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
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
                <ul class="nav nav-pills web_nav1 .nav-justified">
                    <li role="presentation"><a href="#" class="font-nav1">推荐</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">视频</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">娱乐</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">疫情</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">618</a></li>
                    <li role="presentation"><a href="#" class="font-nav1">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    </a></li>
                </ul>
        </div>

            <!-- 主要文字 -->
            <div class="main_content">
                <div class="media">
                    <div class="media-body">
                        浏览器是用来检索、展示以及传递Web信息资源的应用程序。Web信息资源由统一资源标识符所标记，它是一张网页、一张图片、一段视频或者任何在Web上所呈现的内容。使用者可以借助超级链接，通过浏览器浏览互相关联的信息。    
                    </div>
                </div>
                <div class="media-left media-middle day_choice">每日精选</div>
            </div>

            <!-- 大图 -->
            <div class="img_container">
                <a href="#">
                    <img class="media-object img" src="../assets/cat.jpg">
                </a>
            </div>

            <div class="media bottom_cantainer">
                <div class="media-body media-middle text">
                    浏览器是用来检索、展示以及传递Web信息资源的应用程序。  
                </div>
                <div class="media-right cat_img">
                    <a href="#">
                    <img class="media-object img1" src="../assets/cat.jpg">
                    </a>
                </div>
            </div>

    </div>
</template>

<script>
import 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
export default {
  name: 'HelloWorld',
  data () {
    return {
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.search {
    margin-top: 2rem;
}
.nav_container{
    -webkit-margin-start: 1rem;
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
    flex:7;
}
.cat_img{
    flex:2;
}
.img1{
    width: 100%;
    height: auto;
}
</style>
