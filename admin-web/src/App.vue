<script setup lang="ts">
const modules = ['訂單與預訂', '商品與方案', '價格與庫存', '供應商', '付款與退款', '內容與 SEO', '報表與稽核']
</script>

<template>
  <div class="layout">
    <aside><div class="brand">Shownet<span>Travel</span></div><nav><a v-for="module in modules" :key="module" href="#">{{ module }}</a></nav></aside>
    <main><header><div><p>OPERATIONS CONSOLE</p><h1>營運管理中心</h1></div><button>尚未登入</button></header>
      <section class="notice"><strong>Foundation Phase</strong><p>管理後台骨架已建立。身份驗證、商品、訂單與付款功能將依 OpenSpec Change 分批加入。</p></section>
      <section class="metrics"><article><span>今日新訂單</span><strong>—</strong></article><article><span>待供應商確認</span><strong>—</strong></article><article><span>退款申請</span><strong>—</strong></article></section>
      <section><h2>平台模組</h2><div class="module-grid"><article v-for="module in modules" :key="module"><h3>{{ module }}</h3><p>規格與權限尚待對應 Change 實作。</p></article></div></section>
    </main>
  </div>
</template>

