<script setup lang="ts">
const countries = [
  { name: '越南', items: ['北越', '中越', '南越', '富國島', '越南簽證'] },
  { name: '日本', items: ['北海道', '關東', '京都', '大阪', '日本包車'] },
  { name: '台灣', items: ['北台灣', '中台灣', '南台灣', '東台灣'] },
  { name: '馬來西亞', items: ['吉隆坡', '檳城'] },
  { name: '韓國', items: ['濟州島', '首爾'] },
  { name: '泰國', items: ['曼谷', '芭達雅', '蘇美島'] }
]

const featured = [
  { name: '北越', copy: '河內、下龍灣與沙壩深度旅遊', tone: 'north' },
  { name: '中越', copy: '峴港、會安、順化包車與行程', tone: 'central' },
  { name: '南越', copy: '胡志明市、芽莊與大叻自由安排', tone: 'south' },
  { name: '富國島', copy: '海島度假、潛水與水上活動', tone: 'island' }
]

const articles = [
  { date: '2026/09/07', title: '越南包車攻略：中文司機、包車費用與行程安排一次看懂', copy: '從家庭、親子到多人同行，整理越南包車類型、費用因素與預約清單。' },
  { date: '2025/07/03', title: '越南旅遊購買流程與預約注意事項', copy: '出發前整理行程、交通、住宿與客服聯絡方式，讓旅程更安心。' },
  { date: '2025/04/22', title: 'Shownet旅遊合作服務與在地支援', copy: '台灣團隊與越南在地團隊協作，提供旅途中即時協助。' }
]

const reviews = [
  ['謝先生', '非常感謝楊老闆及整個團隊的精心安排，讓我們在越南度過一個難忘的假期。'],
  ['Rose', '團隊專業又迅速，包車支援讓我們有自由行的彈性，也有跟團的方便與安心。'],
  ['萬小姐', '中文溝通順暢，行程安排符合需求，旅途中遇到問題也能快速得到協助。']
]
</script>

<template>
  <div class="site-shell">
    <header class="topbar">
      <NuxtLink class="brand" to="/">Shownet<span>旅遊</span></NuxtLink>
      <nav class="country-nav" aria-label="國家與地區導覽">
        <div v-for="country in countries" :key="country.name" class="nav-group">
          <button type="button">{{ country.name }} <span>⌄</span></button>
          <div class="nav-menu"><NuxtLink v-for="item in country.items" :key="item" to="/catalog">{{ item }}</NuxtLink></div>
        </div>
      </nav>
      <div class="account-nav"><NuxtLink to="/account">我的帳戶</NuxtLink><NuxtLink to="/cart">購物車</NuxtLink><NuxtLink class="account-button" to="/account">登入／註冊</NuxtLink></div>
    </header>

    <main>
      <section class="hero-legacy"><div class="hero-overlay"><p class="eyebrow">SHOWNET TRAVEL</p><h1>Shownet旅遊是你的最佳選擇</h1><p class="hero-subtitle">越南包車、中文司機、住宿與在地行程，一站完成旅程安排</p><form class="travel-search" @submit.prevent><label class="search-wide"><span>搜尋</span><input placeholder="輸入目的地、行程或服務" /></label><label><span>Location</span><input placeholder="選擇地區" /></label><label><span>Categories</span><select><option>全部分類</option><option>包車與中文司機</option><option>一日／多日遊</option><option>遊輪</option><option>潛水</option><option>住宿</option></select></label><label><span>Tags</span><select><option>選擇標籤</option><option>峴港</option><option>河內</option><option>下龍灣</option><option>富國島</option></select></label><label><span>Start date</span><input type="date" /></label><label><span>End date</span><input type="date" /></label><button type="submit">搜尋</button></form></div></section>

      <section class="content-section service-section"><div class="section-heading"><p class="eyebrow">FEATURED DESTINATIONS</p><h2>主打服務</h2><p>依照地區與服務類型，找到適合你的旅遊安排</p></div><div class="service-tabs"><button class="active" type="button">越南旅遊</button><button type="button">日本旅遊</button><button type="button">台灣旅遊</button><button type="button">其他國家</button></div><div class="feature-grid"><NuxtLink v-for="item in featured" :key="item.name" to="/catalog" class="feature-card" :class="`feature-card--${item.tone}`"><div><span>越南精選</span><h3>{{ item.name }}</h3><p>{{ item.copy }}</p><strong>查看服務 →</strong></div></NuxtLink></div></section>

      <section class="content-section article-section"><div class="section-heading section-heading--row"><div><p class="eyebrow">TRAVEL GUIDE</p><h2>相關文章和指南</h2></div><NuxtLink to="/articles" class="more-link">閱讀全部文章 →</NuxtLink></div><div class="article-grid"><article v-for="article in articles" :key="article.title" class="article-card"><div class="article-image"></div><div class="article-body"><small>{{ article.date }}</small><h3>{{ article.title }}</h3><p>{{ article.copy }}</p><NuxtLink to="/articles">閱讀更多 »</NuxtLink></div></article></div></section>

      <section class="review-section"><div class="content-section"><div class="section-heading"><p class="eyebrow">REAL TRAVEL STORIES</p><h2>客戶評價</h2></div><div class="review-grid"><blockquote v-for="review in reviews" :key="review[0]"><div class="stars">★★★★★</div><p>「{{ review[1] }}」</p><footer>{{ review[0] }}<span>顧客</span></footer></blockquote></div></div></section>
    </main>

    <footer class="site-footer"><div class="footer-main"><div><NuxtLink class="brand brand--footer" to="/">Shownet<span>旅遊</span></NuxtLink><p>專注越南與多國旅遊服務，提供包車、中文司機、行程、遊輪、潛水與住宿安排。</p></div><div><h3>快速連結</h3><NuxtLink to="/about">關於我們</NuxtLink><NuxtLink to="/articles">旅遊攻略</NuxtLink><NuxtLink to="/account">我的帳戶</NuxtLink></div><div><h3>熱門服務</h3><NuxtLink to="/catalog">越南包車</NuxtLink><NuxtLink to="/catalog">中文司機</NuxtLink><NuxtLink to="/catalog">下龍灣遊輪</NuxtLink></div><div><h3>聯絡我們</h3><p>02-25715811 / 0972167658</p><p>info@shownettravel.com</p><p>Line：danny095074</p></div></div><div class="footer-bottom"><span>© 2026 Shownet Travel. All rights reserved.</span><span>VND · TWD · USD · JPY · SGD · CNY · HKD</span></div></footer>
  </div>
</template>
