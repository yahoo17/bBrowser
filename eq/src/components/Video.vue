<template>
    <div class="vid">
        <div class="media" v-for="item in allVideos" :key="item.id">
                <button @click="openVideo(item.url)">
                    <a>
                <div class="media-body">
                    <p style="font-size: 12px;">{{item.title}}</p>
                    <p style="font-size: 10px; color: black;">{{item.description}}</p>
                </div>
                <div class="media-right">
                    <!-- <img class="media-object" src="../assets/cat.jpg"> -->
                </div>
                </a>
                </button>
            </div>
            <div class='mask' v-if='isVideo === true' @click='masksCloseFun'></div>
            <div class="video" v-if="isVideo===true">
                <video :src="videoUrl" controls='controls' autoplay>
                    "您的浏览器不支持播放此视频"
                </video>
            </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            allVideos: [],
            isVideo: false,
            videoUrl:''
        }
    },
    created(){
        this.getVideos();
    },
    updated(){
        // this.getVideos();
    },
    methods: {
        getVideos: async function(){
            await this.$fetch('http://api.tianapi.com/film/index?key=f2e40d8925195e3086f3df7b36b58d0b&num=10').then(res=>{
                // console.log(res);
                if(res.code===200){
                    this.allVideos = res.newslist;
                } else{
                    alert("加载数据失败！")
                }
            })
        },
        openVideo(url){
            this.isVideo = true;
            // this.videoUrl = 'https'+url;
            this.videoUrl = 'http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4'
            console.log("打开视频窗口:"+this.videoUrl)
            scroll(0,0);
        },
        masksCloseFun(){
            this.isVideo = false;
        }
    }
}
</script>
<style scoped>
.media {
    display: flex;
    width: 90%;
    margin: 1rem;
    margin-left: 2rem;
    z-index: 1;
}
.media-body {
    flex: 8;
    /* background-color: pink; */
}
.media-right {
    flex: 1;
    /* background-color: deeppink; */
}
.media-object {
    width: 100%;
    height: auto;
}
button{
    border: none;
    background-color: #fff;
}
.mask{
	position:fixed;
	top:0;
	left:0;
	bottom:0;
	right:0;
	z-index:2;
	background-color: #000000;
    opacity: .6;
}
.video{
    z-index: 3;
    /* width: 20rem;
    height: 20rem; */
    width: 90%;
    /* height: auto; */
    position: absolute;
    top: 20rem;
    left: 2rem;
}
video{
    width: 100%;
}
</style>