export default defineNuxtConfig({
  compatibilityDate: '2026-09-01',
  devtools: { enabled: true },
  css: ['~/assets/css/main.css'],
  runtimeConfig: {
    public: {
      apiBase: process.env.NUXT_PUBLIC_API_BASE ?? 'http://localhost:8080/api/v1'
    }
  },
  app: {
    head: {
      htmlAttrs: { lang: 'zh-Hant-TW' },
      meta: [
        { name: 'theme-color', content: '#0f6978' }
      ]
    }
  },
  typescript: {
    strict: true,
    typeCheck: true
  }
})

