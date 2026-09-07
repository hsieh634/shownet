# Design: Destination and Product Catalog

採用 `catalog` domain，商品以 PostgreSQL `catalog_products` 儲存；公開 API 只回傳 active 商品。

## API

`GET /api/v1/catalog/products?type=HOTEL&destinationCode=DAD`

回應格式為 `{ items: [...] }`，目前支援 type 與 destinationCode 篩選。

## Compatibility

商品型別使用字串 enum，避免資料庫與前端依賴數字順序；價格以 `NUMERIC(12,2)` 與 ISO 4217 三碼幣別保存。
