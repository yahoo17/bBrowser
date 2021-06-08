<template>
    <div class="all">
        <div class="media" v-for="item in allnews" :key="item.id">
                <a :href="item.url">
                <div class="media-body media-middle text1">
                    {{item.title}}  
                </div>
                <div class="media-right">
                    <img class="media-object" :src="item.picUrl">
                </div>
                </a>
            </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            //获取所有娱乐新闻数据
            allnews: []
        }
    },
    created(){
        this.getNews()
    },
    updated(){
        // this.getNews()
    },
    methods: {
        getNews: function(){
            this.$fetch('http://api.tianapi.com/huabian/index?key=f2e40d8925195e3086f3df7b36b58d0b&num=10').then(res=>{
                // console.log(res)
                if(res.code!==200){
                    alert("数据加载错误！")
                } else{
                    this.allnews = res.newslist;
                }
            })
        }
    }
}
</script>
<style scoped>
.all {
    width: 90%;
    margin: 1rem;
}
.media {
    margin-left: 1rem;
}
</style>