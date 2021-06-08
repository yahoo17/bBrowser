import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Recommend from '@/components/Recommend'
import Video from '@/components/Video'
import Outbreaks from '@/components/Outbreaks'
import Entertainment from '@/components/Entertainment'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/entertainment',
      name: 'Entertainment',
      component: Entertainment
    },
    {
      path: '/outbreaks',
      name: 'Outbreaks',
      component: Outbreaks
    },
    {
      path: '/video',
      name: 'Video',
      component: Video
    },
    {
      path: '/recommend',
      name: 'Recommend',
      component: Recommend
    },
  ]
})
