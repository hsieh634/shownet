<script setup lang="ts">
const services = [
  { icon: '🏨', name: '飯店與 Villa', copy: '城市飯店、海景度假村與多人包棟住宿。' },
  { icon: '🚐', name: '包車與接送', copy: '機場接送、中文司機與跨城市私人包車。' },
  { icon: '🧭', name: '一日／多日遊', copy: '北越、中越、南越與富國島精選行程。' },
  { icon: '🤿', name: '潛水與水上活動', copy: '浮潛、體驗潛水與私人包船。' },
  { icon: '🛳️', name: '遊輪', copy: '下龍灣日遊、過夜郵輪與艙房方案。' },
  { icon: '⛳', name: '高爾夫', copy: '球場、接送與客製多人行程。' }
]

const destinations = ['河內・下龍灣', '峴港・會安', '胡志明市', '富國島']
</script>

<template>
  <div>
    <header class="site-header">
      <NuxtLink class="brand" to="/">Shownet<span>旅遊</span></NuxtLink>
      <nav aria-label="主要導覽">
        <a href="#services">旅遊服務</a>
        <a href="#destinations">熱門目的地</a>
        <a href="#about">關於我們</a>
      </nav>
      <button class="ghost-button" type="button">登入</button>
    </header>

    <main>
      <section class="hero">
        <div class="hero__content">
          <p class="eyebrow">VIETNAM TRAVEL SPECIALIST</p>
          <h1>讓每一段越南旅程，<br><span>簡單又安心。</span></h1>
          <p class="hero__copy">從飯店、Villa、中文司機包車，到一日遊、潛水與下龍灣遊輪，一站完成旅程安排。</p>
          <form class="search-card" @submit.prevent>
            <label><span>想去哪裡？</span><input placeholder="輸入城市或景點" value="越南"></label>
            <label><span>服務類型</span><select><option>全部服務</option><option>飯店與 Villa</option><option>包車與接送</option><option>一日／多日遊</option></select></label>
            <label><span>出發日期</span><input type="date"></label>
            <button type="submit">搜尋旅程</button>
          </form>
        </div>
      </section>

      <section id="services" class="section">
        <p class="eyebrow">TRAVEL YOUR WAY</p>
        <h2>你需要的越南旅遊服務</h2>
        <p class="section__lead">自由行的彈性，加上在地團隊即時協助。</p>
        <div class="card-grid">
          <article v-for="service in services" :key="service.name" class="service-card">
            <span class="service-card__icon" aria-hidden="true">{{ service.icon }}</span>
            <h3>{{ service.name }}</h3><p>{{ service.copy }}</p><a href="#">探索服務 →</a>
          </article>
        </div>
      </section>

      <section id="destinations" class="section section--tint">
        <p class="eyebrow">POPULAR IN VIETNAM</p>
        <h2>從最受歡迎的地方開始</h2>
        <div class="destination-grid">
          <article v-for="(destination, index) in destinations" :key="destination" :class="`destination destination--${index + 1}`">
            <p>越南精選</p><h3>{{ destination }}</h3><a href="#">查看行程</a>
          </article>
        </div>
      </section>

      <section id="about" class="trust-section">
        <div><p class="eyebrow">LOCAL SUPPORT</p><h2>台灣溝通，在地服務</h2><p>熟悉台灣旅客需求，也了解越南當地實際狀況。從預訂前諮詢到旅途中臨時需求，都有人可以協助。</p></div>
        <ul><li><strong>中文客服</strong><span>溝通更直接</span></li><li><strong>透明資訊</strong><span>費用與政策先說清楚</span></li><li><strong>在地團隊</strong><span>旅途中有人支援</span></li></ul>
      </section>
    </main>

    <footer><span>Shownet旅遊</span><p>越南為主的多國旅遊預訂平台</p><small>© 2026 Shownet Travel. All rights reserved.</small></footer>
  </div>
</template>

